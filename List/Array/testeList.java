public class testeList {
  public static void main(String[] args) {
    List l = new List(1);
    l.insertLast(1);
    l.insertLast(2);
    l.insertLast(3);
    l.insertLast(4);
    System.out.println(l.toString());
    System.out.println(l.strStruct());
    //l.insertLast(3);
    //l.insertBefore(l.findElement(3),2);
    //l.insertAfter(l.findElement(3),4);
    //System.out.println(l.toString());
    //System.out.println(l.strStruct());
  }
}
