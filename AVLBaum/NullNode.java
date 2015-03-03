public class NullNode implements INode {
    public NullNode() {
        
    }
    
    public int Count() {
        return 0;
    }
    
    public INode Insert(IData data) {
        Node element = new Node(data);
        element.SetLeft(this);
        element.SetRight(this);
        
        return element;
    }
    
    public INode Delete(IData data) {
        return this;
    }
    
    public boolean Contains(IData data) {
        return false;
    }
    
    public INode GetBiggestNode() {
        return null;
    }
    
    public INode Balance() {
        return null;
    }
    
    public void SetLeft(INode element) {
        // empty
    }
    
    public void SetRight(INode element) {
        // empty
    }
    
    @Override public String toString() {
        return "";
    }
    public String toString(OutputOrder order) {
        return toString();
    }
    
    public Object[] toJSON() {
        return null;
    }
}