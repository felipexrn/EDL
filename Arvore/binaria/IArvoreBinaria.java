import java.util.Iterator;
import java.util.function.Consumer;
public interface IArvoreBinaria {

	void setComparer(GenericComparator<T> c);

	GenericComparator<T> getComparer();

	Node search(Node n, Object k);

	Node include(Object k);

	Object remove(Object k);

	Node getRoot();

	void setRoot(Node p);

	void inOrder(Node n);

	void preOrder(Node n, Consumer<T> action);

	void postOrder(Node n);

	int height(Node n);

	int depth(Node n);

	void show();

	Iterator nodes();

	Iterator elements();

	int size();

	boolean isEmpty();

}