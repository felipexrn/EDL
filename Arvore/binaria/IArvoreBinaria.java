import java.util.Iterator;

public interface IArvoreBinaria {

	void setComparer(Comparer c);

	Comparer getComparer();

	Node search(Node n, Object k);

	Node include(Object k);

	Object remove(Object k);

	Node getRoot();

	void setRoot(Node p);

	void inOrder(Node n);

	void preOrder(Node n);

	void postOrder(Node n);

	int height(Node n);

	int depth(Node n);

	void show();

	Iterator nodes();

	Iterator elements();

	int size();

	boolean isEmpty();

}