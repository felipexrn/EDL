import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import Arvore.src.binaria.*;

public class testeArvoreBinariaAleatoria {
    public static void main(String[] args) {
        // Gera numeros Aleatórios a inserir
        GerarArquivoNumeroInteiro.main(new String[] {"Arvore/src/binaria/insercao.txt", args[0]});
        
        // Sorteia numeros a remover
        ArrayList<Integer> numerosUnicos = new ArrayList<>();

        // Comparador de inteiros e arvore instanciados
        //GenericComparator<Integer> IntComparator = new GenericComparator<>(0); // 0=inteiros
        ArvoreBinaria AB = new ArvoreBinaria(0);
        System.out.println("Arvore binária de busca instanciada");

        // Configurar comparador na árvore
        //AB.setComparer(IntComparator);
        GenericComparator GC = AB.getComparer();
        System.out.println("Configurado comparador de tipo: " + GC.getStrType());

        // teste de inserção
        System.out.println("TESTE DE INSERÇÃO");

        // Ler entradas do arquivo e inserir na árvore
        int inseridos = 0;
        try {
            Scanner scanner = new Scanner(new File("Arvore/src/binaria/insercao.txt"));
            while (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                try {
                    AB.include(value);
                    inseridos++;                   
                    System.out.println("Inserido o nó: " + value);
                    numerosUnicos.add(value);
                }
                catch (Exception ex) {
                    System.out.println("Não foi possível inserir: "+ value +"\n"+ ex.getMessage()); 
                }
                // Mostrar status da árvore
                statusArvore(AB);    
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
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
                    AB.remove(value);
                    removidos++;                   
                    System.out.println("Removido o nó: " + value);
                }
                catch (Exception ex) {
                    System.out.println("Não foi possível remover: "+ value +"\n"+ ex.getMessage());    
                }
                // Mostrar status da árvore
                statusArvore(AB);    
            }
        } catch (Exception e) {
            System.out.println("Erro ao remover itens da árvore:\n" + e.getMessage());
        }          
    }

    public static void statusArvore(ArvoreBinaria AB) {
        //AB.status();
        AB.show();
    }
}
