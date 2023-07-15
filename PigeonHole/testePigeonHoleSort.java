import java.util.ArrayList;
public class testePigeonHoleSort {
  public static void main (String[] args) {
    pigeonHoleSort phs = new pigeonHoleSort();
    ArrayList<ArrayList<Object>> pigeonsHoles = new ArrayList<ArrayList<Object>>();
    ArrayList<Object> pigeons = new ArrayList<Object>();
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
    
    pigeonsHoles = phs.pigeonsVoidHoles(pigeons);
    
    System.out.println("Buracos dos Pombos");
    for (int i = 0; i < pigeonsHoles.size(); i++) {
      System.out.println(pigeonsHoles.get(i));
    }
    System.out.println();

    pigeonsHoles = phs.populatedHoles(pigeons);
    System.out.println("Pombos nos Buracos");
    for (int i = 0; i < pigeonsHoles.size(); i++) {
      System.out.println(pigeonsHoles.get(i) + " ");
    }
    System.out.println();

    // fazer código pra contar o tempo
    pigeons = phs.sortPigeons(pigeons);
    
    System.out.println("Pombos ordenados");
    for (int i = 0; i < pigeons.size(); i++) {
      System.out.print(pigeons.get(i) + " ");
    }
    System.out.println();

    // exibir o tempo de execução do sortPigeons
  } 
}