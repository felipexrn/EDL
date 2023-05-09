public class List {
  private Node[] l;
  private int begin;
  private int end;
  private int capacity;
  public List(int cap) {
    l = new Node[cap];
    begin = 0;
    end = 0;
    capacity = cap;
  }
  public void insertFirst(Obcjet o) {
    if (this.isFull()) this.malloc();
    if (begin == 0) begin = capacity -1;
    else begin = (begin - 1) % capacity;
  }
  public void insertLast(Obcjet o) {
    if (this.isFull()) this.malloc();
    if (end == capacity -1) end = 0;
    else end = (end + 1) % capacity;
  }
  public void insertBefore(Node n, Obcjet o) {
    if (this.isFull()) this.malloc();
  }
  public void insertAfter(Node n, Obcjet o) {
    if (this.isFull()) this.malloc();
  }
  public Object remove(Node n) {
    Object temp =  n.getElement();
    //os atributos next e previous da classe Node são valores inteiros?
    return temp;
  }
  private void malloc() {
    int newCapacity = capacity *= 2;
    Node[] newList = new Node[newCapacity];
    int j = begin, newEnd = 0;
    for (int i = 0; j != end; i++) {
      newList[i] = l[j];
      j = (j + 1) % capacity;
      newEnd = i+1;
    }
    begin = 0;
    end = newEnd;
    l = newList;
    capacity = newCapacity;
  }
  public void swapElements(Node n, Node q) {
    
  }
  public void replaceElement(Node n, Object o) {
    
  }
  public Object first() {
    return l[this.begin].getElement();
  }
  public Object last() {
    int e;
    if (end == 0) e = capacity -1;
    else e = (end - 1) % capacity;
    return l[e].getElement();
  }
  public Object before(Node n) {
    return l[n.getPrevious()];
  }
  public Object after(Node n) {
    return l[n.getNext()];
  }
  public boolean isFirst(Node n) {
    return this.first() == n
  }
  public boolean isLast(Node n) {
    return this.last() == n
  }
  public boolean isEmpty() {
    return this.size() == 0;
  }
  public boolean isFull() {
    return this.size() == capacity -1;
  }
  public int size() {
    return (capacity - begin + end) % capacity;
  }
  public String toString() {
    String s = "{";
    for (int i = 0; i < this.size(); i++) {
      if (i < this.size() -1) s += ", ";
      s += l[i].getElement();
    }
    return s += "}";
  }
}