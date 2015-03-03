public class NullElement implements IElement {
    public NullElement() {
        
    }
    
    public IElement Insert(IData data) {
        TreeElement element = new TreeElement(data);
        element.SetLeft(this);
        element.SetRight(this);
        
        return element;
    }
    
    public IElement Delete(IData data) {
        return null;
    }
    
    public boolean Contains(IData data) {
        return false;
    }
    
    public IElement Balance() {
        return null;
    }
    
    public void SetLeft(IElement element) {
        // empty
    }
    
    public void SetRight(IElement element) {
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