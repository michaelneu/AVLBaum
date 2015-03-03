public class AVLTree {
    private INode root;
    
    public AVLTree() {
        root = new NullNode();
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
    
    public void Delete(IData data) {
        root.Delete(data);
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
