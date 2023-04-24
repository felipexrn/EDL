public interface IPilha { 
  public abstract int size();
  public abstract boolean isEmpty();
  public abstract void empty();
  public abstract boolean isFull();
  public abstract Object top() throws EmptyQueueException; 
  public abstract void push(Object o);
  public abstract void adicionaPilha(Pilha P);
  public Object pop() throws EmptyQueueException;
  public abstract String toString();
}

