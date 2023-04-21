import java.util.Scanner;
public class Atendimento {
  public static void menu(Fila f) { // exibe menu na tela
    System.out.println("Menu Digite o número para executar uma função:");
    System.out.println("1 - Novo paciente na fila");
    System.out.println("2 - Próximo paciente a ser atendido");
    System.out.println("3 - Quantidade de pacientes em espera");
    System.out.println("4 - FIM");
    Scanner scan = new Scanner(System.in);
    int opcao = Integer.parseInt(scan.nextLine());
    switch (opcao) {
      case 1:
        novoPaciente(f);
      break;
      case 2:
        proximoPaciente(f);
      break;
        case 3:
        filaDeEspera(f);
      break;
        case 4:
        encerrarPrograma();
      break;
    }
  } 
  public static void novoPaciente(Fila f) { // insere nome de um paciente na fila
    System.out.println("Digite o nome do paciente que irá entrar na fila:");
    Scanner scan = new Scanner(System.in);
    String nomePaciente = scan.nextLine();
    f.enqueue(nomePaciente);
  } 
  public static void proximoPaciente(Fila f) { // retira um paciente da fila e exibe seu nome
    System.out.println("Próximo paciente: " + f.dequeue());
  }
  public static void filaDeEspera(Fila f) { // exibe a quantidade de pacientes em espera na fila
    System.out.println("Existem " + f.size() + " pacientes em espera");
  }
  public static void encerrarPrograma() { // encerra programa
    System.out.println("FIM");
    System.exit(0);
  }
  public static void main(String[] args) {
    Fila f = new Fila(1, true, 0);
    while(true) menu(f);
  }
}

