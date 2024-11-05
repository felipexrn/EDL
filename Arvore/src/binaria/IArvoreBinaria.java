package Arvore.src.binaria;
import java.util.Iterator;
import java.util.ArrayList;
public interface IArvoreBinaria<T extends Comparable<T>> {
	void setComparer(GenericComparator<T> c);
	GenericComparator<T> getComparer();
	Node<T> search(Node<T> n, T k);
	Node<T> include(T k);
	T remove(T k);
	Node<T> getRoot();
	void setRoot(Node<T> p);
	void inOrder(Node<T> n);
	void preOrder(Node<T> n);
	void postOrder(Node<T> n);
	int height(Node<T> n);
	int depth(Node<T> n);
	void show();
	Iterator<Node<T>> nodes();
	Iterator<T> elements();
	int size();
	boolean isEmpty();
}