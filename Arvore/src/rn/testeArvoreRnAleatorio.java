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
        // Cores para destaque na impressão
        String corAmarelo = "\033[43m";
        String corAzul = "\033[46m";
        String corVerde = "\033[32m";
        String corVermelho = "\033[31m";
        String corPadrao = "\033[0m";

        try {
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
                        System.out.println(corAzul + "Inserindo o nó: " + value + corPadrao);
                        ARn.include(value);
                        inseridos++;                   
                        numerosUnicos.add(value);
                    }
                    catch (Exception ex) {
                        System.out.println(corVermelho+"Não foi possível inserir: "+ value +"\n"+ ex.getMessage()+corPadrao); 
                    }
                    // Mostrar status da árvore
                    statusArvore(ARn);
                    ARn.verifyRn();  
                }
                scanner.close();                
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException(corVermelho+"Arquivo '" + arquivo + "' não encontrado!\n" + e.getMessage()+corPadrao);
            } catch (Exception e) {
                throw new Exception(corVermelho+"Erro ao inserir itens na árvore!\n" + e.getMessage()+corPadrao);
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
                        System.out.println(corAmarelo + "Removendo o nó: " + value + corPadrao);
                        ARn.remove(value);
                        removidos++;                   
                    }
                    catch (Exception ex) {
                        throw new Exception(corVermelho+"Não foi possível remover: "+ value +"\n"+ ex.getMessage()+corPadrao);    
                    }
                    // Mostrar status da árvore
                    statusArvore(ARn); 
                    ARn.verifyRn();   
                }
            } catch (Exception e) {
                throw new Exception(corVermelho+"Erro ao remover itens da árvore!\n" + e.getMessage()+corPadrao);
            }  
            System.out.println(corVerde+"Teste bem sucedido"+corPadrao);
        }
        catch (Exception e) {
            System.out.println(corVermelho+"Erro durante o teste!\n" + e.getMessage()+corPadrao);
        }        
    }

    public static void statusArvore(ArvoreRn<Integer> ARn) {
        //ARn.status();
        ARn.show();
        System.out.println();
    }
}
