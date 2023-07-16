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
    int tax = 2;
    int k = 0;
    int l = 0;
    String m = "dados processados " + k + "% ";

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
        
        k = (int)((i+1) / (double) tempos.length * 100);
        
        if (k > l) {
          m = "dados processados " + k + "% ";
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