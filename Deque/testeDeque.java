public class testeDeque {
  public static void main(String[] args) {
    int in = 10, out = 5, capacity = 1, tax = 1;
    boolean isDouble = true;
    
    Deque D1 = new Deque(capacity, isDouble, tax);
    System.out.println("Inserindo " + in + " elementos no fim do Deque 1");
    for (int i = 0; i < in; i++) {
      D1.insertLast(i);
      System.out.println(D1.last());
    }
    System.out.println("Estado do Deque 1");
    System.out.println(D1.toString());
    System.out.println(D1.strStruct());
    System.out.println("size " + D1.size());
    System.out.println("menor " + D1.acessSmaller());

    System.out.println("Removendo " + out + " elementos no fim do Deque 1");
    for (int i = 0; i < out; i++) {
      System.out.println(D1.removeLast());
    }
    System.out.println("Estado do Deque 1");
    System.out.println(D1.toString());
    System.out.println(D1.strStruct());
    System.out.println("size " + D1.size());
    System.out.println("menor " + D1.acessSmaller());

    System.out.println("Esvaziando o Deque 1");
    D1.empty();
    System.out.println("Estado do Deque 1");
    System.out.println(D1.toString());
    System.out.println(D1.strStruct());
    System.out.println("size " + D1.size());
       
    Deque D2 = new Deque(capacity, isDouble, tax);
    System.out.println("Inserindo " + in + " elementos no início do Deque 2");
    for (int i = 0; i < in; i++) {
      D2.insertFirst(i);
      System.out.println(D2.first());
      System.out.println(D2.toString());
      System.out.println(D2.strStruct());
    }
    System.out.println("Estado do Deque 2");
    System.out.println(D2.toString());
    System.out.println(D2.strStruct());
    System.out.println("size " + D2.size());
    System.out.println("menor " + D2.acessSmaller());

    System.out.println("Removendo " + out + " elementos no início do Deque 2");
    for (int i = 0; i < out; i++) {
      System.out.println(D2.removeFirst());
    }
    System.out.println("Estado do Deque 2");
    System.out.println(D2.toString());
    System.out.println(D2.strStruct());
    System.out.println("size " + D2.size());
    System.out.println("menor " + D2.acessSmaller());

    System.out.println("Esvaziando o Deque 2");
    D1.empty();
    System.out.println("Estado do Deque 2");
    System.out.println(D1.toString());
    System.out.println(D1.strStruct());
    System.out.println("size " + D1.size());

    System.out.println("Teste de Exceção Deque 2");
    D1.removeFirst();
    D2.removeFirst();
  }
}
  