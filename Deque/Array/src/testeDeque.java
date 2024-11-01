public class testeDeque {
  public static void main(String[] args) {
    int in = -10, out = 5, capacity = 1, tax = 1, menor1 = -10, menor2 = -11;
    boolean isDouble = true;
    
    Deque D = new Deque(capacity, isDouble, tax);
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
    System.out.println(D.strStruct());
    System.out.println("size " + D.size());
    System.out.println("menor " + D.acessSmaller());

    System.out.println("Removendo " + out + " elementos no fim do Deque");
    for (int i = 0; i < out; i++) {
      if (i % 2 != 0) {
        System.out.println(D.removeLast());
      }
      else {
        System.out.println(D.removeFirst());
      }
    }
    System.out.println("Estado do Deque");
    System.out.println(D.toString());
    System.out.println(D.strStruct());
    System.out.println("size " + D.size());
    System.out.println("menor " + D.acessSmaller());

    System.out.println("Inserindo novo menor " + menor1 + " no fim do Deque");
    D.insertLast(menor1);
    System.out.println("Estado do Deque");
    System.out.println(D.toString());
    System.out.println(D.strStruct());
    System.out.println("size " + D.size());
    System.out.println("menor " + D.acessSmaller());

    System.out.println("Inserindo novo menor " + menor2 + " no início do Deque");
    D.insertFirst(menor2);
    System.out.println("Estado do Deque");
    System.out.println(D.toString());
    System.out.println(D.strStruct());
    System.out.println("size " + D.size());
    System.out.println("menor " + D.acessSmaller());

    System.out.println("Esvaziando o Deque");
    D.empty();
    System.out.println("Estado do Deque");
    System.out.println(D.toString());
    System.out.println(D.strStruct());
    System.out.println("size " + D.size());
    
    System.out.println("Teste de Exceção Deque");
    D.removeFirst();
    
  }
}
  