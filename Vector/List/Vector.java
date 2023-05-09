public class Vector {
  private List V;
  public Vector() {
    this.V = new List();
  }
  public void insertAtRank(int r, Object o) {
    if (((r < 0) || (r > this.V.size() -1)) && (r != 0))
      throw new InvalidIndexVectorException("Invalid Index");
    V.insertBefore(r, o);
  }
  public Object removeAtRank(int r) {
    if (((r < 0) || (r > this.V.size() -1)) && (r != 0))
      throw new InvalidIndexVectorException("Invalid Index");
    if (this.isEmpty()) throw new EmptyVectorException("Empty Vector");
    return this.V.removeBefore(r);
  }
  public Object elementAtRank(int r) {
    return this.V.getElementAt(r);
  }
  public Object replaceAtRank(int r, Object o) {
    if (((r < 0) || (r > this.V.size() -1)) && (r != 0))
      throw new InvalidIndexVectorException("Invalid Index");
    return V.replaceElementAt(r, o);
  }
  public int size() {
    return this.V.size();
  }
  public boolean isEmpty() {
    return this.V.size() == 0;
  }
  public String toString() {
    return V.toString();
  }
}