public class IntData implements IData {
    private int content;
    
    public Object GetData() {
        return content;
    }
    
    public void SetData(Object data) {
        content = (int)data;
    }
    
    public int CompareTo(IData data) {
        if (data instanceof IntData) {
            int other = (int)data.GetData();
            
            if (content < other) {
                return -1;
            } else if (content == other) {
                return 0;
            } else {
                return 1;
            }
        } else {
            String other = data.GetData().toString();
            
            return (content + "").compareTo(other);
        }
    }
    
    public boolean Equals(IData data) {
        if (data instanceof IntData) {
            int other = (int)data.GetData();
            
            return content == other;
        } else {
            String other = data.GetData().toString();
            
            return (content + "").equals(other);
        }
    }
    
    @Override public String toString() {
        return content + "";
    }
}