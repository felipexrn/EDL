public class testePilha {
	public static void main(String[] args) {	
    int in = 1000;
    int out = 5;
		PilhaVector pv = new PilhaVector();
    System.out.println("Tamanho da Pilha: " + pv.size());
		System.out.println("inserindo " + in + " elementos");
		for(int i = 0; i < in; i++){  
		  pv.push(i);
		}
    System.out.println(pv.list());
    System.out.println("Tamanho da Pilha: " + pv.size());
		System.out.println("retirando " + out + " elementos");
    System.out.println("topo - removido");
		for(int i = 0; i < out; i++){
			  System.out.print(pv.top());
			  System.out.println(" - " + pv.pop());
		}
    System.out.println(pv.list());
    System.out.println("Tamanho da Pilha: " + pv.size());
	}
}
