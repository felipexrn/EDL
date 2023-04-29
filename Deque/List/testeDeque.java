public class testeDeque {
  public static void main(String[] args) {
    List l = new List();
    System.out.println("Inserindo no começo");
    for (int i = 0; i < 10; i++) {
      l.insertBegin(i);
    }
    System.out.println(l.toString());
    System.out.println(l.size());
    System.out.println("Inserindo no fim");
    for (int i = 0; i < 10; i++) {
      l.insertEnd(i);
    }
    System.out.println(l.toString());
    System.out.println(l.size());
    System.out.println("Removendo no começo");
    for (int i = 0; i < 5; i++) {
      l.removeBegin();
    }
    System.out.println(l.toString());
    System.out.println(l.size());
    System.out.println("Removendo no fim");
    for (int i = 0; i < 5; i++) {
      l.removeEnd();
    }
    System.out.println(l.toString());
    System.out.println(l.size());
    System.out.println("Esvaziando lista");
    l.empty();
    System.out.println(l.toString());
    System.out.println(l.size());
    System.out.println("Teste de exceção");
    l.removeEnd();
    /*int in = -10, out = 5, menor1 = -10, menor2 = -11;
    
    Deque D = new Deque();
    System.out.println("Inserindo " + Math.abs(in) + " elementos no fim do Deque");
    for (int i = 0; i > in; i--) {
      if (i % 2 == 0) {
        D.insertLast(i);
        System.out.println(D.last());
      }
      else {
        D.insertFirst(i);
        System.out.println(D.first());
      }
      
    }
    System.out.println("Estado do Deque");
    System.out.println(D.toString());
    System.out.println("size " + D.size());
    System.out.println("menor " + D.acessSmaller());

    System.out.println("Removendo " + out + " elementos no fim do Deque");
    for (int i = 0; i < out; i++) {
      if (i % 2 == 0) {
        System.out.println(D.removeLast());
      }
      else {
        System.out.println(D.removeFirst());
      }
    }
    System.out.println("Estado do Deque");
    System.out.println(D.toString());
    System.out.println("size " + D.size());
    System.out.println("menor " + D.acessSmaller());

    System.out.println("Inserindo novo menor " + menor1 + " no Deque");
    D.insertLast(menor1);
    System.out.println("Estado do Deque");
    System.out.println(D.toString());
    System.out.println("size " + D.size());
    System.out.println("menor " + D.acessSmaller());

    System.out.println("Inserindo novo menor " + menor2 + " no Deque");
    D.insertFirst(menor2);
    System.out.println("Estado do Deque");
    System.out.println(D.toString());
    System.out.println("size " + D.size());
    System.out.println("menor " + D.acessSmaller());

    System.out.println("Esvaziando o Deque");
    D.empty();
    System.out.println("Estado do Deque");
    System.out.println(D.toString());
    System.out.println("size " + D.size());
    
    System.out.println("Teste de Exceção Deque");
    D.removeFirst();*/
  }
}
  