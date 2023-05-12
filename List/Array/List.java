public class List {
  private Node[] l;
  private int begin;
  private int end;
  private int capacity;
  public List(int cap) {
    this.l = new Node[cap];
    this.begin = 0;
    this.end = 0;
    this.capacity = cap;
  }
  public void insertFirst(Object o) {
    if (this.isFull()) this.malloc();
    if (this.begin == 0) this.begin = this.capacity -1;
    else this.begin = (this.begin - 1) % this.capacity;
    Node newNode = new Node();
    newNode.setElement(o);
    newNode.setNext((this.begin + 1) % this.capacity);
    newNode.setPrevious((this.begin - 1) % this.capacity);
    l[this.begin] = newNode;
  }
  public void insertLast(Object o) {
    if (this.isFull()) this.malloc();
    Node newNode = new Node();
    newNode.setElement(o);
    newNode.setNext((this.end + 1) % this.capacity);
    newNode.setPrevious((this.end - 1) % this.capacity);
    l[this.end] = newNode;
    if (this.end == this.capacity -1) this.end = 0;
    else this.end = (this.end + 1) % this.capacity;
  }
  public void insertBefore(Node n, Object o) {
    if (this.isFull()) this.malloc();
    
    int r = this.begin;
    for (int i = 0; l[i] != n; i++) {
      r = (r + 1) % this.capacity;
      if (i == this.size()) throw new ThereIsNoNodeException("There is no corresponding Node");
    } 
      
    for (int i = (end -1) % capacity; i != r; i = (i -1) % this.capacity) {
      this.l[i].setNext((this.l[i].getNext() + 1) % this.capacity); 
      this.l[i].setPrevious((this.l[i].getPrevious() + 1) % this.capacity); 
      this.l[i] = this.l[(i -1) % this.capacity];
    }

    Node newNode = new Node();
    newNode.setElement(o);
    newNode.setNext((r + 1) % this.capacity);
    newNode.setPrevious((r - 1) % this.capacity);
    this.l[r] = newNode;
  }
  public void insertAfter(Node n, Object o) {
    if (this.isFull()) this.malloc();
    
    int r = this.begin;
    for (int i = 0; l[i] != n; i++) {
      r = (r + 1) % this.capacity;
      if (i == this.size()) throw new ThereIsNoNodeException("There is no corresponding Node");
    } 

    r = (r + 1) % this.capacity;
      
    for (int i = (end -1) % capacity; i != r; i = (i -1) % this.capacity) {
      this.l[i].setNext((this.l[i].getNext() + 1) % this.capacity); 
      this.l[i].setPrevious((this.l[i].getPrevious() + 1) % this.capacity); 
      this.l[i] = this.l[(i -1) % this.capacity];
    }

    Node newNode = new Node();
    newNode.setElement(o);
    newNode.setNext((r + 1) % this.capacity);
    newNode.setPrevious((r - 1) % this.capacity);
    this.l[r] = newNode;
  }
  public Object remove(Node n) {
    int r = this.begin;
    for (int i = 0; l[i] != n; i++) {
      r = (r + 1) % this.capacity;
      if (i == this.size()) throw new ThereIsNoNodeException("There is no corresponding Node");
    } 

    for (int i = r; i != (end -1) % capacity; i = (i +1) % this.capacity) {
      this.l[i].setNext((this.l[i].getNext() - 1) % this.capacity); 
      this.l[i].setPrevious((this.l[i].getPrevious() - 1) % this.capacity); 
      this.l[i] = this.l[(i +1) % this.capacity];
    }
    
    return n.getElement(); 
  }
  private void malloc() {
    int newCapacity = this.capacity *= 2;
    Node[] newList = new Node[newCapacity];
    int j = this.begin, newEnd = 0;
    for (int i = 0; j != this.end; i++) {
      newList[i] = this.l[j];
      j = (j + 1) % this.capacity;
      newEnd = i+1;
    }
    this.begin = 0;
    this.end = newEnd;
    this.l = newList;
    this.capacity = newCapacity;
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
    int r = this.begin;
    for (int i = 0; l[i].getElement() != o; i++) {
      r = (r + 1) % this.capacity;
      if (i == this.size()) throw new ThereIsNoNodeException("There is no corresponding Node");
    } 
    return l[r];
  }
  public Object first() {
    return this.l[this.begin].getElement();
  }
  public Object last() {
    int e;
    if (this.end == 0) e = this.capacity -1;
    else e = (this.end - 1) % this.capacity;
    return this.l[e].getElement();
  }
  public Object before(Node n) {
    return this.l[n.getPrevious()];
  }
  public Object after(Node n) {
    return this.l[n.getNext()];
  }
  public boolean isFirst(Node n) {
    return this.first() == n;
  }
  public boolean isLast(Node n) {
    return this.last() == n;
  }
  public boolean isEmpty() {
    return this.size() == 0;
  }
  public boolean isFull() {
    return this.size() == this.capacity -1;
  }
  public int size() {
    return (this.capacity - this.begin + this.end) % this.capacity;
  }
  public String toString() {
    String s = "{";
    for (int i = 0; i < this.size(); i++) {
      if (i < this.size() -1) s += ", ";
      s += this.l[i].getElement();
    }
    return s += "}";
  }
}