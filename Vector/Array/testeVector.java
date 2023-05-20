public class testeVector {
	public static void main(String[] args) {
		int in = 10, out = 3;
    Vector v = new Vector(1);
    System.out.println("Entrando " + in + " elementos");
    for (int i = 0; i < in; i++) {
      v.insertAtRank(0, i); 
      System.out.println(i);
    }
    System.out.println("O Vetor contém " + v.size() + " elementos");
    System.out.println("Estrutura do Vetor");
    System.out.println(v.strStruct());
    System.out.println("Estado do Vetor");
    System.out.println(v.toString());
    
    System.out.println("Saindo " + out + " elementos");
    for (int i = 0; i < out; i++) {
      System.out.println(v.elementAtRank(i));
      v.removeAtRank(i);
    }
    
    System.out.println("O Vetor contém " + v.size() + " elementos");
    System.out.println("Estrutura do Vetor");
    System.out.println(v.strStruct());
    System.out.println("Estado do Vetor");
    System.out.println(v.toString());

    System.out.println("subistituindo " + v.size() + " elementos");
    for (int i = 0; i < v.size(); i++) {
      System.out.println(v.elementAtRank(i) + " por " + i*2);
      v.replaceAtRank(i, i*2);
    }

    System.out.println("O Vetor contém " + v.size() + " elementos");
    System.out.println("Estrutura do Vetor");
    System.out.println(v.strStruct());
    System.out.println("Estado do Vetor");
    System.out.println(v.toString());

    System.out.println("Esvazinado o Vetor");
    while (v.size() > 0) {
      System.out.println("Saiu " + v.removeAtRank(0));
    }

    System.out.println("O Vetor contém " + v.size() + " elementos");
    System.out.println("Estrutura do Vetor");
    System.out.println(v.strStruct());
    System.out.println("Estado do Vetor");
    System.out.println(v.toString());

    System.out.println("Teste de excecão");
    try {
      System.out.println("Removendo elemento de Vetor vazio");
      System.out.println(v.removeAtRank(0));
      System.out.println("Elemento removido de Vetor vazio");
    }
    catch (Exception e) {
      System.out.println(e);
      try {
        System.out.println("inserindo elemento índice inválido");
        v.insertAtRank(-1, 0); 
        System.out.println("Elemento inserido em índice inválido");
      } catch (Exception f) {
        System.out.println(f);
        System.out.println("\nTeste concluído");
      }      
    }
	}
}
