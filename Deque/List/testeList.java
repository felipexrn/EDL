public class testeList {
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
  }
}