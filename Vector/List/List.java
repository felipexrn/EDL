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
  public void insertBegin(Object o) {
    Node n = new Node();
    n.setElement(o);
    n.setPrevious(begin);
    n.setNext(n.getPrevious().getNext());
    n.getPrevious().getNext().setPrevious(n);
    this.begin.setNext(n);
    size++;
  }
  public void insertEnd(Object o) {
    Node n = new Node();
    n.setElement(o);
    n.setNext(end);
    n.setPrevious(n.getNext().getPrevious());
    n.getNext().getPrevious().setNext(n);
    this.end.setPrevious(n);
    size++;
  }
  public void insertBefore(int index, Object o) {  
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
  public void insertAfter(int index, Object o) {
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
  public Object removeBegin() {
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
  public Object removeEnd() {
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
  public Object removeBefore(int index) {
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
  public Object removeAfter(int index) {
    return this.removeBefore(index);
  }
  public Object getElementAt(int index) {
    Node actual = begin.getNext();
    for (int i = 0; i < index; i++) {
      actual = actual.getNext();
    }
    return actual.getElement();
  }
  public Object getFirstElement() {
    return begin.getNext().getElement();
  }
  public Object getLastElement() {
    return end.getPrevious().getElement();
  }
  public Object replaceElementAt(int index, Object o) {
    Object temp = new Object();
    Node actual = begin.getNext();
    for (int i = 0; i < index; i++) {
      actual = actual.getNext();
    }
    temp = actual.getElement();
    actual.setElement(o);
    return temp;
  }
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