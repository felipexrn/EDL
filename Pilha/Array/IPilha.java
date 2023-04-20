public interface IPilha { 
  public int size();
  public boolean isEmpty();
  public void empty();
  public boolean isFull();
  public Object top() throws PilhaVaziaExcecao; 
  public void push(Object o);
  public void adicionaPilha(Pilha P);
  public Object pop() throws PilhaVaziaExcecao;
  public void print();
}

