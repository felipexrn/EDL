import java.util.*;
public class testeArvoreBinaria {
  public static void main(String[] args) {
    GenericComparator IntComparator = new GenericComparator(0);
    ArvoreBinaria AB = new ArvoreBinaria();
    
    AB.setComparer(IntComparator);
    GenericComparator GC = AB.getComparer();
    
    Node r = new Node(null, 6);
    AB.setRoot(r);
    AB.include(4);
    AB.include(8);
    AB.include(3);
    //AB.include(5);
    //AB.include(7);
    AB.include(9);

    System.out.println("depth " + AB.depth(AB.getRoot()));
    System.out.println("height " + AB.height(AB.getRoot()));
    System.out.println("size " + AB.size());
    System.out.println(AB.strNodes());
    System.out.println(AB.strElements());
    AB.show();

    AB.include(1);
    AB.include(11);

    System.out.println("depth " + AB.depth(AB.getRoot()));
    System.out.println("height " + AB.height(AB.getRoot()));
    System.out.println("size " + AB.size());
    System.out.println(AB.strNodes());
    System.out.println(AB.strElements());
    AB.show();

    AB.include(2);
    AB.include(10);

    System.out.println("depth " + AB.depth(AB.getRoot()));
    System.out.println("height " + AB.height(AB.getRoot()));
    System.out.println("size " + AB.size());
    System.out.println(AB.strNodes());
    System.out.println(AB.strElements());
    AB.show();

    AB.include(5);
    AB.include(5);
    AB.include(7);

    System.out.println("depth " + AB.depth(AB.getRoot()));
    System.out.println("height " + AB.height(AB.getRoot()));
    System.out.println("size " + AB.size());
    System.out.println(AB.strNodes());
    System.out.println(AB.strElements());
    AB.show();

    System.out.println("removido " + AB.remove(3));

    System.out.println("depth " + AB.depth(AB.getRoot()));
    System.out.println("height " + AB.height(AB.getRoot()));
    System.out.println("size " + AB.size());
    System.out.println(AB.strNodes());
    System.out.println(AB.strElements());
    AB.show();

    System.out.println("removido " + AB.remove(5));

    System.out.println("depth " + AB.depth(AB.getRoot()));
    System.out.println("height " + AB.height(AB.getRoot()));
    System.out.println("size " + AB.size());
    System.out.println(AB.strNodes());
    System.out.println(AB.strElements());
    AB.show();

    System.out.println("removido " + AB.remove(4));

    System.out.println("depth " + AB.depth(AB.getRoot()));
    System.out.println("height " + AB.height(AB.getRoot()));
    System.out.println("size " + AB.size());
    System.out.println(AB.strNodes());
    System.out.println(AB.strElements());
    AB.show();
    
    System.out.println("removido " + AB.remove(9));

    System.out.println("depth " + AB.depth(AB.getRoot()));
    System.out.println("height " + AB.height(AB.getRoot()));
    System.out.println("size " + AB.size());
    System.out.println(AB.strNodes());
    System.out.println(AB.strElements());
    AB.show();
    
    System.out.println("removido " + AB.remove(5));

    System.out.println("depth " + AB.depth(AB.getRoot()));
    System.out.println("height " + AB.height(AB.getRoot()));
    System.out.println("size " + AB.size());
    System.out.println(AB.strNodes());
    System.out.println(AB.strElements());
    AB.show();

    AB.include(5);
    AB.include(4);

    System.out.println("incluido 5 e 4");

    System.out.println("depth " + AB.depth(AB.getRoot()));
    System.out.println("height " + AB.height(AB.getRoot()));
    System.out.println("size " + AB.size());
    System.out.println(AB.strNodes());
    System.out.println(AB.strElements());
    AB.show();
    

    // Node newRoot = new Node(null, 0);
    // ArvoreBinaria newAB = new ArvoreBinaria();
    // newAB.setComparer(IntComparator);
    // newAB.include(newRoot.getKey());

    // System.out.println("depth " + newAB.depth(newAB.getRoot()));
    // System.out.println("height " + newAB.height(newAB.getRoot()));
    // System.out.println("size " + newAB.size());
    // System.out.println(newAB.strNodes());
    // System.out.println(newAB.strElements());
    // newAB.show();

    // newAB.include(4);
    // newAB.include(8);
    // newAB.include(3);
    // newAB.include(5);
    // newAB.include(7);
    // newAB.include(9);

    // System.out.println("depth " + newAB.depth(newAB.getRoot()));
    // System.out.println("height " + newAB.height(newAB.getRoot()));
    // System.out.println("size " + newAB.size());
    // System.out.println(newAB.strNodes());
    // System.out.println(newAB.strElements());
    // newAB.show();
  }
}
