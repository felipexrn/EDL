public class testeList {
  public static void estado(List lista) {
    System.out.println("Estado da List");
    System.out.println(lista.toString());
    System.out.println("size " + lista.size());
    System.out.println("begin " + lista.getBegin());
    System.out.println("end " + lista.getEnd());
    System.out.println("Estrutura da Array");
    System.out.println(lista.strStruct());
  }
  public static void main(String[] args) {
    int in1 = 4, in2 = 10, in3 = 9, in4 = -1, in5 = -2;
    List l = new List();
    System.out.println("\ninserindo " + in1 + " elementos no início");
    for (int i = 0; i < in1; i++) {
      l.insertFirst(i);
    }
    estado(l);

    System.out.println("\ninserindo " + in2 + " elementos no fim");
    for (int i = 0; i < in2; i++) {
      l.insertLast(i);
    }
    estado(l);
    
    System.out.println("\ninserindo elemento " + in4 + " antes do elemento " + in3 + " na List");
    l.insertBefore(l.findElement(in3),in4);
    estado(l);

    System.out.println("\ninserindo elemento " + in5 + " depois do elemento " + in3 + " na List");
    l.insertAfter(l.findElement(in3),in5);
    estado(l);
    
  }
}
