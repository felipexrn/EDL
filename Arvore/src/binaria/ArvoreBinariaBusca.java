package Arvore.src.binaria;

public class ArvoreBinariaBusca<T extends Comparable<T>, N extends NodeBinariaBusca<T>> extends ArvoreBinariaAbstrata<T,NodeBinariaBusca<T>> {
    
    public ArvoreBinariaBusca(int type) {
        super(type);
    }

    public ArvoreBinariaBusca(GenericComparator<T,NodeBinariaBusca<T>> c) {
        super(c);
    }

    protected NodeBinariaBusca<T> createNode(NodeBinariaBusca<T> p, T k) {
        if ((p instanceof NodeBinariaBusca) || (p == null)) {
            return new NodeBinariaBusca<T>(p, k);
        } else {
            throw new IllegalArgumentException("Tipo incompatível de nó: " + p.getClass().getName());
        }
    }
}
