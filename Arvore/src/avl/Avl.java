package Arvore.src.avl;
import Arvore.src.binaria.*;
public class Avl<T extends Comparable<T>> extends ArvoreBinaria<T> implements IArvoreBinaria<T>, IAvl<T> {
  public Avl(int type) {
    super(type);
  }
  public Avl(GenericComparator<T> c) {
    super(c);
  }
  @override
	public Node<T> include(T k){
    return null;
  }
  @override
	public T remove(T k){
    return null;
  }
  public void rebalance() {

  }
}
  