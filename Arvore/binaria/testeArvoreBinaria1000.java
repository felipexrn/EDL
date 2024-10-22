import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testeArvoreBinaria1000 {
    public static void main(String[] args) {
        // Comparador de inteiros e arvore instanciados
        GenericComparator IntComparator = new GenericComparator(0); // 0=inteiros
        ArvoreBinaria AB = new ArvoreBinaria();

        // Configurar comparador na árvore
        AB.setComparer(IntComparator);
        GenericComparator GC = AB.getComparer();
        System.out.println("Tipo: " + GC.getType() + ", comparador de " + GC.getStrType());
        System.out.println();

        // Ler entradas do arquivo e inserir na árvore
        int inseridos = 0;
        try {
            Scanner scanner = new Scanner(new File("insercao.txt"));
            while (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                AB.include(value);                
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }

        System.out.println("Inseridos: " + inseridos + " nós");

        // Mostrar status da árvore
        statusArvore(AB);      
    }

    public static void statusArvore(ArvoreBinaria AB) {
        System.out.println("Height: " + AB.height(AB.getRoot()));
        System.out.println("Size: " + AB.size());
        System.out.println("Nodes: " + AB.strNodes());
        System.out.println("Keys: " + AB.strElements());
        System.out.println("Depths: " + AB.strDepths());
        AB.show();
    }
}
