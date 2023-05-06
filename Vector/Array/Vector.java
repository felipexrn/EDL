public class Vector {
  private int size;
  private int capacity;
  private Object[] V;
  public Vector(int cap) {
    this.size = 0;
    this.capacity = cap;
    this.V = new Object[capacity];
  }
  public void insertAtRank(int r, Object o) {
    if (((r < 0) || (r > this.size -1)) && (r != 0))
      throw new InvalidIndexVectorException("Invalid Index");
    if (this.isFull()) {
      this.capacity *= 2;
      Object[] newV = new Object[capacity];
      for (int i = 0; i < size; i++) {
        newV[i] = V[i];
      }
      V = newV;
    }
    this.size++;
    for (int i = this.size-1; i > r; i--) {
      this.V[i] = V[i-1];
    }
    this.V[r] = o;
  }
  public Object removeAtRank(int r) {
    if (((r < 0) || (r > this.size -1)) && (r != 0))
      throw new InvalidIndexVectorException("Invalid Index");
    if (this.isEmpty()) throw new EmptyVectorException("Empty Vector");
    Object temp = this.V[r];
    if (this.size == 1) this.V[r] = null;
    this.size--;
    for (int i = r; i < this.size; i++) {
      this.V[i] = V[i+1];
      if (i == this.size-1) this.V[i+1] = null;
    }
    return temp;
  }
  public Object elementAtRank(int r) {
    return this.V[r];
  }
  public Object replaceAtRank(int r, Object o) {
    if (((r < 0) || (r > this.size -1)) && (r != 0))
      throw new InvalidIndexVectorException("Invalid Index");
    Object temp = this.V[r];
    this.V[r] = o;
    return temp;
  }
  public int size() {
    return this.size;
  }
  public boolean isEmpty() {
    return this.size == 0;
  }
  public boolean isFull() {
    return this.size == capacity-1;
  }
  public String strStruct() {
    String s = "{";
    for(int i = 0; i < this.capacity; i++) { 
      s += this.V[i];
      if (i < this.capacity-1) s += ", ";
    }
    return s += "}";
  }
  public String toString() {
    String s = "{";
    for(int i = 0; i < this.size; i++) { 
      s += this.V[i];
      if (i < this.size-1) s += ", ";
    }
    return s += "}";
  }
}