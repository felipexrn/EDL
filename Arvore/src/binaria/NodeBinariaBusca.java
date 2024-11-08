package Arvore.src.binaria;
import java.util.Iterator;
import java.util.prefs.NodeChangeEvent;
import java.util.ArrayList;
public class NodeBinariaBusca<T extends Comparable<T>> extends Node<T, NodeBinariaBusca<T>> implements INode<T,NodeBinariaBusca<T>> {
  public NodeBinariaBusca(NodeBinariaBusca<T> p, T k) {
    super(p, k);
  }
}