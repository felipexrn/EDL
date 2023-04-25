public class testeDeque {
  public static void main(String[] args) {
    int capacity = 10, tax = 1;
    boolean isDouble = true;
    Deque D = new Deque(capacity, isDouble, tax);
    for (int i = 0; i < capacity; i++) {
      D.insertFirst(i);
      System.out.println(D.first());
      System.out.println(D.toString());
      System.out.println(D.strStruct());
      System.out.println(D.size());
      System.out.println("menor " + D.acessSmaller());
    }
    System.out.println("Estado final do Deque");
    System.out.println(D.toString());
    System.out.println(D.size());
    System.out.println(D.strStruct());
    System.out.println("menor " + D.acessSmaller());
  }
}
  