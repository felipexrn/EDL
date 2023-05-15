public class List {
  private Node[] l;
  private int begin;
  private int end;
  private int capacity;
  public List() {
    capacity = 1;
    l = new Node[capacity];
    begin = 0;
    end = 0;
  }
  public void insertFirst(Object o) {
    if (isFull()) malloc();
    if (begin == 0) begin = capacity -1;
    else begin = (begin - 1);
    Node newNode = new Node();
    newNode.setElement(o);
    l[begin] = newNode;
  }
  public void insertLast(Object o) {
    if (isFull()) malloc();
    Node newNode = new Node();
    newNode.setElement(o);
    l[end] = newNode;
    end = (end + 1) % capacity;
  }
  public void insertBefore(Node n, Object o) {
    if (isFull()) malloc();
    
    int r = begin;
    for (int i = 0; l[r] != n; i++) {
      r = (r + 1) % capacity;
      if (i == size()) throw new ThereIsNoNodeException("There is no corresponding Node");
    } 
    if (begin == r && begin == 0) begin = capacity -1;
    if (r == 0) r = capacity -1;
    else r--;
    System.out.println("before r " + r);
    
    int j;
    if (end == 0) j = capacity -1;
    else j = end -1;
    for (int i = end; i != r; i = (i +1) % capacity) {
      l[i] = l[j];
      j = (j +1) % capacity;
    }
    //end = (end +1) % capacity;

    Node newNode = new Node();
    newNode.setElement(o);
    l[r] = newNode;
  }
  public void insertAfter(Node n, Object o) {
    if (isFull()) malloc();
    
    int r = begin;
    for (int i = 0; l[i] != n; i++) {
      r = (r + 1) % capacity;
      if (i == size()) throw new ThereIsNoNodeException("There is no corresponding Node");
    } 
    r = (r + 1) % capacity;
    System.out.println("after r " + r);
      
    for (int i = (end -1) % capacity; i != r; i = (i -1) % capacity) {
      l[i] = l[(i -1) % capacity];
    }

    Node newNode = new Node();
    newNode.setElement(o);
    l[r] = newNode;
  }
  public Object remove(Node n) {
    int r = begin;
    for (int i = 0; l[i] != n; i++) {
      r = (r + 1) % capacity;
      if (i == size()) throw new ThereIsNoNodeException("There is no corresponding Node");
    } 

    for (int i = r; i != (end -1) % capacity; i = (i +1) % capacity) {
      l[i] = l[(i +1) % capacity];
    }
    
    return n.getElement(); 
  }
  private void malloc() {
    int newCapacity = capacity * 2;
    Node[] newList = new Node[newCapacity];
    int j = begin, newEnd = 0;
    for (int i = 0; i < size(); i++) {
      newList[i] = l[j];
      j = (j + 1) % capacity;
      newEnd = i+1;
    }
    l = newList;
    capacity = newCapacity;
    begin = 0;
    end = newEnd;
    strStruct();
  }
  public void swapElements(Node n, Node q) {
    Object temp = n.getElement();
    n.setElement(q.getElement());
    q.setElement(temp);
  }
  public Object replaceElement(Node n, Object o) {
    Object temp = n.getElement();
    n.setElement(o);
    return temp;
  }
  public Node findElement(Object o) {
    int index = begin;
    for (int i = 0; i < size(); i++) {
      if (o != l[index].getElement()) index = (index + 1) % capacity;
      else break;
    } 
    if (index == size())
      throw new ThereIsNoNodeException("There is no corresponding Node");
    return l[index];
  }
  public Object first() {
    return l[begin].getElement();
  }
  public Object last() {
    int e;
    if (end == 0) e = capacity -1;
    else e = (end - 1) % capacity;
    return l[e].getElement();
  }
  public Node before(Node n) {
    int index = begin;
    for (int i = 0; i < size(); i++) {
      if (n != l[index]) index = (index + 1) % capacity;
      else break;
    }
    if (index == size())
      throw new ThereIsNoNodeException("There is no corresponding Node");
    return l[index];
  }
  public Node after(Node n) {
    int index = begin;
    for (int i = 0; i < size(); i++) {
      if (n != l[index]) index = (index + 1) % capacity;
      else break;
    }
    if (index == size())
      throw new ThereIsNoNodeException("There is no corresponding Node");
    return l[index];
  }
  public boolean isFirst(Node n) {
    return first() == n;
  }
  public boolean isLast(Node n) {
    return last() == n;
  }
  public boolean isEmpty() {
    return size() == 0;
  }
  public boolean isFull() {
    return size() == capacity -1;
  }
  public int size() {
    return (capacity - begin + end) % capacity;
  }
  public int getBegin() {
    return begin;
  }
  public int getEnd() {
    return end;
  }
  public String strStruct() {
    String s = "{";
    Node actual = l[begin];
    for (int i = 0; i < capacity; i++) {
      if (l[i] == null) s += l[i];
      else s += l[i].getElement();
      if (i < capacity -1) {
        s += ", ";   
      }
    }
    return s += "}";
  }
  public String toString() {
    String s = "{";
    int j = begin;
    for (int i = 0; i < size(); i++) {
      s += l[j].getElement();
      j = (j + 1) % capacity;
      if (i < size() -1) {
        s += ", ";   
      }
    }
    return s += "}";
  }
}