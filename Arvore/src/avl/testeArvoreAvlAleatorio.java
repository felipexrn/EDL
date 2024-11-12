import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import Arvore.src.avl.*;
import Arvore.src.binaria.GerarArquivoNumeroInteiro;
import Arvore.src.binaria.GenericComparator;

public class testeArvoreAvlAleatorio {
    public static void main(String[] args) {
        try {
            // Arquivo para inserção de números aleatórios
            String arquivo = "Arvore/src/avl/insercao.txt";

            // Gera numeros Aleatórios a inserir
            GerarArquivoNumeroInteiro.main(new String[] {arquivo, args[0]});
            
            // Sorteia numeros a remover
            ArrayList<Integer> numerosUnicos = new ArrayList<>();

            // Comparador de inteiros e arvore instanciados
            //GenericComparator<Integer> IntComparator = new GenericComparator<>(0); // 0=inteiros
            ArvoreAvl<Integer> AAvl = new ArvoreAvl<Integer>(0);
            System.out.println("Arvore binária de busca instanciada");

            AAvl.setDebug(true);
            if (AAvl.getDebug()) System.out.println("debug ligado");
            else System.out.println("debug desligado");

            // Configurar comparador na árvore
            //AAvl.setComparer(IntComparator);
            GenericComparator GC = AAvl.getComparer();
            System.out.println("Configurado comparador de tipo: " + GC.getStrType());
            
            // teste de inserção
            System.out.println("TESTE DE INSERÇÃO");

            // Ler entradas do arquivo e inserir na árvore
            int inseridos = 0;
            try {
                Scanner scanner = new Scanner(new File(arquivo));
                while (scanner.hasNextInt()) {
                    int value = scanner.nextInt();
                    try {
                        AAvl.include(value);
                        inseridos++;                   
                        System.out.println("Inserido o nó: " + value);
                        numerosUnicos.add(value);
                    }
                    catch (Exception ex) {
                        System.out.println("Não foi possível inserir: "+ value +"\n"+ ex.getMessage()); 
                    }
                    // Mostrar status da árvore
                    statusArvore(AAvl);    
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
                        AAvl.remove(value);
                        removidos++;                   
                        System.out.println("Removido o nó: " + value);
                    }
                    catch (Exception ex) {
                        throw new Exception("Não foi possível remover: "+ value +"\n"+ ex.getMessage()+"\n");    
                    }
                    // Mostrar status da árvore
                    statusArvore(AAvl);    
                }
            } catch (Exception e) {
                throw new Exception("Erro ao remover itens da árvore!\n" + e.getMessage()+"\n");
            }  
            System.out.println("Teste bem sucedido");
        }
        catch (Exception e) {
            System.out.println("Erro durante o teste!\n"+e.getMessage());
        }        
    }

    public static void statusArvore(ArvoreAvl<Integer> AAvl) {
        //AAvl.status();
        AAvl.show();
    }
}
