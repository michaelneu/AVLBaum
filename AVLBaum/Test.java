import java.util.*;

public class Test {
    public static void main(String[] args) {
        // for jar building
    }
    
    public static void TestInsert() {
        Random r = new Random();
        
        AVLTree tree = new AVLTree();
        
        for (int i = 0; i < 10; i++) {
            String text = (char)(r.nextInt(26) + 97) + "";
            
            StringData data = new StringData();
            data.SetData(text);
            
            tree.Insert(data);
        }
        
        System.out.println(tree.toJSON());
    }
}
