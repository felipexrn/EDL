public interface IFila {
  public abstract void enqueue(Object o);
  public abstract Object dequeue() throws EmptyQueueException;
  public Object first() throws EmptyQueueException;
  public abstract int size();
  public abstract boolean isEmpty();
  public abstract String strStruct();
  public abstract String toString();
}
