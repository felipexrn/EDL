public class Node {
  private Object Element;
  private Node Next;
  public Object GetElement() {
    return this.Element;
  }
  public void SetElement(Object o){
    this.Element = o;
  }
  public Node GetNext(){
    return this.Next;
  }
  public void SetNext(Node newNode){
    this.Next = newNode;
  }
}