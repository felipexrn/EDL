package Arvore.src.avl;
import Arvore.src.binaria.Node;
import Arvore.src.binaria.INode;
public class NodeAvl<T extends Comparable<T>> extends Node<T, NodeAvl<T>> implements INode<T,NodeAvl<T>>, INodeAvl {
  protected int FB;
  public NodeAvl(NodeAvl<T> p, T k) {
    super(p, k);
    FB = 0;
  }
  public void upFB() {
    FB++;
  }
  public void downFB() {
    FB--;
  }
  public int getFB() {
    return FB;
  }
  public void setFB(int newFB) {
    this.FB = newFB;
  }
  public String getStrFB() {
    return String.format("%s",FB);
  }
}