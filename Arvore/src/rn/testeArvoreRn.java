import java.util.*;
import Arvore.src.rn.*;
public class testeArvoreRn {
  public static void main (String[] args) {
    try {
      // 0=inteiro    
      ArvoreRn ARN = new ArvoreRn(0);
      System.out.println("instanciada Arvore Rubro Negra do tipo: " + ARN.getComparer().getStrType());
      ARN.setDebug(false);
      if(ARN.getDebug()) System.out.println("Debug ligado.");
      else System.out.println("Debug desligado.");
      // NodeRn n = new NodeRn(null, 1);
      // NodeRn m = new NodeRn(n, 2);
      // System.out.println(m.getParent().getKey());
      // System.out.println(m.getKey());
      System.out.println("TESTE DE INSERÇÃO");      
      System.out.println("Inserindo 10");
      ARN.include(10);
      ARN.show();    
      ARN.verifyRn();  
      System.out.println("Inserindo 30");
      ARN.include(30);
      ARN.show();    
      ARN.verifyRn();  
      System.out.println("Inserindo 20");
      ARN.include(20);
      ARN.show();
      ARN.verifyRn();
      System.out.println("Inserindo 40");
      ARN.include(40);
      ARN.show();
      ARN.verifyRn();
      System.out.println("Inserindo 90");
      ARN.include(90);
      ARN.show();
      ARN.verifyRn();
      System.out.println("Inserindo 80");
      ARN.include(80);
      ARN.show();
      ARN.verifyRn();
      System.out.println("Inserindo 70");
      ARN.include(70);
      ARN.show();
      ARN.verifyRn();
      System.out.println("Inserindo 60");
      ARN.include(60);
      ARN.show();
      ARN.verifyRn();
      System.out.println("Inserindo 50");
      ARN.include(50);
      ARN.show();
      ARN.verifyRn();
      System.out.println("TESTE DE REMOÇÃO");
      System.out.println("Removendo 10");
      ARN.remove(10);
      ARN.show();
      System.out.println("Removendo 60");
      ARN.remove(60);
      ARN.show();
      System.out.println("Removendo 30");
      ARN.remove(30);
      ARN.show();
      System.out.println("Removendo 40");
      ARN.remove(40);
      ARN.show();
      System.out.println("Removendo 50");
      ARN.remove(50);
      ARN.show();
      System.out.println("Removendo 70");
      ARN.remove(70);
      ARN.show();
      System.out.println("Removendo 20");
      ARN.remove(20);
      ARN.show();
      System.out.println("Removendo 90");
      ARN.remove(90);
      ARN.show();
      System.out.println("Removendo 80");
      ARN.remove(80);
      ARN.show();
      ARN.verifyRn();
      System.out.println("Teste bem sucedido.");
    } catch (Exception e) {
      System.out.println("Erro durante o teste!\n"+e.getMessage());
    }
  }
}