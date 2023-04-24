public class Deque {
  private Object[] D;
  private int begin;
  private int end;
  private int capacity;
  private boolean fc;
  private int tx;
  private int menor;
  public Deque(int cap, boolean factor, int tax) {
    capacity = cap;
    D = new Object[cap];
    begin = 0;
    end = len -1;
    fc = factor;
    tx = tax;    
    menor = 0;
  }
  public void insertFirst(Object o) {}
  public void insertLast(Object o) {
    // implementação
    if (capacity > 0)
      if (o < D[menor]) menor = (menor + 1) % capacity;
  }
  public Object removeLast() {
    Object temp = D[end];
    if (end = capacity -1) begin = 0;
    end = (end + 1) % capacity;
    return temp;
  }
  public Object removeFirst() {
    Object temp = D[begin];
    if (begin = 0) begin = capacity -1;
    else begin = (begin - 1) % capacity;
    return temp;
  }
  //public Object First() {}
  //public Object Last() {}
  public Object AcessarMenor() {
    if (length == 0) throw new EmptyDequeException("Empty Deque");
    else return D[menor];
  }
}