import java.util.*;
import Arvore.src.rn.*;
public class testeArvoreRn {
  public static void main (String[] args) {
    try {
      // 0=inteiro    
      ArvoreRn ARN = new ArvoreRn(0);
      System.out.println("instanciada Arvore Rubro Negra do tipo: " + ARN.getComparer().getStrType());
      ARN.setDebug(true);
      if(ARN.getDebug()) System.out.println("Debug ligado.");
      else System.out.println("Debug desligado.");
      ArrayList<Integer> inseridos = new ArrayList<>(Arrays.asList(10, 30, 20, 40, 90, 80, 70, 60, 50, 48, 49, 81));
      ArrayList<Integer> removidos = new ArrayList<>(Arrays.asList(50, 40, 90, 20, 49, 70, 10, 30, 80, 60, 48, 81));
      System.out.println("TESTE DE INSERÇÃO"); 
      for (int i = 0; i < inseridos.size(); i++) {
        System.out.println("Inserindo "+ inseridos.get(i).toString());
        ARN.include(inseridos.get(i));
        ARN.show();    
        ARN.verifyRn();    
      }           
      System.out.println("TESTE DE REMOÇÃO");
      for (int i = 0; i < removidos.size(); i++) {
        System.out.println("Removendo "+ removidos.get(i).toString());
        ARN.remove(removidos.get(i));
        ARN.show();    
        ARN.verifyRn();        
      }   
      ARN.test();      
      System.out.println("Teste bem sucedido.");
    } catch (Exception e) {
      System.out.println("Erro durante o teste!\n"+e.getMessage());
    }
  }
}