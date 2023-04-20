public class testQueue {
  public static void main(String[] args) {
    int in = 15, out1 = 10, out2 = 5, out3 = 1;
    System.out.println("Inserindo " + in + " elementos");
    Queue l = new Queue();
    for (int i = 0; i < in; i++) {
      l.enqueue(i);
      System.out.println(l.first());
    }
    System.out.println("Estado atual da Fila de " + l.size() + " elementos");
    System.out.println(l.toString());
    
    System.out.println("Removendo " + out1 + " elementos");
    for (int i = 0; i < out1; i++) { 
      System.out.println(l.dequeue());
    }
    System.out.println("Estado atual da Fila de " + l.size() + " elementos");
    System.out.println(l.toString());
    
    System.out.println("Removendo " + out2 + " elementos");
    for (int i = 0; i < out2; i++) { 
      System.out.println(l.dequeue());
    }
    System.out.println("Estado atual da Fila de " + l.size() + " elementos");
    System.out.println(l.toString());

    System.out.println("Removendo " + out3 + " elementos");
    for (int i = 0; i < out3; i++) { 
      System.out.println(l.dequeue());
    }
    System.out.println("Estado atual da Fila de " + l.size() + " elementos");
    System.out.println(l.toString());
  }
}