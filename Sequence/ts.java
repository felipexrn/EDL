public class ts {
  public static void estado(Sequence seq) {
    System.out.println("\nEstado da Sequence");
    System.out.println(seq.toString());
    System.out.println("size " + seq.size());
    System.out.println("Estrutura da Sequence");
    System.out.println(seq.strStruct());
  }
  public static void testeInsercao(Sequence seq) {
    int in = 10;
    System.out.println("\nEntrando " + in + " elementos");
    for (int i = 0; i < in; i++) {
      seq.insertAtRank(0, i); 
    }
  }
  public static void main(String[] args) {
    Sequence s = new Sequence();
    testeInsercao(s);
    estado(s);
    s.empty();
    estado(s);
    testeInsercao(s);
    estado(s);
  }
}