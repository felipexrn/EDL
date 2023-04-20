import java.io.IOException;
import java.util.Scanner;
class main {
  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    String mensagem = scan.nextLine();
    char teste = (char)System.in.read();
    System.out.println(teste);
    System.out.println(mensagem);
    int a, b, soma;
    a = 32;
    b = 41;
    soma = a + b;
    System.out.println(soma);
  }
}