public class Pilha implements IPilha {
  Fila f1, f2;
  int capacity, tx;
  boolean FC;
  public Pilha(int tam, boolean factor, int tax) {
    f1 = new Fila(tam, factor, tax);
    f2 = new Fila(tam, factor, tax);
    capacity = tam;
    FC = factor;
    tx = tax;
  }
  public int size() {
    return f1.size();
  }   
  public boolean isEmpty() {
    return f1.isEmpty();
  }
  public boolean isFull() {
    return f1.isFull();
  }
  public Object top(){
    if (this.isEmpty()) throw new EmptyStackException("Pilha vazia"); 
    else {
      int len = f1.size();
      for (int i = 0; i < len-1; i++) f2.enqueue(f1.dequeue());
      Object temp = f1.first();
      f2.enqueue(f1.dequeue());
      len = f2.size();
      for (int i = 0; i < len; i++) f1.enqueue(f2.dequeue());
      return temp;
    }
  }
  public void push(Object o) {
    f1.enqueue(o);
  }
  public void adicionaPilha(Pilha P) {
    Pilha P2 = new Pilha(capacity, FC, tx);
    while(P.size() != 0) P2.push(P.pop());
    while(P2.size() != 0) {
      Object o = P2.pop();
      this.push(o);
      P.push(o);
    } 
  }
  public Object pop() {
    if (this.isEmpty()) throw new EmptyStackException("Pilha vazia");
    else {
      int len = f1.size();
      for (int i = 0; i < len-1; i++) f2.enqueue(f1.dequeue());
      Object temp = f1.dequeue();
      len = f2.size();
      for (int i = 0; i < len; i++) f1.enqueue(f2.dequeue());
      return temp;
    }
  }
  public void empty() {
    while (!f1.isEmpty()) f1.dequeue();
  }
  public String toString(){
    return f1.toString();
  }
}

