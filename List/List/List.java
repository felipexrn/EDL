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
  } // Ok
  public void insertLast(Object o) {
    Node n = new Node();
    n.setElement(o);
    n.setNext(end);
    n.setPrevious(n.getNext().getPrevious());
    n.getNext().getPrevious().setNext(n);
    this.end.setPrevious(n);
    size++;
  } // Ok
  public void insertBefore(Node n, Object o) {  
    Node actual = begin.getNext();
    Node newNode = new Node();
    newNode.setElement(o);
    while (actual != n) {
      actual = actual.getNext();
      if (actual.getNext() == null) throw new ThereIsNoNodeException("There is no corresponding Node");
    }  
    newNode.setPrevious(actual.getPrevious());
    newNode.setNext(actual);
    actual.getPrevious().setNext(newNode);
    actual.setPrevious(newNode);
    size++;
  } // Ok
  public void insertAfter(Node n, Object o) {
    Node actual = begin.getNext();
    Node newNode = new Node();
    newNode.setElement(o);
    while (actual != n) {
      actual = actual.getNext();
      if (actual.getNext() == null) throw new ThereIsNoNodeException("There is no corresponding Node");
    }
    newNode.setPrevious(actual);
    newNode.setNext(actual.getNext());
    actual.getNext().setPrevious(newNode);
    actual.setNext(newNode);
    size++;
  } // Ok
  public Object remove(Node n) {
    if (isEmpty()) throw new EmptyListException("Empty List");
    Object temp = n.getElement();
    n.getPrevious().setNext(n.getNext());
    n.getNext().setPrevious(n.getPrevious());
    size--;
    return temp;
  } // Ok
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
  } // Ok
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
  } // Ok
  public Object removeBefore(Node n) {
    if (isEmpty()) throw new EmptyListException("Empty List");
    Object temp = new Object();
    Node actual = begin.getNext();
    while (actual != n) {
      actual = actual.getNext();
    }
    temp = actual.getElement();
    actual.getPrevious().setNext(actual.getNext());
    actual.getNext().setPrevious(actual.getPrevious());
    actual.setNext(null);
    actual.setPrevious(null);
    size--;
    return temp;
  } // Ok
  public Object removeAfter(Node n) {
    if (isEmpty()) throw new EmptyListException("Empty List");
    Object temp = new Object();
    Node actual = begin.getNext();
    while (actual != n) {
      actual = actual.getNext();
    }
    temp = actual.getElement();
    actual.getPrevious().setNext(actual.getNext());
    actual.getNext().setPrevious(actual.getPrevious());
    actual.setNext(null);
    actual.setPrevious(null);
    size--;
    return temp;
  } // Ok
  public void swapElements(Node q, Node p) {
    Object temp = q.getElement();
    q.setElement(p.getElement());
    p.setElement(temp);
  } // Ok
  public Node findElement(Object o) {
    if (isEmpty()) throw new EmptyListException("Empty List");
    
    Node actual = begin.getNext();

    while (actual.getElement() != o) {
      actual = actual.getNext();
      if (actual.getNext() == null) throw new ThereIsNoNodeException("There is no corresponding Node");
    }
    
    return actual;
  } // Ok
  public Object first() {
    return begin.getNext().getElement();
  } // Ok
  public Object last() {
    return end.getPrevious().getElement();
  } // Ok
  public Node before(Node n) {
    return n.getPrevious();
  } // Ok
  public Node after(Node n) {
    return n.getNext();
  } // Ok
  public Object replaceElement(Node n, Object o) {
    Object temp = new Object();
    Node actual = begin.getNext();
    while (actual != n) {
      actual = actual.getNext();
    }
    temp = actual.getElement();
    actual.setElement(o);
    return temp;
  } // Ok
  public boolean isFirst(Node n) {
    return begin.getNext() == n;
  } // Ok
  public boolean isLast(Node n) {
    return end.getPrevious() == n;
  } // Ok
  public boolean isEmpty() {
    return (size == 0);
  } // Ok
  public int size() {
    return this.size;
  } // Ok
  public void empty() {
    while(!this.isEmpty()) this.removeFirst();
  } // Ok
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
  } // Ok
}