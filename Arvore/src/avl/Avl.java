package Arvore.src.avl;
import java.util.Iterator;
import Arvore.src.binaria.*;

public class Avl<T extends Comparable<T>> extends ArvoreBinaria<T> implements IArvoreBinaria<T>, IAvl<T> {
  
  public Avl(int type) {
    super(type);
  }

  public Avl(GenericComparator<T> c) {
    super(c);
  }

  public Node<T> include(T k){ 
    NodeAvl<T> m = (NodeAvl<T>) super.include(k);  
    if (m.getParent().getLeftChild() == m)
      m.upFB();
    else
      m.downFB();;
    return m;
  }
  
	public T remove(T k){
    return super.remove(k);
  }

  public void show() {
    String s = "";
    String l = "";
    Iterator i;
    NodeAvl<T> n;
    if (super.size() != 0){
      int treeHeight = height(super.getRoot());
      for (int h = 0; h <= treeHeight; h++) {
        i = nodes();
        while(i.hasNext()) {
          n = (NodeAvl<T>) i.next();
          if (depth(n) == h) {
            s += n.getKey() + "(" + n.getStrFB() + ")" + "";
            if (hasLeft(n)) l += "/"; else l += "    ";
            if (hasRight(n)) l += "\\"; else l += "    ";
          }
          else {
            s += "     ";
            l += "     ";
          }
        }
        if (l.indexOf("\\") + l.indexOf("/") != -2) 
          l = "\n" + l + "\n";
        s += l;
        l = "";
      }
    }
    else {
      s = "";
    }
    System.out.println(s + "\n");
  }

  public void rebalance() {}
    
  public void rightSimpleRotation(Node<T> n1, Node<T> n2){}
    
  public void leftSimpleRotation(Node<T> n1, Node<T> n2){}
    
  public void rightDoubleRotation(Node<T> n1, Node<T> n2){}
    
  public void leftDoubleRotation(Node<T> n1, Node<T> n2){}
}
  