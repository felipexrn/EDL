package Arvore.src.rn;
import Arvore.src.binaria.*;
public interface IArvoreRn<T extends Comparable<T>> {
  NodeRn<T> rebalance(NodeRn<T> v, NodeRn<T> x, NodeRn<T> t, NodeRn<T> w, NodeRn<T> xLN, NodeRn<T> xRN, Boolean inInsert);
  NodeRn<T> rightSimpleRotation(NodeRn<T> b);
  NodeRn<T> leftSimpleRotation(NodeRn<T> b);
  NodeRn<T> rightDoubleRotation(NodeRn<T> b);
  NodeRn<T> leftDoubleRotation(NodeRn<T> b);
  int blackHeight(NodeRn<T> v);
}