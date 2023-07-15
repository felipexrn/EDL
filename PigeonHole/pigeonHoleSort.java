import java.util.ArrayList;
public class pigeonHoleSort {
  private ArrayList<ArrayList<Object>> pigeonsHole;
  private int higher;
  private int lower;
  private int len;
  public ArrayList<Object> getSortPigeons(ArrayList<Object> pigeons) {
    // achar max e min
    calculateMaxMin(pigeons);
    // construir os buracos dos pombos
    createHoles(pigeons);
    // popular buracos dos pombos
    populateHoles(pigeons);
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
  public ArrayList<ArrayList<Object>> getPigeonsVoidHoles(ArrayList<Object> pigeons) {
    // achar max e min
    calculateMaxMin(pigeons);
    // construir os buracos dos pombos
    createHoles(pigeons);
    return pigeonsHole;
  }
  
  public ArrayList<ArrayList<Object>> getPopulatedHoles(ArrayList<Object> pigeons) {
    // achar max e min
    calculateMaxMin(pigeons);
    // construir os buracos dos pombos
    createHoles(pigeons);
    // popular buracos dos pombos
    populateHoles(pigeons);
    return pigeonsHole;
  }
  private void calculateMaxMin(ArrayList<Object> pigeons) {
    higher = (int) pigeons.get(0);
    lower = (int) pigeons.get(0);
    for (int i = 0; i < pigeons.size(); i ++) {
      higher = Math.max(higher, (int) pigeons.get(i));
      lower = Math.min(lower, (int) pigeons.get(i));
    }  
  }
  private void createHoles(ArrayList<Object> pigeons) {
    len = higher - lower + 1;
    pigeonsHole = new ArrayList<ArrayList<Object>>();
    for (int i = 0; i < len; i++) {
      pigeonsHole.add(new ArrayList<Object>());  
    }
  }
  private void populateHoles(ArrayList<Object> pigeons) {
    for (int i = 0; i < pigeons.size(); i++) {
      pigeonsHole.get((int) pigeons.get(i)-lower).add((int) pigeons.get(i));
    }
  }
  public int getLower(ArrayList<Object> pigeons) {
    // achar max e min
    calculateMaxMin(pigeons);
    return lower;
  }
  public int getHigher(ArrayList<Object> pigeons) {
    // achar max e min
    calculateMaxMin(pigeons);
    return higher;
  }
}