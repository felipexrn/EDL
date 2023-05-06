public class testeVector {
	public static void main(String[] args) {
		int in = 10, out = 3, cir = 2;
    Vector v = new Vector(1);
    System.out.println("Entrando " + in + " elementos");
    // j 0 0 1 2
    // i 0 1 2 3
    // V[0, , , ]
    // V[1,0, , ]
    // V[2,1,0, ]
    for (int i = 0; i < in; i++) {
      v.insertAtRank(0, i); 
      System.out.println(i);
    }
    System.out.println("A Fila contém " + v.size() + " elementos");
    System.out.println("Estrutura da Fila");
    System.out.println(v.strStruct());
    System.out.println("Estado da Fila");
    System.out.println(v.toString());
    //System.out.println("O menor elemento da Fila é " + f.acessSmaller());
    
    System.out.println("Saindo " + out + " elementos");
    for (int i = 0; i < out; i++) {
      System.out.println(v.elementAtRank(i));
      v.removeAtRank(i);
    }
    
    System.out.println("A Fila contém " + v.size() + " elementos");
    System.out.println("Estrutura da Fila");
    System.out.println(v.strStruct());
    System.out.println("Estado da Fila");
    System.out.println(v.toString());
    //System.out.println("O menor elemento da Fila é " + f.acessSmaller());

    for (int i = 0; i < cir; i++) {
      System.out.println("Entrou " + i);
      v.insertAtRank(i / 2, i);
      System.out.println("Saiu " + i);
      v.removeAtRank(i / 2);
    }

    System.out.println("A Fila contém " + v.size() + " elementos");
    System.out.println("Estrutura da Fila");
    System.out.println(v.strStruct());
    System.out.println("Estado da Fila");
    System.out.println(v.toString());
    //System.out.println("O menor elemento da Fila é " + f.acessSmaller());

    System.out.println("Esvazinado a Fila");
    while (v.size() > 0) {
      System.out.println("Saiu " + v.removeAtRank(0));
    }

    System.out.println("A Fila contém " + v.size() + " elementos");
    System.out.println("Estrutura da Fila");
    System.out.println(v.strStruct());
    System.out.println("Estado da Fila");
    System.out.println(v.toString());

    System.out.println("Teste de excecão");
    System.out.println(v.removeAtRank(0));
	}
}
