import java.util.*;
public class PilhaVector implements IPilhaVector {
  private Vector<Object> V;
  public PilhaVector() {
    V = new Vector<Object>();
  }
  public void push(Object o) {
    V.add(o);
  }
  public Object top() {
    if(this.isEmpty()) throw new VectorEmptyException("Empty Vector");
    else {
      return V.lastElement();
    }
  } 
	public Object pop() {
    if(this.isEmpty()) throw new VectorEmptyException("Empty Vector");
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
  public String list() {
    String s = "{";
    int l = V.size();
    for (int i = 0; i < l; i++) {
      s += V.elementAt(i);
      if (i < l-1) s += ", ";
    }
    return s += "}";
  }
}