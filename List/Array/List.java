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
  } // Ok
  public void insertFirst(Object o) {
    if (isFull()) malloc();
    if (begin == 0) begin = capacity -1;
    else begin = (begin - 1);
    Node newNode = new Node();
    newNode.setElement(o);
    l[begin] = newNode;
  } // Ok
  public void insertLast(Object o) {
    if (isFull()) malloc();
    Node newNode = new Node();
    newNode.setElement(o);
    l[end] = newNode;
    end = (end + 1) % capacity;
  } // Ok
  public void insertBefore(Node n, Object o) {
    if (isFull()) malloc();
    
    int r = begin;
    for (int i = 0; l[r] != n; i++) {
      r = (r + 1) % capacity;
      if (i == size()) throw new ThereIsNoNodeException("There is no corresponding Node");
    } 
    end = (end +1) % capacity;
    System.out.println("before r " + r);
    
    int j;
    if (end == 0) j = capacity -1;
    else j = end -1;
    for (int i = end; i != r; i = (i -1) % capacity) {
      if (i == -1) i = capacity -1;
      l[i] = l[j];
      j = (j -1) % capacity;
      if (j == -1) j = capacity -1;
    }

    Node newNode = new Node();
    newNode.setElement(o);
    l[r] = newNode;
  } // Ok
  public void insertAfter(Node n, Object o) {
    if (isFull()) malloc();
    
    int r = begin;
    for (int i = 0; l[i] != n; i++) {
      r = (r + 1) % capacity;
      if (i == size()) throw new ThereIsNoNodeException("There is no corresponding Node");
    } 
    r = (r + 1) % capacity;
    System.out.println("after r " + r);
      
    int j;
    if (end == 0) j = capacity -1;
    else j = end -1;
    for (int i = end; i != r; i = (i -1) % capacity) {
      if (i == -1) i = capacity -1;
      l[i] = l[j];
      j = (j -1) % capacity;
      if (j == -1) j = capacity -1;
    }
    end = (end +1) % capacity;
    
    Node newNode = new Node();
    newNode.setElement(o);
    l[r] = newNode;
  } // Ok
  public Object remove(Node n) {
    if (isEmpty()) throw new EmptyListException("Empty List");
    int r = begin;
    for (int i = 0; l[i] != n; i++) {
      r = (r + 1) % capacity;
      if (i == size()) throw new ThereIsNoNodeException("There is no corresponding Node");
    } 

    int j = (r +1) % capacity;
    for (int i = r; i != end; i = (i +1) % capacity) {
      l[i] = l[j];
      j = (j +1) % capacity;
    }
    
    if (end == 0) end = capacity -1;
    else end--;
    
    return n.getElement(); 
  } // Ok
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
  } // Ok
  public void swapElements(Node n, Node q) {
    Object temp = n.getElement();
    n.setElement(q.getElement());
    q.setElement(temp);
  } // Ok
  public Object replaceElement(Node n, Object o) {
    Object temp = n.getElement();
    n.setElement(o);
    return temp;
  } // Ok
  public Node findElement(Object o) {
    int index = begin;
    for (int i = 0; i < size(); i++) {
      if (o != l[index].getElement()) index = (index + 1) % capacity;
      else break;
    } 
    if (index == size())
      throw new ThereIsNoNodeException("There is no corresponding Node");
    return l[index];
  } // Ok
  public Object first() {
    return l[begin].getElement();
  } // Ok
  public Object last() {
    int e;
    if (end == 0) e = capacity -1;
    else e = end - 1;
    return l[e].getElement();
  } // ok
  public Node before(Node n) {
    
    int index = begin;
    for (int i = 0; i < size(); i++) {
      if (n != l[index]) index = (index + 1) % capacity;
      else break;
    }

    if (index == size() || index == 0)
      throw new ThereIsNoNodeException("There is no corresponding Node");
    
    index--;
    
    return l[index];
  } // Ok
  public Node after(Node n) {
    int index = begin;
    for (int i = 0; i < size(); i++) {
      if (n != l[index]) index = (index + 1) % capacity;
      else break;
    }

    if (index == size() || index == capacity -1)
      throw new ThereIsNoNodeException("There is no corresponding Node");
    
    index++;
     
    return l[index];
  } // Ok
  public boolean isFirst(Node n) {
    return l[begin] == n;
  } // Ok
  public boolean isLast(Node n) {
    int e;
    if (end == 0) e = capacity -1;
    else e = (end - 1) % capacity;
    return l[e] == n;
  } // Ok
  public boolean isEmpty() {
    return size() == 0;
  } // Ok
  public boolean isFull() {
    return size() == capacity -1;
  } // Ok
  public int size() {
    return (capacity - begin + end) % capacity;
  } // Ok
  public int getBegin() {
    return begin;
  } // Ok
  public int getEnd() {
    return end;
  } // Ok
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
  } // Ok
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
  } // Ok
}