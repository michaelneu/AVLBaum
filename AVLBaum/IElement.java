public interface IElement {
    public IElement Insert(IData data);
    public IElement Delete(IData data);
    public boolean Contains(IData data);
    public IElement Balance();
    public void SetLeft(IElement element);
    public void SetRight(IElement element);
    public String toString(OutputOrder order);
    public Object[] toJSON();
}