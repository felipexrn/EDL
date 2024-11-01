import java.util.Scanner;
public class Personalidade {
  // classe genérica personalidade
  protected String nome;
  protected String falha;
  protected String sucesso;
  private int estado; // 0 espera, 1 compilando, 2 falha,
  public void espera() {
    System.out.println("Aguardando caminho do arquivo para compilar");
    Scanner scan = new Scanner(System.in);
    String mensagem = scan.next();
    compilar(mensagem); // ./d3bb13/teste.java
  }
  public void compilar(String arquivo) {
    try {
      String comando = "javac " + arquivo;
      Process run = Runtime.getRuntime().exec(comando);
      System.out.println(sucesso);
    } catch (Exception e) {
      System.out.println(e);
      System.out.println(falha);
    }
  }
  public void falha() {}
  public String getNome() {
    return nome;
  }
  public String tilte() {
    return "Eu nunca fa...fa..fal... falho!";
  }
}