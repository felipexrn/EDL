public class testeList {
  public static void main(String[] args) {
    List l = new List();
    l.insertFirst(1);
    l.insertFirst(2);
    l.insertFirst(3);
    l.insertFirst(4);
    System.out.println(l.toString());
    System.out.println(l.strStruct());
    //l.insertFirst(3);
    //l.insertBefore(l.findElement(3),2);
    //l.insertAfter(l.findElement(3),4);
    //System.out.println(l.toString());
    //System.out.println(l.strStruct());
  }
}
