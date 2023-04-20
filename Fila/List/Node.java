public class Node {
  private Object element;
  private Node next;
  public Object getElement() {
    return this.element;
  }
  public void setElement(Object o){
    this.element = o;
  }
  public Node getNext(){
    return this.next;
  }
  public void setNext(Node newNode){
    this.next = newNode;
  }
}