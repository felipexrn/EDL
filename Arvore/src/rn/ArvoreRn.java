package Arvore.src.rn;
import java.util.Iterator;
import Arvore.src.binaria.*;
import Arvore.src.avl.*;


public class ArvoreRn<T extends Comparable<T>> extends ArvoreBalanceadaAbstrata<T,NodeRn<T>>  implements IArvoreBinaria<T, NodeRn<T>>, IArvoreRn<T> {
  private String colorBlack = "\033[34m"; // Azul
  private String colorRed = "\033[31m";
  private String colorReset = "\033[0m";
  private String red = "R";
  private String black = "B";
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
      rebalance(v, null, null, null, null, null true);
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

      // remove k
      v = super.remove(k);

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
        else if (isSituation3Remove(v, x, t, w)) {
          resolveSituation3Remove(v, x, t, w);
          return null;
        }
        else if (isSituation4Remove(v, x)) {
          resolveSituation4Remove(v, x);
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
      /*if (super.getDebug()) {
        a.showLinks();
        b.showLinks();
      }*/


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
      if (x != null) x.setBlack();
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
        r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isSituation3Remove!\n" + e.getMessage());
    }
  }
  public void resolveSituation3Remove(NodeRn<T> v, NodeRn<T> x, NodeRn<T> t, NodeRn<T> w) {
    try {
      if (super.getDebug()) System.out.println("resolveSituation3Remove");
      /*
      Situação 3 – v é negro e x é negro.
      */
      // caso 1
      if (isCase1Remove(v, x, t, w)) {
        resolveCase1Remove(v, x, t, w);
        resolveCase2bRemove(v, x, t, w);
      }
      // caso 2a
      if (isCase2aRemove(v, x)) {
        resolveCase2aRemove(v, x);
      }
      // caso 2b
      if (isCase2bRemove(v, x, t, w)) {
        resolveCase2bRemove(v, x, t, w);
      }
      // caso 3
      if (isCase3Remove(v, x)) {
        resolveCase3Remove(v, x);
      }
      // caso 4
      if (isCase4Remove(v, x)) {
        resolveCase4Remove(v, x);
      }
     
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveSituation3Remove!\n" + e.getMessage());
    }
  }
  public Boolean isCase1Remove(NodeRn<T> v, NodeRn<T> x, NodeRn<T> t, NodeRn<T> w) {
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
      //NodeRn<T> w = x.getBrother();
      //NodeRn<T> t = x.getParent();
      if (
        isBlack(x) &&
        isRed(w) &&
        isBlack(t)
      ) {
        if (super.getDebug()) System.out.println("isCase1Remove");
          r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isCase1Remove!\n" + e.getMessage());
    }
  }
  public void resolveCase1Remove(NodeRn<T> v, NodeRn<T> x, NodeRn<T> t, NodeRn<T> w) {
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
      super.leftSimpleRotation(w);
      if (w != null) w.setBlack();
      if (t != null) t.setRed();
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveCase1Remove!\n" + e.getMessage());
    }
  }
  public Boolean isCase2aRemove(NodeRn<T> v, NodeRn<T> x, NodeRn<T> t, NodeRn<T> w) {
    try {
      /*
      Caso 2a: se x é negro, tem w(irmão de x) negro com filhos negros e t(pai de x) negro.
      faça o seguinte:
      • Pinte o irmão w de rubro
      */
      Boolean r = false;
      //NodeRn<T> w = x.getBrother();
      //NodeRn<T> t = x.getParent();
      NodeRn<T> wLN = x.getLeftNephew();
      NodeRn<T> wRN = x.getRightNephew();
      if (
          (x != null) &&
          (w != null) &&
          (t != null)
        ) {
        if (
            isBlack(x) &&
            isBlack(w) &&
            (
              ((wLN == null) || isBlack(wLN)) &&
              ((wRN == null) || isBlack(wRN))
            ) &&
            isBlack(t)
          ) {
          if (super.getDebug()) System.out.println("isCase2aRemove");
          r = true;
        }
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isCase2aRemove!\n" + e.getMessage());
    }
  }
  public void resolveCase2aRemove(NodeRn<T> v, NodeRn<T> x) {
    try {
      if (super.getDebug()) System.out.println("resolveCase2aRemove");
      /*
      Caso 2a: se x é negro, tem w(irmão de x) negro com filhos negros e t(pai de x) negro.
      faça o seguinte:
      • Pinte w(irmão de x) de rubro
      */
      NodeRn<T> w = x.getBrother();
      w.setRed();
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveCase2aRemove!\n" + e.getMessage());
    }
  }
  public Boolean isCase2bRemove(NodeRn<T> v, NodeRn<T> x, NodeRn<T> t, NodeRn<T> w) {
    try {
      /*
      Caso 2b: se x é negro, tem w(irmão de x) negro com filhos negros e t(pai de x) rubro.
      faça o seguinte:
      • Pinte w(irmão de x) de rubro e o t(pai de x) de negro
      */
      Boolean r = false;
      //NodeRn<T> w = x.getBrother();
      //NodeRn<T> t = x.getParent();
      NodeRn<T> wLN = x.getLeftNephew();
      NodeRn<T> wRN = x.getRightNephew();
      if (
          (x != null) &&
          (w != null) &&
          (t != null)
        ) {
          if (
            isBlack(x) &&
            isBlack(w) &&
            (
              ((wLN == null) || isBlack(wLN)) &&
              ((wRN == null) || isBlack(wRN))
            ) &&
            isRed(t)
          ) {
          if (super.getDebug()) System.out.println("isCase2bRemove");
          r = true;
        }
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isCase2bRemove!\n" + e.getMessage());
    }
  }
  public void resolveCase2bRemove(NodeRn<T> v, NodeRn<T> x, NodeRn<T> t, NodeRn<T> w) {
    try {
      if (super.getDebug()) System.out.println("resolveCase2bRemove");
      /*
      Caso 2b: se x é negro, tem w (irmão de x) negro com filhos negros e t(pai de w) é rubro.
      faça o seguinte:
      • Pinte w(irmão de x) de rubro e t(pai de x) de negro
      */
      //NodeRn<T> w = x.getBrother();
      //NodeRn<T> t = x.getParent();
      if (w != null) w.setRed();
      if (t != null) t.setBlack();
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveCase2bRemove!\n" + e.getMessage());
    }
  }
  public Boolean isCase3Remove(NodeRn<T> v, NodeRn<T> x, NodeRn<T> t, NodeRn<T> w) {
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
      NodeRn<T> wLN = x.getLeftNephew();
      NodeRn<T> wRN = x.getRightNephew();
      if (
          (x != null) &&
          (w != null) &&
          (t != null)
        ) {
          if (
            (
              (isBlack(x) && isLeftChild(x)) &&
              isBlack(w) &&
              (
                ((wLN == null) || isRed(wLN)) &&
                ((wRN == null) || isBlack(wRN))
              )
            ) || (
              (isBlack(x) && isRightChild(x)) &&
              isBlack(w) &&
              (
                ((wLN == null) || isBlack(wLN)) &&
                ((wRN == null) || isRed(wRN))
              )
            )
          ) {
        if (super.getDebug()) System.out.println("isCase3Remove");
        r = true;
        }
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isCase3Remove!\n" + e.getMessage());
    }
  }
  public void resolveCase3Remove(NodeRn<T> v, NodeRn<T> x) {
    try {
      if (super.getDebug()) System.out.println("resolveCase3Remove");
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
      NodeRn<T> w = x.getBrother();
      NodeRn<T> t = x.getParent();
      NodeRn<T> wLN = x.getLeftNephew();
      NodeRn<T> wRN = x.getRightNephew();
      if (isLeftChild(x)) {
        super.rightSimpleRotation(w);
        w.setRed();
        wLN.setBlack();
      } else if (isRightChild(x)) {
        super.leftSimpleRotation(w);
        w.setRed();
        wRN.setBlack();
      }
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveCase3Remove!\n" + e.getMessage());
    }
  }
  public Boolean isCase4Remove(NodeRn<T> v, NodeRn<T> x) {
    try {
      /*
      Caso 4: se x é negro, tem w(irmão de x) negro, tem t(pai de x) de qualquer cor (rubro ou negro), tem
      w(irmão de x) com filho esquerdo qualquer cor e com filho direito rubro.
      faça o seguinte:
      • Rotação simples a esquerda
      • Pinte o pai de negro
      • w igual a cor anterior do pai de x
      • Pinte o filho direito de w de negro
      */
      Boolean r = false;
      NodeRn<T> w = x.getBrother();
      NodeRn<T> t = x.getParent();
      NodeRn<T> wLN = x.getLeftNephew();
      NodeRn<T> wRN = x.getRightNephew();
      if (
          (x != null) &&
          (w != null) &&
          (t != null)
        ) {
          if (
            (
              (isBlack(x) && isLeftChild(x)) &&
              isBlack(w) &&
              ((wRN == null) || isRed(wRN))
            ) || (
              (isBlack(x) && isRightChild(x)) &&
              isBlack(w) &&
              ((wLN == null) || isRed(wLN))
            )
          ) {
        if (super.getDebug()) System.out.println("isCase4Remove");
        r = true;
        }
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isCase4Remove!\n" + e.getMessage());
    }
  }
  public void resolveCase4Remove(NodeRn<T> v, NodeRn<T> x) {
    try {
      if (super.getDebug()) System.out.println("resolveCase4Remove");
      /*
      Caso 4: se x é negro, tem w(irmão de x) negro, tem t(pai de x) de qualquer cor (rubro ou negro), tem
      w(irmão de x) com filho esquerdo qualquer cor e com filho direito rubro.
      Se x é filho esquerdo:
        • Rotação simples a esquerda
        • w recebe a cor de t(pai de x)
        • Pinte o t(pai de x) de negro        
        • Pinte o filho direito de w de negro
      Se x é filho direito:
        • Rotação simples a direita
        • w recebe a cor de t(pai de x)
        • Pinte o t(pai de x) de negro
        • Pinte o filho esquerdo de w de negro
      */
      NodeRn<T> w = x.getBrother();
      NodeRn<T> t = x.getParent();
      NodeRn<T> wLN = x.getLeftNephew();
      NodeRn<T> wRN = x.getRightNephew();
      if (isLeftChild(x)) {
        super.leftSimpleRotation(w);
        if (isRed(t)) w.setRed();
        else w.setBlack();
        t.setBlack();
        wRN.setBlack();
      } else if (isRightChild(x)) {
        super.rightSimpleRotation(w);
        if (isRed(t)) w.setRed();
        else w.setBlack();
        t.setBlack();
        wLN.setBlack();
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
        r = true;
      }
      return r;
    } catch (Exception e) {
      throw new RuntimeException("Erro durante isSituation4Remove!\n" + e.getMessage());
    }
  }
  public void resolveSituation4Remove(NodeRn<T> v, NodeRn<T> x) {
    try {
      if (super.getDebug()) System.out.println("resolveSituation4Remove");
      /*
      Situação 4 – v é rubro e x é negro.
    – Similar à situação 3. faça o seguinte:
    • Pinte x de rubro
    • Proceda como na situação 3
      */
      x.setRed();
    } catch (Exception e) {
      throw new RuntimeException("Erro durante resolveSituation4Remove!\n" + e.getMessage());
    }
  }
  public Boolean isRed(NodeRn<T> n){
    Boolean r = true;
    if (n == null) return false;
    else return n.getColor().equals(red);
  }
  public Boolean isBlack(NodeRn<T> n){
    Boolean r = true;
    if (n == null) return true;
    else return n.getColor().equals(black);
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
}