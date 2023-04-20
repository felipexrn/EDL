public class Pilha implements IPilha {
  private int t = -1;
  private Object[] S;
  private int capacity;
  private boolean FC;
  private int tx;
  public Pilha(int tam, boolean Crescimento, int taxa) {
    FC = Crescimento;  
    tx = taxa;
    S = new Object[tam];
    capacity = tam;
  }
  public int size() {
    return t+1;
  }   
  public boolean isEmpty() {
    return (t == -1);
  }
  public boolean isFull() {
    return (t+1 == capacity);
  }
  public Object top(){
    if (this.isEmpty()) throw new PilhaVaziaExcecao("Pilha vazia"); 
    else return S[t];
  }
  public void push(Object o) {
    if (this.isFull()) {
      int oldCapacity = capacity;
      if (FC) capacity *= 2; // se verdadeiro duplica
      else capacity += tx;
      Object[] temp = new Object[capacity];
      for (int i = 0; i <= t; i++) {
        temp[i] = S[i];
      }
      S = temp;
    }
    S[++t] = o;
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
    if (this.isEmpty()) throw new PilhaVaziaExcecao("Pilha vazia");
    else {
      Object temp = S[t];
      S[t] = null;
      t = t-1;
      return temp;
    }
  }
  public void empty() {
    t = -1;
  }
  public void print(){
    System.out.print("{");
    for(int i = 0; i <= t; i++){ 
      System.out.print(S[i]);
    if (i <= t-1)
      System.out.print(", ");
    }
    System.out.println("}");
  }
}

