import java.io.*;

public class comp {
  public static void main(String[] args) {
    try {
      // Caminho para o arquivo do programa a ser compilado
      String sourceFilePath = "teste.java";

      // Executar o comando de compilação
      Process process = Runtime.getRuntime().exec("javac " + sourceFilePath);

      // Capturar a saída do processo
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }

      // Esperar pelo término do processo
      int exitCode = process.waitFor();

      if (exitCode == 0) {
        System.out.println("Compilação concluída com sucesso.");
      } else {
        System.out.println("Falha na compilação.");
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
