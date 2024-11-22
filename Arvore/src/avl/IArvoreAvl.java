package Arvore.src.avl;
import Arvore.src.binaria.*;
public interface IArvoreAvl<T extends Comparable<T>> {
  NodeAvl<T> rebalance(NodeAvl<T> b, Boolean isFromRight, Boolean isInsert);
  NodeAvl<T> rightSimpleRotation(NodeAvl<T> b);
  NodeAvl<T> leftSimpleRotation(NodeAvl<T> b);
  NodeAvl<T> rightDoubleRotation(NodeAvl<T> b);
  NodeAvl<T> leftDoubleRotation(NodeAvl<T> b);
  void recalculateFB(NodeAvl<T> a, NodeAvl<T> b, Boolean isRightRotation);
}