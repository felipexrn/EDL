public class Fila implements IFila {
  private Object[] queue;
  private int begin = 0;
  private int end;
  private int length;
  private int fc;
  private int tx;
  public Fila(int len, int factor, int tax) {
    queue = new Object[len];
    length = len;
    fc = factor;
    tx = tax;
    end = len -1;
  }
  public void enqueue(Object o) {
    if(this.isFull()) {
      int newLength = length;
      if (fc == 0) newLength += tx;
      else newLength *= 2;
      Object[] newQueue = new Object[newLength];
      int i;
      int j = begin;
      for (i = 0; j < end; i++) {
        newQueue[i] = queue[j++];
      }
      queue = newQueue;
      begin = 0;
      end = i;
      length = newLength;
    }
    queue[end++] = o;
  }
  public Object dequeue() {
    if (this.isEmpty()) throw new EmptyQueueException("");
    Object temp = queue[begin];
    queue[begin++] = null;
    return temp;
  }
  public Object first() {
    if (this.isEmpty()) throw new EmptyQueueException("");
    return queue[begin];
  }
  public int size() {
    return end - begin;
  }
  public boolean isEmpty() {
    return (begin == end);
  }
  public boolean isFull() {
    return (end == this.length-1);
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
    for(int i = begin; i < end; i++){ 
      s += queue[i];
    if (i < end -1)
      s += ", ";
    }
    s += "}";
    return s;
  }
}