import java.util.*;
public class Deque {
  private Vector<Object> Deque;
  private int smaller = 0;
  public Deque() {
    Deque = new Vector<Object>();
  }
  public void insertFirst(Object o) {
    if (this.size() == 0) smaller = 0;
    else if ((int) o > (int) Deque.get(smaller)) smaller++;
    else smaller = 0;
    Deque.add(0, o);
  }
  public void insertLast(Object o) {
    if (this.size() == 0) smaller = 0;
    else if ((int) o < (int) Deque.get(smaller)) smaller = this.size();
    Deque.add(o);
  }
  public Object removeFirst() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      Object lastMin = Deque.get(smaller);
      Object temp = Deque.remove(0);
      if (temp == lastMin) this.setNextSmaller();
      else smaller--;
      return temp;
    }
  }
  public Object removeLast() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      Object lastMin = Deque.get(smaller);
      Object temp = Deque.remove(Deque.size() -1);
      if (temp == lastMin) this.setNextSmaller();
      return temp;
    }
  }
  public Object first() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      return Deque.firstElement();
    }
  }
  public Object last() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      return Deque.lastElement();
    }
  }
  public boolean isEmpty() {
    return Deque.isEmpty();
  }
  public int size() {
    return Deque.size();
  }
  public Object acessSmaller() {
    if (isEmpty()) throw new EmptyDequeException("Empty Deque");
    else {
      return Deque.get(smaller);
    }
  }
  public void setNextSmaller() {
    Object temp = Deque.get(0);
    for (int i = 0; i < this.size(); i++) {
      if ((int) Deque.get(i) < (int) temp) {
        temp = Deque.get(i);
        smaller = i;
      }
    }
  }
  public void empty() {
    Deque.removeAllElements();
  }
  public String toString() {
    return Deque.toString();
  }
}