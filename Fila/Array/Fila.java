public class Fila implements IFila {
  private Object[] queue;
  private int begin = 0;
  private int end;
  private int length;
  private int fc;
  private int tx;
  private int smaller;
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
    if (this.size() == 1) smaller = end -1;
    else if ((int) o < (int) queue[smaller]) smaller = end -1;
  }
  public Object dequeue() {
    if (this.isEmpty()) throw new EmptyQueueException("");
    Object temp = queue[begin];
    Object lastMin = queue[smaller];
    queue[begin++] = null;
    if (temp == lastMin) this.setNextSmaller();
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
  public Object acessSmaller() {
    if (isEmpty()) throw new EmptyQueueException("Empty Queue");
    else {
      return queue[smaller];
    }
  }
  public void setNextSmaller() {
    Object temp = queue[begin];
    int j = begin;
    for (int i = 0; j != end; i++){
      if (queue[j] != null && (int) queue[j] <= (int) temp) {
        temp = queue[j];
        smaller = j;
      }
      j++;
    }
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