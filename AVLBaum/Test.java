import java.util.*;

public class Test {
    private static Random random = new Random();
    
    private static AVLTree GenerateRandomTree(int elements) {
        return GenerateRandomTree(elements, 5);
    }
    private static AVLTree GenerateRandomTree(int elements, int maxWordLength) {
        AVLTree tree = new AVLTree();
        
        for (int i = 0; i < 10; i++) {
            int textLength = random.nextInt(maxWordLength) + 1;
            String text = RandomString(textLength);
            
            StringData data = new StringData();
            data.SetData(text);
            
            tree.Insert(data);
        }
        
        return tree;
    }
    
    private static String RandomString(int length) {
        String text = "";
        
        for (int i = 0; i < length; i++) {
            int add = 97;
            if (random.nextInt(2) == 1) {
                add = 66;
            }
            
            text += (char)(random.nextInt(26) + add) + "";
        }
        
        return text;
    }
    
    
    public static void TestJSON() {
        AVLTree tree = GenerateRandomTree(10);
        
        System.out.println(tree.toJSON());
    }
    
    public static void TestContains() {
        AVLTree tree = GenerateRandomTree(10, 1);
        
        System.out.println("> var tree = " + tree.toJSON() + "\n");
        
        StringData data = new StringData();
        data.SetData("a");
        
        System.out.println("> 'a' in tree\n" + tree.Contains(data) + "\n");
        
        tree.Insert(data);
        System.out.println("> tree\n" + tree.toJSON() + "\n");
        
        System.out.println("> 'a' in tree\n" + tree.Contains(data));
    }
}
