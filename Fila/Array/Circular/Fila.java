public class Fila implements IFila {
  private Object[] queue;
  private int begin = 0;
  private int end;
  private int length;
  public Fila(int len) {
    queue = new Object[len];
    length = len;
    end = len -1;
  }
  public void enqueue(Object o) {
    if(this.isFull()) {
      Object[] newQueue = new Object[length*2];
      int j = begin;
      for (int i = 0; j != end; i++) {
        newQueue[i] = queue[j];
        j = (j + 1) % length;
      }
      queue = newQueue;
      begin = 0;
      end = j;
      length *= 2;
    }
    queue[end] = o;
    end = (end + 1) % length;
  }
  public Object dequeue() {
    if (this.isEmpty()) throw new EmptyQueueException("");
    Object temp = queue[begin];
    queue[begin] = null;
    begin = (begin + 1) % length;
    return temp;
  }
  public Object first() {
    if (this.isEmpty()) throw new EmptyQueueException("");
    return queue[begin];
  }
  public int size() {
    return (length - begin + end) % length;
  }
  public boolean isEmpty() {
    return (begin == end);
  }
  public boolean isFull() {
    return ((this.size()+1) == length);
  }
  public String strStruct() {
    String s = "{";
    for(int i = 0; i < length; i++){ 
      s += queue[i];
    if (i < length-1)
      s += ", ";
    }
    s += "}";
    return s;
  }
  public String toString() {
    String s = "{";
    int j = begin;
    for(int i = 0; j != end; i++){ 
      s += queue[j];
      j = (j + 1) % length;
      if (j != end) s += ", ";
    }
    s += "}";
    return s;
  }
}