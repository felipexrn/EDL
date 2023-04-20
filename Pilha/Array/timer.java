public class timer {
  public static void main(String[] args) {
    System.out.println("Incremental");
    int taxa = 10;
    while (taxa <= 1000) {
      int tam = 10;
      while(tam <= 1000000) {
        PilhaArray p = new PilhaArray(1, false, taxa);
        long inicio = System.currentTimeMillis();
        for (long i = 0; i < tam; i++) {
          p.push(1);
        }
        long fim = System.currentTimeMillis();
        System.out.print(fim - inicio);
        System.out.print(" ms - ");
        System.out.print(tam);
        System.out.print(" tamanho - ");
        System.out.print(taxa);
        System.out.println(" taxa");
        p = null;
        tam *= 10;
      }
      taxa *= 10;
    }
    System.out.println("Duplicação");
    int tam = 10;
    while(tam <= 1000000) {
      PilhaArray p = new PilhaArray(1, true, taxa);
      long inicio = System.currentTimeMillis();
      for (long i = 0; i < tam; i++) {
        p.push(1);
      }
      long fim = System.currentTimeMillis();
      System.out.print(fim - inicio);
      System.out.print(" ms - ");
      System.out.print(tam);
      System.out.println(" tamanho");
      p = null;
      tam *= 10;
    }
  }
}

