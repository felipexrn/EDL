public class testStack {
	public static void main(String[] args) {	
    int in = 10;
    int out = 5;
		StackVector pv = new StackVector();
    
    System.out.println("Tamanho da Pilha: " + pv.size());
		System.out.println("inserindo " + in + " elementos");
		for(int i = 0; i < in; i++){  
		  pv.enqueue(i);
		}
    System.out.println(pv.toString());
    System.out.println("Tamanho da Pilha: " + pv.size());
    
		System.out.println("retirando " + out + " elementos");
    System.out.println("topo - removido");
		for(int i = 0; i < out; i++){
      System.out.print(pv.first());
      System.out.println(" - " + pv.dequeue());
		}
    System.out.println("Tamanho da Pilha: " + pv.size());
    System.out.println(pv.toString());

    System.out.println("retirando " + out + " elementos");
    System.out.println("topo - removido");
    for(int i = 0; i < out; i++){
      System.out.print(pv.first());
      System.out.println(" - " + pv.dequeue());
		}
    System.out.println("Tamanho da Pilha: " + pv.size());
    System.out.println(pv.toString());
    
    System.out.println("Teste de Exceção");
    for(int i = 0; i < out; i++){
      System.out.print(pv.first());
      System.out.println(" - " + pv.dequeue());
		}
    
	}
}
