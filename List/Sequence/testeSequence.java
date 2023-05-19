public class testeSequence {
  public static void estado(Sequence seq) {
    System.out.println("Estado da Sequence");
    System.out.println(seq.toString());
    System.out.println("size " + seq.size());
  }
  public static void main(String[] args) {
    int in1 = 4, in2 = 10, in3 = 7, in4 = -1, in5 = -2, in6 = 5,
      in7 = 3, in8 = 9, in9 = -3, in10 = -5, in11 = -3, in12 = -4;
    Sequence s = new Sequence();
    System.out.println("\ninserindo " + in1 + " elementos no início");
    for (int i = 0; i < in1; i++) {
      s.insertFirst(i);
    }
    estado(s);

    System.out.println("\ninserindo " + in2 + " elementos no fim");
    for (int i = 0; i < in2; i++) {
      s.insertLast(i);
    }
    estado(s);
    
    System.out.println("\ninserindo elemento " + in4 +
                       " antes do elemento " + in3 + " na List");
    s.insertBefore(s.findElement(in3),in4);
    estado(s);

    System.out.println("\ninserindo elemento " + in5 +
                       " depois do elemento " + in3 + " na List");
    s.insertAfter(s.findElement(in3),in5);
    estado(s);

    System.out.println("\ninserindo elemento " + in4 +
                       " antes do elemento " + in7 + " na List");
    s.insertBefore(s.findElement(in7),in4);
    estado(s);

    System.out.println("\ninserindo elemento " + in9 +
                       " depois do elemento " + in8 + " na List");
    s.insertAfter(s.findElement(in8),in9);
    estado(s);

    System.out.println("\nremovendo elemento " + in6 + " da List");
    s.remove(s.findElement(in6));
    estado(s);

    System.out.println("\nremovendo elemento " + s.first() + " da List");
    s.remove(s.findElement(s.first()));
    estado(s);

    System.out.println("\nremovendo elemento " + s.last() + " da List");
    s.remove(s.findElement(s.last()));
    estado(s);

    System.out.println("\ntrocando os elementos " + s.first() +
                       " por " + s.last() + " da List");
    s.swapElements(s.findElement(s.first()),s.findElement(s.last()));
    estado(s);

    System.out.println("\nsubistituindo o elemento " + s.first() +
                       " por " + in10 + " da List");
    s.replaceElement(s.findElement(s.first()),in10);
    estado(s);

    System.out.println("\nsubistituindo o elemento " + s.last() +
                       " por " + in11 + " da List");
    s.replaceElement(s.findElement(s.last()),in11);
    estado(s);
    
    System.out.println("\nsubistituindo o elemento " + s.last() +
                       " por " + in12 + " da List");
    s.replaceElement(s.findElement(s.last()),in12);
    estado(s);

    System.out.println("\no elemento anterior ao elemento " + s.last() +
                       " é " + s.before(s.findElement(s.last())).getElement());

    System.out.println("\no elemento posterior ao elemento " + s.first() +
                       " é " + s.after(s.findElement(s.first())).getElement());

    System.out.println("\no elemento " + in10 + " é o primeiro? "
                       + s.isFirst(s.findElement(in10)));

    System.out.println("\no elemento " + in12 + " é o último? " +
                       s.isLast(s.findElement(in12)));

    System.out.println("\no elemento " + in12 + " é o primeiro? "
                       + s.isFirst(s.findElement(in12)));

    System.out.println("\no elemento " + in10 + " é o último? "
                       + s.isLast(s.findElement(in10)));

    System.out.println("\nEsvaziando a List");
    s.empty();
    estado(s);

     

    System.out.println("Entrando " + in + " elementos");
    for (int i = 0; i < in; i++) {
      s.insertAtRank(0, i); 
      System.out.println(i);
    }
    System.out.println("O Vetor contém " + s.size() + " elementos");
    System.out.println("Estado do Vetor");
    System.out.println(s.toString());
    
    System.out.println("Saindo " + out + " elementos");
    for (int i = 0; i < out; i++) {
      System.out.println(s.elementAtRank(i));
      s.removeAtRank(i);
    }
    
    System.out.println("O Vetor contém " + s.size() + " elementos");
    System.out.println("Estado do Vetor");
    System.out.println(s.toString());

    System.out.println("subistituindo " + s.size() + " elementos");
    for (int i = 0; i < s.size(); i++) {
      System.out.println(s.elementAtRank(i) + " por " + i*2);
      s.replaceAtRank(i, i*2);
    }

    System.out.println("O Vetor contém " + s.size() + " elementos");
    System.out.println("Estado do Vetor");
    System.out.println(s.toString());

    System.out.println("Esvazinado o Vetor");
    while (s.size() > 0) {
      System.out.println("Saiu " + s.removeAtRank(0));
    }

    System.out.println("O Vetor contém " + s.size() + " elementos");
    System.out.println("Estado do Vetor");
    System.out.println(s.toString());

    System.out.println("\nTestes de excecão");
    try {
      System.out.println("\nRemovendo elemento através do removeAtRank() da Sequence vazia");
      System.out.println(s.removeAtRank(0));
      System.out.println("Elemento removido da Sequence vazia");
    }
    catch (Exception e) {
      try {
        System.out.println("inserindo elemento em índice inválido por meio do insertAtRank()");
        s.insertAtRank(-1, 0); 
        System.out.println("Elemento inserido em índice inválido");
      }
      catch (Exception e) {
        try {
          System.out.println("\nBuscando elemento inexistente por meio do findElement()");
          s.isLast(s.findElement(99));
          System.out.println("\nElemento encontrado");
        } catch (Exception e) {
          System.out.println("\nRemovendo elemento através do remove() da Sequence vazia");
          s.remove(s.findElement(0));
          System.out.println("\nElemento removido");
        } 
      }
    }

    System.out.println("\ntestes de exceção ");
    
  }
}
