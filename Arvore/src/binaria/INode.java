package Arvore.src.binaria;
import java.util.Iterator;
public interface INode<T> {
	Node<T> getRightChild();
	Node<T> getLeftChild();
	Node<T> getParent();
	T getKey();
  Iterator<Node<T>> children();
	void setRightChild(Node<T> r);
	void setLeftChild(Node<T> l);
	void setParent(Node<T> p);
	void setKey(T k);
}