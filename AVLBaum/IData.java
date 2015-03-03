public interface IData {
    public Object GetData();	
    public void SetData(Object obj);
    
    public int CompareTo(IData data);
}