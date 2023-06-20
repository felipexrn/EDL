import java.util.Iterator;
import java.util.ArrayList;
import java.util.function.Consumer;
public class ArvoreBinaria implements IArvoreBinaria {
  private Node root;
  private int size;
  private GenericComparator<T> comparator;
  public ArvoreBinaria(Comparer<T> c) {
    setComparer(c);
  }
  public ArvoreBinaria(Object k, GenericComparator<T> c) {
    root = new Node(null, k);
    size = 1;
    setComparer(c);
  }
  public void setComparer(GenericComparator<T> c) {
    comparator = c;
  }
  public GenericComparator<T> getComparer() {
    return comparator;
  }
	public Node search(Node n, Object k) {
    int r = getComparer().compare(k, n.getKey());
    if (r < 0) {
      if (hasLeft(n)) return search(n.getLeftChild(), k);
    }
    if (r > 0) {
      if (hasRight(n)) return search(n.getRightChild(), k);
    }
    if (r == 0) return n;
    if (isExternal(n)) return null;
  }
	public Node include(Object k) {
    Node n = new Node(null, 0); // teste
    size++;
    return  n;
  }
	public Object remove(Object k) {
    size--;
    return k; // teste
  }
	public Node getRoot() {
    return root;
  }
	public void setRoot(Node n) { // Como funciona isso?
    n.setLeftChild(root.getLeftChild());
    n.setRightChild(root.getRightChild());
    n.setParent(null);
    root = n;
  }
	public void inOrder(Node n) {
    if (hasLeft(n)) {
      inOrder(n.getLeftChild());
    }
    //visite(n)
    if (hasRight(n)) {
      inOrder(n.getRightChild());
    }
  }
  private void m(Object o) {
    System.out.println(o);
  }
	public void preOrder(Node n, Consumer<T> action) {
    // visite(n)
    action.accept(n.getKey());
    if (hasLeft(n)) {
      preOrder(n.getLeftChild(), action);
    }
    if (hasRight(n)) {
      preOrder(n.getRightChild(), action);
    }
  }
	public void postOrder(Node n) {
    if (hasLeft(n)) {
      postOrder(n.getLeftChild());
    }
    if (hasRight(n)) {
      postOrder(n.getRightChild());
    }
    //visite(n)
  }
	public int height(Node n) {
    if (isExternal(n)) return 0;
    else {
      int h = 0;
      Iterator c = n.children();
      while(c.hasNext()){
        h = Math.max(h, height((Node)c.next()));
      }
      return 1 + h;
    }
  }
	public int depth(Node n) {
    if (n == root) return 0;
		else return 1 + depth(n.getParent());
  }
	public void show() {
    
  }
	public Iterator nodes() {
    ArrayList<Node> a = new ArrayList<Node>();// teste
    
    return a.iterator();
  }
	public Iterator elements() {
    ArrayList<Object> a = new ArrayList<Object>(); // teste
    
    return a.iterator();
  }
	public int size() {
    return size;
  }
  public boolean isEmpty() {
    return root == null;
  }
  public boolean hasLeft(Node n) {
    return n.getLeftChild() != null;
  }
  public boolean hasRight(Node n) {
    return n.getRightChild() != null;
  }
  public boolean isInternal(Node n) {
    return hasLeft(n) || hasRight(n);
  } 
  public boolean isExternal(Node n) {
    return !isInternal(n);
  }
}