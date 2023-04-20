public class testList {
  public static void main(String[] args) {
    int in = 15;
    int out = 10;
    System.out.println("Inserindo " + in + " elementos");
    List l = new List();
    for (int i = 0; i < in; i++) {
      l.Push(i);
    }
    System.out.println(l.GetList());
    System.out.println("Removendo " + out + " elementos");
    System.out.println("Topo - removido");
    for (int i = 0; i < out; i++) { 
      System.out.print(l.Top());
      System.out.print(" - ");
      System.out.println(l.Pop());
    }
    System.out.println("Removendo " + out + " elementos");
    System.out.println("Topo - removido");
    for (int i = 0; i < out; i++) { 
      System.out.print(l.Top());
      System.out.print(" - ");
      System.out.println(l.Pop());
    }
    System.out.println(l.GetList());
  }
}