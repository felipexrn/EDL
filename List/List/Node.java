public class Node {
  private Object element;
  private Node next;
  private Node previous;
  public Node() {}
  public Object getElement() {
    return this.element;
  }
  public void setElement(Object o){
    this.element = o;
  }
  public Node getNext(){
    return this.next;
  }
  public Node getPrevious(){
    return this.previous;
  }
  public void setNext(Node newNode){
    this.next = newNode;
  }
  public void setPrevious(Node newNode){
    this.previous = newNode;
  }
}