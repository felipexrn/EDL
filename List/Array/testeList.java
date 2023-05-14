public class testeList {
  public static void main(String[] args) {
    List l = new List();
    for (int i = 0; i < 4; i++) {
      l.insertFirst(i);
    }
    System.out.println(l.toString());
    System.out.println(l.strStruct());
    for (int i = 0; i < 4; i++) {
      l.insertLast(i);
    }
    System.out.println(l.toString());
    System.out.println(l.strStruct());
    
    //l.insertBefore(l.findElement(3),2);
    //l.insertAfter(l.findElement(3),4);
    
  }
}
