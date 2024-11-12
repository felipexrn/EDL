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
        // troca ligações entre a e b
        N a = b.getLeftChild();
        b.setLeftChild(a.getRightChild());
        a.setRightChild(b);
        a.setParent(b.getParent());
        b.setParent(a);
        // troca ligações do pai de b e do filho de a
        if (b.getRightChild() != null) b.getLeftChild().setParent(b);
        if (a.getParent() != null) {
            if (a.getParent().getRightChild() == a)
                a.getParent().setRightChild(a);
            else 
                a.getParent().setLeftChild(a);
        } 
        if (super.getRoot() == b) super.setRoot(a);
        if (super.getDebug()) System.out.println("rightSimpleRotationAbstract");        
        return a;
    }
    public N leftSimpleRotation(N b) {             
        // troca ligações entre a e b
        N a = b.getRightChild();
        b.setRightChild(a.getLeftChild());
        a.setLeftChild(b);
        a.setParent(b.getParent());
        b.setParent(a);
        // troca ligações do pai de b e do filho de a
        if (b.getRightChild() != null) b.getRightChild().setParent(b);
        if (a.getParent() != null) {
            if (a.getParent().getLeftChild() == a)
                a.getParent().setLeftChild(a);
            else 
                a.getParent().setRightChild(a);
        } 
        if (super.getRoot() == b) super.setRoot(a);
        if (super.getDebug()) System.out.println("leftSimpleRotationAbstract");
        return a;
    }
    public N rightDoubleRotation(N b) {
        N a = leftSimpleRotation(b.getLeftChild());
        b = rightSimpleRotation(a.getParent());
        return b;
    }
    public N leftDoubleRotation(N b) {
        N a = rightSimpleRotation(b.getRightChild());
        b = leftSimpleRotation(a.getParent());
        return b;
    }
}