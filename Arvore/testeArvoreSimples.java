public class testeArvoreSimples {
  public static void main(String args[]) {
    ArvoreSimples A = new ArvoreSimples(1);
    System.out.println("raiz é " + A.root().element());

    System.out.println("inserindo filhos 2, 3 e 4 em raiz");
    A.addChild(A.root(), 2);
    A.addChild(A.root(), 3);
    A.addChild(A.root(), 4);
    System.out.println("inserindo filho 5 em 3");
    A.addChild(A.find(3), 5);
    System.out.println("inserindo filho 6 em 4");
    A.addChild(A.find(4), 6);
    System.out.println("inserindo filho 7 em 6");
    A.addChild(A.find(6), 7);

    System.out.println("os filhos de raiz são " + A.strChildren(A.root()));
    String resposta = "";
    if (A.isInternal(A.find(7))) resposta = "não é";
    if (A.isExternal(A.find(7))) resposta = "é";
    System.out.println("o elemento 7 " + resposta + " externo");

    if (A.isInternal(A.find(6))) resposta = "é";
    if (A.isExternal(A.find(6))) resposta = "não é";
    System.out.println("o elemento 6 " + resposta + " interno");

    if (A.isRoot(A.find(3))) resposta = "é";
    else resposta = "não é";
    System.out.println("o elemento 3 " + resposta + " raiz");
    
    System.out.println("o pai de 7 é " + A.find(7).parent().element());
    System.out.println("altura da arvore é " + A.height());
    System.out.println("produndidade do elemento 4 é " + A.depth(A.find(4)));
    System.out.println("produndidade do elemento 6 é " + A.depth(A.find(6)));
    System.out.println("produndidade do elemento 7 é " + A.depth(A.find(7)));
    System.out.println("elemento " + A.remove(A.find(7)) + " removido");
    System.out.println("altura da arvore é " + A.height());
    System.out.println("o tamanho da árvore é " + A.size());
    System.out.println("trocando elemento 3 pelo elemento 4");
    A.swapElements(A.find(3), A.find(4));
    System.out.println("os filhos de raiz são " + A.strChildren(A.root()));
    System.out.println("os filhos de 3 são " + A.strChildren(A.find(3)));
    System.out.println("os filhos de 4 são " + A.strChildren(A.find(4)));
    System.out.println("trocando elemento " + A.replace(A.find(3), 7) + " por 7");
    System.out.println("os filhos de 7 são " + A.strChildren(A.find(7)));
  } 
}