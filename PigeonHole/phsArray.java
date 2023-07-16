public class phsArray {
  private int[] ph;
  private int[] p;
  private int higher;
  private int lower;
  private int length;
  public phsArray(int[] p) {
    this.p = p;
  }
  private void calculateMaxMin() {
    higher = p[0];
    lower = p[0];
    for (int i = 0; i < p.length; i++) {
      higher = Math.max(higher, p[i]);
      lower = Math.min(lower, p[i]);
    }  
  }
  private void createHoles() {
    length = higher - lower + 1;
    ph = new int[length];
  }
  private void populateHoles() {
    for (int i = 0; i < p.length; i++) {
      ph[p[i]-lower] = ph[p[i]-lower] +1;
    }
  }
  public int[] getSortedPigeons() {
    // achar max e min
    calculateMaxMin();
    // construir os buracos dos pombos
    createHoles();
    // popular buracos dos pombos
    populateHoles();
    // devolver os pombos ordenados
    int j = 0;
    for (int i = 0; i < length; i++) {
      int h = ph[i];
      while (h > 0) {
        p[j] = i + lower;
        h--;
        j++;
      }
    }
    ph = null;
    return p; 
  }
  public int[] getVoidHoles() {
    // achar max e min
    calculateMaxMin();
    // construir os buracos dos pombos
    createHoles();
    return ph;
  }
  public int[] getPopulatedHoles() {
    // achar max e min
    calculateMaxMin();
    // construir os buracos dos pombos
    createHoles();
    // popular buracos dos pombos
    populateHoles();
    return ph;
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