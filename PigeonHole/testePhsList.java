import java.util.ArrayList;
import java.util.Random;
public class testePhsList {
  public static void main (String[] args) {
    ArrayList<Object> pigeons;
    phsList phs;
    Random num = new Random();
    double[] tempos;
    int limit = 1000; // ms
    int time = 0; // ms
    int tests = 100;
    int range = 1;
    int tax = 10;
    int k = 0;
    int l = 0;
    String m;

    while (time < limit) {
      
      tempos = new double[tests];
      m = "dados processados " + k + "% ";
      for (int i = 0; i < m.length(); i++) System.out.print("\b");  
      System.out.print(m);
      
      for (int i = 0; i < tests; i++) {
        
        pigeons = new ArrayList<Object>();
        for (int j = 0; j < range; j++) pigeons.add(num.nextInt(range));
        phs = new phsList(pigeons);
  
        long inicio = System.currentTimeMillis();
        pigeons = phs.getSortedPigeons();
        long fim = System.currentTimeMillis();
        tempos[i] = fim-inicio;

        String isSorted = "Dados processados";
        for (int j = 0; j < pigeons.size() -1; j++) {
          int pigeonI = (int) pigeons.get(j);
          int pigeonII = (int) pigeons.get(j+1);
          if (pigeonI > pigeonII) {
            System.out.println();
            System.out.println("Dados estão foram processados corretamente. " + pigeonI + " não é menor que " + pigeonII);
            System.exit(0);
          }
        }
        
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