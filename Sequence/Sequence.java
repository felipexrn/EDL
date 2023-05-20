public class Sequence extends List{
  private List S;
  public void insertAtRank(int r, Object o) {
    if (((r < 0) || (r > size() -1)) && (r != 0))
      throw new InvalidIndexSequenceException("Invalid Index");
    Node actual = getBegin();
    for (int i = 0; i < r; i++) actual = after(actual);
    insertBefore(actual, o);
  }
  public Object removeAtRank(int r) {
    if (((r < 0) || (r > size() -1)) && (r != 0))
      throw new InvalidIndexSequenceException("Invalid Index");
    if (isEmpty())
      throw new EmptySequenceException("Empty Sequence");
    Node actual = getBegin();
    for (int i = 0; i < r; i++) actual = after(actual);
    return remove(actual);
  }
  public Object elementAtRank(int r) {
    if (((r < 0) || (r > size() -1)) && (r != 0))
      throw new InvalidIndexSequenceException("Invalid Index");
    Node actual = getBegin();
    for (int i = 0; i < r; i++) actual = after(actual);
    return actual.getElement();
  }
  public Object replaceAtRank(int r, Object o) {
    if (((r < 0) || (r > size() -1)) && (r != 0))
      throw new InvalidIndexSequenceException("Invalid Index");
    if (isEmpty())
      throw new EmptySequenceException("Empty Sequence");
    Node actual = getBegin();
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
     Node actual = getBegin();
    for (int i = 0; i < r; i++) actual = after(actual);
    return actual.getElement();
  } 
  public int rankOf(Object o) {
    if (isEmpty())
      throw new EmptySequenceException("Empty Sequence");

    int r = 0;
    Node actual = getBegin();
    while (actual.getElement() != o) {
      r++;
      actual = actual.getNext();
      if (actual.getNext() == null)
        throw new ThereIsNoNodeException("There is no corresponding Node");
    }
    
    return r;
  }
}