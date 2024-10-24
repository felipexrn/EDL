import java.util.*;
public class interfaceArvore {
  public static void main(String[] args) {
    int selecionado;
    Scanner ler = new Scanner(System.in);
    ArrayList<String> metodos = new ArrayList<String>();
      metodos.add("metodo 1");
      metodos.add("metodo 2");
      metodos.add("metodo 3");
      metodos.add("metodo 4");
      metodos.add("metodo 5");
      metodos.add("metodo 6");
      metodos.add("metodo 7");

    while (true) {
      listaMetodos(metodos);
      selecionado = selecionaMetodo(ler);
      
      for (int i = 0 ; i < metodos.size(); i++) {
        if (selecionado == i) {
          System.out.println(metodos.get(i));
          break;  
        }
      }     
      
    }
  }
  public static void listaMetodos(ArrayList<String> metodos) {
    for (int i = 0; i < metodos.size(); i++) {
      System.out.println(i + ": " + metodos.get(i));
    }
  }
  public static int selecionaMetodo(Scanner ler) {
    try {
      return ler.nextInt();
    }
    catch(Exception e) {
      System.out.println("Comando inválido. Selecione outro método");
    } 
    return 0;
  }
} 