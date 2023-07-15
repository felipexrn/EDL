import java.util.ArrayList;
public class pigeonHoleSort {
  private ArrayList<ArrayList<Object>> pigeonsHole;
  public ArrayList<Object> sortPigeons(ArrayList<Object> pigeons) {
    int higher = (int) pigeons.get(0);
    int lower = (int) pigeons.get(0);
    // achar max e min
    for (int i = 0; i < pigeons.size(); i ++) {
      higher = Math.max(higher, (int) pigeons.get(i));
      lower = Math.min(lower, (int) pigeons.get(i));
    }
    // construir os buracos dos pombos
    int len = higher - lower + 1;
    pigeonsHole = new ArrayList<ArrayList<Object>>();
    for (int i = 0; i < len; i++) {
      pigeonsHole.add(new ArrayList<Object>());  
    }
    // popular buracos dos pombos
    for (int i = 0; i < pigeons.size(); i++) {
      pigeonsHole.get((int) pigeons.get(i)-lower).add((int) pigeons.get(i));
    }
    // devolver os pombos ordenados
    int i = 0;
    int k = 0;
    while (k < pigeons.size()) {
      for (int j = 0; j < pigeonsHole.get(i).size(); j++) {
        pigeons.set(k, (pigeonsHole.get(i)).get(j));
        k++;
      }
      i++;
    }
    return pigeons;
  }
  public ArrayList<ArrayList<Object>> pigeonsVoidHoles(ArrayList<Object> pigeons) {
    int higher = (int) pigeons.get(0);
    int lower = (int) pigeons.get(0);
    // achar max e min
    for (int i = 0; i < pigeons.size(); i ++) {
      higher = Math.max(higher, (int) pigeons.get(i));
      lower = Math.min(lower, (int) pigeons.get(i));
    }
    // construir os buracos dos pombos
    int len = higher - lower + 1;
    pigeonsHole = new ArrayList<ArrayList<Object>>();
    for (int i = 0; i < len; i++) {
      pigeonsHole.add(new ArrayList<Object>());  
    }
    return pigeonsHole;
  }
  
  public ArrayList<ArrayList<Object>> populatedHoles(ArrayList<Object> pigeons) {
    int higher = (int) pigeons.get(0);
    int lower = (int) pigeons.get(0);
    // achar max e min
    for (int i = 0; i < pigeons.size(); i ++) {
      higher = Math.max(higher, (int) pigeons.get(i));
      lower = Math.min(lower, (int) pigeons.get(i));
    }
    // construir os buracos dos pombos
    int len = higher - lower + 1;
    pigeonsHole = new ArrayList<ArrayList<Object>>();
    for (int i = 0; i < len; i++) {
      pigeonsHole.add(new ArrayList<Object>());  
    }
    // popular buracos dos pombos
    for (int i = 0; i < pigeons.size(); i++) {
      pigeonsHole.get((int) pigeons.get(i)-lower).add((int) pigeons.get(i));
    }
    return pigeonsHole;
  }
}