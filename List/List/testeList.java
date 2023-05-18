public class testeList {
  public static void estado(List lista) {
    System.out.println("Estado da List");
    System.out.println(lista.toString());
    System.out.println("size " + lista.size());
  }
  public static void main(String[] args) {
    int in1 = 4, in2 = 10, in3 = 7, in4 = -1, in5 = -2, in6 = 5, in7 = 3, in8 = 9, in9 = -3, in10 = -5, in11 = -3, in12 = -4;
    List l = new List();
    System.out.println("\ninserindo " + in1 + " elementos no início");
    for (int i = 0; i < in1; i++) {
      l.insertFirst(i);
    }
    estado(l);

    System.out.println("\ninserindo " + in2 + " elementos no fim");
    for (int i = 0; i < in2; i++) {
      l.insertLast(i);
    }
    estado(l);
    
    System.out.println("\ninserindo elemento " + in4 + " antes do elemento " + in3 + " na List");
    l.insertBefore(l.findElement(in3),in4);
    estado(l);

    System.out.println("\ninserindo elemento " + in5 + " depois do elemento " + in3 + " na List");
    l.insertAfter(l.findElement(in3),in5);
    estado(l);

    System.out.println("\ninserindo elemento " + in4 + " antes do elemento " + in7 + " na List");
    l.insertBefore(l.findElement(in7),in4);
    estado(l);

    System.out.println("\ninserindo elemento " + in9 + " depois do elemento " + in8 + " na List");
    l.insertAfter(l.findElement(in8),in9);
    estado(l);

    System.out.println("\nremovendo elemento " + in6 + " da List");
    l.remove(l.findElement(in6));
    estado(l);

    System.out.println("\nremovendo elemento " + l.first() + " da List");
    l.remove(l.findElement(l.first()));
    estado(l);

    System.out.println("\nremovendo elemento " + l.last() + " da List");
    l.remove(l.findElement(l.last()));
    estado(l);

    System.out.println("\ntrocando os elementos " + l.first() + " por " + l.last() + " da List");
    l.swapElements(l.findElement(l.first()),l.findElement(l.last()));
    estado(l);

    System.out.println("\nsubistituindo o elemento " + l.first() + " por " + in10 + " da List");
    l.replaceElement(l.findElement(l.first()),in10);
    estado(l);

    System.out.println("\nsubistituindo o elemento " + l.last() + " por " + in11 + " da List");
    l.replaceElement(l.findElement(l.last()),in11);
    estado(l);
    
    System.out.println("\nsubistituindo o elemento " + l.last() + " por " + in12 + " da List");
    l.replaceElement(l.findElement(l.last()),in12);
    estado(l);

    System.out.println("\no elemento anterior ao elemento " + l.last() + " é " + l.before(l.findElement(l.last())).getElement());

    System.out.println("\no elemento posterior ao elemento " + l.first() + " é " + l.after(l.findElement(l.first())).getElement());

    System.out.println("\no elemento " + in10 + " é o primeiro? " + l.isFirst(l.findElement(in10)));

    System.out.println("\no elemento " + in12 + " é o último? " + l.isLast(l.findElement(in12)));

    System.out.println("\no elemento " + in12 + " é o primeiro? " + l.isFirst(l.findElement(in12)));

    System.out.println("\no elemento " + in10 + " é o último? " + l.isLast(l.findElement(in10)));

    System.out.println("\nEsvaziando a List");
    l.empty();
    estado(l);

    System.out.println("\ntestes de exceção ");
    try {
      System.out.println("\nBuscando elemento inexistente");
      l.isLast(l.findElement(99));
      System.out.println("\nElemento encontrado");
    } catch (Exception e) {
      System.out.println("\nRemovendo elemento da List vazia");
      l.remove(l.findElement(0));
      System.out.println("\nElemento removido");
    }    
  }
}
