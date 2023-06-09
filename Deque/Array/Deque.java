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
    if (isFull()) this.malloc();
    if (begin == 0) begin = capacity -1;
    else begin = (begin - 1) % capacity;
    D[begin] = o;
    if (this.size() == 1) smaller = begin;
    else if ((int) o < (int) D[smaller]) smaller = begin;
  }
  public void insertLast(Object o) {
    if (isFull()) this.malloc();
    D[end] = o;
    if (end == capacity -1) end = 0;
    else end = (end + 1) % capacity;
    if (this.size() == 1) smaller = begin;
    else if ((int) o < (int) D[smaller]) {
      if (end == 0) smaller = capacity -1;
      else smaller = (end - 1) % capacity;
    }
  }
  public Object removeFirst() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      Object lastMin = D[smaller];
      Object temp = D[begin];
      D[begin] = null;
      if (begin == capacity -1) begin = 0;
      else begin = (begin + 1) % capacity;
      if (temp == lastMin) this.setNextSmaller();
      return temp;
    }
  }
  public Object removeLast() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      Object lastMin = D[smaller];
      if (end == 0) end = capacity -1;
      else end = (end - 1) % capacity;
      Object temp = D[end];
      D[end] = null;
      if (temp == lastMin) this.setNextSmaller();
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
      else temp = D[(end - 1) % capacity];
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
      return D[smaller];
    }
  }
  public void setNextSmaller() {
    Object temp = D[begin];
    int j = begin;
    for (int i = 0; j != end; i++){
      if (D[j] != null && (int) D[j] <= (int) temp) {
        temp = D[j];
        smaller = j;
      }
      j = (j + 1) % capacity;
    }
  }
  private void malloc() {
    int newCapacity = capacity;
    if (isd) newCapacity *= 2;
    else newCapacity += tx;
    Object[] newDeque = new Object[newCapacity];
    int j = begin, newEnd = 0;
    smaller = j;
    for (int i = 0; j != end; i++) {
      newDeque[i] = D[j];
      j = (j + 1) % capacity;
      newEnd = i+1;
      if ((int) newDeque[i] <= (int) D[smaller]) smaller = i;
    }
    begin = 0;
    end = newEnd;
    D = newDeque;
    capacity = newCapacity;
  }
  public void empty() {
    while (!this.isEmpty()) this.removeLast();
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
    return s;
  }
}