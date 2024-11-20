package Arvore.src.rn;
import Arvore.src.binaria.*;
public class NodeRn<T extends Comparable<T>> extends Node<T,NodeRn<T>> implements INode<T, NodeRn<T>>, INodeRn {
  public String color;
  public NodeRn(NodeRn<T> p, T k) {
    super(p, k);
    color = "V";
  }
  public String getColor(){
    return this.color;
  }
  public void setColor(String c) {
    if ((c != "R") && (c != "B")) throw new RuntimeException("Cor inválida! Utilize 'R' ou 'B'.");
    this.color = c;
  }
  public String getStrColor() {
    return this.color == "R" ? "Red" : "Black";
  }
}