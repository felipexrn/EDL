public class phsArray {
  private Object[] ph;
  private int[] p;
  private int[] h;
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
    ph = new Object[length];
    //t = new int[2];
    for (int i = 0; i < length; i++) { 
      ph[i] = new int[2];
      ((int[]) ph[i])[0] = 0;
    }
  }
  private void populateHoles() {
    for (int i = 0; i < p.length; i++) {
      h = (int[]) ph[p[i]-lower];
      h[1] = p[i];
      h[0] = h[0] + 1;
      ph[p[i]-lower] = h;
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
      h = (int[]) ph[i];
      while (h[0] > 0) {
        p[j] = h[1];
        h[0] = h[0] -1;
        j++;
      }
    }
    return p; 
  }
  public Object[] getVoidHoles() {
    // achar max e min
    calculateMaxMin();
    // construir os buracos dos pombos
    createHoles();
    return ph;
  }
  public Object[] getPopulatedHoles() {
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