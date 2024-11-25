package Arvore.src.avl;
import Arvore.src.binaria.*;
public abstract class ArvoreBalanceadaAbstrata<T extends Comparable<T>, N extends Node<T,N>> extends ArvoreBinariaAbstrata<T, N> {
    public ArvoreBalanceadaAbstrata(int type){
        super(type);
    }
    public ArvoreBalanceadaAbstrata(GenericComparator c){
        super(c);
    }
    public N rightSimpleRotation(N b) {        
        if (super.getDebug()) System.out.println("rightSimpleRotationAbstract");     
        // troca ligações entre a e b
        N a = b.getLeftChild();
        b.setLeftChild(a.getRightChild());
        a.setRightChild(b);
        a.setParent(b.getParent());
        b.setParent(a);
        // troca ligações do pai de b e do filho de a
        if (b.getLeftChild() != null) b.getLeftChild().setParent(b);
        if (a.getParent() != null) {
            if (a.getParent().getLeftChild() == b)
                a.getParent().setLeftChild(a);
            else 
                a.getParent().setRightChild(a);
        }
        if (super.getRoot() == b) super.setRoot(a);
        return a;
    }
    public N leftSimpleRotation(N b) {             
        if (super.getDebug()) System.out.println("leftSimpleRotationAbstract");        
        // troca ligações entre a e b
        N a = b.getRightChild();
        b.setRightChild(a.getLeftChild());
        a.setLeftChild(b);
        a.setParent(b.getParent());
        b.setParent(a);
        // troca ligações do pai de b e do filho de a
        if (b.getRightChild() != null) b.getRightChild().setParent(b);
        if (a.getParent() != null) {
            if (a.getParent().getLeftChild() == b)
                a.getParent().setLeftChild(a);
            else 
                a.getParent().setRightChild(a);
        }
        if (super.getRoot() == b) super.setRoot(a);
        return a;
    }
    public N rightDoubleRotation(N b) {
        if (super.getDebug()) System.out.println("rightDoubleRotationAbsrtact"); 
        N a = this.leftSimpleRotation(b.getLeftChild());
        a = this.rightSimpleRotation(a.getParent());
        return a;
    }
    public N leftDoubleRotation(N b) {
        if (super.getDebug()) System.out.println("leftDoubleRotationAbsrtact"); 
        N a = this.rightSimpleRotation(b.getRightChild());
        a = this.leftSimpleRotation(a.getParent());
        return a;
    }
}