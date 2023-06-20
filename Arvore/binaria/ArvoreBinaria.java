import java.util.Iterator;
public class ArvoreBinaria implements IArvoreBinaria {
  private Node root;
  private int size;
  private Comparer<T> comparator;
  public ArvoreBinaria(Comparer<T> c) {
    setComparer(c);
  }
  public ArvoreBinaria(Object k) {
    root = new Node(null, k);
    size = 1;
  }
  public void setComparer(Comparer<T> c) {
    comparator = c;
  }
  public Comparer<T> getComparer() {
    return comparator;
  }
	public Node search(Node n, Object k) {
    setComparer
    if (k < n.getKey()) {
      if (n.hasLeft()) return search(n.getLeftChild(), k);
    }
    if (k > n.getKey()) {
      if (n.hasRight()) return search(n.getRightChild(), k);
    }
    if (k == n.getKey()) return n;
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
	public void setRoot(Node p) { // Como funciona isso?
    p.setLeftChild(root.getLeftChild());
    p.setRightChild(root.getRightChild());
    p.setParent(null);
    root = p;
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
  private void m() {
    System.out.println("m");
  }
	public void preOrder(Node n) {
    // visite(n)
    if (hasLeft(n)) {
      inOrder(n.getLeftChild());
    }
    if (hasRight(n)) {
      inOrder(n.getRightChild());
    }
  }
	public void postOrder(Node n) {
    if (hasLeft(n)) {
      inOrder(n.getLeftChild());
    }
    if (hasRight(n)) {
      inOrder(n.getRightChild());
    }
    //visite(n)
  }
	public int height(Node n) {
    if (isExternal(n)) return 0;
    else {
      int h = 0;
      Iterator c = children(n);
      while(c.hasNext()){
        h = Math.max(h, height((No)c.next()));
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
    Iterator i = new Iterator(); // teste
    return i;
  }
	public Iterator elements() {
    Iterator i = new Iterator(); // teste
    return i;
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