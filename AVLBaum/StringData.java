public class StringData implements IData {
    private String content;
    
    public Object GetData() {
        return content;
    }
    
    public void SetData(Object obj) {
        content = (String)obj;
    }
    
    public int CompareTo(IData data) {
        if (data == null || content == null) {
            return 0;
        }
        
        if (data instanceof StringData) {
            String other = (String)data.GetData();
            
            return content.compareTo(other);
        } else {
            String other = data.GetData().toString();
            
            return content.compareTo(other);
        }
    }
    
    public boolean Equals(IData data) {
        if (data instanceof StringData) {
            String other = (String)data.GetData();
            
            return content.equals(other);
        } else {
            String other = data.GetData().toString();
            
            return content.equals(other);
        }
    }
    
    @Override public String toString() {
        return content;
    }
}
