public class AVLNullNode extends NullNode {
    public AVLNullNode() {
        super();
    }
    
    public INode Insert(IData data) {
        AVLNode element = new AVLNode(data);
        element.SetLeft(this);
        element.SetRight(this);
        
        return element;
    }
}
