import java.util.*;

public class Usage {
    public static void main(String[] args) {
        BinaryTree unbalancedTree = new BinaryTree();
        AVLTree avl = new AVLTree();
        IData delete = null;
        
        for (int i = 1; i < 10; i++) {
            IntData data = new IntData();
            data.SetData(i);
            
                if (i == 6) {
                    delete = data;
                }
            
                System.out.println("Element zum Einfügen: ");
                System.out.println(data.toString());
                System.out.println("");
            
            Object[] json = avl.toJSONBase();
            unbalancedTree.fromJSON(json);
            
            unbalancedTree.Insert(data);
                System.out.println("Nach Einfügen: ");
                System.out.println(unbalancedTree.toJSON());
                System.out.println("");
            
            avl.Insert(data);
                System.out.println("Balanciert: ");
                System.out.println(avl.toJSON());
                System.out.println("");
                
                System.out.println("Inorder: " + avl.toString());
                
                System.out.println("##################################################");
        }
        
            System.out.println("\nElement zum Löschen: ");
            System.out.println(delete.toString());
            System.out.println("");
        
        Object[] json = avl.toJSONBase();
        unbalancedTree.fromJSON(json);
        
        unbalancedTree.Delete(delete);
            System.out.println("Nach Einfügen: ");
            System.out.println(unbalancedTree.toJSON());
            System.out.println("");
        
        avl.Delete(delete);
            System.out.println("Balanciert: ");
            System.out.println(avl.toJSON());
            System.out.println("");
            
            System.out.println("Inorder: " + avl.toString());
            
            System.out.println("##################################################");
        
    }
    
    private static Random random = new Random();
    private static String RandomChar() {
        char c = (char)(random.nextInt(26) + 97);
        
        return c + "";
    }
}