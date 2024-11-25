package Arvore.src.rn;
import java.util.Iterator;
import Arvore.src.binaria.*;
import Arvore.src.avl.*;

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
      NodeRn<T> v = super.include(k);   
      rebalance(v, true);
      return v;
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
  public NodeRn<T> rebalance(NodeRn<T> v, Boolean inInsert) {
    try {  
      if (super.getDebug()) System.out.println("rebalance");
      
      // Condição de parada se for raiz
      if (v == null) return null;
      //if (super.getDebug()) System.out.println("parada raiz");  
                         
      //if (super.getDebug()) System.out.println("isInsert: " + isInsert.ToString());
      // se inserção
      if (inInsert) {
        // critério 2: o Node root deve ser negro
        if (v.getParent() == null)
          v.setBlack();
        
        if (isCase2Insertion(v)) {
          v = resolveCase2Insertion(v);
          return rebalance(v, inInsert);
        }
        else if (isCase3Insertion(v)) {
          v = resolveCase3Insertion(v);
        }
        else if (isCase1Insertion(v)) {          
          return null;
        }
        } 
      // se remoção
      /*else {

      }*/

      // chama recursivamente
      // return rebalance(v.getParent(), inInsert);
      return null;
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.rebalance(NodeRn<T> n, Boolean isFromRight, Boolean inInsert)\n" + e.getMessage());
    }
  }
  public NodeRn<T> rightSimpleRotation(NodeRn<T> b) {  
    try {
      if (super.getDebug()) {
        System.out.println("After rotate:");
        show();
      }
      NodeRn<T> a = super.rightSimpleRotation(b);
      if (super.getDebug()) {
        System.out.println("Before rotate:");
        show();
      }
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
      if (super.getDebug()) {
        System.out.println("After rotate:");
        show();
      }
      NodeRn<T> a = super.leftSimpleRotation(b);
      if (super.getDebug()) {
        System.out.println("Before rotate:");
        show();
      }
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
  public int blackHeight(NodeRn<T> v) {
    if (v == null) return 0;
    else {
      int h = 0;
      Iterator c = v.children();
      while(c.hasNext()){
        NodeRn<T> vChild = (NodeRn<T>) c.next();
        h = Math.max(h, blackHeight(vChild));
      }
      return h + (v.isRed() ? 0 : 1);
    }
  }
  public Boolean isCase1Insertion(NodeRn<T> v) {
    try {
      /* 
      Caso 1 da inserção:
      se w, o pai de v, é negro, nada mais precisa ser feito já que o critério 4 foi mantido.
      */
      Boolean r = false;
      if (v.getParent() == null || v.getParent().isBlack()) {        
        if (super.getDebug()) System.out.println("isCase1Insertion");
        r = true; 
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isCase1Insertion!\n" + e.getMessage());
    }
  }
  public Boolean isCase2Insertion(NodeRn<T> v) {
    try {
      /*
      Caso 2 da inserção:
      Suponha w(pai de v) rubro e t, o pai de w(avó de v) é negro.
      Se u, o irmão de w (tio de v) é rubro, ainda é possível manter o
      critério 4 apenas fazendo a re-coloração de t(Rubro),u(Negro) e w(Negro).
      Se o pai de t for rubro o processo deverá ser repetido fazendo v=t.
      */
      Boolean r = false;
      NodeRn<T> w = v.getParent();
      NodeRn<T> t = v.getGrandfather();
      NodeRn<T> u = v.getUncle();
      if (
          ((w != null) && w.isRed()) &&
          ((t != null) && t.isBlack()) &&
          ((u != null) && u.isRed())      
        ) {
          if (super.getDebug()) System.out.println("isCase2Insertion");
          // t.setRed();
          // u.setBlack();
          // w.setBlack();
          r = true;
      }
        return r;
      } catch (Exception e) {
        throw new RuntimeException("Erro durante isCase2Insertion!\n" + e.getMessage());
      }
    }
    public NodeRn<T> resolveCase2Insertion(NodeRn<T> v) {
      try {
      if (super.getDebug()) System.out.println("resolveCase2Insertion");
      // Se o pai de t for rubro o processo deverá ser repetido fazendo v=t.
      NodeRn<T> w = v.getParent();
      NodeRn<T> t = v.getGrandfather();
      NodeRn<T> u = v.getUncle();
      t.setRed();
      u.setBlack();
      w.setBlack();
      
      // critério 2: o Node root deve ser negro
      if (t.getParent() == null) t.setBlack();
      
      if ((t.getParent() != null) && t.getParent().isRed())
        return t; 
      
      return v;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveCase2Insertion!\n" + e.getMessage());
    }
  }
  public Boolean isCase3Insertion(NodeRn<T> v) {
    try {
      /*
      Caso 3: suponha w(pai de v) rubro, t(avô de v) é negro e seu irmão u(tio de v) é negro.
      Neste caso, para manter o critério 3 é necessário fazer rotações com w, v, t e u.
      Existe 4 subcasos que correspondem às 4 rotações possíveis.
      */
      Boolean r = false;
      NodeRn<T> w = v.getParent();
      NodeRn<T> t = v.getGrandfather();
      NodeRn<T> u = v.getUncle();
      if (
          ((w != null) && w.isRed()) &&
          ((t != null) && t.isBlack()) &&
          ((u == null) || u.isBlack())      
        ) {
        if (super.getDebug()) System.out.println("isCase3Insertion");
        // subcaso 3a - rotação simples à direita
        // subcaso 3b - rotação simples à esquerda
        // subcaso 3c - rotação dupla à esquerda
        // subcaso 3d - rotação dupla à direita
        r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isCase3Insertion!\n" + e.getMessage());
    }
  }
  public NodeRn<T> resolveCase3Insertion(NodeRn<T> v) {
    try {
      if (super.getDebug()) System.out.println("resolveCase3Insertion");

      NodeRn<T> w = v.getParent();
      NodeRn<T> t = v.getGrandfather();      
      t.setRed();

      if (isSubcase3aInsertion(v)) {
        w.setBlack();        
        v = rightSimpleRotation(v.getGrandfather());
      }
      else if (isSubcase3bInsertion(v)) {
        w.setBlack();
        v = leftSimpleRotation(v.getGrandfather());
      }
      else if (isSubcase3cInsertion(v)) {
        v.setBlack();
        v = leftDoubleRotation(v.getGrandfather());
      }
      else if (isSubcase3dInsertion(v)) {
        v.setBlack();
        v = rightDoubleRotation(v.getGrandfather());
      }

      return v;
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.resolveCase3Insertion(NodeRn<T> n)\n" + e.getMessage());
    }
  }
  public Boolean isSubcase3aInsertion(NodeRn<T> v) {
    try {
      /*
      subcaso 3a - rotação simples à direita:
      v é filho esquerdo de w
      w é filho esquerdo de t
      */
      Boolean r = false;
      NodeRn<T> w = v.getParent();
      if (
          super.isLeftChild(v) &&
          super.isLeftChild(w)
        ) {
        if (super.getDebug()) System.out.println("isSubcase3aInsertion");
        r = true;
      }      
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isSubcase3aInsertion!\n" + e.getMessage());
    }
  }
  public Boolean isSubcase3bInsertion(NodeRn<T> v) {
    try {
      /*
      subcaso 3b - rotação simples à esquerda:
      v é filho direito de w
      w é filho direito de t
      */
      Boolean r = false;
      NodeRn<T> w = v.getParent();
      if (
          super.isRightChild(v) &&
          super.isRightChild(w)
        ) {
        if (super.getDebug()) System.out.println("isSubcase3bInsertion");
        r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isSubcase3bInsertion!\n" + e.getMessage());
    }
  }
  public Boolean isSubcase3cInsertion(NodeRn<T> v) {
    try {
      /*
      subcaso 3c - rotação dupla à esquerda:
      v é filho esquerdo de w
      w é filho direito de t
      */
      Boolean r = false;
      NodeRn<T> w = v.getParent();
      if (
          super.isLeftChild(v) &&
          super.isRightChild(w)
        ) {
          if (super.getDebug()) System.out.println("isSubcase3cInsertion");
          r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isSubcase3cInsertion!\n" + e.getMessage());
    }
  }
  public Boolean isSubcase3dInsertion(NodeRn<T> v) {
    try {
      /*
      subcaso 3d - rotação dupla à direita:
      v é filho direito de w
      w é filho esquerdo de t
      */
      Boolean r = false;
      NodeRn<T> w = v.getParent();
      if (
        super.isRightChild(v) &&
        super.isLeftChild(w)
        ) {
        if (super.getDebug()) System.out.println("isSubcase3dInsertion");
        r = true;
      }      
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isSubcase3dInsertion!\n" + e.getMessage());
    }
  }
  public void show() {
    try {
      String s = "";
      String l = "";
      String e = "";
      String space = " ";
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
            int sizeE = n.getKey().toString().length();          
            for (int j = 0; j < sizeE; j ++) e += space;
            // impressão 
            if (depth(n) == h) {
              // linha para value
              s += (n.isRed() ? colorRed : colorBlack) + n.getKey() + colorReset + "";            
              // linha para ligação
              if (hasLeft(n)) l += "/"; 
              if (hasRight(n)) l += "\\";
            }
            else {
              // insere espaço se não houver valor na coluna
              s += e;
            }
            // insere espaço na linha de ligação
            if (depth(n) == h) {
              if ((hasLeft(n)) ^ (hasRight(n))) l += space;
              else if (isExternal(n)) l += e; 
            }
            else l += e;
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
  public Boolean verifyRn() {
    try {
      Boolean isRn = true;
      // critério 1: não precisa ser testada, pois todos os nós folhas são sempre negros
      if (super.size() == 0) return isRn;
      // critério 2: o Node root deve ser negro
      if (getRoot().isRed()) throw new RuntimeException(
        "Condição 2 não atendida: NodeRn<T> root: " + getRoot().getKey() + " tem cor 'R'."
      );
      Iterator i;
      NodeRn<T> v;
      i = nodes();
      while(i.hasNext()) {
        v = (NodeRn<T>) i.next();
        // critério 3: Se v é rubro, seus filhos devem ser negros
        if (v.isRed()) {
          if (!isExternal(v)) {
            if (v.getLeftChild() != null)
              if (v.getLeftChild().isRed())
                throw new RuntimeException(
                  "Condição 3 não atendida: NodeRn<T> v: " + v.getKey() + " tem cor 'R' e seu filho esquerdo: " + v.getLeftChild().getKey() + " tem cor 'R'."
                );            
            if (v.getRightChild() != null)
              if (v.getRightChild().isRed())
                throw new RuntimeException(
                  "Condição 3 não atendida: NodeRn<T> v: " + v.getKey() + " tem cor 'R' e seu filho direito: " + v.getRightChild().getKey() + " tem cor 'R'."
                );            
          }
        }
        // critério 4: Os caminhos de v para seus nós descendentes externos possuem idêntico número de nós negros
        if (blackHeight(v.getLeftChild()) != blackHeight(v.getRightChild()))
          throw new RuntimeException(
            "Condição 4 não atendida: altura negra dos filhos de NodeRn<T> v: " + v.getKey() + " são diferentes."
          );            
      }
      return isRn;
    } catch (Exception e) {
      throw new RuntimeException("Arvore não é rubro-negra!\n" + e.getMessage());
    }
  }
} 
  