public class ReverteFila {
  public static Fila reverter(Fila f) {
    Pilha p = new Pilha(f.size(), true, 0);
    int size = f.size();
    for (int i = 0; i < size; i++) p.push(f.dequeue());
    for (int i = 0; i < size; i++) f.enqueue(p.pop());
    return f;
  }
  public static void main(String[] args) {
    Fila f = new Fila(1, 1, 0);
    for (int i = 0; i < 10; i++) f.enqueue(i);
    
    System.out.println("Fila criada");
    System.out.println(f.toString());
    
    f = reverter(f);

    System.out.println("Fila invertida");
    System.out.println(f.toString());
  }
}