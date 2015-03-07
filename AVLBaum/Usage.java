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
            
                System.out.println("Element zum Einfügen: " + data.toString());
                System.out.println("");
            
            Object[] json = avl.toJSON();
            unbalancedTree.fromJSON(json);
            
            unbalancedTree.Insert(data);
                System.out.println("Nach Einfügen: ");
                System.out.println(TreeVisualizer.Encode(unbalancedTree.toJSON()));
                System.out.println("");
            
            avl.Insert(data);
                System.out.println("Balanciert: ");
                System.out.println(TreeVisualizer.Encode(avl.toJSON()));
                System.out.println("");
                
                System.out.println("Inorder: " + avl.toString());
                
                System.out.println("##################################################");
        }
        
            System.out.println("\nElement zum Löschen: " + delete.toString());
            System.out.println("");
        
        Object[] json = avl.toJSON();
        unbalancedTree.fromJSON(json);
        
        unbalancedTree.Delete(delete);
            System.out.println("Nach Löschen: ");
            System.out.println(TreeVisualizer.Encode(unbalancedTree.toJSON()));
            System.out.println("");
        
        avl.Delete(delete);
            System.out.println("Balanciert: ");
            System.out.println(TreeVisualizer.Encode(avl.toJSON()));
            System.out.println("");
            
            System.out.println("Inorder: " + avl.toString());
            
            System.out.println("##################################################");
        
    }
}