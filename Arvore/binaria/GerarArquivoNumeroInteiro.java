import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GerarArquivoNumeroInteiro {
    public static void main(String[] args) {
        // Gera 1000 números inteiros aleatórios e únicos
        ArrayList<Integer> numerosUnicos = new ArrayList<>();
        Random random = new Random();
        while (numerosUnicos.size() < 1000) {
            int numero = random.nextInt(1000); // Gera número entre 0 e 1000
            if (!numerosUnicos.contains(numero))
                numerosUnicos.add(numero);
        }

        // Escreve os números no arquivo
        String nome = "insercao.txt";
        try (FileWriter writer = new FileWriter(nome)) {
            for (Integer numero : numerosUnicos) {
                writer.write(numero + "\n");
            }
            System.out.println("Arquivo de entrada " + nome + " gerado com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao gerar o arquivo: " + nome + "\n" + e.getMessage());
        }
    }
}
