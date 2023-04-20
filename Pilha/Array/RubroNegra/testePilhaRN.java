public class testePilhaRN {
	public static void main(String[] args) {
    int tamanho = 1;
    int inseridos = 12;
    int removidos = 4;
		PilhaRN p = new PilhaRN(tamanho);
		System.out.println("inserindo " + inseridos + " números");

    /*p.push(2, true);
    p.push(5, true);
    p.push(8, true);
    p.push(7, false);
    p.push(3, false);
    p.push(1, false);*/
    
		for(int i = 0; i < inseridos; i++){
      if (i%2 == 0)
        p.push(i, true);
      else p.push(i, false);
		  System.out.println(i);		  
		}
   
    System.out.print("Pilha Rubra ");	
    p.printPilha(true);
    System.out.print("Pilha Negra ");	
    p.printPilha(false);
    System.out.println("Estrutura Pilha Rubro-Negra");	
    p.printPilhaRN();

    /*System.out.println("inserindo " + 1 + " número");
    p.push(5, false);
    System.out.println(5);


    System.out.print("Pilha Rubra ");	
    p.printPilha(true);
    System.out.print("Pilha Negra ");	
    p.printPilha(false);
    System.out.println("Estrutura Pilha Rubro-Negra");	
    p.printPilhaRN();*/

    
		System.out.println("retirando " + removidos + " Números");
    System.out.println("topo - retirado");

    /*p.pop(true);
    p.pop(false);*/
    
		for(int i = 0; i < removidos; i++){ 
      if (i%2 == 0) {
        System.out.print(p.top(true));
        System.out.print(" - ");
        System.out.println(p.pop(true));
      } else {
        System.out.print(p.top(false));
        System.out.print(" - ");
        System.out.println(p.pop(false));
      }
		}
    
    System.out.print("Pilha Rubra ");	
    p.printPilha(true);
    System.out.print("Pilha Negra ");	
    p.printPilha(false);
    System.out.println("Estrutura Pilha Rubro-Negra");	
    p.printPilhaRN();
	}
}
