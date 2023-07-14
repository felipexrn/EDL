import java.util.Iterator;
import java.util.ArrayList;
public class ArvoreBinaria implements IArvoreBinaria {
  private Node root;
  private int size;
  private GenericComparator comparator;
  private ArrayList<Object> nodes;
  public ArvoreBinaria() {
     size = 0;
  }
  public ArvoreBinaria(GenericComparator c) {
    size = 0;
    setComparer(c);
  }
  public void setComparer(GenericComparator c) {
    comparator = c;
  }
  public GenericComparator getComparer() {
    return comparator;
  }
  public Node search(Node n, Object k) {
    Node m = new Node(null, k);
    if(comparator.compareTo(m, n) < 0) {
      if(isInternal(n)) {
        if (hasLeft(n)) return search(n.getLeftChild(), k);
        else return n;
      }  
    }
    if(comparator.compareTo(m, n) == 0) return n;
    if(comparator.compareTo(m, n) > 0) {
      if(isInternal(n)) {
        if (hasRight(n)) return search(n.getRightChild(), k);
        else return n;
      }  
    }
    return n;
  }
	public Node include(Object k) {
    if (comparator == null) throw new DoesNotExistComparatorException("Does Not Exist Comparator");
    if (root == null) {
      setRoot(new Node(null, k));
      return root;
    }
    Node n = search(root, k);  
    Node m = new Node(n, k);
    if(comparator.compareTo(m, n) < 0) n.setLeftChild(m);
    else n.setRightChild(m);
    size++;
    return m;
  }
	public Object remove(Object k) {
    if (comparator == null) throw new DoesNotExistComparatorException("Does Not Exist Comparator");
    Node n = search(root, k);
    Node m;
    if (n == root && size == 1) root = null;
    else if(size > 1) {
      if (n.getKey() == k) { 
        if (isExternal(n)) {
          if (n == n.getParent().getLeftChild()) {
            n.getParent().setLeftChild(null);
          }
          else {
            n.getParent().setRightChild(null); 
          }
        }
        else if (!hasRight(n)) {
          n.getLeftChild().setParent(n.getParent());
          n.getParent().setLeftChild(n.getLeftChild());
        }
        else {
          m = search(n.getRightChild(), k);
          if (isExternal(m)) {
            n.setKey(m.getKey());
            if (m == m.getParent().getLeftChild()) {
              m.getParent().setLeftChild(null);
            }
            else {
              m.getParent().setRightChild(null);
            }
          }
        }
      }
      else throw new DoesNotExistKeyException("Does Not Exist this Key");
    }
    size--;
    return k;
  }
	public Node getRoot() {
    return root;
  }
	public void setRoot(Node n) {
    if (size == 0) {
      root = n;
      size++;
    }
    else {
      n.setLeftChild(root.getLeftChild());
      n.setRightChild(root.getRightChild());
      n.setParent(null);
      if (root.getLeftChild() != null) root.getLeftChild().setParent(n);
      if (root.getRightChild() != null) root.getRightChild().setParent(n);
      root = n; 
    }
  }
	public void inOrder(Node n) {
    if (hasLeft(n)) {
      inOrder(n.getLeftChild());
    }
    nodes.add(n);
    if (hasRight(n)) {
      inOrder(n.getRightChild());
    }
  }
	public void preOrder(Node n) {
    nodes.add(n);
    if (hasLeft(n)) {
      preOrder(n.getLeftChild());
    }
    if (hasRight(n)) {
      preOrder(n.getRightChild());
    }
  }
	public void postOrder(Node n) {
    if (hasLeft(n)) {
      postOrder(n.getLeftChild());
    }
    if (hasRight(n)) {
      postOrder(n.getRightChild());
    }
    nodes.add(n);
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
    String s = "";
    Iterator i;
    Node n;
    for (int h = 0; h <= height(root); h++) {
      i = nodes();
      while(i.hasNext()) {
        n = (Node) i.next();
        if (depth(n) == h) s += n.getKey() + " ";
        else s += "  ";
      }
      s += "\n";
    }
    System.out.println(s);
  }
	public Iterator nodes() {
    nodes = new ArrayList<Object>();
    ArrayList<Object> b = new ArrayList<Object>();
    inOrder(root);
    nodes.forEach((obj) -> b.add((Node)obj));  
    return b.iterator();
  }
	public Iterator elements() {
    nodes = new ArrayList<Object>();
    ArrayList<Object> b = new ArrayList<Object>();
    inOrder(root);
    nodes.forEach((obj) -> b.add(((Node)obj).getKey()));  
    return b.iterator();
  }
  public String strNodes() {
    String s = "{";
    Iterator i = nodes();
    int l = size;
    while(i.hasNext()) {
      s += i.next();
      if (l > 1) {
        s += ", ";
        l--;
      }
    } 
    return s += "}";
  }
  public String strElements() {
    String s = "{";
    Iterator i = elements();
    int l = size;
    while(i.hasNext()) {
      s += i.next();
      if (l > 1) {
        s += ", ";
        l--;
      }
    } 
    return s += "}";
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