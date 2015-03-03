public interface IElement {
    public IElement Insert(IData data);
    public IElement Delete(IData data);
    public boolean Contains(IData data);
    public IElement Balance();
}