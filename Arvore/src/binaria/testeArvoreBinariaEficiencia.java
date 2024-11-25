import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import Arvore.src.binaria.*;

public class testeArvoreBinariaEficiencia {
    public static void main(String[] args) {
        try {
            // Arquivo para inserção de números aleatórios
            String arquivo = "Arvore/src/binaria/insercao.txt";

            // Gera numeros Aleatórios a inserir
            GerarArquivoNumeroInteiro.main(new String[] {arquivo, args[0]});
            
            // Sorteia numeros a remover
            ArrayList<Integer> numerosUnicos = new ArrayList<>();

            // Comparador de inteiros e arvore instanciados
            //GenericComparator<Integer> IntComparator = new GenericComparator<>(0); // 0=inteiros
            ArvoreBinariaBusca<Integer,NodeBinariaBusca<Integer>> AB = new ArvoreBinariaBusca<Integer,NodeBinariaBusca<Integer>>(0);
            System.out.println("Arvore binária de busca instanciada");

            // Configurar comparador na árvore
            //AB.setComparer(IntComparator);
            GenericComparator GC = AB.getComparer();
            System.out.println("Configurado comparador de tipo: " + GC.getStrType());

            // Configura debug da árvore
            AB.setDebug(false);

            // variaveis para contagem do tempo
            long tempoInsercaoInicio = 0;
            long tempoInsercaoFim = 0;
            long tempoInsercaoTotal = 0;
            long tempoRemocaoInicio = 0;
            long tempoRemocaoFim = 0;
            long tempoRemocaoTotal = 0;
            
            // teste de inserção
            System.out.println("TESTE DE INSERÇÃO");

            // Ler entradas do arquivo e inserir na árvore
            int inseridos = 0;
            try {
                Scanner scanner = new Scanner(new File(arquivo));
                while (scanner.hasNextInt()) {
                    Integer value = scanner.nextInt();
                    try {
                        tempoInsercaoInicio = System.currentTimeMillis();
                        AB.include(value);
                        tempoInsercaoFim = System.currentTimeMillis();
                        tempoInsercaoTotal += tempoInsercaoFim - tempoInsercaoInicio;
                        clear();
                        System.out.println("inserções: " + inseridos);
                        System.out.println("Tempo de inserção: " + 
                            (tempoInsercaoFim - tempoInsercaoInicio) + " ms."
                        );
                        inseridos++;                   
                        //System.out.println("Inserido o nó: " + value);
                        numerosUnicos.add(value);
                    }
                    catch (Exception ex) {                        
                        System.out.println("Não foi possível inserir: "+ value +"\n"+ ex.getMessage()); 
                    }
                    // Mostrar status da árvore
                    //statusArvore(AB);    
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException("Arquivo '" + arquivo + "' não encontrado! " + e.getMessage()+"\n");
            } catch (Exception e) {
                throw new Exception("Erro ao inserir itens na árvore!" + e.getMessage()+"\n");
            }         

            // teste de remoção
            System.out.println("TESTE DE REMOÇÃO");

            // Embaralha (sorteia) a lista de números
            Collections.shuffle(numerosUnicos);

            // Ler entradas do arquivo e remover na árvore
            int removidos = 0;
            try {
                for (Integer value : numerosUnicos) {
                    try {
                        tempoRemocaoInicio = System.currentTimeMillis();
                        AB.remove(value);
                        tempoRemocaoFim = System.currentTimeMillis();
                        tempoRemocaoTotal += tempoRemocaoFim - tempoRemocaoInicio;
                        clear();
                        System.out.println("remoções: " + removidos);
                        System.out.println("Tempo de remoção: " + 
                            (tempoRemocaoFim - tempoRemocaoInicio) + " ms."
                        );
                        removidos++;                   
                        //System.out.println("Removido o nó: " + value);
                    }
                    catch (Exception ex) {
                        throw new Exception("Não foi possível remover: "+ value +"\n"+ ex.getMessage()+"\n");    
                    }
                    // Mostrar status da árvore
                    //statusArvore(AB);    
                }
                System.out.println("Tempo inserção Total de: " + 
                    (tempoInsercaoTotal) + " ms."
                );
                System.out.println("Media de tempo por inserção de: " + 
                    (tempoInsercaoTotal / inseridos) + " ms."
                );

                System.out.println("Tempo remoção Total de: " + 
                    (tempoRemocaoTotal) + " ms."
                );
                System.out.println("Media de tempo por remoção de: " + 
                    (tempoRemocaoTotal / removidos) + " ms."
                );                
            } catch (Exception e) {
                throw new Exception("Erro ao remover itens da árvore!\n" + e.getMessage()+"\n");
            }  
            System.out.println("Teste bem sucedido");
        }
        catch (Exception e) {
            System.out.println("Erro durante o teste!\n"+e.getMessage());
        }        
    }

    public static void statusArvore(ArvoreBinariaBusca<Integer,NodeBinariaBusca<Integer>> AB) {
        //AB.status();
        AB.show();
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
}
