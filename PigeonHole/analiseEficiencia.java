import java.util.ArrayList;
import java.util.Random;
import java.io.*;
public class analiseEficiencia {
  public static void main (String[] args) throws IOException, InterruptedException {
    pigeonHoleSort phs = new pigeonHoleSort();
    ArrayList<Object> pigeons = new ArrayList<Object>();
    int limit = 1000; // ms
    int time = 0; // ms
    int tests = 100;
    int range = 1;
    
    double[] tempos = new double[tests];
    
    // teste de eficiencia de tempo
    Random num = new Random();

    int k = 0;
    int l = 0;
    while (time < limit) {
      for (int i = 0; i < tests; i++) {
        pigeons = new ArrayList<Object>();
        
        for (int j = 0; j < range; j++) {
          pigeons.add(num.nextInt(range));
        }
        
        long inicio = System.currentTimeMillis();
        pigeons = phs.getSortPigeons(pigeons);
        long fim = System.currentTimeMillis();
  
        tempos[i] = fim-inicio;
        
        k = (int)((i+1) / (double) tempos.length * 100);
        
        if (k > l) {
          System.out.print("\033[M\033[0J");  
          System.out.print("dados processados " + k + "%");
          l++;
        }
      }

      k = 0;
      l = 0;
      
      System.out.println();
      
      double total = 0;
      for (int i = 0; i < tests; i++) {
        total += tempos[i];
      }

      range *= 10;
      time = (int) total/tempos.length;
      System.out.println("A média do tempo, em " + tests + " testes, para ordenar " + range + " pombos, foi de " + (total/tempos.length) + " ms");
    }
  }
}