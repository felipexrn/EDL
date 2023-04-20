public interface IPilhaVector {

	Object top() throws VectorEmptyException;

	void push(Object o);

	Object pop() throws VectorEmptyException;

	int size();

  String list();

}