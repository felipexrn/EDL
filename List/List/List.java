public class List {
  private Node begin;
  private Node end;
  private int size;
  public List() {
    begin = new Node();
    end = new Node();
    begin.setNext(end);
    end.setPrevious(begin);
    size = 0;
  }
  public void insertFirst(Object o) {
    Node n = new Node();
    n.setElement(o);
    n.setPrevious(begin);
    n.setNext(n.getPrevious().getNext());
    n.getPrevious().getNext().setPrevious(n);
    this.begin.setNext(n);
    size++;
  }
  public void insertLast(Object o) {
    Node n = new Node();
    n.setElement(o);
    n.setNext(end);
    n.setPrevious(n.getNext().getPrevious());
    n.getNext().getPrevious().setNext(n);
    this.end.setPrevious(n);
    size++;
  }
  public void insertBefore(Node n, Object o) {  
    Node actual = begin.getNext();
    Node newNode = new Node();
    newNode.setElement(o);
    for (int i = 0; i < index; i++) {
      actual = actual.getNext();
    }
    newNode.setPrevious(actual.getPrevious());
    newNode.setNext(actual);
    actual.getPrevious().setNext(newNode);
    actual.setPrevious(newNode);
    size++;
  }
  public void insertAfter(Node n, Object o) {
    Node actual = begin.getNext();
    Node newNode = new Node();
    newNode.setElement(o);
    for (int i = 0; i < index; i++) {
      actual = actual.getNext();
    }
    newNode.setPrevious(actual);
    newNode.setNext(actual.getNext());
    actual.getNext().setPrevious(newNode);
    actual.setNext(newNode);
    size++;
  }
  public Object remove(Node n) {}
  public Object removeFirst() {
    if (isEmpty()) throw new EmptyListException("Empty List");
    Node oldNode = begin.getNext();
    Object temp = oldNode.getElement();
    oldNode.getNext().setPrevious(begin);
    begin.setNext(oldNode.getNext());
    oldNode.setPrevious(null);
    oldNode.setNext(null);
    size--;
    return temp;
  }
  public Object removeLast() {
    if (isEmpty()) throw new EmptyListException("Empty List");
    Node oldNode = end.getPrevious();
    Object temp = oldNode.getElement();
    oldNode.getPrevious().setNext(end);
    end.setPrevious(oldNode.getPrevious());
    oldNode.setPrevious(null);
    oldNode.setNext(null);
    size--;
    return temp;
  }
  public Object removeBefore(Node n) {
    Object temp = new Object();
    Node actual = begin.getNext();
    for (int i = 0; i < index; i++) {
      actual = actual.getNext();
    }
    temp = actual.getElement();
    actual.getPrevious().setNext(actual.getNext());
    actual.getNext().setPrevious(actual.getPrevious());
    actual.setNext(null);
    actual.setPrevious(null);
    size--;
    return temp;
  }
  public Object removeAfter(Node n) {
    return this.removeBefore(index);
  }
  public Object swapElements(Node q, Node p) {}
  public Node findElement(Object o) {}
  public Object first() {
    return begin.getNext().getElement();
  }
  public Object lastt() {
    return end.getPrevious().getElement();
  }
  public Object before(Node n) {}
  public Object after(Node n) {}
  public Object replaceElement(Node n, Object o) {
    Object temp = new Object();
    Node actual = begin.getNext();
    for (int i = 0; i < index; i++) {
      actual = actual.getNext();
    }
    temp = actual.getElement();
    actual.setElement(o);
    return temp;
  }
  public boolean isFirst() {}
  public boolean isLast() {}
  public boolean isEmpty() {
    return (size == 0);
  }
  public int size() {
    return this.size;
  }
  public void empty() {
    while(!this.isEmpty()) this.removeBegin();
  }
  public String toString() {
    String s = "{";
    Node actual = new Node();
    actual = begin.getNext();
    for (int i = 0; i < size; i++) {
      s += actual.getElement();
      actual = actual.getNext();
      if (i < size -1) s += ", ";
    }
    s += "}";
    return s;
  }
}