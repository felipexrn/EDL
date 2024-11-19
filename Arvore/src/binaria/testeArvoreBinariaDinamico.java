// interface dinâmica para testar arvore binaria de pesquisa
// utilize numeros para selecionar as os comandos do menu

import java.util.*;
import Arvore.src.binaria.*;

public class testeArvoreBinariaDinamico {
  public static void main(String[] args) {
    boolean existeArvore = false;
    int selecionado, k;
    String s;
    Double d;
    Node buscado;
    Scanner ler = new Scanner(System.in);
    ArrayList<String> metodos = new ArrayList<String>();
    GenericComparator GC = new GenericComparator<>(0);
    ArvoreBinariaBusca AB = null;
    ArvoreBinariaBusca<Integer,NodeBinariaBusca<Integer>> ABI = new ArvoreBinariaBusca<Integer,NodeBinariaBusca<Integer>>(0);
    ArvoreBinariaBusca<String,NodeBinariaBusca<String>> ABS = new ArvoreBinariaBusca<String,NodeBinariaBusca<String>>(1);
    ArvoreBinariaBusca<Double,NodeBinariaBusca<Double>> ABD = new ArvoreBinariaBusca<Double,NodeBinariaBusca<Double>>(2);
      // lista de métodos utilizáveis
      metodos.add("sair");                                 // 0: fechar programa
      metodos.add("criar arvore binaria de tipo inteiro"); // 1: cria árvore binária de tipo inteiro
      metodos.add("criar arvore binaria de tipo String");  // 2: cria árvore binária de tipo String
      metodos.add("criar arvore binaria de tipo Double");  // 3: cria árvore binária de tipo Double
      metodos.add("inserir nó de chave k");                // 4: insere nó com chave k 
      metodos.add("remover nó de chave k");                // 5: remove nó com chave k 
      metodos.add("buscar nó de chave k");                 // 6: busca nó com chave k 
      metodos.add("mostrar arvore");                       // 7: mostra arvore 
      metodos.add("mostrar status da arvore");             // 8: mostra status da arvore 
      metodos.add("reiniciar arvore");                     // 9: reiniciar arvore

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
            // 1: cria árvore binária de tipo inteiro
            case 1:
              clear();
              AB = new ArvoreBinariaBusca<Integer,NodeBinariaBusca<Integer>>(0); // Arvore Binaria de pesquisa vazia
              GC = AB.getComparer();
              //GC.setType(0); // 0=inteiro 
              //AB.setComparer(GC);
              existeArvore = true;
              System.out.println("Arvore binaria de pesquisa de tipo " + GC.getStrType() + " criada");
            break;
              
            // 2: cria árvore binária de tipo String
            case 2:
              clear();
              AB = new ArvoreBinariaBusca<String,NodeBinariaBusca<String>>(1); // Arvore Binaria de pesquisa vazia do tipo String
              GC = AB.getComparer();
              //GC.setType(1); // 1=String 
              //AB.setComparer(GC);
              existeArvore = true;
              System.out.println("Arvore binaria de pesquisa de tipo " + GC.getStrType() + "  criada");
              break;

            // 3: cria árvore binária de tipo Double
            case 3:
              clear();
              AB = new ArvoreBinariaBusca<Double,NodeBinariaBusca<Double>>(2); // Arvore Binaria de pesquisa vazia do tipo Double
              GC = AB.getComparer();
              //GC.setType(2); // 2=Souble 
              //AB.setComparer(GC);
              existeArvore = true;
              System.out.println("Arvore binaria de pesquisa de tipo " + GC.getStrType() + "  criada");
              break;
            
            // 4: insere nó com chave k 
            case 4:
              clear();
              System.out.println("Insira a chave k do tipo " + GC.getStrType() + " a ser inserida na arvore");
              Object key; 

              switch(GC.getType()) {
                // insere chave k do tipo inteiro
                case 0:
                  key = AB.include(ler.nextInt()).getKey();
                break;
                  
                // insere chave k do tipo String
                case 1:
                  key = AB.include(ler.next()).getKey();
                break;

                // insere chave k do tipo Double
                case 2:
                  key = AB.include(ler.nextDouble()).getKey();
                break;

                default: key = "";
              } 
              System.out.println("Chave k " + key + " inserida.");
            break;

            // 5: remove nó com chave k 
            case 5:
              clear();
              if (AB.getRoot() == null) {
                System.out.println("Adicione ao menos uma chave na arvore");
                break;
              }
              System.out.println("Insira a chave k do tipo " + GC.getStrType() + " a ser removida da arvore");
              switch(GC.getType()) {
                // remove chave k do tipo inteiro
                case 0:
                  k = ler.nextInt(); 
                  buscado = null;                 
                  try {
                    buscado = AB.search(AB.getRoot(), k);
                  } catch (Exception e) {
                    System.out.println("chave k " + k + " não encontrada");
                  }  
                  if (buscado.getKey() != null) {
                    if (k == (int) buscado.getKey()) {
                      AB.remove(k);
                      System.out.println("chave k " + k + " removida");
                    }
                    else System.out.println("chave k " + k + " não encontrda");
                  }
                break;
                  
                // remove chave k do tipo String
                case 1:
                  s = ler.next();
                  buscado = null;
                  try {
                    buscado = AB.search(AB.getRoot(), s);
                  } catch (Exception e) {
                    System.out.println("chave k " + s + "não encontrada");
                  }                    
                  if (buscado.getKey() != null) {
                    if (s.equals(buscado.getKey())) {
                      AB.remove(s);
                      System.out.println("chave k " + s + " removida");
                    }
                    else System.out.println("chave k não encontrada");
                  }
                break;

                // remove chave k do tipo Double
                case 2:
                  d = ler.nextDouble();
                  buscado = null;
                  try {
                    buscado = AB.search(AB.getRoot(), d);
                  } catch (Exception e) {
                    System.out.println("chave k " + d + " não encontrada");
                  }  
                  if ((buscado != null) && (buscado.getKey() != null)) {
                    if (d.equals(buscado.getKey())) {
                      System.out.println(d.getClass() + " " + buscado.getKey().getClass());
                      AB.remove(d);
                      System.out.println("chave k " + d + " removida");
                    }
                    else System.out.println("chave k " + d + " não encontrada");
                  }
                break;
              } 
            break;

            // 6: busca nó com chave k
            case 6:
              clear();
              if (AB.getRoot() == null) {
                System.out.println("Adicione ao menos uma chave na arvore");
                break;
              }
              System.out.println("Insira a chave k do tipo " + GC.getStrType() + " a ser buscada na arvore");
              switch(GC.getType()) {
                // busca chave k do tipo inteiro
                case 0:
                  k = ler.nextInt();
                  buscado = AB.search(AB.getRoot(),k);
                  if (buscado.getKey() != null) {
                    if ((int) buscado.getKey() == k) System.out.println("chave k encontrada: " + buscado.getKey()); 
                    else System.out.println("chave " + k + " não encontrada");
                  }
                break;
                  
                // busca chave k do tipo String
                case 1:
                  s = ler.next();
                  buscado = AB.search(AB.getRoot(),s);
                  if (buscado != null && s.equals(buscado.getKey()))
                    System.out.println("chave k encontrada: " + buscado.getKey());                   
                  else
                    System.out.println("chave " + s + " não encontrada");
                break;

                // busca chave k do tipo Double
                case 2:
                  d = ler.nextDouble();
                  buscado = AB.search(AB.getRoot(),d);
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
              if (AB.getRoot() == null) {
                System.out.println("Adicione ao menos uma chave na arvore");
                break;
              }
              System.out.println("Topo da arvore");
              AB.show();
              System.out.println("Base da arvore");
            break;

            // 8: mostra status da arvore 
            case 8: 
              clear();
              if (AB.getRoot() == null) {
                System.out.println("Adicione ao menos uma chave na arvore");
                break;
              }
              System.out.println("status da arvore");
              System.out.println("nodes:    " + AB.strNodes());
              System.out.println("elements: " + AB.strElements());
              System.out.println("depths:   " + AB.strDepths());
              System.out.println("heigth:   " + AB.height(AB.getRoot()));
            break;

            // 9: reiniciar arvore 
            case 9: 
              clear();
              AB = new ArvoreBinariaBusca(GC.getType());
              System.out.println("Arvore do tipo " + GC.getStrType() + " reiniciada.");
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