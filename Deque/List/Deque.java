public class Deque {
  private List Deque;
  public Deque() {
    Deque = new List();
  }
  public void insertFirst(Object o) {
    Deque.insertBegin(o);
  }
  public void insertLast(Object o) {
    Deque.insertEnd(o);
  }
  public Object removeFirst() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      Object temp = Deque.removeBegin();
      return temp;
    }
  }
  public Object removeLast() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      Object temp = Deque.removeEnd();
      return temp;
    }
  }
  public Object first() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      return Deque.getFirstElement();
    }
  }
  public Object last() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      return Deque.getLastElement();
    }
  }
  public boolean isEmpty() {
    return Deque.isEmpty();
  }
  public int size() {
    return Deque.size();
  }
  public void empty() {
    Deque.empty();
  }
  public String toString() {
    return Deque.toString();
  }
}