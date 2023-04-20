public class Queue implements IFila {
  private int length = 0;
  private Node first = null;
  public void enqueue(Object o) {
    Node newNode = new Node();
    Node oldFirst = first;
    this.first = newNode;
    newNode.setElement(o);
    newNode.setNext(oldFirst);
    this.length++;
  }
  public Object first() {
    if (this.isEmpty()) throw new EmptyQueueException("Empty List");
    else return this.first.getElement();
  }
  public Object dequeue() {
    if (this.isEmpty()) throw new EmptyQueueException("Empty List");
    else {
      Node temp = this.first;
      Object element = temp.getElement();
      while (temp.getNext() != null) {
        Node tempNext = temp.getNext();
        if (tempNext.getNext() == null) {
          element = tempNext.getElement();
          temp.setNext(null);
          break;
        }
        temp = tempNext;
      }
      this.length--;
      return element;
    }
  }
  public int size() {
    return length;
  }
  public boolean isEmpty() {
    return length == 0;
  }
  public String toString() {
    String list = "";
    Node actualNode = this.first;
    for (int i = 0; i < this.length; i++) {
      list = actualNode.getElement().toString() + list;
      if (i < this.length - 1) {
        list = ", " + list;   
      }
      actualNode = actualNode.getNext();  
    }
    return list = "{" + list + "}";
  }
}