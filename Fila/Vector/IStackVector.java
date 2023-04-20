public interface IStackVector {
  public abstract void enqueue(Object o);
  public abstract Object dequeue() throws EmptyVectorException;
  public Object first() throws EmptyVectorException;
  public abstract int size();
  public abstract boolean isEmpty();
  public abstract String toString();
  
}