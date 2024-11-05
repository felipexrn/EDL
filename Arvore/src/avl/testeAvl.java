import java.util.*;
import Arvore.src.avl.*;
public class testeAvl {
  public static void main (String[] args) {
    GenericComparator GC = new GenericComparator(); 
    GC.setType(0); // 0=inteiro
    Avl A = new Avl(GC);
    // NodeAvl n = new NodeAvl(null, 1);
    // NodeAvl m = new NodeAvl(n, 2);
    // System.out.println(m.getParent().getKey());
    // System.out.println(m.getKey());
    A.include(10);
    // A.include(17);
    // A.include(13);
    // A.include(15);
    // A.include(5);
    // A.include(2);
    // A.include(7);
    // A.include(6);
    // A.show();
    A.mantraNacara();
  }
}