public interface INode {
    public int Count();
    public int Depth();
    public boolean Contains(IData data);
    
    public IData Min();
    public IData Max();
    
    public INode Insert(IData data);
    public INode Delete(IData data);
    public INode GetBiggestNode();
    
    public void SetLeft(INode element);
    public void SetRight(INode element);
    public INode GetLeft();
    public INode GetRight();
    
    public String toString(OutputOrder order);
    public Object[] toJSON();
}