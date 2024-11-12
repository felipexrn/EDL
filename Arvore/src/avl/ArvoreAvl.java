package Arvore.src.avl;
import java.util.Iterator;
import Arvore.src.binaria.*;

public class ArvoreAvl<T extends Comparable<T>> extends ArvoreBalanceadaAbstrata<T,NodeAvl<T>>  implements IArvoreBinaria<T, NodeAvl<T>>, IAvl<T> {
  public ArvoreAvl(int type) {
    super(type);
  }
  public ArvoreAvl(GenericComparator<T, NodeAvl<T>> c) {
    super(c);
  }
  public NodeAvl<T> createNode(NodeAvl<T> p, T k) {
    if ((p instanceof NodeAvl) || (p == null)) {
      return new NodeAvl<T>(p, k);
    } else {
      throw new IllegalArgumentException("Tipo incompatível de nó: " + p.getClass().getName());
    }
  }
  public NodeAvl<T> include(T k){ 
    NodeAvl<T> n = super.include(k);   
    rebalance(n.getParent(), k, true);

    if (super.getDebug()) System.out.println("include");

    return n;
  }
	public NodeAvl<T> remove(T k){ 
    NodeAvl<T> m = super.remove(k);
    rebalance(m.getParent(), k, false);

    if (super.getDebug()) System.out.println("remove");

    return m;
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
            if (hasLeft(n)) l += "/"; else l += "   ";
            if (hasRight(n)) l += "\\"; else l += "  ";
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
  public NodeAvl<T> rebalance(NodeAvl<T> b, T k, Boolean inInsert) {
    if (super.getDebug()) System.out.println("rebalance entrada");

    // Condição de parada se for raiz
    if (b == null) return null;
    if (super.getDebug()) System.out.println("rebalance parada raiz");  

    // ajusta fator de balanceamento
    if (inInsert) {
      if (getComparer().compareTo(b, new NodeAvl(null,k)) > 0)
        b.upFB();
      else if (getComparer().compareTo(b, new NodeAvl(null,k)) < 0)
        b.downFB();
    }
    else {
      if (getComparer().compareTo(b, new NodeAvl(null,k)) > 0)
        b.downFB();
      else if (getComparer().compareTo(b, new NodeAvl(null,k)) < 0)
        b.upFB();
    }
    if (super.getDebug()) System.out.println("rebalance atualiza FB");
    if (super.getDebug()) System.out.println("b: " + b.getKey() + ", newFBB: " + b.getFB());

    // verifica necessidade de rotações 
    if (b.getFB() == 2) {
      if (b.getLeftChild().getFB() >= 0 ) 
        b = rightSimpleRotation(b);
      else
        b = rightDoubleRotation(b);
    }
    if (b.getFB() == -2) {
      if (b.getRightChild().getFB() <= 0 )
        b = leftSimpleRotation(b);
        else
        b = leftDoubleRotation(b);
    }          
    if (super.getDebug()) System.out.println("rebalance rotacoes");  

    // condição de parada inserção
    if (inInsert && (b.getFB() == 0)) return null;
    if (super.getDebug()) System.out.println("rebalance parada insercao");

    // condição de parada remoção
    if (!inInsert && (b.getFB() != 0)) return null;    
    if (super.getDebug()) System.out.println("rebalance parada remocao");

    // chama recursivamente
    return rebalance(b.getParent(), k, inInsert);
  }
  public NodeAvl<T> rightSimpleRotation(NodeAvl<T> b) {
    NodeAvl<T> a = super.rightSimpleRotation(b);

    if (super.getDebug()) System.out.println("rightSimpleRotation");

    recalculateFB(a, b, true);
    return a;
  }
  public NodeAvl<T> leftSimpleRotation(NodeAvl<T> b) {    
    NodeAvl<T> a = super.leftSimpleRotation(b);
    
    if (super.getDebug()) System.out.println("leftSimpleRotation");

    recalculateFB(a, b, false);
    return a;
  }
  public NodeAvl<T> rightDoubleRotation(NodeAvl<T> b) {
    NodeAvl<T> a = leftSimpleRotation(b.getLeftChild());
    b = rightSimpleRotation(a.getParent());
    return b;
  }
  public NodeAvl<T> leftDoubleRotation(NodeAvl<T> b) {
    NodeAvl<T> a = rightSimpleRotation(b.getRightChild());
    b = leftSimpleRotation(a.getParent());
    return b;
  }
  public void recalculateFB(NodeAvl<T> a, NodeAvl<T> b, Boolean isRightRotation){
    int newFBA, newFBB; 
    if (isRightRotation) {
      newFBB = b.getFB() - 1 - Math.max(a.getFB(), 0);
      newFBA = a.getFB() - 1 + Math.min(newFBB, 0);  
    }
    else {      
      newFBB = b.getFB() + 1 - Math.min(a.getFB(), 0);
      newFBA = a.getFB() + 1 + Math.max(newFBB, 0);
    }  
    a.setFB(newFBA);
    b.setFB(newFBB);

    if (super.getDebug()) System.out.println("recalulateFB");
    if (super.getDebug()) System.out.println("a: " + a.getKey() + ", newFBA " + a.getFB());
    if (super.getDebug()) System.out.println("b: " + b.getKey() + ", newFBB: " + b.getFB());

  }
} 
  