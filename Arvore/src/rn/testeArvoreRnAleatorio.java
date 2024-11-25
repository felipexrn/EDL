import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import Arvore.src.rn.*;
import Arvore.src.binaria.GerarArquivoNumeroInteiro;
import Arvore.src.binaria.GenericComparator;

public class testeArvoreRnAleatorio {
    public static void main(String[] args) {
        try {
            // Cores para destaque na impressão
            String corVermelho = "\033[31m";
            String corVerde = "\033[32m";
            String corPadrao = "\033[0m";

            // Arquivo para inserção de números aleatórios
            String arquivo = "Arvore/src/rn/insercao.txt";

            // Gera numeros Aleatórios a inserir
            GerarArquivoNumeroInteiro.main(new String[] {arquivo, args[0]});
            
            // Sorteia numeros a remover
            ArrayList<Integer> numerosUnicos = new ArrayList<>();

            // Comparador de inteiros e arvore instanciados
            //GenericComparator<Integer> IntComparator = new GenericComparator<>(0); // 0=inteiros
            ArvoreRn<Integer> ARn = new ArvoreRn<Integer>(0);
            System.out.println("Arvore Rubro negra instanciada");

            ARn.setDebug(true);
            if (ARn.getDebug()) System.out.println("debug ligado");
            else System.out.println("debug desligado");

            // Configurar comparador na árvore
            //ARn.setComparer(IntComparator);
            GenericComparator GC = ARn.getComparer();
            System.out.println("Configurado comparador de tipo: " + GC.getStrType());
            
            // teste de inserção
            System.out.println("TESTE DE INSERÇÃO");

            // Ler entradas do arquivo e inserir na árvore
            int inseridos = 0;
            try {
                Scanner scanner = new Scanner(new File(arquivo));
                while (scanner.hasNextInt()) {
                    Integer value = scanner.nextInt();
                    try {
                        System.out.println(corVerde + "Inserindo o nó: " + value + corPadrao);
                        ARn.include(value);
                        inseridos++;                   
                        numerosUnicos.add(value);
                    }
                    catch (Exception ex) {
                        System.out.println("Não foi possível inserir: "+ value +"\n"+ ex.getMessage()); 
                    }
                    // Mostrar status da árvore
                    statusArvore(ARn);
                    ARn.verifyRn();  
                }
                scanner.close();                
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException("Arquivo '" + arquivo + "' não encontrado!\n" + e.getMessage());
            } catch (Exception e) {
                throw new Exception("Erro ao inserir itens na árvore!\n" + e.getMessage());
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
                        System.out.println(corVermelho + "Removendo o nó: " + value + corPadrao);
                        ARn.remove(value);
                        removidos++;                   
                    }
                    catch (Exception ex) {
                        throw new Exception("Não foi possível remover: "+ value +"\n"+ ex.getMessage());    
                    }
                    // Mostrar status da árvore
                    statusArvore(ARn); 
                    ARn.verifyRn();   
                }
            } catch (Exception e) {
                throw new Exception("Erro ao remover itens da árvore!\n" + e.getMessage());
            }  
            System.out.println("Teste bem sucedido");
        }
        catch (Exception e) {
            System.out.println("Erro durante o teste!\n" + e.getMessage());
        }        
    }

    public static void statusArvore(ArvoreRn<Integer> ARn) {
        //ARn.status();
        ARn.show();
        System.out.println();
    }
}
