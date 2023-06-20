import java.util.Comparator;
public class GenericComparator<T> implements Comparator<T> {
  private final Comparator<T> comparator;
  public GenericComparator(Comparator<T> c) {
    comparator = c;
  }
  @Override
  public int compare(T a, T b) {
    return comparator.compare(a, b);
  }
}