import java.util.ArrayList;
public class showPhs {
  public static void main (String[] args) {
    ArrayList<ArrayList<Object>> pigeonsHoles = new ArrayList<ArrayList<Object>>();
    ArrayList<Object> pigeons = new ArrayList<Object>();
    phsList phs = new phsList(pigeons);
    
    pigeons.add(8);
    pigeons.add(3);
    pigeons.add(6);
    pigeons.add(6);
    pigeons.add(4);
    pigeons.add(2);
    pigeons.add(4);
    pigeons.add(2);
    pigeons.add(2);

    System.out.println(pigeons.size() + " pombos desordenados");
    for (int i = 0; i < pigeons.size(); i++) {
      System.out.print(pigeons.get(i) + " ");
    }
    System.out.println("\n");
    
    System.out.print("maior pombo " + phs.getHigher() + ", ");
    System.out.println("menor pombo " + phs.getLower());
    System.out.println("maior - menor + 1 \n");
    
    pigeonsHoles = phs.getVoidHoles();
    
    System.out.println(phs.getLength() + " buracos de pombos");
    for (int i = 0; i < pigeonsHoles.size(); i++) {
      System.out.println(pigeonsHoles.get(i));
    }
    System.out.println();

    System.out.println("No buraco B[Pombo[i] - menor], adicione Pombo[i] \n");

    pigeonsHoles = phs.getPopulatedHoles();
    System.out.println("Pombos nos Buracos");
    for (int i = 0; i < pigeonsHoles.size(); i++) {
      System.out.println(pigeonsHoles.get(i));
    }
    System.out.println();

    pigeons = phs.getSortedPigeons();

    System.out.println("Pegue todos os pombos a partir do primeiro buraco \n");
    
    System.out.println("Pombos ordenados");
    for (int i = 0; i < pigeons.size(); i++) {
      System.out.print(pigeons.get(i) + " ");
    }
    System.out.println();
  } 
}