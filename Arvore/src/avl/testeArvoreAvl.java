import java.util.*;
import Arvore.src.avl.*;
public class testeArvoreAvl {
  public static void main (String[] args) {
    try {
      //GenericComparator GC = new GenericComparator(0); 
      //GC.setType(0); // 0=inteiro    
      ArvoreAvl A = new ArvoreAvl(0);
      System.out.println("instanciada Arvore Avl do tipo: " + A.getComparer().getStrType());
      A.setDebug(true);
      if(A.getDebug()) System.out.println("Debug ligado.");
      else System.out.println("Debug desligado.");
      // NodeAvl n = new NodeAvl(null, 1);
      // NodeAvl m = new NodeAvl(n, 2);
      // System.out.println(m.getParent().getKey());
      // System.out.println(m.getKey());
      System.out.println("TESTE DE INSERÇÃO");      
      System.out.println("Inserindo 10");
      A.include(10);
      A.show();      
      System.out.println("Inserindo 30");
      A.include(30);
      A.show();      
      System.out.println("Inserindo 20");
      A.include(20);
      A.show();
      System.out.println("Inserindo 40");
      A.include(40);
      A.show();
      System.out.println("Inserindo 90");
      A.include(90);
      A.show();
      System.out.println("Inserindo 80");
      A.include(80);
      A.show();
      System.out.println("Inserindo 70");
      A.include(70);
      A.show();
      System.out.println("Inserindo 60");
      A.include(60);
      A.show();
      System.out.println("Inserindo 50");
      A.include(50);
      A.show();
      System.out.println("TESTE DE REMOÇÃO");
      System.out.println("Removendo 10");
      A.remove(10);
      A.show();
      System.out.println("Removendo 60");
      A.remove(60);
      A.show();
      System.out.println("Removendo 30");
      A.remove(30);
      A.show();
      System.out.println("Removendo 40");
      A.remove(40);
      A.show();
      System.out.println("Removendo 50");
      A.remove(50);
      A.show();
      System.out.println("Removendo 70");
      A.remove(70);
      A.show();
      System.out.println("Removendo 20");
      A.remove(20);
      A.show();
      System.out.println("Removendo 90");
      A.remove(90);
      A.show();
      System.out.println("Removendo 80");
      A.remove(80);
      A.show();
      System.out.println("Teste bem sucedido.");
    } catch (Exception e) {
      System.out.println("Erro durante o teste!\n"+e.getMessage());
    }
  }
}