import java.util.Iterator;
import java.util.ArrayList;
public class Node implements INode {
  private Object key;
  private Node parent;
  private Node rightChild;
  private Node leftChild;
  public Node(Node p, Object k) {
    parent = p;
    key = k;
  }
  public Node getRightChild() {
    return rightChild;
  }
  public Node getLeftChild() {
    return leftChild;
  }
  public Node getParent() {
    return parent;
  }
  public Object getKey() {
    return key;
  }
  public void setRightChild(Node n) {
    rightChild = n;
  }
  public void setLeftChild(Node n) {
    leftChild = n;
  }
  public void setParent(Node p) {
    parent = p;
  }
  public void setKey(Object k) {
    key = k;
  }
  // estes métodos têm alguma serventia?
  public int childrenNumber() {
    int n = 0;
    if (rightChild != null) n++;
    if (leftChild != null) n++;
    return n;
  }
  public Iterator<Node> children() {
    ArrayList<Node> c = new ArrayList<Node>();
    if (rightChild != null) c.add(rightChild);
    if (leftChild != null) c.add(leftChild);
    return c.iterator();
  }
}