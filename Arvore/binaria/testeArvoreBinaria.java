import java.util.*;
public class testeArvoreBinaria {
  public static void main(String[] args) {
    // Node n1 = new Node(null, 1);
    // Node n2 = new Node(null, 2);
    // Node n3 = new Node(null, "Felipe");
    // Node n4 = new Node(null, "Felícia");
    // Node n5 = new Node(null, "Danielle");
    
    GenericComparator IntComparator = new GenericComparator(0);
    // System.out.println(n1.getKey() + " ? " + n2.getKey() + " = " + IntComparator.compareTo(n1, n2));
    // System.out.println(n2.getKey() + " ? " + n1.getKey() + " = " + IntComparator.compareTo(n2, n1));
    // System.out.println(n1.getKey() + " ? " + n1.getKey() + " = " + IntComparator.compareTo(n1, n1));
    
    // GenericComparator StrComparator = new GenericComparator(1);
    // System.out.println(n3.getKey() + " ? " + n4.getKey() + " = " +  StrComparator.compareTo(n3, n4));
    // System.out.println(n3.getKey() + " ? " + n5.getKey() + " = " +  StrComparator.compareTo(n3, n5));
    // System.out.println(n5.getKey() + " ? " + n4.getKey() + " = " +  StrComparator.compareTo(n5, n4));
    // System.out.println(n3.getKey() + " ? " + n3.getKey() + " = " +  StrComparator.compareTo(n3, n3));
   
    ArvoreBinaria AB = new ArvoreBinaria();
    
    AB.setComparer(IntComparator);
    GenericComparator GC = AB.getComparer();
    
    Node r = new Node(null, 6);
    AB.setRoot(r);
    //AB.include(5);
    //AB.include(7);
    //AB.include(2);
    //AB.include(3);
    //AB.include(6);
    
    Node r01 = new Node(null, 5);
    Node r02 = new Node(null, 8);
    r.setRightChild(r01);
    r.setLeftChild(r02);
    r01.setParent(r);
    r02.setParent(r);
    Node r11 = new Node(null, 3);
    Node r12 = new Node(null, 4);
    r01.setRightChild(r11);
    r01.setLeftChild(r12);
    r11.setParent(r01);
    r12.setParent(r01);
    Node r21 = new Node(null, 7);
    Node r22 = new Node(null, 9);   
    r02.setRightChild(r21);
    r02.setLeftChild(r22);
    r21.setParent(r02);
    r22.setParent(r02);
    
    System.out.println(AB.depth(r));
    System.out.println(AB.depth(r01));
    System.out.println(AB.depth(r11));

    System.out.println(AB.depth(AB.getRoot()));
    System.out.println(AB.height(AB.getRoot()));

    System.out.println(r.getKey() + " ? " + r.getKey() + " = " + AB.getComparer().compareTo(r, r));
    System.out.println(r.getKey() + " ? " + r01.getKey() + " = " + AB.getComparer().compareTo(r, r01));
    System.out.println(r.getKey() + " ? " + r02.getKey() + " = " + AB.getComparer().compareTo(r, r02));
    System.out.println(r01.getKey() + " ? " + r02.getKey() + " = " + AB.getComparer().compareTo(r01, r02));
  }
}
