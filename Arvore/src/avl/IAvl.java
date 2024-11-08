package Arvore.src.avl;
import Arvore.src.binaria.*;
public interface IAvl<T extends Comparable<T>> {
  void rebalance();
  void rightSimpleRotation(Node<T> n1, Node<T> n2);
  void leftSimpleRotation(Node<T> n1, Node<T> n2);
  void rightDoubleRotation(Node<T> n1, Node<T> n2);
  void leftDoubleRotation(Node<T> n1, Node<T> n2);
}