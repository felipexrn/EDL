public class expressaAritmetica {
  public boolean verificaExpressa(String expressa) {
    PilhaArray P = new PilhaArray(1, false, 1);
    Character[] abertura = {'(', '{', '['}; 
    Character[] fechamento = {')', '}', ']'}; 
    for (int i = 0; i < expressa.length(); i++) {
      boolean eAbertura = false;
      for (int j = 0; j < 3; j++) {
        eAbertura = (expressa.charAt(i) == abertura[j]) || eAbertura; 
      }
      if (eAbertura) P.push(expressa.charAt(i));
      else {
        if (P.size() == 0)
          return false;
        Object ultimaAbertura = P.pop();
        Object fechamentoAtual = expressa.charAt(i);
        for (int k = 0; k < 3; k++)
          if (fechamentoAtual == fechamento[k]) fechamentoAtual = abertura[k];
        if (fechamentoAtual != ultimaAbertura) {
          System.out.println(
            "Caracter Atual " + fechamentoAtual +
            "\nPosição " + i +
            "\nÚltima Abertura " + ultimaAbertura +
            "\nPosição " + (P.size() - 1)
          );
          return false;
        }
      }
    }
    if (P.size() > 0)
      return false;
    return true;
  }
  public static void main(String[] args) {
    expressaAritmetica E = new expressaAritmetica();
    System.out.println(E.verificaExpressa(args[0]));
  }
}
// {[()]}{[]}({[]}[(){()}]){({[]})}{[({})]}{({()})}[(){()}]{[]}[({()})] expressão correta de 100 caracteres