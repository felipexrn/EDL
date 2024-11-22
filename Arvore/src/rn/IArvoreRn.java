package Arvore.src.rn;
import Arvore.src.binaria.*;
public interface IArvoreRn<T extends Comparable<T>> {
  NodeRn<T> rebalance(NodeRn<T> b, Boolean isInsert);
  NodeRn<T> rightSimpleRotation(NodeRn<T> b);
  NodeRn<T> leftSimpleRotation(NodeRn<T> b);
  NodeRn<T> rightDoubleRotation(NodeRn<T> b);
  NodeRn<T> leftDoubleRotation(NodeRn<T> b);
}