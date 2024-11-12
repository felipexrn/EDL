import java.util.*;
import Arvore.src.binaria.*;
public class testeArvoreBinaria {
  public static void main(String[] args) {
    try {
      // Comparador de inteiros e arvore instanciados
      //GenericComparator IntComparator = new GenericComparator(0); // 0=inteiros
      ArvoreBinariaBusca<Integer,NodeBinariaBusca<Integer>> AB = new ArvoreBinariaBusca<Integer,NodeBinariaBusca<Integer>>(0);

      // comparador configurado na arvore 
      //AB.setComparer(IntComparator);
      GenericComparator GC = AB.getComparer();
      System.out.println("tipo: " + GC.getType() + ", comparador de " +  GC.getStrType());
      System.out.println();
      NodeBinariaBusca<Integer> r = new NodeBinariaBusca(null, 6);
      
      AB.setRoot(r);
      AB.include(4);
      AB.include(8);
      AB.include(3);
      AB.include(9);
      System.out.println("inseridos 6, 4, 8, 3, 9");
      statusArvore(AB);

      AB.include(1);
      AB.include(11);
      System.out.println("inseridos 1, 11");
      statusArvore(AB);

      AB.include(2);
      AB.include(10);
      System.out.println("inseridos 2, 10");
      statusArvore(AB);

      AB.include(5);
      AB.include(5);
      AB.include(7);
      System.out.println("inseridos 5, 5, 7");
      statusArvore(AB);

      AB.remove(3);
      System.out.println("removido 3");
      statusArvore(AB);

      AB.remove(5);
      System.out.println("removido 5");
      statusArvore(AB);

      AB.remove(4);
      System.out.println("removido 4");
      statusArvore(AB);
      
      AB.remove(9);
      System.out.println("removido 9");
      statusArvore(AB);

      try {
        AB.remove(5);
        System.out.println("removido 5");
        statusArvore(AB);
      }
      catch (Exception e) {
        System.out.println("não foi possível remover 5.\n" + e.getMessage());
      }

      AB.include(5);
      AB.include(4);
      System.out.println("inseridos 5, 4");
      statusArvore(AB);

      AB.remove(6);
      System.out.println("removido 6");
      statusArvore(AB);

      AB.include(17);
      AB.include(13);
      AB.include(14);
      System.out.println("inseridos 17, 13 e 14");
      statusArvore(AB);

      AB.remove(11);
      System.out.println("removido 11");
      statusArvore(AB);

      System.out.println("Testes bem sucedidos");
    }
    catch (Exception e) {
      System.err.println("Erro durante o teste!\n" + e.getMessage());
    }
  }
  public static void statusArvore(ArvoreBinariaBusca<Integer, NodeBinariaBusca<Integer>> AB) {
    AB.status();
    AB.show();
  }
}
