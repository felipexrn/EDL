public class Deque {  // {begin, end, , , } capacity
  private Object[] D;
  private int begin;
  private int end;
  private int capacity;
  private boolean fc;
  private int tx;
  private int smaller;
  public Deque(int cap, boolean factor, int tax) {
    capacity = cap;
    D = new Object[cap];
    begin = 0;
    end = 0;
    fc = factor;
    tx = tax;    
    smaller = 0;
  }
  public void insertFirst(Object o) {
    if (isFull()) {
      // add capacity
    }
    if (begin == 0) begin = capacity -1;
    begin = (begin - 1) % capacity;
    D[begin] = o;
    if (this.size() > 0)
      if (o < D[smaller]) smaller = begin;
  }
  public void insertLast(Object o) {
    if (isFull()) {
      // add capacity
    }
    if (end == capacity -1) end = 0;
    end = (end + 1) % capacity;
    D[end] = o;
    if (this.size() > 0)
      if (o < D[smaller]) smaller = end;
  }
  public Object removeFirst() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      Object temp = D[begin];
      D[begin] = null;
      if (begin == capacity -1) begin = 0;
      else begin = (begin + 1) % capacity;
      return temp;
    }
  }
  public Object removeLast() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      Object temp = D[end];
      D[end] = null;
      if (end == 0) begin = capacity -1;
      end = (end - 1) % capacity;
      return temp;
    }
  }
  public Object First() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      return D[begin];
    }
  }
  public Object Last() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      Object temp;
      if (end == 0) temp = D[capacity -1];
      else temp = D[end-1];
      return temp;
    }
  }
  public boolean isFull() {
    return ((this.size() +1) == capacity);
  }
  public boolean isEmpty() {
    return (begin == end);
  }
  public int size() {
    return (capacity - begin + end) % capacity
  }
  public Object acessSmaller() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      if (D[smaller] == null) setNextSmaller();
      return D[smaller];
    }
  }
  public Object setNextSmaller() {
    Object temp = D[begin];
    j = begin;
    for (int i = 0; j != end; j = (j + 1) % capacity) {
      if (D[j] < temp) {
        temp = D[j];
        smaller = j;
      }
    }
  }
}