public class PilhaRN { 
  private int tr = -1;
  private int tn;
  private Object[] S;
  private int capacity;
  private int FC;
  public PilhaRN(int tam) {
    S = new Object[tam];
    capacity = tam;
    tn = capacity;
  }
  public int size(boolean rubro) {
    if (rubro)
      return tr+1;
    else return capacity - tn;
  }   
  public boolean isEmpty(boolean rubro) {
    if (rubro)
      return (tr == -1);
    else return (tn == capacity);
  }
  public boolean isFull() {
    return (tr+1 == tn);
  }
  public Object top(boolean rubro){
    if (rubro)
      if (this.isEmpty(rubro)) throw new PilhaVaziaExcecao("Pilha vazia"); 
      else return S[tr];
    else if (this.isEmpty(rubro)) throw new PilhaVaziaExcecao("Pilha vazia"); 
      else return S[tn];
  }
  public void push(Object o, boolean rubro) {
    if (this.isFull()) {
      int oldCapacity = capacity;
      capacity = capacity*2;
      Object[] temp = new Object[capacity];
      for (int i = 0; i <= tr; i++) {
        temp[i] = S[i];
      }
      int j = capacity-1;
      for (int i = oldCapacity-1; i >= tn; i--) {
        temp[j--] = S[i];
      }
      tn = j+1;
      S = temp;
    }
    if (rubro) {
      S[++tr] = o;
    } else {
      S[--tn] = o;
    }
  }
  public Object pop(boolean rubro) {
    if (rubro)
      if (this.isEmpty(rubro)) throw new PilhaVaziaExcecao("Pilha vazia");
      else {
        Object temp = S[tr];
        S[tr--] = null;
        return temp;
      }
    else if (this.isEmpty(rubro)) throw new PilhaVaziaExcecao("Pilha vazia");
      else {
        Object temp = S[tn];
        S[tn++] = null;
        return temp;
      }
  }
  public void printPilha(boolean rubro){
    if (rubro)
      if (this.isEmpty(rubro)) System.out.println("");
      else {
        System.out.print("{");
        for(int i = 0; i < tr+1; i++){ 
          if (S[i] != null)
  		      System.out.print(S[i]);
          else System.out.print("");
        if (i < tr)
          System.out.print(", ");
  		  }
        System.out.println("}");
      }
    else
      if (this.isEmpty(rubro)) System.out.println("");
    else {
      System.out.print("{");
      for(int i = capacity-1; i > tn-1; i--){ 
        if (S[i] != null)
          System.out.print(S[i]);
        else System.out.print("");
      if (i > tn)
        System.out.print(", ");
      }
      System.out.println("}");
    }
  }
  public void printPilhaRN(){
    System.out.print("{");
    for(int i = 0; i < capacity; i++){
      if (S[i] != null)
        System.out.print(S[i]);
      else  System.out.print("");
    if (i < capacity-1)
      System.out.print(", ");
    }
    System.out.println("}");
  }
}

