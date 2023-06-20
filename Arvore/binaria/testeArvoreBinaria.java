public class testeArvoreBinaria {
  public static void main(String[] args) {
    int a = 26;
    int b = 25;
    GenericComparator<Integer> intComparator = new GenericComparator<>(Integer::compareTo);
    int d = intComparator.compare(a, b);
    System.out.println(d);
  }
}
