package Arvore.src.rn;
import java.util.Iterator;
import Arvore.src.binaria.*;

public class ArvoreRn<T extends Comparable<T>> extends ArvoreBalanceadaAbstrata<T,NodeRn<T>>  implements IArvoreBinaria<T, NodeRn<T>>, IArvoreRn<T> {
  private String colorBlack = "\033[34m"; // Azul
  private String colorRed = "\033[31m"; 
  private String colorReset = "\033[0m";
  public ArvoreRn(int type) {
    super(type);
  }
  public ArvoreRn(GenericComparator<T, NodeRn<T>> c) {
    super(c);
  }
  public NodeRn<T> createNode(NodeRn<T> p, T k) {
    if ((p instanceof NodeRn) || (p == null)) {
      return new NodeRn<T>(p, k);
    } else {
      throw new IllegalArgumentException("Tipo incompatível de nó: " + p.getClass().getName());
    }
  }
  public NodeRn<T> include(T k){ 
    try {
      //if (super.getDebug()) System.out.println("include");
      NodeRn<T> n = super.include(k);   
      rebalance(n.getParent(), isRightChild(n), true);
      return n;
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.include(T k)\n" + e.getMessage());
    }
  }
	public NodeRn<T> remove(T k){ 
    try {
      //if (super.getDebug()) System.out.println("remove");
      
      // Guarda o sucessor de k para rebalancear a arvore
      NodeRn<T> m = super.getSucessor(k);    
      Boolean isFromRight = false;
      if (m != null) {
        isFromRight = isRightChild(m);
        if (m != getRoot()) m = m.getParent();
        /*if (getDebug()) {
          System.out.println("m!=null");
          m.showLinks();
        }*/
      } else {
        m = super.search(getRoot(), k);
        isFromRight = isRightChild(m);
        if (m != getRoot()) m = m.getParent();
        /*if (getDebug()) {
          System.out.println("m==null");
          m.showLinks();
        }*/
      }
      // remove k
      NodeRn<T> n = super.remove(k);

      /*if (getDebug()) {
        System.out.println("n:");
        n.showLinks();
      }*/

      /*if ((super.size() > 0) && (n.getParent() != null) && (!isSucessorCase(n)) && (m != n.getParent())) {
        if (getDebug()) {
          System.out.println("root: " + getRoot().getKey());
        }
        throw new RuntimeException("Pai direfente do esperado!");
      }*/

      // Rebalanceia a árvore
      if (super.size() > 0) rebalance(m, false);
      return n;
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.remove(T k)\n" + e.getMessage());
    }
  }  
  public NodeRn<T> rebalance(NodeRn<T> n, Boolean inInsert) {
    try {  
      if (super.getDebug()) System.out.println("rebalance");
      
      // Condição de parada se for raiz
      if (n == null) return null;
      //if (super.getDebug()) System.out.println("rebalance parada raiz");  
      
      // verifica necessidade de rotações 
      n = verifyRotate(n);              
      
      // condição de parada inserção
      if (inInsert && (n.getFB() == 0)) return null;
      //if (super.getDebug()) System.out.println("rebalance parada insercao");

      // condição de parada remoção
      if (!inInsert && (n.getFB() != 0)) return null;    
      //if (super.getDebug()) System.out.println("rebalance parada remocao");

      // chama recursivamente
      return rebalance(n.getParent(), inInsert);
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.rebalance(NodeRn<T> n, Boolean isFromRight, Boolean inInsert)\n" + e.getMessage());
    }
  }
  public NodeRn<T> verifyRotate(NodeRn<T> n) {
    try {
      if (n.getFB() == 2) {
        if (n.getLeftChild().getFB() >= 0) n = rightSimpleRotation(n);
        else n = rightDoubleRotation(n);
      }
      if (n.getFB() == -2) {
        if (n.getRightChild().getFB() <= 0) n = leftSimpleRotation(n);
        else n = leftDoubleRotation(n);
      }   
      return n;
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.verifyRotate(NodeRn<T> n)\n" + e.getMessage());
    }
  }
  public NodeRn<T> rightSimpleRotation(NodeRn<T> b) {  
    try {
      if (super.getDebug()) show();
      NodeRn<T> a = super.rightSimpleRotation(b);
      if (super.getDebug()) show();
      /*if (super.getDebug()) {
        a.showLinks();
        b.showLinks();
      }*/
      //if (super.getDebug()) System.out.println("rightSimpleRotation");

      return a;
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.rightSimpleRotation(NodeRn<T> b)\n" + e.getMessage());
    }
  }
  public NodeRn<T> leftSimpleRotation(NodeRn<T> b) {    
    try {
      if (super.getDebug()) show();
      NodeRn<T> a = super.leftSimpleRotation(b);
      if (super.getDebug()) show();
      /*if (super.getDebug()) {
        a.showLinks();
        b.showLinks();
      }*/
      //if (super.getDebug()) System.out.println("leftSimpleRotation");

      return a;
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.leftSimpleRotation(NodeRn<T> b)\n" + e.getMessage());
    }
  }
  public NodeRn<T> rightDoubleRotation(NodeRn<T> b) {
    try {
      //if (super.getDebug()) System.out.println("rightDoubleRotation");    
      //NodeRn<T> a = leftSimpleRotation(b.getLeftChild());
      //b = rightSimpleRotation(b);
      return super.rightDoubleRotation(b);
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.rightDoubleRotation(NodeRn<T> b)\n" + e.getMessage());
    }
  }
  public NodeRn<T> leftDoubleRotation(NodeRn<T> b) {
    try {
      //if (super.getDebug()) System.out.println("leftDoubleRotation");
      //NodeRn<T> a = rightSimpleRotation(b.getRightChild());
      //b = leftSimpleRotation(b);
      return super.leftDoubleRotation(b);
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.leftSimpleRotation(NodeRn<T> b)\n" + e.getMessage());
    }
  }
  public void show() {
    try {
      String s = "";
      String l = "";
      String e = "";
      Iterator i;
      NodeRn<T> n;
      if (super.size() != 0){
        int treeHeight = height(super.getRoot());
        for (int h = 0; h <= treeHeight; h++) {
          i = nodes();
          while(i.hasNext()) {
            // recupera Node atual
            n = (NodeRn<T>) i.next();
            // calcula espaço padrão para coluna atual
            e = "";
            int sizeE = n.getKey().toString().length() + 2;          
            for (int j = 0; j < sizeE; j ++) e += " ";
            // impressão 
            if (depth(n) == h) {
              // linha para value
              s += (n.isred() ? colorRed : colorBlack) + n.getKey() + colorReset + "";            
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
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.show()\n"+ e.getMessage());
    }
  }
} 
  