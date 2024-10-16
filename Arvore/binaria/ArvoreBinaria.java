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
    // Se m menor que n busque na esquerda
    if(comparator.compareTo(m, n) < 0) {
      if(isInternal(n)) {
        if (hasLeft(n)) return search(n.getLeftChild(), k);
        else return n;
      }  
    }
    // Se m = n retorna n
    if(comparator.compareTo(m, n) == 0) return n;
    // Se m > n busque na direita
    if(comparator.compareTo(m, n) > 0) {
      if(isInternal(n)) {
        if (hasRight(n)) return search(n.getRightChild(), k);
        else return n;
      }  
    }
    // retorno padrão
    return n;
  }
	public Node include(Object k) {
    // verifica se foi configurado um comparador
    if (comparator == null) throw new DoesNotExistComparatorException("Does Not Exist Comparator");
    // se a árvore está vazia insere k em root
    if (root == null) {
      setRoot(new Node(null, k));
      return root;
    }
    // busca o node com chave maior ou igual a k a partir do raiz
    Node n = search(root, k);  
    Node m = new Node(n, k);
    // se m é menor que n adiciona k à esquerda, caso contrário insere k à direita
    if(comparator.compareTo(m, n) < 0) n.setLeftChild(m);
    else n.setRightChild(m);
    size++;
    // retorno padrão
    return m;
  }
	public Object remove(Object k) {
    // verifica se foi configurado um comparador
    if (comparator == null) throw new DoesNotExistComparatorException("Does Not Exist Comparator");
    // busca o node com chave maior ou igual a k a partir do raiz
    Node n = search(root, k);
    Node m;
    // se o node é o raiz e só e existe ele na àrvore ele é removido
    if (n == root && size == 1) root = null;
    // se a árvore contém mais de um node 
    else if(size > 1) {
      // se a chave k existe na árvore
      if (n.getKey() == k) { 
        // se externo
        if (isExternal(n)) {
          // filho esquerdo
          if (n == n.getParent().getLeftChild()) {
            n.getParent().setLeftChild(null);
          }
          // filho direito
          else {
            n.getParent().setRightChild(null); 
          }
        }
        // se interno
        // se não tem filho direito
        else if (!hasRight(n)) {
          // o avô recebe o neto esquerdo como filho esquerdo
          n.getLeftChild().setParent(n.getParent());
          n.getParent().setLeftChild(n.getLeftChild());
        }
        // se não tem filho esquerdo
        else if (!hasLeft(n)) {
          // o avô recebe o neto direito como filho direito
          n.getRightChild().setParent(n.getParent());
          n.getParent().setRightChild(n.getRightChild());
        }
        // se tem dois filhos
        else {
          // busca à direita o nó com menor chave maior ou igual a k
          m = search(n.getRightChild(), k);
          // se externo
          if (isExternal(m)) {
            n.setKey(m.getKey());
            if (m == m.getParent().getLeftChild()) {
              m.getParent().setLeftChild(null);
            }
            else {
              m.getParent().setRightChild(null);
            }
          }
          // se interno
          else {
            n.setKey(m.getKey());
            // tem filho direito
            if (hasRight(m)) {
              m.getRightChild().setParent(m.getParent());
              m.getParent().setLeftChild(m.getRightChild());
            }
          }
        }
      }
      // se não existe a chave k na árvore
      else throw new DoesNotExistKeyException("Does Not Exist this Key");
    }
    size--;
    // retorno padrão
    return k;
  }
	public Node getRoot() {
    return root;
  }
  // esse método pode quebrar a árvore!
	public void setRoot(Node n) {
    // se a árvore está vazia
    if (size == 0) {
      root = n;
      size++;
    }
    // se a árvore contém root 
    else {
      // n recebe filhos e pai do root
      n.setLeftChild(root.getLeftChild());
      n.setRightChild(root.getRightChild());
      n.setParent(null);
      // configura n como pai dos filhos de root
      if (root.getLeftChild() != null) root.getLeftChild().setParent(n);
      if (root.getRightChild() != null) root.getRightChild().setParent(n);
      // por fim root recebe n
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
  // não utilizado
	public void preOrder(Node n) {
    nodes.add(n);
    if (hasLeft(n)) {
      preOrder(n.getLeftChild());
    }
    if (hasRight(n)) {
      preOrder(n.getRightChild());
    }
  }
  // não uitlizado
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
    String l = "";
    Iterator i;
    Node n;
    int treeHeight = height(root);
    for (int h = 0; h <= treeHeight; h++) {
      i = nodes();
      while(i.hasNext()) {
        n = (Node) i.next();
        if (depth(n) == h) {
          s += n.getKey() + " ";
          if (hasLeft(n)) l += "/"; else l += " ";
          if (hasRight(n)) l += "\\"; else l += " ";
        }
        else {
          s += "  ";
          l += "  ";
        }
      }
      s += "\n";
      s += l;
      l = "";
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
  public String strDepths() {
    String s = "{";
    Iterator i = nodes();
    int l = size;
    while(i.hasNext()) {
      s += depth((Node) i.next());
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