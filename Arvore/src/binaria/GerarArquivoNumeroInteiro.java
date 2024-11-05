package Arvore.src.binaria;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GerarArquivoNumeroInteiro {
    public static void main(String[] args) {
        // Gera N números inteiros aleatórios e únicos
        ArrayList<Integer> numerosUnicos = new ArrayList<>();
        Random random = new Random();
        int tamanho = Integer.parseInt(args[1]);
        while (numerosUnicos.size() < tamanho) {
            int numero = random.nextInt(tamanho * tamanho);
            if (!numerosUnicos.contains(numero))
                numerosUnicos.add(numero);
        }

        // Escreve os números no arquivo
        String nome = args[0];
        try (FileWriter writer = new FileWriter(nome)) {
            for (Integer numero : numerosUnicos) {
                writer.write(numero + "\n");
            }
            System.out.println("Arquivo " + nome + " gerado com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao gerar o arquivo: " + nome + "\n" + e.getMessage());
        }
    }
}
