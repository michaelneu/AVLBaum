public class TreeElement implements IElement {
    private IData content;
    private IElement leftElement, rightElement;
    
    public TreeElement(IData data) {
        content = data;
    }
    
    public int Count() {
        return 1 + leftElement.Count() + rightElement.Count();
    }
    
    public IElement Insert(IData data) {
        if (data.CompareTo(content) <= 0) {
            leftElement = leftElement.Insert(data);
        } else {
            rightElement = rightElement.Insert(data);
        }
        
        return this;
    }
    
    public IElement Delete(IData data) {
        return this;
    }
    
    public boolean Contains(IData data) {
        return content.Equals(data) || leftElement.Contains(data) || rightElement.Contains(data);
    }
    
    public IElement Balance() {
        return null;
    }
    
    public void SetLeft(IElement element) {
        leftElement = element;
    }
    
    public void SetRight(IElement element) {
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