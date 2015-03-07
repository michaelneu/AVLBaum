public class BinaryTree {
    protected INode root;
    
    public BinaryTree() {
        root = new NullNode();
    }
    
    
    public int Count() {
        return root.Count();
    }
    
    public boolean Contains(IData data) {
        return root.Contains(data);
    }
    
    public IData Max() {
        return root.Max();
    }
    
    public IData Min() {
        return root.Min();
    }
    
    public int Depth() {
        return root.Depth();
    }
    
    
    public void Insert(IData data) {
        root = root.Insert(data);
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
    
    public void fromJSON(Object[] json) {
        root = decodeJSON(json);
    }
    private INode decodeJSON(Object[] json) {
        if (json == null) {
            return new NullNode();
        } else {
            Node node = new Node((IData)json[0]);
            node.SetLeft(decodeJSON((Object[])json[1]));
            node.SetRight(decodeJSON((Object[])json[2]));
            
            return node;
        }
    }
}
