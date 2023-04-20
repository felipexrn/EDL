public class List {
  private int Length = 0;
  private Node First = null;
  public void Push(Object o) {
    Node newNode = new Node();
    Node oldFirst = First;
    this.First = newNode;
    newNode.SetElement(o);
    newNode.SetNext(oldFirst);
    this.Length++;
  }
  public Object Top() {
    if (this.IsEmpty()) throw new ListEmptyException("Empty List");
    else return this.First.GetElement();
  }
  public Object Pop() {
    if (this.IsEmpty()) throw new ListEmptyException("Empty List");
    else {
      Object temp = this.First.GetElement();
      this.First = this.First.GetNext();
      this.Length--;
      return temp;
    }
  }
  public int Size() {
    return Length;
  }
  public boolean IsEmpty() {
    return Length == 0;
  }
  public String GetList() {
    String list = "";
    Node ActualNode = this.First;
    for (int i = 0; i < this.Length; i++) {
      list = ActualNode.GetElement().toString() + list;
      if (i < this.Length - 1) {
        list = ", " + list;   
      }
      ActualNode = ActualNode.GetNext();  
    }
    return list = "{" + list + "}";
  }
}