public class Deque {  // {begin, end, , , } capacity
  private Object[] D;
  private int begin;
  private int end;
  private int capacity;
  private boolean isd;
  private int tx;
  private int smaller;
  public Deque(int cap, boolean isDouble, int tax) {
    capacity = cap;
    D = new Object[cap];
    begin = 0;
    end = 0;
    isd = isDouble;
    tx = tax;    
    smaller = 0;
  }
  public void insertFirst(Object o) {
    if (isFull()) {
      this.malloc();
    }
    if (begin == 0) begin = capacity -1;
    else begin = (begin - 1) % capacity;
    D[begin] = o;
    if (this.size() == 1) smaller = begin;
    else if ((int) o < (int) D[smaller]) smaller = begin;
    System.out.println("capacidade " + capacity);
  }
  public void insertLast(Object o) {
    if (isFull()) {
      this.malloc();
    }
    D[end] = o;
    if (end == capacity -1) end = 0;
    else end = (end + 1) % capacity;
    if (this.size() == 1) smaller = end;
    else if ((int) o < (int) D[smaller]) smaller = end;
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
  public Object first() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      return D[begin];
    }
  }
  public Object last() {
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
    return (capacity - begin + end) % capacity;
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
    int j = begin;
    for (int i = 0; j != end; j = (j + 1) % capacity) {
      if ((int) D[j] < (int) temp) {
        temp = D[j];
        smaller = j;
      }
    }
    return temp;
  }
  private void malloc() {
    int newCapacity = capacity;
    if (isd) newCapacity *= 2;
    else newCapacity += tx;
    Object[] newDeque = new Object[newCapacity];
    int j = begin;
    for (int i = 0; j != end; i++) {
      newDeque[i] = D[j];
      j = (j + 1) % capacity;
    }
    begin = 0;
    end = j;
    D = newDeque;
    capacity = newCapacity;
  }
  public String toString() {
    String s = "{";
    int j = begin;
    for (int i = 0; j != end; i++) {
      s += D[j];
      j = (j + 1) % capacity;
      if (j != end) s += ", ";
    }
    s += "}";
    return s;
  }
  public String strStruct() {
    String s = "{";
    for(int i = 0; i < capacity; i++){ 
      s += D[i];
    if (i < capacity -1)
      s += ", ";
    }
    s += "}";
    System.out.println(begin);
    System.out.println(end);
    return s;
  }
}