public class testeFila {
	public static void main(String[] args) {
		int in = 7, out = 3, cir = 3;
    Fila f = new Fila(1);
		try {
      System.out.println("Entrando " + in + " elementos");
      for (int i = 0; i < in; i++) {
        f.enqueue(i);
        System.out.println(i);
      }
      System.out.println("A Fila contém " + f.size() + " elementos");
      
      System.out.println("Saindo " + out + " elementos");
      for (int i = 0; i < out; i++) {
        System.out.println(f.first());
        if (i < out) f.dequeue();
      }
      
      System.out.println("A Fila contém " + f.size() + " elementos");
      System.out.println("Estrutura da Fila");
      System.out.println(f.strStruct());
      System.out.println("Estado da Fila");
      System.out.println(f.toString());
      
      for (int i = 0; i < cir; i++) {
        System.out.println("Entrou " + i);
        f.enqueue(i);
        System.out.println("Saiu " + f.first());
        f.dequeue();
      }

      System.out.println("A Fila contém " + f.size() + " elementos");
      System.out.println("Estrutura da Fila");
      System.out.println(f.strStruct());
      System.out.println("Estado da Fila");
      System.out.println(f.toString());

      System.out.println("Esvazinado a Fila");
      while (f.size() > 0) {
        System.out.println("Saiu " + f.first());
        f.dequeue();
      }

      System.out.println("A Fila contém " + f.size() + " elementos");
      System.out.println("Estrutura da Fila");
      System.out.println(f.strStruct());
      System.out.println("Estado da Fila");
      System.out.println(f.toString());

      System.out.println("Teste de excecão");
      System.out.println(f.dequeue());
      
		} catch(EmptyQueueException erro) {
			System.out.println("Empty queue " + erro.getMessage());
		}
	}
}
