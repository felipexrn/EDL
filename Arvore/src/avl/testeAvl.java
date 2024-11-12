import java.util.*;
import Arvore.src.avl.*;
public class testeAvl {
  public static void main (String[] args) {
    try {
      //GenericComparator GC = new GenericComparator(0); 
      //GC.setType(0); // 0=inteiro    
      Avl A = new Avl(0);
      System.out.println("instanciada Arvore Avl do tipo: " + A.getComparer().getStrType());
      A.setDebug(true);
      if(A.getDebug()) System.out.println("Debug ligado.");
      else System.out.println("Debug desligado.");
      // NodeAvl n = new NodeAvl(null, 1);
      // NodeAvl m = new NodeAvl(n, 2);
      // System.out.println(m.getParent().getKey());
      // System.out.println(m.getKey());
      System.out.println("TESTE DE INSERÇÃO");      
      A.include(10);
      System.out.println("Inserido 10");
      A.show();      
      A.include(20);
      System.out.println("Inserido 20");
      A.show();      
      A.include(30);
      System.out.println("Inserido 30");
      A.show();
      A.include(40);
      System.out.println("Inserido 40");
      A.show();
      A.include(50);
      System.out.println("Inserido 50");
      A.show();
      A.include(60);
      System.out.println("Inserido 60");
      A.show();
      A.include(70);
      System.out.println("Inserido 70");
      A.show();
      A.include(80);
      System.out.println("Inserido 80");
      A.show();
      A.include(90);
      System.out.println("Inserido 90");
      A.show();
      System.out.println("TESTE DE REMOÇÃO");
      A.remove(10);
      System.out.println("Removido 10");
      A.show();
      A.remove(20);
      System.out.println("Removido 20");
      A.show();
      A.remove(30);
      System.out.println("Removido 30");
      A.show();
      A.remove(40);
      System.out.println("Removido 40");
      A.show();
      A.remove(50);
      System.out.println("Removido 50");
      A.show();
      A.remove(60);
      System.out.println("Removido 60");
      A.show();
      A.remove(70);
      System.out.println("Removido 70");
      A.show();
      A.remove(80);
      System.out.println("Removido 80");
      A.show();
      A.remove(90);
      System.out.println("Removido 90");
      A.show();
      System.out.println("Teste bem sucedido.");
    } catch (Exception e) {
      System.out.println("Erro durante o teste!\n"+e.getMessage());
    }
  }
}