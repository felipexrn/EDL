import java.io.*;
import java.util.Scanner;
import java.util.Calendar;
public class d3bb13 {
  public static void main(String args[]) {
    Calendar cal = Calendar.getInstance();
    Segunda pers = new Segunda(); 
    /*if (cal.get(Calendar.DAY_OF_WEEK) == 7) {
      Segunda pers = new Segunda(); 
    } else {
      Segunda pers = new Segunda();
    }*/
    System.out.println("hoje é " + pers.getNome());
    //while(true) pers.espera();
    try {
      // Ler caminho do arquivo
      System.out.println("Aguardando caminho do arquivo para compilar");
      Scanner scan = new Scanner(System.in);
      String arquivo = scan.nextLine();
      String comando = "javac " + arquivo;

      // Executar o comando de compilação
      Process process = Runtime.getRuntime().exec("javac " + comando);

      // Capturar a saída do processo
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }

      // Esperar pelo término do processo
      int exitCode = process.waitFor();

      if (exitCode == 0) {
        System.out.println(pers.sucesso);
      } else {
        System.out.println(pers.falha);
      }
      
    } catch (IOException | InterruptedException e) {
      System.out.println(pers.tilte());
      e.printStackTrace();
    }
  }
}