import java.util.ArrayList;
public class phsList {
  private ArrayList<ArrayList<Object>> pigeonsHole;
  private ArrayList<Object> pigeons;
  private int higher;
  private int lower;
  private int length;
  public phsList(ArrayList<Object> pigeons) {
    this.pigeons = pigeons;
  }
  private void calculateMaxMin() {
    higher = (int) pigeons.get(0);
    lower = (int) pigeons.get(0);
    for (int i = 0; i < pigeons.size(); i ++) {
      higher = Math.max(higher, (int) pigeons.get(i));
      lower = Math.min(lower, (int) pigeons.get(i));
    }  
  }
  private void createHoles() {
    length = higher - lower + 1;
    pigeonsHole = new ArrayList<ArrayList<Object>>();
    for (int i = 0; i < length; i++) {
      pigeonsHole.add(new ArrayList<Object>());  
    }
  }
  private void populateHoles() {
    for (int i = 0; i < pigeons.size(); i++) {
      int pigeon = (int) pigeons.get(i);
      pigeonsHole.get(pigeon-lower).add(pigeon);
    }
  }
  public ArrayList<Object> getSortedPigeons() {
    // achar max e min
    calculateMaxMin();
    // construir os buracos dos pombos
    createHoles();
    // popular buracos dos pombos
    populateHoles();
    // devolver os pombos ordenados
    int i = 0;
    int k = 0;
    while (k < pigeons.size()) {
      ArrayList<Object> hole = (ArrayList<Object>) pigeonsHole.get(i);
      for (int j = 0; j < hole.size(); j++) {
        pigeons.set(k, hole.get(j));
        k++;
      }
      i++;
    }
    return pigeons;
  }
  public ArrayList<ArrayList<Object>> getVoidHoles() {
    // achar max e min
    calculateMaxMin();
    // construir os buracos dos pombos
    createHoles();
    return pigeonsHole;
  }
  
  public ArrayList<ArrayList<Object>> getPopulatedHoles() {
    // achar max e min
    calculateMaxMin();
    // construir os buracos dos pombos
    createHoles();
    // popular buracos dos pombos
    populateHoles();
    return pigeonsHole;
  }
  public int getLower() {
    // achar max e min
    calculateMaxMin();
    return lower;
  }
  public int getHigher() {
    // achar max e min
    calculateMaxMin();
    return higher;
  }
  public int getLength() {
    return higher - lower + 1;
  }
}