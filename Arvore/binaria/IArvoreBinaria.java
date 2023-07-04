import java.util.Iterator;
import java.util.function.Consumer;
public interface IArvoreBinaria {

	void setComparer(GenericComparator c);

	GenericComparator getComparer();

//	Node search(Node n, Object k);

//	Node include(Object k);

//	Object remove(Object k);

	Node getRoot(); // ok

	void setRoot(Node p); // ok

//	void inOrder(Node n, Consumer<T> action);

//	void preOrder(Node n, Consumer<T> action);

//	void postOrder(Node n, Consumer<T> action);

	int height(Node n); // ok

	int depth(Node n); // ok

//	void show();

//	Iterator nodes();

//	Iterator elements();

	int size();

	boolean isEmpty();

}