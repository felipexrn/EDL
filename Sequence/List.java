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
    Node newNode = new Node();
    newNode.setElement(o);
    newNode.setPrevious(n.getPrevious());
    newNode.setNext(n);
    n.getPrevious().setNext(newNode);
    n.setPrevious(newNode);
    size++;
  } 
  public void insertAfter(Node n, Object o) {
    Node newNode = new Node();
    newNode.setElement(o);
    newNode.setPrevious(n);
    newNode.setNext(n.getNext());
    n.getNext().setPrevious(newNode);
    n.setNext(newNode);
    size++;
  } 
  public Object remove(Node n) {
    if (isEmpty()) throw new EmptyListException("Empty List");
    Object temp = n.getElement();
    n.getPrevious().setNext(n.getNext());
    n.getNext().setPrevious(n.getPrevious());
    size--;
    return temp;
  } 
  public Object removeFirst() {
    if (isEmpty()) throw new EmptyListException("Empty List");
    Node oldNode = begin.getNext();
    Object temp = oldNode.getElement();
    oldNode.getNext().setPrevious(begin);
    begin.setNext(oldNode.getNext());
    size--;
    return temp;
  } 
  public Object removeLast() {
    if (isEmpty()) throw new EmptyListException("Empty List");
    Node oldNode = end.getPrevious();
    Object temp = oldNode.getElement();
    oldNode.getPrevious().setNext(end);
    end.setPrevious(oldNode.getPrevious());
    size--;
    return temp;
  } 
  public Object removeBefore(Node n) {
    if (isEmpty()) throw new EmptyListException("Empty List");
    Object temp = n.getElement();
    n.getPrevious().setNext(n.getNext());
    n.getNext().setPrevious(n.getPrevious());
    size--;
    return temp;
  } 
  public Object removeAfter(Node n) {
    if (isEmpty()) throw new EmptyListException("Empty List");
    Object temp = n.getElement();
    n.getPrevious().setNext(n.getNext());
    n.getNext().setPrevious(n.getPrevious());
    size--;
    return temp;
  } 
  public void swapElements(Node q, Node p) {
    Object temp = q.getElement();
    q.setElement(p.getElement());
    p.setElement(temp);
  } 
  public Node findElement(Object o) {
    if (isEmpty()) throw new EmptyListException("Empty List");
    
    Node actual = begin.getNext();

    while (actual.getElement() != o) {
      actual = actual.getNext();
      if (actual.getNext() == null)
        throw new ThereIsNoNodeException("There is no corresponding Node");
    }
    
    return actual;
  } 
  public Object first() {
    return begin.getNext().getElement();
  } 
  public Object last() {
    return end.getPrevious().getElement();
  } 
  public Node before(Node n) {
    return n.getPrevious();
  } 
  public Node after(Node n) {
    return n.getNext();
  } 
  public Object replaceElement(Node n, Object o) {
    Object temp = new Object();
    Node actual = begin.getNext();
    while (actual != n) {
      actual = actual.getNext();
    }
    temp = actual.getElement();
    actual.setElement(o);
    return temp;
  } 
  public boolean isFirst(Node n) {
    return begin.getNext() == n;
  } 
  public boolean isLast(Node n) {
    return end.getPrevious() == n;
  } 
  public Node getBegin() {
    return begin.getNext();
  }
  public Node getEnd() {
    return end.getPrevious();
  }
  public boolean isEmpty() {
    return (size == 0);
  } 
  public int size() {
    return this.size;
  } 
  public void empty() {
    while(this.size() != 0) this.removeFirst();
  } 
  public String strStruct() {
    String s = "{";
    Node actual = begin;
    while (actual.getNext() != null) {
      s += actual.getElement();
      if (actual != begin  || actual != end) s += ", ";
      actual = actual.getNext();
    }
    return s += actual.getElement() + "}";
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