public class Node implements INode {
    private IData content;
    private INode leftElement, rightElement;
    
    public Node(IData data) {
        content = data;
    }
    
    public IData GetData() {
        return content;
    }
    
    public int Count() {
        return 1 + leftElement.Count() + rightElement.Count();
    }
    
    public INode Insert(IData data) {
        if (data.CompareTo(content) <= 0) {
            leftElement = leftElement.Insert(data);
        } else {
            rightElement = rightElement.Insert(data);
        }
        
        return this;
    }
    
    public boolean Contains(IData data) {
        return content.Equals(data) || leftElement.Contains(data) || rightElement.Contains(data);
    }
    
    public INode Delete(IData data) {
        if (content == data) {
            int elementsLeftSide = leftElement.Count(),
                    elementsRightSide = rightElement.Count();
                
            if (elementsLeftSide != 0 && elementsRightSide == 0) { // only elements on the left
                return leftElement;
            } else if (elementsLeftSide == 0 && elementsRightSide != 0) { // only elements on the right
                return rightElement;
            } else if (elementsLeftSide == 0 && elementsRightSide == 0) { // no elements at all
                System.out.println("");
                return leftElement;
            } else { // > 1 element on each side
                INode biggest = GetBiggestNode();
                biggest.SetLeft(leftElement);
                biggest.SetRight(rightElement);
                
                return biggest;
            }
        } else {
            leftElement = leftElement.Delete(data);
            rightElement = rightElement.Delete(data);
            
            return this;
        }
    }
    
    public INode GetBiggestNode() {
        int leftCount = leftElement.Count(),
            rightCount = rightElement.Count();
        
        if (rightCount == 1) {
            INode biggest = rightElement;
            rightElement = new NullNode();
            
            return biggest;
        } else if (rightCount == 0) {
            if (leftCount == 1) {
                INode biggest = leftElement;
                leftElement = new NullNode();
                
                return biggest;
            } else {
                return leftElement.GetBiggestNode();
            }
        } else {
            return rightElement.GetBiggestNode();
        }
    }
    
    public INode Balance() {
        return null;
    }
    
    public void SetLeft(INode element) {
        leftElement = element;
    }
    
    public void SetRight(INode element) {
        rightElement = element;
    }
    
    @Override public String toString() {
        return content.toString();
    }
    public String toString(OutputOrder order) {
        String left = leftElement.toString(order),
            self = content.toString(),
            right = rightElement.toString(order);
        
        if (left != "") {
            left += ", ";
        }
            
        if (right != "") {
            right += ", ";
        }
        
        self += ", ";
        
        switch (order) {
            case Preorder: 
                return self + left + right;
            
            case Postorder: 
                return left + right + self;
           
            default: 
                return left + self + right;
        }
    }
    
    public Object[] toJSON() {
        Object[] left = leftElement.toJSON(),
            right = rightElement.toJSON();
        
        return new Object[] { this, left, right };
    }
}