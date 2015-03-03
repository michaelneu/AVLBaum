public class AVLTree {
    private IElement root;
    
    public AVLTree() {
        root = new NullElement();
    }
    
    public int Count() {
        return root.Count();
    }
    
    public void Insert(IData data) {
        root = root.Insert(data);
    }
    
    public boolean Contains(IData data) {
        return root.Contains(data);
    }
    
    @Override public String toString() {
        return toString(OutputOrder.Inorder);
    }
    public String toString(OutputOrder order) {
        return root.toString(order);
    }
    
    public Object[] toJSONBase() {
        return root.toJSON();
    }
    public String toJSON() {
        Object[] avl = toJSONBase();
        
        return JSON.Encode(avl);
    }
}
