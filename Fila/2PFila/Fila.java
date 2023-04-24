public class Fila implements IFila {
  Pilha p1, p2;
  public Fila(int len, boolean factor, int tax) {
    p1 = new Pilha(len, factor, tax);
    p2 = new Pilha(len, factor, tax);
  }
  public void enqueue(Object o) {
    p1.push(o);
  }
  public Object dequeue() {
    if (this.isEmpty()) throw new EmptyQueueException("");
    int len = p1.size();
    for (int i = 0; i < len-1; i++) p2.push(p1.pop());
    Object temp = p1.pop();
    len = p2.size();
    for (int i = 0; i < len; i++) p1.push(p2.pop());
    return temp;
  }
  public Object first() {
    if (this.isEmpty()) throw new EmptyQueueException("");
    int len = p1.size();
    for (int i = 0; i < len-1; i++) p2.push(p1.pop());
    Object temp = p1.top();
    len = p2.size();
    for (int i = 0; i < len; i++) p1.push(p2.pop());
    return temp;
  }
  public int size() {
    return p1.size();
  }
  public boolean isEmpty() {
    return p1.isEmpty();
  }
  public boolean isFull() {
    return p1.isFull();
  }
  public String toString() {
    return p1.toString();
  }
}