package Arvore.src.rn;
import Arvore.src.binaria.*;
public class NodeRn<T extends Comparable<T>> extends Node<T,NodeRn<T>> implements INode<T, NodeRn<T>>, INodeRn {
  private String color;
  private String red = "R";
  private String black = "B";
  public NodeRn(NodeRn<T> p, T k) {
    super(p, k);
    color = red;
  }
  public String getColor(){
    return this.color;
  }
  public void setRed() {
    this.color = red;
  }
  public void setBlack() {
    this.color = black;
  }
  public String getStrColor() {
    return this.color.equals(red) ? "Red" : "Black";
  }
  public Boolean isRed() {
    return this.color.equals(red);
  }
  public Boolean isBlack() {
    return this.color.equals(black);
  }
}