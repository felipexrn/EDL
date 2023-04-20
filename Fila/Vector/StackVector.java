import java.util.*;
public class StackVector implements IStackVector {
  private Vector<Object> V;
  public StackVector() {
    V = new Vector<Object>();
  }
  public void enqueue(Object o) {
    V.add(o);
  }
  public Object first() {
    if(this.isEmpty()) throw new EmptyVectorException("Empty Vector");
    else {
      return V.lastElement();
    }
  } 
	public Object dequeue() {
    if(this.isEmpty()) throw new EmptyVectorException("Empty Vector");
    else {
      Object temp = V.lastElement();
      V.removeElementAt(V.size() - 1);
      return temp;
    }
  }
	public int size() {
    return V.size();
  }
  public boolean isEmpty() {
    return V.isEmpty();
  }
  public String toString() {
    String s = "{";
    int l = V.size();
    for (int i = 0; i < l; i++) {
      s += V.elementAt(i);
      if (i < l-1) s += ", ";
    }
    return s += "}";
  }
}