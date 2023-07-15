import java.util.ArrayList;
import java.util.Random;
public class testePigeonHoleSort {
  public static void main (String[] args) {
    pigeonHoleSort phs = new pigeonHoleSort();
    ArrayList<ArrayList<Object>> pigeonsHoles = new ArrayList<ArrayList<Object>>();
    ArrayList<Object> pigeons = new ArrayList<Object>();

    // teste de eficiencia de tempo
    Random num = new Random();
    int range = 1000;
    
    for (int i = 0; i < range; i++) {
      pigeons.add(num.nextInt(range));
    }

    long inicio = System.currentTimeMillis();
    pigeons = phs.getSortPigeons(pigeons);
    long fim = System.currentTimeMillis();

    System.out.println("Para ordenar " + range + " pombos, o tempo foi de " + (fim-inicio) + " ms\n");

    // Exibição dos dados
    pigeons = new ArrayList<Object>();
    
    pigeons.add(8);
    pigeons.add(3);
    pigeons.add(6);
    pigeons.add(4);
    pigeons.add(2);
    pigeons.add(4);
    pigeons.add(1);
    pigeons.add(2);
    pigeons.add(2);

    System.out.println("Pombos desordenados");
    for (int i = 0; i < pigeons.size(); i++) {
      System.out.print(pigeons.get(i) + " ");
    }
    System.out.println("\n");
    
    pigeonsHoles = phs.getPigeonsVoidHoles(pigeons);
    
    System.out.println("Buracos dos Pombos");
    for (int i = 0; i < pigeonsHoles.size(); i++) {
      System.out.println(pigeonsHoles.get(i));
    }
    System.out.println();

    pigeonsHoles = phs.getPopulatedHoles(pigeons);
    System.out.println("Pombos nos Buracos");
    for (int i = 0; i < pigeonsHoles.size(); i++) {
      System.out.println(pigeonsHoles.get(i));
    }
    System.out.println();

    pigeons = phs.getSortPigeons(pigeons);
    
    System.out.println("Pombos ordenados");
    for (int i = 0; i < pigeons.size(); i++) {
      System.out.print(pigeons.get(i) + " ");
    }
    System.out.println("\n");
  } 
}