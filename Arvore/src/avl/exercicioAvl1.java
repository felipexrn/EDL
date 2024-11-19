import javAAvl.util.*;
import Arvore.src.avl.*;
public class exercicioAvl1 {
  public static void main (String[] args) {
    try {
      // 0=inteiro    
      ArvoreAvl AAvl = new ArvoreAvl(0);
      System.out.println("instanciada Arvore Avl do tipo: " + AAvl.getComparer().getStrType());
      AAvl.setDebug(true);
      
      if(AAvl.getDebug()) System.out.println("Debug ligado.");
      else System.out.println("Debug desligado.");

      System.out.println("TESTE DE INSERÇÃO");      
      System.out.println("Inserindo 10");
      AAvl.include(10);
      AAvl.show();      
      System.out.println("Inserindo 30");
      AAvl.include(30);
      AAvl.show();      
      System.out.println("Inserindo 20");
      AAvl.include(20);
      AAvl.show();
      System.out.println("Inserindo 40");
      AAvl.include(40);
      AAvl.show();
      System.out.println("Inserindo 90");
      AAvl.include(90);
      AAvl.show();
      System.out.println("Inserindo 80");
      AAvl.include(80);
      AAvl.show();
      System.out.println("Inserindo 70");
      AAvl.include(70);
      AAvl.show();
      System.out.println("Inserindo 60");
      AAvl.include(60);
      AAvl.show();
      System.out.println("Inserindo 50");
      AAvl.include(50);
      AAvl.show();
      System.out.println("TESTE DE REMOÇÃO");
      System.out.println("Removendo 10");
      AAvl.remove(10);
      AAvl.show();
      System.out.println("Removendo 60");
      AAvl.remove(60);
      AAvl.show();
      System.out.println("Removendo 30");
      AAvl.remove(30);
      AAvl.show();
      System.out.println("Removendo 40");
      AAvl.remove(40);
      AAvl.show();
      System.out.println("Removendo 50");
      AAvl.remove(50);
      AAvl.show();
      System.out.println("Removendo 70");
      AAvl.remove(70);
      AAvl.show();
      System.out.println("Removendo 20");
      AAvl.remove(20);
      AAvl.show();
      System.out.println("Removendo 90");
      AAvl.remove(90);
      AAvl.show();
      System.out.println("Removendo 80");
      AAvl.remove(80);
      AAvl.show();
      System.out.println("Teste bem sucedido.");
    } catch (Exception e) {
      System.out.println("Erro durante o teste!\n"+e.getMessage());
    }
  }
}
