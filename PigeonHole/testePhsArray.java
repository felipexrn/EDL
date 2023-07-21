import java.util.Random;
public class testePhsArray {
  public static void main (String[] args) {
    int[] p;
    phsArray phs;
    Random num = new Random();
    double[] tempos;
    int limit = 1000; // ms
    int time = 0; // ms
    int tests = 100;
    int range = 1;
    int tax = 2;
    int k = 0;
    int l = 0;
    String m;

    while (time < limit) {
      
      tempos = new double[tests];
      m = "dados processados " + k + "% ";
      for (int i = 0; i < m.length(); i++) System.out.print("\b");  
      System.out.print(m);
      
      for (int i = 0; i < tests; i++) {
        
        p = new int[range];
        for (int j = 0; j < range; j++) {
          p[j] = num.nextInt(range); 
        }
        phs = new phsArray(p);
        p = null;
  
        long inicio = System.currentTimeMillis();
        p = phs.getSortedPigeons();
        long fim = System.currentTimeMillis();
        tempos[i] = fim-inicio;

        String isSorted = "Dados processados";
        for (int j = 0; j < p.length -1; j++) {
          int pI = p[j];
          int pII = p[j+1];
          if (pI > pII) {
            System.out.println();
            System.out.println("Dados estão foram processados corretamente. " + pI + " não é menor que " + pII);
            System.exit(0);
          }
        }

        p = null;
        phs = null;
        
        k = (int)((i+1) / (double) tempos.length * 100);
        
        if (k > l) {
          m = isSorted + " " + k + "% ";
          for (int n = 0; n < m.length(); n++) System.out.print("\b");  
          System.out.print(m);
          l++;
        }
      }
      for (int n = 0; n < m.length(); n++) System.out.print("\b");
      
      k = 0;
      l = 0;
      range *= tax;
      
      double total = 0;
      for (int i = 0; i < tests; i++) total += tempos[i];
      time = (int) total/tempos.length;
      System.out.println("A media do tempo, em " + tests + " testes, para ordenar " + range + " pombos, foi de " + (total/tempos.length) + " ms");
    }
  }
}