public class AVLTree {
    private IElement root;
    private int count;
    
    public AVLTree() {
        root = new NullElement();
        count = 0;
    }
    
    public int Count() {
        return count;
    }
    
    public void Insert(IData data) {
        root = root.Insert(data);
        count += 1;
    }
    
    @Override public String toString() {
        return toString(OutputOrder.Inorder);
    }
    public String toString(OutputOrder order) {
        return root.toString(order);
    }
    
    public String toJSON() {
        Object[] avl = root.toJSON();
        return JSON.Encode(avl);
    }
}
