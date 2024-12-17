package Arvore.src.rn;
import java.text.Format;
import java.util.Iterator;
import Arvore.src.binaria.*;
import Arvore.src.avl.*;

public class ArvoreRn<T extends Comparable<T>> extends ArvoreBalanceadaAbstrata<T,NodeRn<T>>  implements IArvoreBinaria<T, NodeRn<T>>, IArvoreRn<T> {
  private String colorBlack = "\033[34m"; // Azul
  private String colorRed = "\033[31m";
  private String colorReset = "\033[0m";
  private String red = "R";
  private String black = "B";
  private TestCaseArvoreRn testRn = new TestCaseArvoreRn();
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
      rebalance(v, null, null, null, null, null, true);
      return v;
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.include(T k)\n" + e.getMessage());
    }
  }
  public NodeRn<T> remove(T k){
    try {
      //if (super.getDebug()) System.out.println("remove");
     
      // Encontre o nó v a ser removido
      NodeRn<T> v = super.search(getRoot(), k);
      
      // Guarda o sucessor de k para rebalancear a arvore
      NodeRn<T> x = super.getSucessor(k);          
      if (x == null) {
        x = v;
      }

      // parentes de x
      NodeRn<T> t = x.getParent();  
      NodeRn<T> w = x.getBrother();
      NodeRn<T> xLN = x.getLeftNephew();
      NodeRn<T> xRN = x.getRightNephew();

      /*if (super.getDebug()) {
        System.out.println("family:");
        System.out.println("  v: " + (v != null ? v.getKey() + " " + v.getColor() : "null B"));
        System.out.println("  x: " + (x != null ? x.getKey() + " " + x.getColor() : "null B"));
        System.out.println("  t: " + (t != null ? t.getKey() + " " + t.getColor() : "null B"));
        System.out.println("  w: " + (w != null ? w.getKey() + " " + w.getColor() : "null B"));
        System.out.println("xLN: " + (xLN != null ? xLN.getKey() + " " + xLN.getColor() : "null B"));
        System.out.println("xRn: " + (xRN != null ? xRN.getKey() + " " + xRN.getColor() : "null B"));
      }*/

      // remove k
      super.remove(k);

      // Rebalanceia a árvore
      if (super.size() > 0) rebalance(v, x, t, w, xLN, xRN, false);
      return v;
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.remove(T k)\n" + e.getMessage());
    }
  }  
  public NodeRn<T> rebalance(NodeRn<T> v, NodeRn<T> x, NodeRn<T> t, NodeRn<T> w, NodeRn<T> xLN, NodeRn<T> xRN, Boolean inInsert) {
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
       
        if (isCase2Include(v)) {
          v = resolveCase2Include(v);
          return rebalance(v,null,null,null,null,null, inInsert);
        }
        else if (isCase3Include(v)) {
          v = resolveCase3Include(v);
          return null;
        }
        else if (isCase1Include(v)) {          
          return null;
        }
        }
      // se remoção
      else {
        if (isSituation1Remove(v, x)) {
          return null;
        }
        else if (isSituation2Remove(v, x)) {
          resolveSituation2Remove(v, x);
          return null;
        }
        else if (isSituation3Remove(v, x)) {
          resolveSituation3Remove(x, t, w, xLN, xRN);
          return null;
        }
        else if (isSituation4Remove(v, x)) {
          
          if (super.getDebug()) {
            System.out.println("family:");
            //System.out.println("  v: " + (v != null ? v.getKey() + " " + v.getColor() : "null B"));
            System.out.println("  x: " + (x != null ? x.getKey() + " " + x.getColor() : "null B"));
            System.out.println("  t: " + (t != null ? t.getKey() + " " + t.getColor() : "null B"));
            System.out.println("  w: " + (w != null ? w.getKey() + " " + w.getColor() : "null B"));
            System.out.println("xLN: " + (xLN != null ? xLN.getKey() + " " + xLN.getColor() : "null B"));
            System.out.println("xRn: " + (xRN != null ? xRN.getKey() + " " + xRN.getColor() : "null B"));
          }
          
          resolveSituation4Remove(x, t, w, xLN, xRN);   

          NodeRn<T> newW = x.getBrother();
          NodeRn<T> newXLN = x.getRightNephew();
          NodeRn<T> newXRN = x.getLeftNephew(); 
          if (super.isLeftChild(x)) {
            newXLN = x.getLeftNephew();
            newXRN = x.getRightNephew();
          }
          if (super.isRightChild(x)) {
            newXLN = x.getRightNephew();
            newXRN = x.getLeftNephew();
          }
          
          if (super.getDebug()) {
            System.out.println("family new:");
            //System.out.println("  v: " + (v != null ? v.getKey() + " " + v.getColor() : "null B"));
            System.out.println("  new x: " + (x != null ? x.getKey() + " " + x.getColor() : "null B"));
            System.out.println("  new t: " + (t != null ? t.getKey() + " " + t.getColor() : "null B"));
            System.out.println("  new w: " + (newW != null ? newW.getKey() + " " + newW.getColor() : "null B"));
            System.out.println("new xLN: " + (newXLN != null ? newXLN.getKey() + " " + newXLN.getColor() : "null B"));
            System.out.println("new xRN: " + (newXRN != null ? newXRN.getKey() + " " + newXRN.getColor() : "null B"));
          }

          resolveSituation3Remove(x, t, newW, newXLN, newXRN); 
          
          return null;
        }
      }

      return null;
    } catch (Exception e) {
      throw new RuntimeException(
        "Erro em: ArvoreRn.rebalance(NodeRn<T> n, NodeRn<T> x, Boolean inInsert)\n" + e.getMessage()
      );
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
      return a;
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.leftSimpleRotation(NodeRn<T> b)\n" + e.getMessage());
    }
  }
  public NodeRn<T> rightDoubleRotation(NodeRn<T> b) {
    try {
      //NodeRn<T> a = leftSimpleRotation(b.getLeftChild());
      //b = rightSimpleRotation(b);
      return super.rightDoubleRotation(b);
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.rightDoubleRotation(NodeRn<T> b)\n" + e.getMessage());
    }
  }
  public NodeRn<T> leftDoubleRotation(NodeRn<T> b) {
    try {
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
  public Boolean isCase1Include(NodeRn<T> v) {
    try {
      /*
      Caso 1 da inserção:
      se w, o pai de v, é negro, nada mais precisa ser feito já que o critério 4 foi mantido.
      */
      Boolean r = false;
      if (v.getParent() == null || v.getParent().isBlack()) {        
        if (super.getDebug()) System.out.println("isCase1Include");
        testRn.SetTestIsCase1Include();
        r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isCase1Include!\n" + e.getMessage());
    }
  }
  public Boolean isCase2Include(NodeRn<T> v) {
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
          if (super.getDebug()) System.out.println("isCase2Include");
          testRn.SetTestIsCase2Include();
          // t.setRed();
          // u.setBlack();
          // w.setBlack();
          r = true;
      }
        return r;
      } catch (Exception e) {
        throw new RuntimeException("Erro durante isCase2Include!\n" + e.getMessage());
      }
    }
    public NodeRn<T> resolveCase2Include(NodeRn<T> v) {
      try {
      if (super.getDebug()) System.out.println("resolveCase2Include");
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
      throw new RuntimeException("Erro durante resolveCase2Include!\n" + e.getMessage());
    }
  }
  public Boolean isCase3Include(NodeRn<T> v) {
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
        if (super.getDebug()) System.out.println("isCase3Include");
        testRn.SetTestIsCase3Include();
        // subcaso 3a - rotação simples à direita
        // subcaso 3b - rotação simples à esquerda
        // subcaso 3c - rotação dupla à esquerda
        // subcaso 3d - rotação dupla à direita
        r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isCase3Include!\n" + e.getMessage());
    }
  }
  public NodeRn<T> resolveCase3Include(NodeRn<T> v) {
    try {
      if (super.getDebug()) System.out.println("resolveCase3Include");


      NodeRn<T> w = v.getParent();
      NodeRn<T> t = v.getGrandfather();      
      t.setRed();


      if (isSubcase3aInclude(v)) {
        w.setBlack();        
        v = rightSimpleRotation(v.getGrandfather());
      }
      else if (isSubcase3bInclude(v)) {
        w.setBlack();
        v = leftSimpleRotation(v.getGrandfather());
      }
      else if (isSubcase3cInclude(v)) {
        v.setBlack();
        v = leftDoubleRotation(v.getGrandfather());
      }
      else if (isSubcase3dInclude(v)) {
        v.setBlack();
        v = rightDoubleRotation(v.getGrandfather());
      }


      return v;
    } catch (Exception e) {
      throw new RuntimeException("Erro em: ArvoreRn.resolveCase3Include(NodeRn<T> n)\n" + e.getMessage());
    }
  }
  public Boolean isSubcase3aInclude(NodeRn<T> v) {
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
        if (super.getDebug()) System.out.println("isSubcase3aInclude");
        testRn.SetTestIsSubcase3aInclude();
        r = true;
      }      
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isSubcase3aInclude!\n" + e.getMessage());
    }
  }
  public Boolean isSubcase3bInclude(NodeRn<T> v) {
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
        if (super.getDebug()) System.out.println("isSubcase3bInclude");
        testRn.SetTestIsSubcase3bInclude();
        r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isSubcase3bInclude!\n" + e.getMessage());
    }
  }
  public Boolean isSubcase3cInclude(NodeRn<T> v) {
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
        if (super.getDebug()) System.out.println("isSubcase3cInclude");
        testRn.SetTestIsSubcase3cInclude();
        r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isSubcase3cInclude!\n" + e.getMessage());
    }
  }
  public Boolean isSubcase3dInclude(NodeRn<T> v) {
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
        if (super.getDebug()) System.out.println("isSubcase3dInclude");
        testRn.SetTestIsSubcase3dInclude();
        r = true;
      }      
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isSubcase3dInclude!\n" + e.getMessage());
    }
  }
  public Boolean isSituation1Remove(NodeRn<T> v, NodeRn<T> x) {
    try {
      /*
      Situação 1 – seja v o nó a ser removido. Sendo v rubro e x, sucessor de v, também rubro.
      Nada necessita ser feito, pois a árvore Rubro-Negra continua atendendo a todos os critérios.
      */
      Boolean r = false;
      if (isRed(v) && isRed(x)) {
        if (super.getDebug()) System.out.println("isSituation1Remove");
        testRn.SetTestIsSituation1Remove();
        r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isSituation1Remove!\n" + e.getMessage());
    }
  }
  public Boolean isSituation2Remove(NodeRn<T> v, NodeRn<T> x) {
    try {
      /*
      Situação 2 – v é negro e x é rubro.
      Pinte x de negro e pare.
      */
      Boolean r = false;
      if (isBlack(v) && isRed(x)) {
        if (super.getDebug()) System.out.println("isSituation2Remove");
        testRn.SetTestIsSituation2Remove();        
        r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isSituation2Remove!\n" + e.getMessage());
    }
  }
  public void resolveSituation2Remove(NodeRn<T> v, NodeRn<T> x) {
    try {
      if (super.getDebug()) System.out.println("resolveSituation2Remove");
      /*
      Situação 2 – v é negro e x é rubro.
      Pinte x de negro e pare.
      */
      setBlack(x);
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveSituation2Remove!\n" + e.getMessage());
    }
  }
  public Boolean isSituation3Remove(NodeRn<T> v, NodeRn<T> x) {
    try {
      /*
      Situação 3 – v é negro e x é negro.
      */
      Boolean r = false;
      if (isBlack(v) && isBlack(x)) {
        if (super.getDebug()) System.out.println("isSituation3Remove");
        testRn.SetTestIsSituation3Remove();
        r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isSituation3Remove!\n" + e.getMessage());
    }
  }
  public void resolveSituation3Remove(NodeRn<T> x, NodeRn<T> t, NodeRn<T> w, NodeRn<T> xLN, NodeRn<T> xRN) {
    try {
      if (super.getDebug()) System.out.println("resolveSituation3Remove");
      /*
      Situação 3 – v é negro e x é negro.
      */
      // caso 1
      if (isCase1Remove(x, t, w)) {
        resolveCase1Remove(t, w);        
        resolveSituation3Remove(x, x.getParent(), x.getBrother(), x.getLeftNephew(), x.getRightNephew());
      }
      // caso 2a
      else if (isCase2aRemove(x, t, w, xLN, xRN)) {
        resolveCase2aRemove(w);
        if (getRoot() != t)
          resolveSituation3Remove(t, t.getParent(), t.getBrother(), t.getLeftNephew(), t.getRightNephew());        
      }
      // caso 2b
      else if (isCase2bRemove(x, t, w, xLN, xRN)) {
        resolveCase2bRemove(t, w);
      }
      // caso 3
      else if (isCase3Remove(x, t, w, xLN, xRN)) {
        resolveCase3Remove(x, w, xLN, xRN);

        if (super.getDebug()) {
          System.out.println("family:");
          System.out.println("  x: " + (x != null ? x.getKey() + " " + x.getColor() : "null B"));
          System.out.println("  t: " + (t != null ? t.getKey() + " " + t.getColor() : "null B"));
          System.out.println("  w: " + (w != null ? w.getKey() + " " + w.getColor() : "null B"));
          System.out.println("xLN: " + (xLN != null ? xLN.getKey() + " " + xLN.getColor() : "null B"));
          System.out.println("xRN: " + (xRN != null ? xRN.getKey() + " " + xRN.getColor() : "null B"));
        }           

        NodeRn<T> newW = x.getBrother();
        NodeRn<T> newXLN = x.getRightNephew();
        NodeRn<T> newXRN = x.getLeftNephew(); 
        if (super.isLeftChild(x)) {
          newXLN = x.getLeftNephew();
          newXRN = x.getRightNephew();
        }
        if (super.isRightChild(x)) {
          newXLN = x.getRightNephew();
          newXRN = x.getLeftNephew();
        }

        if (super.getDebug()) {
          System.out.println("family new:");
          //System.out.println("  v: " + (v != null ? v.getKey() + " " + v.getColor() : "null B"));
          System.out.println("  new x: " + (x != null ? x.getKey() + " " + x.getColor() : "null B"));
          System.out.println("  new t: " + (t != null ? t.getKey() + " " + t.getColor() : "null B"));
          System.out.println("  new w: " + (newW != null ? newW.getKey() + " " + newW.getColor() : "null B"));
          System.out.println("new xLN: " + (newXLN != null ? newXLN.getKey() + " " + newXLN.getColor() : "null B"));
          System.out.println("new xRN: " + (newXRN != null ? newXRN.getKey() + " " + newXRN.getColor() : "null B"));
        }

        resolveSituation3Remove(x,t,newW,newXLN,newXRN);
      }
      // caso 4
      else if (isCase4Remove(x, t, w, xLN, xRN)) {
        resolveCase4Remove(x, t, w, xLN, xRN);
      }
     
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveSituation3Remove!\n" + e.getMessage());
    }
  }
  public Boolean isCase1Remove(NodeRn<T> x, NodeRn<T> t, NodeRn<T> w) {
    try {
      /*
      Caso 1: se x é negro e x tem irmão w rubro e t(pai de x) é negro.
      Marque ele com um duplo negro e faça o seguinte:
      • Faça uma rotação simples esquerda
      • Pinte w de negro
      • Pinte pai de x de rubro
      • Chame o caso 2b
      */
      Boolean r = false;
      if (
        isBlack(x) && isRed(w) &&
        isBlack(t)
      ) {
        if (super.getDebug()) System.out.println("isCase1Remove");
        testRn.SetTestIsCase1Remove();
        r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isCase1Remove!\n" + e.getMessage());
    }
  }
  public void resolveCase1Remove(NodeRn<T> t, NodeRn<T> w) {
    try {
      if (super.getDebug()) System.out.println("resolveCase1Remove");
      /*
      Caso 1: se x é negro e x tem irmão w rubro e t(pai de x) é negro.
      Marque ele com um duplo negro e faça o seguinte:
      • Faça uma rotação simples esquerda em w
      • Pinte w de negro
      • Pinte pai de x de rubro
      • Chame o caso 2b
      */
      //NodeRn<T> w = x.getBrother();
      //NodeRn<T> t = x.getParent();
      if (super.isRightChild(w)) leftSimpleRotation(t);
      if (super.isLeftChild(w)) rightSimpleRotation(t);
      setBlack(w);
      setRed(t);
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveCase1Remove!\n" + e.getMessage());
    }
  }
  public Boolean isCase2aRemove(NodeRn<T> x, NodeRn<T> t, NodeRn<T> w, NodeRn<T> xLN, NodeRn<T> xRN) {
    try {
      /*
      Caso 2a: se x é negro, tem w(irmão de x) negro com filhos negros e t(pai de x) negro.
      faça o seguinte:
      • Pinte o irmão w de rubro
      */
      Boolean r = false;
      //NodeRn<T> w = x.getBrother();
      //NodeRn<T> t = x.getParent();
      //NodeRn<T> xLN = x.getLeftNephew();
      //NodeRn<T> xRN = x.getRightNephew();

      if (
          isBlack(x) && isBlack(w) &&
          isBlack(xLN) && isBlack(xRN) &&
          isBlack(t)
        ) {
        if (super.getDebug()) System.out.println("isCase2aRemove");
        testRn.SetTestIsCase2aRemove();
        r = true;
      }
      
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isCase2aRemove!\n" + e.getMessage());
    }
  }
  public void resolveCase2aRemove(NodeRn<T> w) {
    try {
      if (super.getDebug()) System.out.println("resolveCase2aRemove");
      /*
      Caso 2a: se x é negro, tem w(irmão de x) negro com filhos negros e t(pai de x) negro.
      faça o seguinte:
      • Pinte w(irmão de x) de rubro
      */
      //NodeRn<T> w = x.getBrother();
      setRed(w);
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveCase2aRemove!\n" + e.getMessage());
    }
  }
  public Boolean isCase2bRemove(NodeRn<T> x, NodeRn<T> t, NodeRn<T> w, NodeRn<T> xLN, NodeRn<T> xRN) {
    try {
      /*
      Caso 2b: se x é negro, tem w(irmão de x) negro com filhos negros e t(pai de x) rubro.
      faça o seguinte:
      • Pinte w(irmão de x) de rubro e o t(pai de x) de negro
      */
      Boolean r = false;
      //NodeRn<T> w = x.getBrother();
      //NodeRn<T> t = x.getParent();
      //NodeRn<T> xLN = x.getLeftNephew();
      //NodeRn<T> xRN = x.getRightNephew();

      if (
        isBlack(x) && isBlack(w) &&
        isBlack(xLN) && isBlack(xRN) &&
        isRed(t)
      ) {
        if (super.getDebug()) System.out.println("isCase2bRemove");
        testRn.SetTestIsCase2bRemove();
        r = true;
      }

      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isCase2bRemove!\n" + e.getMessage());
    }
  }
  public void resolveCase2bRemove(NodeRn<T> t, NodeRn<T> w) {
    try {
      if (super.getDebug()) System.out.println("resolveCase2bRemove");
      /*
      Caso 2b: se x é negro, tem w (irmão de x) negro com filhos negros e t(pai de w) é rubro.
      faça o seguinte:
      • Pinte w(irmão de x) de rubro e t(pai de x) de negro
      */
      setRed(w);
      setBlack(t);
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveCase2bRemove!\n" + e.getMessage());
    }
  }
  public Boolean isCase3Remove(NodeRn<T> x, NodeRn<T> t, NodeRn<T> w, NodeRn<T> xLN, NodeRn<T> xRN) {
    try {
      /*
      Caso 3: se x é negro, tem  w(irmão de x) negro, tem t(pai de x) de qualquer cor (rubro ou negro), tem
      w(irmão de x) com filho esquerdo rubro e w(irmão de x) com filho direito negro. faça o seguinte:
      se x for filho esquerdo:
        • Rotação simples direita em w(irmão de x) se x for filho esquerdo
        • Trocar as cores de w com seu filho esquerdo
      se x for filho direito:
        • Rotação simples esquerda em w(irmão de x) se x for filho direito
        • Trocar as cores de w com seu filho direito
      */
      Boolean r = false;
      //NodeRn<T> w = x.getBrother();
      //NodeRn<T> t = x.getParent();
      //NodeRn<T> xLN = x.getLeftNephew();
      //NodeRn<T> xRN = x.getRightNephew();
      if (
        (
          isBlack(x) && super.isLeftChild(x) &&
          isBlack(w) && isRed(xLN) && isBlack(xRN)
        ) || (
          isBlack(x) && super.isRightChild(x) &&
          isBlack(w) && isBlack(xLN) && isRed(xRN)
        )
      ) {
        if (super.getDebug()) System.out.println("isCase3Remove");
        if ((super.getDebug()) && super.isLeftChild(x)) System.out.println("isCase3Remove x é filho esquerdo");
        if ((super.getDebug()) && super.isRightChild(x)) System.out.println("isCase3Remove x é filho direito");
        testRn.SetTestIsCase3Remove();
        r = true;
      }
      
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isCase3Remove!\n" + e.getMessage());
    }
  }
  public void resolveCase3Remove(NodeRn<T> x, NodeRn<T> w, NodeRn<T> xLN, NodeRn<T> xRN) {
    try {
      if (super.getDebug()) System.out.println("resolveCase3Remove");
      /*
      Caso 3: se x é negro, tem  w(irmão de x) negro, tem t(pai de x) de qualquer cor (rubro ou negro), tem
      w(irmão de x) com filho esquerdo rubro e w(irmão de x) com filho direito negro. faça o seguinte:
      se x for filho esquerdo:
        • Rotação simples direita em w(irmão de x) 
        • Trocar as cores de w com seu filho esquerdo
      se x for filho direito:
        • Rotação simples esquerda em w(irmão de x)
        • Trocar as cores de w com seu filho direito
      */
      //NodeRn<T> w = x.getBrother();
      //NodeRn<T> t = x.getParent();
      //NodeRn<T> xLN = x.getLeftNephew();
      //NodeRn<T> xRN = x.getRightNephew();
      if (super.isLeftChild(x)) {
        rightSimpleRotation(w);
        setRed(w);
        setBlack(xLN);
        if ((super.getDebug()) && super.isLeftChild(x)) System.out.println("resolveCase3 x é filho esquerdo");
      } if (super.isRightChild(x)) {
        leftSimpleRotation(w);
        setRed(w);
        setBlack(xRN);
        if ((super.getDebug()) && super.isRightChild(x)) System.out.println("resolveCase3 x é filho direito");
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveCase3Remove!\n" + e.getMessage());
    }
  }
  public Boolean isCase4Remove(NodeRn<T> x, NodeRn<T> t, NodeRn<T> w, NodeRn<T> xLN, NodeRn<T> xRN) {
    try {
      /*
      Caso 4: se x é negro, tem w(irmão de x) negro, tem t(pai de x) de qualquer cor (rubro ou negro), tem
      w(irmão de x) com filho esquerdo qualquer cor e com filho direito rubro.
      Se x é filho esquerdo:
        • Rotação simples a esquerda em t
        • w recebe a cor de t(pai de x)
        • Pinte o t(pai de x) de negro        
        • Pinte o filho direito de w de negro
      Se x é filho direito:
        • Rotação simples a direita em t
        • w recebe a cor de t(pai de x)
        • Pinte o t(pai de x) de negro
        • Pinte o filho esquerdo de w de negro
      */
      Boolean r = false;
      //NodeRn<T> w = x.getBrother();
      //NodeRn<T> t = x.getParent();
      //NodeRn<T> wLN = x.getLeftNephew();
      //NodeRn<T> wRN = x.getRightNephew();
      if (
        (
          isBlack(x) && super.isLeftChild(x) &&
          isBlack(w) && isRed(xRN)
        ) || (
          isBlack(x) && super.isRightChild(x) &&
          isBlack(w) && isRed(xLN)
        )
      ) {
        if (super.getDebug()) System.out.println("isCase4Remove");
        if ((super.getDebug()) && super.isLeftChild(x)) System.out.println("isCase4Remove x é filho esquerdo");
        if ((super.getDebug()) && super.isRightChild(x)) System.out.println("isCase4Remove x é filho direito");
        testRn.SetTestIsCase4Remove();
        r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isCase4Remove!\n" + e.getMessage());
    }
  }
  public void resolveCase4Remove(NodeRn<T> x, NodeRn<T> t, NodeRn<T> w, NodeRn<T> xLN, NodeRn<T> xRN) {
    try {
      if (super.getDebug()) System.out.println("resolveCase4Remove");
      /*
      Caso 4: se x é negro, tem w(irmão de x) negro, tem t(pai de x) de qualquer cor (rubro ou negro), tem
      w(irmão de x) com filho esquerdo qualquer cor e com filho direito rubro.
      Se x é filho esquerdo:
        • Rotação simples a esquerda em t
        • w recebe a cor de t(pai de x)
        • Pinte o t(pai de x) de negro        
        • Pinte o filho direito de w de negro
      Se x é filho direito:
        • Rotação simples a direita em t
        • w recebe a cor de t(pai de x)
        • Pinte o t(pai de x) de negro
        • Pinte o filho esquerdo de w de negro
      */
      //NodeRn<T> w = x.getBrother();
      //NodeRn<T> t = x.getParent();
      //NodeRn<T> xLN = x.getLeftNephew();
      //NodeRn<T> xRN = x.getRightNephew();
      if (super.isLeftChild(x)) {
        leftSimpleRotation(t);
        if (isRed(t)) setRed(w);
        else setBlack(w);
        setBlack(t);
        setBlack(xRN);
        if ((super.getDebug()) && super.isLeftChild(x)) System.out.println("resolveCase4 x é filho esquerdo");
      } if (super.isRightChild(x)) {
        rightSimpleRotation(t);
        if (isRed(t)) setRed(w);
        else setBlack(w);
        setBlack(t);
        setBlack(xLN);
        if ((super.getDebug()) && super.isRightChild(x)) System.out.println("resolveCase4 x é filho direito");
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveCase4Remove!\n" + e.getMessage());
    }
  }
  public Boolean isSituation4Remove(NodeRn<T> v, NodeRn<T> x) {
    try {
      /*
      Situação 3 – v é vermelho e x é negro.
      */
      Boolean r = false;
      if (isRed(v) && isBlack(x)) {
        if (super.getDebug()) System.out.println("isSituation4Remove");
        testRn.SetTestIsSituation4Remove();
        r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isSituation4Remove!\n" + e.getMessage());
    }
  }
  public void resolveSituation4Remove(NodeRn<T> x, NodeRn<T> t, NodeRn<T> w, NodeRn<T> xLN, NodeRn<T> xRN) {
    try {
      if (super.getDebug()) System.out.println("resolveSituation4Remove");
      /*
      Situação 4 – v é rubro e x é negro.
    – Similar à situação 3. faça o seguinte:
    • Pinte x de rubro
    • Proceda como na situação 3
      */
      setRed(x);       
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveSituation4Remove!\n" + e.getMessage());
    }
  }
  public Boolean isRed(NodeRn<T> n){
    Boolean r = true;
    if (n == null) return false;
    else return n.isRed();
  }
  public Boolean isBlack(NodeRn<T> n){
    Boolean r = true;
    if (n == null) return true;
    else return n.isBlack();
  }
  public void setBlack(NodeRn<T> n) {
    if (n != null) n.setBlack();
  }
  public void setRed(NodeRn<T> n) {
    if (n != null) n.setRed();
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
              s += (isRed(n) ? colorRed : colorBlack) + n.getKey() + colorReset + "";            
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
      if (isRed(getRoot())) throw new RuntimeException(
        "Condição 2 não atendida: NodeRn<T> root: " + getRoot().getKey() + " tem cor 'R'."
      );
      Iterator i;
      NodeRn<T> v;
      i = nodes();
      while(i.hasNext()) {
        v = (NodeRn<T>) i.next();
        // critério 3: Se v é rubro, seus filhos devem ser negros
        if (isRed(v)) {
          if (!isExternal(v)) {
            if (v.getLeftChild() != null)
              if (isRed(v.getLeftChild()))
                throw new RuntimeException(
                  "Condição 3 não atendida: NodeRn<T> v: " + v.getKey() + " tem cor 'R' e seu filho esquerdo: " + v.getLeftChild().getKey() + " tem cor 'R'."
                );            
            if (v.getRightChild() != null)
              if (isRed(v.getRightChild()))
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
  public void test() {
    testRn.test();
  }
}
class TestCaseArvoreRn {
  // validadores de testes de inserção
  private int testIsCase1Include = 0;
  private int testIsCase2Include = 0;
  private int testIsCase3Include = 0;
  private int testIsSubcase3aInclude = 0;
  private int testIsSubcase3bInclude = 0;
  private int testIsSubcase3cInclude = 0;
  private int testIsSubcase3dInclude = 0;
  
  // validadores de teste de remoção
  private int testIsSituation1Remove = 0;
  private int testIsSituation2Remove = 0;
  private int testIsSituation3Remove = 0;
  private int testIsSituation4Remove = 0;
  private int testIsCase1Remove = 0;
  private int testIsCase2aRemove = 0;
  private int testIsCase2bRemove = 0;
  private int testIsCase3Remove = 0;
  private int testIsCase4Remove = 0;

  public TestCaseArvoreRn() {}
  
  // Configura testes de inserção
  public void SetTestIsCase1Include() {
    testIsCase1Include = 1;
  }
  public void SetTestIsCase2Include() {
    testIsCase2Include = 1;
  }
  public void SetTestIsCase3Include() {
    testIsCase3Include = 1;
  }
  public void SetTestIsSubcase3aInclude() {
    testIsSubcase3aInclude = 1;
  }
  public void SetTestIsSubcase3bInclude() {
    testIsSubcase3bInclude = 1;
  }
  public void SetTestIsSubcase3cInclude() {
    testIsSubcase3cInclude = 1;
  }
  public void SetTestIsSubcase3dInclude() {
    testIsSubcase3dInclude = 1;
  }

  // Configura testes de remoção
  public void SetTestIsSituation1Remove() {
    testIsSituation1Remove = 1;
  }
  public void SetTestIsSituation2Remove() {
    testIsSituation2Remove = 1;
  }
  public void SetTestIsSituation3Remove() {
    testIsSituation3Remove = 1;
  }
  public void SetTestIsSituation4Remove() {
    testIsSituation4Remove = 1;
  }
  public void SetTestIsCase1Remove() {
    testIsCase1Remove = 1;
  }
  public void SetTestIsCase2aRemove() {
    testIsCase2aRemove = 1;
  }
  public void SetTestIsCase2bRemove() {
    testIsCase2bRemove = 1;
  }
  public void SetTestIsCase3Remove() {
    testIsCase3Remove = 1;
  }
  public void SetTestIsCase4Remove() {
    testIsCase4Remove = 1;
  }

  // Exibe quais testes foram executados
  public void test() {
    System.out.println("testIsCase1Include: " + (testIsCase1Include > 0 ? "ok" : ""));
    System.out.println("testIsCase2Include: " + (testIsCase2Include > 0 ? "ok" : ""));
    System.out.println("testIsCase3Include: " + (testIsCase3Include > 0 ? "ok" : ""));
    System.out.println("  testIsSubcase3aInclude: " + (testIsSubcase3aInclude > 0 ? "ok" : ""));
    System.out.println("  testIsSubcase3bInclude: " + (testIsSubcase3bInclude > 0 ? "ok" : ""));
    System.out.println("  testIsSubcase3cInclude: " + (testIsSubcase3cInclude > 0 ? "ok" : ""));
    System.out.println("  testIsSubcase3dInclude: " + (testIsSubcase3dInclude > 0 ? "ok" : ""));
    System.out.println("testIsSituation1Remove: " + (testIsSituation1Remove > 0 ? "ok" : ""));
    System.out.println("testIsSituation2Remove: " + (testIsSituation2Remove > 0 ? "ok" : ""));
    System.out.println("testIsSituation3Remove: " + (testIsSituation3Remove > 0 ? "ok" : ""));
    System.out.println("  testIsCase1Remove: " + (testIsCase1Remove > 0 ? "ok" : ""));
    System.out.println("  testIsCase2aRemove: " + (testIsCase2aRemove > 0 ? "ok" : ""));
    System.out.println("  testIsCase2bRemove: " + (testIsCase2bRemove > 0 ? "ok" : ""));
    System.out.println("  testIsCase3Remove: " + (testIsCase3Remove > 0 ? "ok" : ""));
    System.out.println("  testIsCase4Remove: " + (testIsCase4Remove > 0 ? "ok" : ""));
    System.out.println("testIsSituation4Remove: " + (testIsSituation4Remove > 0 ? "ok" : ""));
  }
}