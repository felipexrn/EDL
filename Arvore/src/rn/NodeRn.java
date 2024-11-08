package Arvore.src.rn;
import Arvore.src.binaria.*;
public class NodeRn<T extends Comparable<T>> extends Node<T,NodeRn<T>> implements INode<T, NodeRn<T>> {
    public char cor;
    public NodeRn(NodeRn<T> p, T k) {
        super(p, k);
        cor = 'V';
      }
}