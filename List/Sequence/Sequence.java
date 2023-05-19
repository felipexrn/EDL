public class Sequence {
  private List S;
  public Sequence() {
    S = new List();
  }
  public void insertFirst(Object o) {
    S.insertFirst(o);
  }
  public void insertLast(Object o) {
    S.insertLast(o);
  }
  public void insertBefore(Node n, Object o) {
    S.insertBefore(n, o);
  }
  public void insertAfter(Node n, Object o) {
    S.insertAfter(n, o);
  }
  public Object remove(Node n) {
    if (isEmpty())
      throw new EmptySequenceException("Empty Sequence");
    return S.remove(n);
  }
  public Object replaceElement(Node n, Object o) {
    return S.replaceElement(n, o);
  }
  public void swapElements(Node q, Node p) {
    S.swapElements(q, p);
  }
  public void insertAtRank(int r, Object o) {
    if (((r < 0) || (r > size() -1)) && (r != 0))
      throw new InvalidIndexSequenceException("Invalid Index");
    Node actual = S.getBegin();
    for (int i = 0; i < r; i++) actual = after(actual);
    insertBefore(actual, o);
  }
  public Object removeAtRank(int r) {
    if (((r < 0) || (r > size() -1)) && (r != 0))
      throw new InvalidIndexSequenceException("Invalid Index");
    if (isEmpty())
      throw new EmptySequenceException("Empty Sequence");
    Node actual = S.getBegin();
    for (int i = 0; i < r; i++) actual = after(actual);
    return remove(actual);
  }
  public Object elementAtRank(int r) {
    if (((r < 0) || (r > size() -1)) && (r != 0))
      throw new InvalidIndexSequenceException("Invalid Index");
    Node actual = S.getBegin();
    for (int i = 0; i < r; i++) actual = after(actual);
    return actual.getElement();
  }
  public Object replaceAtRank(int r, Object o) {
    if (((r < 0) || (r > size() -1)) && (r != 0))
      throw new InvalidIndexSequenceException("Invalid Index");
    if (isEmpty())
      throw new EmptySequenceException("Empty Sequence");
    Node actual = S.getBegin();
    for (int i = 0; i < r; i++) actual = after(actual);
    Object temp = actual.getElement();
    actual.setElement(o);
    return temp;
  }
  public Object atRank(int r) {
    if (((r < 0) || (r > size() -1)) && (r != 0))
      throw new InvalidIndexSequenceException("Invalid Index");
    if (isEmpty())
      throw new EmptySequenceException("Empty Sequence");
     Node actual = S.getBegin();
    for (int i = 0; i < r; i++) actual = after(actual);
    return actual.getElement();
  }
  public int rankOf(Object o) {
    if (isEmpty())
      throw new EmptySequenceException("Empty Sequence");

    int r = 0;
    Node actual = S.getBegin();
    while (actual.getElement() != o) {
      r++;
      actual = actual.getNext();
      if (actual.getNext() == null)
        throw new ThereIsNoNodeException("There is no corresponding Node");
    }
    
    return r;
  }
  public Object first() {
    return S.first();
  }
  public Object last() {
    return S.last();
  }
  public Node before(Node n) {
    return S.before(n);
  }
  public Node after(Node n) {
    return S.after(n);
  }
  public int size() {
    return S.size();
  }
  public boolean isEmpty() {
    return S.isEmpty();
  }
  public String toString() {
    return S.toString();
  }
}