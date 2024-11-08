package Arvore.src.binaria;
import java.util.Iterator;
public interface INode<T extends Comparable<T>, N extends INode<T, N>> {
	N getRightChild();
	N getLeftChild();
	N getParent();
	T getKey();
	Iterator<N> children();
	void setRightChild(N r);
	void setLeftChild(N l);
	void setParent(N p);
	void setKey(T k);
}