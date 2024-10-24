import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArvoreJava {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        // Ler entradas do arquivo e inserir na árvore
        int inseridos = 0;
        try {
            Scanner scanner = new Scanner(new File("insercao.txt"));
            while (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                treeMap.put(value, value); 
                inseridos++;                
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }

        System.out.println("Inseridos: " + inseridos + " nós");

        // Imprimindo a árvore de maneira estruturada
        printTree(treeMap);
    }

    // Função para imprimir a árvore estruturada
    private static void printTree(TreeMap<Integer, Integer> treeMap) {
        treeMap. get(treeMap.firstKey());
    }
}
