import java.util.ArrayList;
import java.util.Random;
import java.io.*;
public class analiseEficiencia {
  public static void main (String[] args) throws IOException, InterruptedException {
    pigeonHoleSort phs = new pigeonHoleSort();
    ArrayList<Object> pigeons = new ArrayList<Object>();
    double[] tempos;
    Random num = new Random();
    int limit = 1000; // ms
    int time = 0; // ms
    int tests = 100;
    int range = 1;
    int k = 0;
    int l = 0;

    while (time < limit) {
      
      tempos = new double[tests];
      
      System.out.print("\033[M\033[0J");  
      System.out.print("dados processados " + k + "%");
      
      for (int i = 0; i < tests; i++) {
        
        pigeons = new ArrayList<Object>();
        for (int j = 0; j < range; j++) pigeons.add(num.nextInt(range));
        
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
      System.out.println();
      
      k = 0;
      l = 0;
      range *= 10;
      
      double total = 0;
      for (int i = 0; i < tests; i++) total += tempos[i];
      time = (int) total/tempos.length;
      System.out.println("A media do tempo, em " + tests + " testes, para ordenar " + range + " pombos, foi de " + (total/tempos.length) + " ms");
    }
  }
}