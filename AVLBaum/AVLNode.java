public class AVLNode extends Node {
    public AVLNode(IData data) {
        super(data);
    }
    
    public INode Insert(IData data) {
        INode node = super.Insert(data);
        node = Rebalance(node);
        
        return node;
    }
    
    
    public INode Delete(IData data) {
        INode node = super.Delete(data);
        node = Rebalance(node);
        
        return node;
    }
    
    
    private INode Rebalance(INode node) {
        INode leftElement = node.GetLeft(),
            rightElement = node.GetRight(),
            leftLeft = leftElement.GetLeft(),
            rightLeft = rightElement.GetLeft(),
            leftRight = leftElement.GetRight(),
            rightRight = rightElement.GetRight();
        
        int heightLeftLeft = leftLeft.Depth(),
            heightRightLeft = rightLeft.Depth(),
            heightLeftRight = leftRight.Depth(),
            heightRightRight = rightRight.Depth(),
            heightLeft = leftElement.Depth(),
            heightRight = rightElement.Depth();
            
        if (heightLeft >= 2 + heightRight) {
            if (heightLeftLeft >= heightLeftRight) {
                return RotateRight(node);
            } else {
                leftElement = RotateLeft(leftElement);
                return RotateRight(node);
            }
        } else if (heightRight >= 2 + heightLeft) {
            if (heightRightRight >= heightRightLeft) {
                return RotateLeft(node);
            } else {
                RotateRight(rightElement);
                return RotateLeft(node);
            }
        } else {
            return node;
        }
    }
    
    private INode RotateLeft(INode node) {
        INode temp = node.GetRight();
        
        node.SetRight(temp.GetLeft());
        temp.SetLeft(node);
        
        return temp;
    }
    
    private INode RotateRight(INode node) {
        INode temp = node.GetLeft();
        
        node.SetLeft(temp.GetRight());
        temp.SetRight(node);
        
        return temp;
    }
}