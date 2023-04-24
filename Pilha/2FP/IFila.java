public interface IFila {
  public abstract void enqueue(Object o);
  public abstract Object dequeue() throws EmptyStackException;
  public abstract  Object first() throws EmptyStackException;
  public abstract int size();
  public abstract boolean isEmpty();
  public abstract String toString();
}
