import java.util.*;

public class Test {
    private static Random random = new Random();
    
    private static BinaryTree GenerateRandomTree(int elements) {
        return GenerateRandomTree(elements, 5, true);
    }
    private static BinaryTree GenerateRandomTree(int elements, int maxWordLength, boolean capitals) {
        BinaryTree tree = new BinaryTree();
        
        for (int i = 0; i < 10; i++) {
            int textLength = random.nextInt(maxWordLength) + 1;
            String text = RandomString(textLength, capitals);
            
            StringData data = new StringData();
            data.SetData(text);
            
            tree.Insert(data);
        }
        
        return tree;
    }
    
    private static String RandomString(int length, boolean capitals) {
        String text = "";
        
        for (int i = 0; i < length; i++) {
            int add = 97;
            if (capitals && random.nextInt(2) == 1) {
                add = 66;
            }
            
            text += (char)(random.nextInt(26) + add) + "";
        }
        
        return text;
    }
    
    
    public static void TestJSON() {
        BinaryTree tree = GenerateRandomTree(10);
        
        System.out.println(tree.toJSON());
    }
    
    public static void TestContains() {
        BinaryTree tree = GenerateRandomTree(10, 1, false);
        
        System.out.println("> var tree = " + tree.toJSON() + "\n");
        
        StringData data = new StringData();
        data.SetData("a");
        
        System.out.println("> 'a' in tree\n" + tree.Contains(data) + "\n");
        
        tree.Insert(data);
        System.out.println("> tree\n" + tree.toJSON() + "\n");
        
        System.out.println("> 'a' in tree\n" + tree.Contains(data));
    }
    
    public static void TestDelete() {
        BinaryTree tree = new BinaryTree();
        
        StringData data = new StringData();
        data.SetData("b");
        tree.Insert(data);
        
        data = new StringData();
        data.SetData("a");
        tree.Insert(data);
        
        data = new StringData();
        data.SetData("k");
        tree.Insert(data);
        StringData delete = data;
        
        data = new StringData();
        data.SetData("h");
        tree.Insert(data);
        
        data = new StringData();
        data.SetData("o");
        tree.Insert(data);
        
        data = new StringData();
        data.SetData("f");
        tree.Insert(data);
        
        data = new StringData();
        data.SetData("i");
        tree.Insert(data);
        
        
        data = new StringData();
        data.SetData("l");
        tree.Insert(data);
        
        data = new StringData();
        data.SetData("p");
        tree.Insert(data);
        
        System.out.println("> var tree = " + tree.toJSON() + "\n");
        
        tree.Delete(delete);
        
        System.out.println("> tree = tree.delete('" + delete.toString() + "')\n> tree\n" + tree.toJSON() + "\n");
        
        tree.Delete(data);
        
        System.out.println("> tree = tree.delete('" + data.toString() + "')\n> tree\n" + tree.toJSON() + "\n");
    }
}
