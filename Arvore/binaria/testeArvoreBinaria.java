
public class testeArvoreBinaria {
  public static void main(String[] args) {
    int a = 26;
    int b = 25;
    GenericComparator<Integer> intComparator = new GenericComparator<>(Integer::compareTo);
    ArvoreBinaria AB = new ArvoreBinaria(intComparator);
    Node n = new Node(null, 6);
    AB.setRoot(n);
    int d = intComparator.compare(a, b);
    Consumer<Integer> action = AB::m;
    System.out.println(AB.preOrder(action));
    System.out.println(d);
  }
}
