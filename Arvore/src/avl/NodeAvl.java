package Arvore.src.avl;
import Arvore.src.binaria.Node;
import Arvore.src.binaria.INode;
public class NodeAvl<T> extends Node<T> implements INode<T>, INodeAvl<T> {
  protected int FB;
  public NodeAvl(Node<T> p, T k) {
    super(p, k);
    FB = 0;
  }
  public int getFB() {
    return FB;
  }
  public void upFB() {
    FB++;
  }
  public void downFB() {
    FB--;
  }
  public String getStrFB() {
    return String.format("[%s]",FB);
  }
}