package Arvore.scr.avl;
import java.util.Iterator;
import java.util.ArrayList;
public interface IAvl<T extends Comparable<T>> {
  // Iterator nodesAvl();
  // void inOrderAvl(NodeAvl n);
  // void show();
  public void RightSimpleRotation(Node<T> n1, Node<T> n2);
  public void LeftSimpleRotation(Node<T> n1, Node<T> n2);
  public void RightDoubleRotation(Node<T> n1, Node<T> n2);
  public void LeftDoubleRotation(Node<T> n1, Node<T> n2);
}