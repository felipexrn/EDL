// interface dinâmica para testar arvore binaria de pesquisa
// utilize numeros para selecionar as os comandos do menu

import java.util.*;
import Arvore.src.avl.*;
import Arvore.src.binaria.*;

public class testeArvoreAvlDinamico {
  public static void main(String[] args) {
    boolean existeArvore = false;
    int selecionado;
    Integer k;
    String s;
    Double d;
    Node buscado;
    Node removido;
    Scanner ler = new Scanner(System.in);
    ArrayList<String> metodos = new ArrayList<String>();
    GenericComparator GC = new GenericComparator<>(0);
    ArvoreAvl AAvl = null;
    ArvoreAvl<Integer> AvlI = new ArvoreAvl<Integer>(0);
    ArvoreAvl<String> AvlS = new ArvoreAvl<String>(1);
    ArvoreAvl<Double> AvlD = new ArvoreAvl<Double>(2);
      // lista de métodos utilizáveis
      metodos.add("sair");                                 // 0: fechar programa
      metodos.add("criar arvore avl de tipo inteiro");     // 1: cria árvore avl de tipo inteiro
      metodos.add("criar arvore avl de tipo String");      // 2: cria árvore avl de tipo String
      metodos.add("criar arvore avl de tipo Double");      // 3: cria árvore avl de tipo Double
      metodos.add("inserir nó de chave k");                // 4: insere nó com chave k 
      metodos.add("remover nó de chave k");                // 5: remove nó com chave k 
      metodos.add("buscar nó de chave k");                 // 6: busca nó com chave k 
      metodos.add("mostrar arvore");                       // 7: mostra arvore 
      metodos.add("mostrar status da arvore");             // 8: mostra status da arvore 
      metodos.add("reiniciar arvore");                     // 9: reiniciar arvore
      metodos.add("Configura Debug");                      // 10: configura Debug

    while (true) {
      listaMetodos(metodos);
      selecionado = selecionaMetodo(ler);
      if ((selecionado > 3) && (!existeArvore)) {
        System.out.println("Crie a arvore antes de selecionar este comando");
        continue;
      }
      
      for (int i = 0 ; i < metodos.size(); i++) {
        if (selecionado == i) {
          switch(selecionado) {
            // 0: fechar programa
            case 0:
              clear();
              System.out.println("Sistema desligado");
              System.exit(0);
            break;
            // 1: cria árvore avl de tipo inteiro
            case 1:
              clear();
              AAvl = new ArvoreAvl<Integer>(0); // Arvore avl de pesquisa vazia
              GC = AAvl.getComparer();
              //GC.setType(0); // 0=inteiro 
              //AAvl.setComparer(GC);
              existeArvore = true;
              System.out.println("Arvore avl de tipo " + GC.getStrType() + " criada");
            break;
              
            // 2: cria árvore binária de tipo String
            case 2:
              clear();
              AAvl = new ArvoreAvl<String>(1); // Arvore Binaria de pesquisa vazia do tipo String
              GC = AAvl.getComparer();
              //GC.setType(1); // 1=String 
              //AAvl.setComparer(GC);
              existeArvore = true;
              System.out.println("Arvore avl de tipo " + GC.getStrType() + "  criada");
              break;

            // 3: cria árvore binária de tipo Double
            case 3:
              clear();
              AAvl = new ArvoreAvl<Double>(2); // Arvore avl de pesquisa vazia do tipo Double
              GC = AAvl.getComparer();
              //GC.setType(2); // 2=Souble 
              //AAvl.setComparer(GC);
              existeArvore = true;
              System.out.println("Arvore avl de tipo " + GC.getStrType() + "  criada");
              break;
            
            // 4: insere nó com chave k 
            case 4:
              clear();
              System.out.println("Insira a chave k do tipo " + GC.getStrType() + " a ser inserida na arvore");
              Object key; 

              switch(GC.getType()) {
                // insere chave k do tipo inteiro
                case 0:
                  key = AAvl.include(ler.nextInt()).getKey();
                break;
                  
                // insere chave k do tipo String
                case 1:
                  key = AAvl.include(ler.next()).getKey();
                break;

                // insere chave k do tipo Double
                case 2:
                  key = AAvl.include(ler.nextDouble()).getKey();
                break;

                default: key = "";
              } 
              System.out.println("Chave k " + key + " inserida.");
            break;

            // 5: remove nó com chave k 
            case 5:
              clear();
              if (AAvl.getRoot() == null) {
                System.out.println("Adicione ao menos uma chave na arvore");
                break;
              }
              System.out.println("Insira a chave k do tipo " + GC.getStrType() + " a ser removida da arvore");
              switch(GC.getType()) {
                // remove chave k do tipo inteiro
                case 0:
                  k = (Integer) ler.nextInt(); 
                  buscado = null;                 
                  try {
                    buscado = AAvl.search(AAvl.getRoot(), k);
                  } catch (Exception e) {
                    System.out.println("chave k " + k + " não encontrada");
                  }  
                  if (buscado.getKey() != null) {
                    if (k == (Integer) buscado.getKey()) {
                      removido = AAvl.remove(k);
                      System.out.println("chave k " + removido.getKey() + " removida");
                    }
                    else System.out.println("chave k " + k + " não encontrda");
                  }
                break;
                  
                // remove chave k do tipo String
                case 1:
                  s = (String) ler.next();
                  buscado = null;
                  try {
                    buscado = AAvl.search(AAvl.getRoot(), s);
                  } catch (Exception e) {
                    System.out.println("chave k " + s + "não encontrada");
                  }                    
                  if (buscado.getKey() != null) {
                    if (s.equals((String) buscado.getKey())) {
                      removido = AAvl.remove(s);
                      System.out.println("chave k " + removido.getKey() + " removida");
                    }
                    else System.out.println("chave k " + s + " não encontrada");
                  }
                break;

                // remove chave k do tipo Double
                case 2:
                  d = (Double) ler.nextDouble();
                  buscado = null;
                  try {
                    buscado = AAvl.search(AAvl.getRoot(), d);
                  } catch (Exception e) {
                    System.out.println("chave k " + d + " não encontrada");
                  }  
                  if (buscado.getKey() != null) {
                    if (d.equals((Double) buscado.getKey())) {
                      removido = AAvl.remove(d);
                      System.out.println("chave k " + removido.getKey() + " removida");
                    }
                    else System.out.println("chave k " + d + " não encontrada");
                  }
                break;
              } 
            break;

            // 6: busca nó com chave k
            case 6:
              clear();
              if (AAvl.getRoot() == null) {
                System.out.println("Adicione ao menos uma chave na arvore");
                break;
              }
              System.out.println("Insira a chave k do tipo " + GC.getStrType() + " a ser buscada na arvore");
              switch(GC.getType()) {
                // busca chave k do tipo inteiro
                case 0:
                  k = (Integer) ler.nextInt();
                  buscado = AAvl.search(AAvl.getRoot(),k);
                  if (buscado.getKey() != null) {
                    if (buscado.getKey().equals(k)) System.out.println("chave k encontrada: " + buscado.getKey()); 
                    else System.out.println("chave " + k + " não encontrada");
                  }
                break;
                  
                // busca chave k do tipo String
                case 1:
                  s = ler.next();
                  buscado = AAvl.search(AAvl.getRoot(),s);
                  if (buscado != null && s.equals(buscado.getKey()))
                    System.out.println("chave k encontrada: " + buscado.getKey());                   
                  else
                    System.out.println("chave " + s + " não encontrada");
                break;

                // busca chave k do tipo Double
                case 2:
                  d = ler.nextDouble();
                  buscado = AAvl.search(AAvl.getRoot(),d);
                  if (buscado != null && d.equals(buscado.getKey()))
                    System.out.println("chave k encontrada: " + buscado.getKey()); 
                  else
                    System.out.println("chave " + d + " não encontrada");
                break;
              } 
            break;

            // 7: mostra arvore 
            case 7:
              clear();
              if (AAvl.getRoot() == null) {
                System.out.println("Adicione ao menos uma chave na arvore");
                break;
              }
              System.out.println("Topo da arvore");
              AAvl.show();
              System.out.println("Base da arvore");
            break;

            // 8: mostra status da arvore 
            case 8: 
              clear();
              if (AAvl.getRoot() == null) {
                System.out.println("Adicione ao menos uma chave na arvore");
                break;
              }
              System.out.println("status da arvore");
              System.out.println("nodes:    " + AAvl.strNodes());
              System.out.println("elements: " + AAvl.strElements());
              System.out.println("depths:   " + AAvl.strDepths());
              System.out.println("heigth:   " + AAvl.height(AAvl.getRoot()));
            break;

            // 9: reiniciar arvore 
            case 9: 
              clear();
              AAvl = new ArvoreAvl(GC.getType());
              System.out.println("Arvore do tipo " + GC.getStrType() + " reiniciada.");
            break;

            // 10: configura debug 
            case 10: 
              clear();              
              System.out.println("Selecione 1 para ligar Debug. Selecione 0 para desligar Debug.");              
              try {
                int opcao = ler.nextInt();
                if ((opcao != 0) && (opcao != 1)) System.out.println("Valor inválido: " + opcao + "\nSelecione 1 para ligar Debug. Selecione 0 para desligar Debug.");
                if (opcao == 1) AAvl.setDebug(true);
                if (opcao == 0) AAvl.setDebug(false);
                if (AAvl.getDebug()) System.out.println("Debug ligado.");
                else  System.out.println("Debug desligado.");
              } catch (Exception e) {
                System.out.println("Erro ao configrar Debug. Utilize 0 ou 1 para configurar corretamente.\n" + e.getMessage());
              }
            break;

            default: 
              clear();
              System.out.println("Insira um comando válido");
          }
        }
      }     
    }
  }
  public static void listaMetodos(ArrayList<String> metodos) {
    for (int i = 0; i < metodos.size(); i++) {
      System.out.println(i + ": " +   metodos.get(i));
    }
  }
  public static int selecionaMetodo(Scanner ler) {
    try {
      return ler.nextInt();
    }
    catch(Exception e) {
      System.out.println("Comando inválido. Selecione outro método");
    } 
    return 0;
  }
  public static void clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
} 