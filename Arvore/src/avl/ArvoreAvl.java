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
    try {
      NodeAvl<T> n = super.include(k);   
      rebalance(n.getParent(), isRightChild(n), true);
      //if (super.getDebug()) System.out.println("include");
      return n;
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreAvl.include(T k)\n" + e.getMessage());
    }
  }
	public NodeAvl<T> remove(T k){ 
    try {
      // Guarda o sucessor de k para rebalancear a arvore
      NodeAvl<T> m = super.getNextNodeBeforeRemove(k);    
      Boolean isFromRight = false;
      if (m != null) {
        isFromRight = isRightChild(m);
        if (m != getRoot()) m = m.getParent();
        if (getDebug()) System.out.println("m!=null");
        m.showLinks();
      } else {
        m = super.search(getRoot(), k);
        isFromRight = isRightChild(m);
        if (m != getRoot()) m = m.getParent();
        if (getDebug()) System.out.println("m==null");
        m.showLinks();
      }
      // remove k
      NodeAvl<T> n = super.remove(k);

      // Rebalanceia a árvore
      rebalance(m, isFromRight, false);
      //if (super.getDebug()) System.out.println("remove");
      return n;
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreAvl.remove(T k)\n" + e.getMessage());
    }
  }  
  public NodeAvl<T> rebalance(NodeAvl<T> n, Boolean isFromRight, Boolean inInsert) {
    try {  
      if (super.getDebug()) System.out.println("rebalance");
      
      // Condição de parada se for raiz
      if (n == null) return null;
      //if (super.getDebug()) System.out.println("rebalance parada raiz");  
      
      // ajusta fator de balanceamento
      refreshFB(n, isFromRight, inInsert); 
      
      // verifica necessidade de rotações 
      n = verifyRotate(n);              
      
      // condição de parada inserção
      if (inInsert && (n.getFB() == 0)) return null;
      //if (super.getDebug()) System.out.println("rebalance parada insercao");

      // condição de parada remoção
      if (!inInsert && (n.getFB() != 0)) return null;    
      //if (super.getDebug()) System.out.println("rebalance parada remocao");

      // chama recursivamente
      return rebalance(n.getParent(), isRightChild(n), inInsert);
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreAvl.rebalance(NodeAvl<T> n, Boolean isFromRight, Boolean inInsert)\n" + e.getMessage());
    }
  }
  public void refreshFB(NodeAvl<T> n, Boolean isFromRight, Boolean inInsert) {
    try {
      if (super.getDebug()) System.out.println("atualizando FB");
      
      if (inInsert) {
        if (isFromRight) n.downFB();
        else n.upFB();
      }
      else {
        if (isFromRight) n.upFB();
        else n.downFB();
      }
      if (super.getDebug()) System.out.println("n: " + n.getKey() + ", newFBB: " + n.getFB() +  ", isFromRight: " + isFromRight);
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreAvl.refreshFB(NodeAvl<T> n, Boolean isFromRight, Boolean inInsert)\n" + e.getMessage());
    }
  }
  public NodeAvl<T> verifyRotate(NodeAvl<T> n) {
    if (n.getFB() == 2) {
      if (n.getLeftChild().getFB() >= 0) n = rightSimpleRotation(n);
      else n = rightDoubleRotation(n);
    }
    if (n.getFB() == -2) {
      if (n.getRightChild().getFB() <= 0) n = leftSimpleRotation(n);
      else n = leftDoubleRotation(n);
    }   
    return n;
  }
  public NodeAvl<T> rightSimpleRotation(NodeAvl<T> b) {  
    if (super.getDebug()) show();
    NodeAvl<T> a = super.rightSimpleRotation(b);
    if (super.getDebug()) show();
    /*if (super.getDebug()) {
      a.showLinks();
      b.showLinks();
    }*/
    //if (super.getDebug()) System.out.println("rightSimpleRotation");
    recalculateFB(a, b, true);
    return a;
  }
  public NodeAvl<T> leftSimpleRotation(NodeAvl<T> b) {    
    if (super.getDebug()) show();
    NodeAvl<T> a = super.leftSimpleRotation(b);
    if (super.getDebug()) show();
    /*if (super.getDebug()) {
      a.showLinks();
      b.showLinks();
    }*/
    //if (super.getDebug()) System.out.println("leftSimpleRotation");
    recalculateFB(a, b, false);
    return a;
  }
  public NodeAvl<T> rightDoubleRotation(NodeAvl<T> b) {
    //if (super.getDebug()) System.out.println("rightDoubleRotation");    
    //NodeAvl<T> a = leftSimpleRotation(b.getLeftChild());
    //b = rightSimpleRotation(b);
    return super.rightDoubleRotation(b);
  }
  public NodeAvl<T> leftDoubleRotation(NodeAvl<T> b) {
    //if (super.getDebug()) System.out.println("leftDoubleRotation");
    //NodeAvl<T> a = rightSimpleRotation(b.getRightChild());
    //b = leftSimpleRotation(b);
    return super.leftDoubleRotation(b);
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
    if (super.getDebug()) System.out.println("a: " + a.getKey() + ", newFBA: " + a.getFB());
    if (super.getDebug()) System.out.println("b: " + b.getKey() + ", newFBB: " + b.getFB());
  }
  public void show() {
    String s = "";
    String l = "";
    String e = "";
    Iterator i;
    NodeAvl<T> n;
    if (super.size() != 0){
      int treeHeight = height(super.getRoot());
      for (int h = 0; h <= treeHeight; h++) {
        i = nodes();
        while(i.hasNext()) {
          // recupera Node atual
          n = (NodeAvl<T>) i.next();
          // calcula espaço padrão para coluna atual
          e = "";
          int sizeE = n.getStrFB().length() + n.getKey().toString().length() + 2;          
          for (int j = 0; j < sizeE; j ++) e += " ";
          // impressão 
          if (depth(n) == h) {
            // linha para value
            s += n.getKey() + "(" + n.getStrFB() + ")" + "";            
            // linha para ligação
            if (hasLeft(n)) l += "/"; 
            if (hasRight(n)) l += "\\";
          }
          else {
            // insere espaço se não houver valor na coluna
            s += e;
          }
          // insere espaço na linha de ligação
          l += e;
        }
        // adiciona linha de ligação abaixo da linha de valores
        if (l.indexOf("\\") + l.indexOf("/") != -2) {
          l = "\n" + l + "\n";
          s += l;
        }        
        // reseta linha de ligação para próxima altura
        l = "";
        // não imprime última linha de ligação. ela é sempre vazia.
      }
    }
    else {
      // mostra vazio se árvore estiver vazia
      s = "";
    }
    System.out.println(s);
  }
} 
  