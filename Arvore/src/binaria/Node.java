package Arvore.src.binaria;
import java.util.Iterator;
import java.util.ArrayList;
public abstract class Node<T extends Comparable<T>, N extends Node<T, N>> implements INode<T, N> {
  private T key;
  private N parent;
  private N rightChild;
  private N leftChild;
  private GenericComparator<T,N> comparator;
  public Node(N p, T k) {
    parent = p;
    key = k;
    this.comparator = createComparator(k); // Chama o método para criar o comparador 
  }
  private GenericComparator<T,N> createComparator(T type) {
    // Instanciando um comparador padrão para os tipos suportados    
    if (type instanceof Integer) 
      return new GenericComparator<>(0); // 0 para Integer
    else if (type instanceof String)
      return new GenericComparator<>(1); // 1 para String
    else if (type instanceof Double)
      return new GenericComparator<>(2); // 2 para Double
    else throw new IllegalArgumentException("Tipo não suportado!");
  }
  public void setComparer(GenericComparator<T,N> c) {
    this.comparator = c;
  }
  public GenericComparator<T,N> getComparer() {
    return this.comparator;
  }
  public N getRightChild() {
    return rightChild;
  }
  public N getLeftChild() {
    return leftChild;
  }
  public N getParent() {
    return parent;
  }
  public T getKey() {
    return key;
  }
  public void setRightChild(N n) {
    rightChild = n;
  }
  public void setLeftChild(N n) {
    leftChild = n;
  }
  public void setParent(N p) {
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
  public Iterator<N> children() {
    ArrayList<N> c = new ArrayList<>();
    if (rightChild != null) c.add(rightChild);
    if (leftChild != null) c.add(leftChild);
    return c.iterator();
  }
  public void showLinks() {
    try {
      System.out.println("ligações do Node: " + this.toString());
      System.out.println("   Key: " + key);    
      System.out.println("   parent: " + (parent != null ? parent.getKey() : "null"));
      System.out.println("   leftChild: " + (leftChild != null ? leftChild.getKey() : "null"));
      System.out.println("   rightChild: " + (rightChild != null ? rightChild.getKey() : "null"));
    } catch (Exception e) {
      throw new RuntimeException("Erro ao mostrar ligações do Node: " + this.toString() + "\n" + e.getMessage());
    }
  }
}