public class StringData implements IData {
    private String content;
    
    public Object GetData() {
        return content;
    }
    
    public void SetData(Object obj) {
        content = (String)obj;
    }
    
    public int CompareTo(IData data) {
        String other = (String)data.GetData();
        
        return content.compareTo(other);
    }
    
    @Override public String toString() {
        return content;
    }
}
