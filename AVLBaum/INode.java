public interface INode {
    public int Count();
    public INode Insert(IData data);
    public boolean Contains(IData data);
    
    public INode Delete(IData data);
    public INode GetBiggestNode();
    
    public INode Balance();
    
    public void SetLeft(INode element);
    public void SetRight(INode element);
    
    public String toString(OutputOrder order);
    public Object[] toJSON();
}