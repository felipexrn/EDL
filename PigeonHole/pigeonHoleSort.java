import java.util.ArrayList;
public class pigeonHoleSort {
  private ArratList<Object> pigeonHole;
  public ArrayList<object> sortPigeons(ArrayList<object> pigeons) {
    int higher = (int) pigeons[0];
    int lower = (int) pigeons[0];
    // achar max e min
    for (int i = 0; i < pigeons.size(); i ++) {
      Math.max(higher, (int) pigeons[i];
      Math.min(lower, (int) pigeons[i];
    }
    // construir a casa dos pombos
    // higher - lower + 1;

    // devolver os pombos ordenados
    return pigeons;
  }
}