public class testePilha {
	public static void main(String[] args) {
    int in = 10, out = 5, tam = 1, tax = 10;
    boolean fator = true;
    String[] nomesPilhas = {"p1", "p2"};
		Pilha p1 = new Pilha(tam, fator, tax);
		System.out.println("inserindo " + in + " elementos na pilha " + nomesPilhas[0]);
		for(int i = 0; i < in; i++){
      p1.push(i);
		  System.out.println(i);		  
		}
    p1.toString();
		System.out.println("retirando " + out + " elementos na pilha " + nomesPilhas[0]);
    System.out.println("topo - retirado");
		for(int i = 0; i < out; i++){  
			System.out.print(p1.top());
      System.out.print(" - ");
      System.out.println(p1.pop());
		}
    System.out.println("Estado inicial da pilha " + nomesPilhas[0] + " antes do empty()");	
    System.out.println(p1.toString());
    p1.empty();
    System.out.println("Estado final da pilha " + nomesPilhas[0] + " após o empty()");	
    System.out.println(p1.toString());
    System.out.println("inserindo " + out + " elementos na pilha " + nomesPilhas[0]);
		for(int i = 0; i < out; i++){
      p1.push(i);
		  System.out.println(i);		  
		}
    Pilha p2 = new Pilha(tam, fator, tax);
    System.out.println("inserindo " + out + " elementos na pilha " + nomesPilhas[1]);
		for(int i = 0; i < out; i++){
      p2.push(i);
		  System.out.println(i);		  
		}
    System.out.println("Estado inicial das pilhas " + nomesPilhas[0] +  " e " + nomesPilhas[1] + " antes do adiconaPilha()");	
    System.out.println(p1.toString());
    System.out.println(p2.toString());
    p1.adicionaPilha(p2);
    System.out.println("Estado final das pilhas " + nomesPilhas[0] +  " e " + nomesPilhas[1] + " depois do adiconaPilha()");	
    System.out.println(p1.toString());
    System.out.println(p2.toString());
	}
}
