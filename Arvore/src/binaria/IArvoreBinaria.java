package Arvore.src.binaria;
import java.util.Iterator;
import java.util.ArrayList;
public interface IArvoreBinaria<T extends Comparable<T>, N extends Node<T,N>> {
	void setComparer(GenericComparator<T,N> c);
	GenericComparator<T,N> getComparer();
	N search(N n, T k);
	N include(T k);
	T remove(T k);
	N getRoot();
	void setRoot(N p);
	void inOrder(N n);
	void preOrder(N n);
	void postOrder(N n);
	int height(N n);
	int depth(N n);
	void show();
	Iterator<N> nodes();
	Iterator<T> elements();
	int size();
	boolean isEmpty();
}