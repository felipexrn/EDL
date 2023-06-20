import java.util.Comparator;
public class Comparer<T> implements Comparator<T> {
  Comparator<T> c = new Comparator<T>();
  private Comparator<T> c;

  public GenericComparator(Comparator<T> c) {
      this.c = c;
  }
  @Override
  public int compare(T a, T b) {
    return c.compareTo(a, b);
  }
}