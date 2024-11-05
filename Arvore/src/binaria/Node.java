package Arvore.src.binaria;
import java.util.Iterator;
import java.util.ArrayList;
public class Node<T> implements INode<T> {
  private T key;
  private Node<T> parent;
  private Node<T> rightChild;
  private Node<T> leftChild;
  public Node(Node<T> p, T k) {
    parent = p;
    key = k;
  }
  public Node<T> getRightChild() {
    return rightChild;
  }
  public Node<T> getLeftChild() {
    return leftChild;
  }
  public Node<T> getParent() {
    return parent;
  }
  public T getKey() {
    return key;
  }
  public void setRightChild(Node<T> n) {
    rightChild = n;
  }
  public void setLeftChild(Node<T> n) {
    leftChild = n;
  }
  public void setParent(Node<T> p) {
    parent = p;
  }
  public void setKey(T k) {
    key = k;
  }
  // estes métodos têm alguma serventia?
  public int childrenNumber() {
    int n = 0;
    if (rightChild != null) n++;
    if (leftChild != null) n++;
    return n;
  }
  public Iterator<Node<T>> children() {
    ArrayList<Node<T>> c = new ArrayList<>();
    if (rightChild != null) c.add(rightChild);
    if (leftChild != null) c.add(leftChild);
    return c.iterator();
  }
}