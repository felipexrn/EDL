import java.util.*;
import Arvore.src.avl.*;
public class exercicioAvl1 {
  public static void main (String[] args) {
    // Cores para destaque na impressão
    String corVermelho = "\033[31m";
    String corVerde = "\033[32m";
    String corPadrao = "\033[0m";
    try {      
      // 0=inteiro    
      ArvoreAvl AAvl = new ArvoreAvl(0);
      System.out.println("instanciada Arvore Avl do tipo: " + AAvl.getComparer().getStrType());
      AAvl.setDebug(true);

      Integer[] insercao = {50,30,70,10,35,65,80,5,11,33,62,67,75,111,3,7,60,73,100,150,144};
      Integer[] remocao = {7,11,73,100,67};
      
      if(AAvl.getDebug()) System.out.println("Debug ligado.");
      else System.out.println("Debug desligado.");

      System.out.println("TESTE DE INSERÇÃO");    
      for (Integer i : insercao) {
        System.out.println(corVerde + "Inserindo " + i + corPadrao);
        AAvl.include(i);
        AAvl.show();              
      }        

      System.out.println("TESTE DE REMOÇÃO");
      for (Integer i : remocao) {
        System.out.println(corVermelho + "Removendo " + i + corPadrao);
        AAvl.remove(i);
        AAvl.show();
      }
      System.out.println(corVerde + "Teste bem sucedido." + corPadrao);
    } catch (Exception e) {
      System.out.println(corVermelho + "Erro durante o teste!\n" + e.getMessage() + corPadrao);
    }
  }
}
