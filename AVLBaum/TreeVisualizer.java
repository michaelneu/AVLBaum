/*
 * MIT Binary Search Trees - BST.__str__ method ported to Java
 * http://ocw.mit.edu/ans7870/6/6.006/s08/lecturenotes/search.htm
 */

import java.util.*;

public class TreeVisualizer {
    public static String Encode(Object[] tree) {
        if (tree == null || tree[0] == null) {
            return "";
        }
        
        RecurseInfo info = EncodeSubTree(tree);
        
        String text = "";
        for (String line : info.Lines) {
            text += line + "\n";
        }
        
        return text;
    }
    
    private static RecurseInfo EncodeSubTree(Object[] tree) {
        if (tree == null) {
            return new RecurseInfo();
        }
        
        String label = tree[0].toString();
        
        RecurseInfo left = EncodeSubTree((Object[])tree[1]),
            right = EncodeSubTree((Object[])tree[2]);
            
        int middle = Math.max(right.Position + left.Width - left.Position + 1, label.length());
        middle = Math.max(middle, 2);
        middle += 1;
        
        int pos = left.Position + middle / 2,
            width = left.Position + middle + right.Width - right.Position;
        
        String appendToLeft = RepeatString(" ", left.Width);
        while (left.Lines.toArray().length < right.Lines.toArray().length) {
            left.Lines.add(appendToLeft);
        }
        
        String appendToRight = RepeatString(" ", right.Width);
        while (right.Lines.toArray().length < left.Lines.toArray().length) {
            right.Lines.add(appendToLeft);
        }
        
        label = Center(label, middle);
        
        RecurseInfo info = new RecurseInfo();
        info.Position = pos;
        info.Width = width;
        
        info.Lines.add(RepeatString(" ", left.Position) + label + RepeatString(" ", right.Width - right.Position));
        info.Lines.add(RepeatString(" ", left.Position) + "/" + RepeatString(" ", middle - 2) + "\\" + RepeatString(" ", right.Width - right.Position));
        
        int zip = Math.min(left.Lines.toArray().length, right.Lines.toArray().length);
        
        for (int i = 0; i < zip; i++) {
            info.Lines.add(left.Lines.get(i) + RepeatString(" ", width - left.Width - right.Width) + right.Lines.get(i));
        }
        
        return info;
    }
    
    private static String Center(String text, int count) {
        int diff = count - text.length();
        diff = Math.max(diff, 0);
        
        int left = diff / 2,
            right = diff - left;
        
        return RepeatString(" ", left) + text + RepeatString(" ", right);
    }
    
    private static String RepeatString(String s, int count) {
        String t = "";
        
        for (int i = 0; i < count; i++) {
            t += s;
        }
        
        return t;
    }
    
    private static class RecurseInfo {
        public ArrayList<String> Lines;
        public int Position, Width;
        
        public RecurseInfo() {
            Lines = new ArrayList<String>();
            Position = Width = 0;
        }
    }
}