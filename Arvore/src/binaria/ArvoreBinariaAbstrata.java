package Arvore.src.binaria;
import java.util.Iterator;
import java.util.ArrayList;
public abstract class ArvoreBinariaAbstrata<T extends Comparable<T>, N extends Node<T,N>> implements IArvoreBinaria<T,N> {
  private N root;
  private int size;
  private GenericComparator<T,N> comparator;
  private ArrayList<N> nodes;
  public ArvoreBinariaAbstrata(int type) {
     this.size = 0;
     this.nodes = new ArrayList<>();
     this.comparator = createComparator(type); // Chama o método para criar o comparador    
  }
  public ArvoreBinariaAbstrata(GenericComparator<T,N> c) {
    this.size = 0;
    this.nodes = new ArrayList<>();
    setComparer(c);
  }
  // Método que cria o comparador adequado
  private GenericComparator<T,N> createComparator(int type) {
    // Instanciando um comparador padrão para os tipos suportados    
    switch (type) {
      case 0: return new GenericComparator<>(0); // 0 para Integer
      case 1: return new GenericComparator<>(1); // 1 para String
      case 2: return new GenericComparator<>(2); // 2 para Double
      default: throw new IllegalArgumentException("Tipo não suportado!");
    }
  }
  public void setComparer(GenericComparator<T,N> c) {
    this.comparator = c;
  }
  public GenericComparator<T,N> getComparer() {
    return this.comparator;
  }
  protected abstract N createNode(N p, T k);
  public N search(N n, T k) {
    N m = createNode(null, k);
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
	public N include(T k) {   
    // verifica se foi configurado um comparador
    if (comparator == null) throw new DoesNotExistComparatorException("Does Not Exist Comparator");
    // se a árvore está vazia insere k em root
    if (root == null) {
      // Cria o node usando padrão factory
      setRoot(createNode(null, k));
      return root;
    }
    // busca o node com chave maior ou igual a k a partir do raiz
    N n = search(root, k);  
    N m = createNode(n, k);
    // se m é menor que n adiciona k à esquerda
    if(comparator.compareTo(m, n) < 0) n.setLeftChild(m);
    // se m é menor que n adiciona k à direita
    else if(comparator.compareTo(m, n) > 0) n.setRightChild(m);
    // se não atualiza chave de n para k e m recebe n e compensa tamanho da árvore 
    else {
      n.setKey(k);
      m = n; 
      size--;
    }
    size++;
    // retorno padrão
    return m;
  }
	public T remove(T k) {
    // verifica se foi configurado um comparador
    if (comparator == null) throw new DoesNotExistComparatorException("Does Not Exist Comparator");
    // busca o node com chave maior ou igual a k a partir do raiz
    N n = search(root, k);
    N m;
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
        // se não tem filho direito (tem somente esquerdo)
        else if (!hasRight(n)) {
          // o filho esquerdo de n recebe o avo como pai
          n.getLeftChild().setParent(n.getParent());
          
          if (n != root) { 

            // n é filho esquerdo do pai
            if (n == n.getParent().getLeftChild())
              n.getParent().setLeftChild(n.getLeftChild());
            // n é filho direito do pai
            else
              n.getParent().setRightChild(n.getLeftChild());
          } else {
            root =  n.getLeftChild();
          }
        }

        // se tem filo direito ou dois filhos
        if (hasRight(n)) {
        
          // busca à direita o nó com menor chave maior ou igual a k
          m = search(n.getRightChild(), k);
          n.setKey(m.getKey());

          // se externo
          if (isExternal(m)) {
            // filho esquerdo
            if (m == m.getParent().getLeftChild()) {
              m.getParent().setLeftChild(null);
            }
            // filho direito
            else {
              m.getParent().setRightChild(null); 
            }
          }
          // se m é interno  
          else{                    
            // m tem filho direito
            if (hasRight(m)) {
              // o filho direito de m recebe o avo como pai
              m.getRightChild().setParent(m.getParent());  
                            
              // m é filho esquerdo do pai
              if (m == m.getParent().getLeftChild())
                m.getParent().setLeftChild(m.getRightChild());
              else
                m.getParent().setRightChild(m.getRightChild());
            }
            // m tem filho esquerdo
            else {
              // o filho esquerdo de m recebe o avo como pai
              m.getLeftChild().setParent(m.getParent());

              // m é filho direito do pai
              if (m == m.getParent().getRightChild())
                m.getParent().setRightChild(m.getLeftChild());
              else
                m.getParent().setLeftChild(m.getLeftChild());                      
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
	public N getRoot() {
    return root;
  }
  // esse método pode quebrar a árvore!
	public void setRoot(N n) {
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
	public void inOrder(N n) {
    if (hasLeft(n)) {
      inOrder(n.getLeftChild());
    }
    nodes.add(n);
    if (hasRight(n)) {
      inOrder(n.getRightChild());
    }
  }
  // não utilizado
	public void preOrder(N n) {
    nodes.add(n);
    if (hasLeft(n)) {
      preOrder(n.getLeftChild());
    }
    if (hasRight(n)) {
      preOrder(n.getRightChild());
    }
  }
  // não uitlizado
	public void postOrder(N n) {
    if (hasLeft(n)) {
      postOrder(n.getLeftChild());
    }
    if (hasRight(n)) {
      postOrder(n.getRightChild());
    }
    nodes.add(n);
  }
	public int height(N n) {
    if (isExternal(n)) return 0;
    else {
      int h = 0;
      Iterator c = n.children();
      while(c.hasNext()){
        h = Math.max(h, height((N)c.next()));
      }
      return 1 + h;
    }
  }
	public int depth(N n) {
    if (n == root) return 0;
		else return 1 + depth(n.getParent());
  }
	public void show() {
    String s = "";
    String l = "";
    Iterator i;
    N n;
    if (size != 0){
      int treeHeight = height(root);
      for (int h = 0; h <= treeHeight; h++) {
        i = nodes();
        while(i.hasNext()) {
          n = (N) i.next();
          if (depth(n) == h) {
            s += n.getKey() + "";
            if (hasLeft(n)) l += "/"; else l += " ";
            if (hasRight(n)) l += "\\"; else l += " ";
          }
          else {
            s += "  ";
            l += "  ";
          }
        }
        if (l.indexOf("\\") + l.indexOf("/") != -2) 
          l = "\n" + l + "\n";
        s += l;
        l = "";
      }
    }
    else {
      s = "";
    }
    System.out.println(s + "\n");
  }
	public Iterator<N> nodes() {
    nodes = new ArrayList<N>();
    ArrayList<N> b = new ArrayList<>();
    inOrder(root);
    nodes.forEach(b::add);  
    return b.iterator();
  }
	public Iterator<T> elements() {
    nodes = new ArrayList<N>();
    ArrayList<T> b = new ArrayList<>();
    inOrder(root);
    nodes.forEach(node -> b.add(node.getKey())); 
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
      s += depth((N) i.next());
      if (l > 1) {
        s += ", ";
        l--;
      }
    } 
    return s += "}";
  }
  public void status() {
    String s = "";
    if (!isEmpty()) {
      s += "Height: " + height(root) + "\n";
      s += "Size: " + size() + "\n";
      s += "Nodes: " + strNodes() + "\n";
      s += "Keys: " + strElements() + "\n";
      s += "Depths: " + strDepths();
    }
    else
      s = "Árvore vazia";
    System.out.println(s);
  }
	public int size() {
    return size;
  }
  public boolean isEmpty() {
    return root == null;
  }
  public boolean hasLeft(N n) {
    return n.getLeftChild() != null;
  }
  public boolean hasRight(N n) {
    return n.getRightChild() != null;
  }
  public boolean isInternal(N n) {
    return hasLeft(n) || hasRight(n);
  } 
  public boolean isExternal(N n) {
    return !isInternal(n);
  }
}