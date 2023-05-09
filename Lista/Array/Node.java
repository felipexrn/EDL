public class Node {
  private Object element;
  private int next;
  private int previous;
  public Node() {}
  public Object getElement() {
    return this.element;
  }
  public void setElement(Object o){
    this.element = o;
  }
  public int getNext(){
    return this.next;
  }
  public int getPrevious(){
    return this.previous;
  }
  public void setNext(int newNode){
    this.next = newNode;
  }
  public void setPrevious(int newNode){
    this.previous = newNode;
  }
}