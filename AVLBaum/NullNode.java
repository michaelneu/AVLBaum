public class NullNode implements INode {
    public NullNode() {
        
    }
    
    
    public int Count() {
        return 0;
    }
    
    public int Depth() {
        return 0;
    }
    
    public boolean Contains(IData data) {
        return false;
    }
    
    public IData Min() {
        return null;
    }
    
    public IData Max() {
        return null;
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
    
    public INode GetBiggestNode() {
        return null;
    }
    
    
    public void SetLeft(INode element) {
        //
    }
    
    public void SetRight(INode element) {
        //
    }
    
    public INode GetLeft() {
        return this;
    }
    
    public INode GetRight() {
        return this;
    }
    
    
    @Override public String toString() {
        return null;
    }
    public String toString(OutputOrder order) {
        return toString();
    }
    
    public Object[] toJSON() {
        return null;
    }
}