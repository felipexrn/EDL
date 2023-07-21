import java.util.Iterator;
public interface INode {
	Node getRightChild();
	Node getLeftChild();
	Node getParent();
	Object getKey();
  Iterator<Node> children();
	void setRightChild(Node r);
	void setLeftChild(Node l);
	void setParent(Node p);
	void setKey(Object k);
}