public class Node implements INode {
    protected IData content;
    protected INode leftElement, rightElement;
    
    public Node(IData data) {
        content = data;
    }
    
    
    
    public int Count() {
        return 1 + leftElement.Count() + rightElement.Count();
    }
    
    public int Depth() {
        int leftDepth = leftElement.Depth(),
            rightDepth = rightElement.Depth();
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    public boolean Contains(IData data) {
        return content.Equals(data) || leftElement.Contains(data) || rightElement.Contains(data);
    }
    
    
    private IData Min(IData a, IData b) {
        if (a == null) {
            return b;
        } else {
            if (a.CompareTo(b) < 0) {
                return a;
            } else {
                return b;
            }
        }
    }
    
    private IData Max(IData a, IData b) {
        if (a == null) {
            return b;
        } else {
            if (a.CompareTo(b) > 0) {
                return a;
            } else {
                return b;
            }
        }
    }
    
    public IData Min() {
        IData left = leftElement.Min(),
            right = rightElement.Min(),
            min;
        
        min = Min(left, right);
        min = Min(min, content);
        
        return min;
    }
    
    public IData Max() {
        IData left = leftElement.Max(),
            right = rightElement.Max(),
            max;
        
        max = Max(left, right);
        max = Max(max, content);
        
        return max;
    }
    
    
    public INode Insert(IData data) {
        if (data.CompareTo(content) <= 0) {
            leftElement = leftElement.Insert(data);
        } else {
            rightElement = rightElement.Insert(data);
        }
        
        return this;
    }
    
    
    public INode Delete(IData data) {
        if (content == data) {
            int elementsLeftSide = leftElement.Count(),
                elementsRightSide = rightElement.Count();
            
            if (elementsLeftSide > 0) {
                INode biggest = leftElement.GetBiggestNode();
                biggest.SetLeft(leftElement);
                biggest.SetRight(rightElement);
                
                return biggest;
            } else {
                return rightElement;
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
        
        if (leftCount == 0 && rightCount == 0) {
            return this;
        } else if (rightCount > 0) {
            return rightElement.GetBiggestNode();
        } else {
            return leftElement.GetBiggestNode();
        }
    }
    
    
    public void SetLeft(INode element) {
        leftElement = element;
    }
    
    public void SetRight(INode element) {
        rightElement = element;
    }
    
    public INode GetLeft() {
        return leftElement;
    }
    
    public INode GetRight() {
        return rightElement;
    }
    
    
    @Override public String toString() {
        return content.toString();
    }
    public String toString(OutputOrder order) {
        String left = leftElement.toString(order),
            self = content.toString(),
            right = rightElement.toString(order);
        
        if (left != null) {
            left += ", ";
        } else {
            left = "";
        }
            
        if (right != null) {
            right += ", ";
        } else {
            right = "";
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
        
        return new Object[] { content, left, right };
    }
}