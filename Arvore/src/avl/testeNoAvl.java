import Arvore.src.avl.*;
public class testeNoAvl {
  public static void main(String[] args) {
    NodeAvl n1 = new NodeAvl(null, 7);
    NodeAvl n2 = new NodeAvl(null, 4);
    NodeAvl n3 = new NodeAvl(null, 9);

    n1.upFB();
    System.out.println(n1.getFB());
    n1.downFB();
    n1.setKey(6);

    n2.setParent(n1);
    n3.setParent(n2);

    n1.setLeftChild(n2);
    n1.setRightChild(n3);

    System.out.print(((NodeAvl) n2.getParent()).getKey());
    System.out.println(((NodeAvl) n3.getParent()).getStrFB());
    System.out.print(((NodeAvl)n1.getLeftChild()).getKey());
    System.out.println(((NodeAvl) n1.getLeftChild()).getStrFB());
    System.out.print(((NodeAvl)n1.getRightChild()).getKey());
    System.out.println(((NodeAvl) n1.getRightChild()).getStrFB());
  }
}