import java.util.*;
// comparador de strings ou inteiros
// Use t=0 para comparar inteiros
// Use t=1 para comparar strings
public class GenericComparator {
  private int type;
  public GenericComparator(int t) {
    // t=0 para inteiros
    // t=1 para strings
    type = t;
  }
  public int compareTo(Node n1, Node n2) {
    // seleciona o tipo de comparação de acordo com type
    switch (type) {
      case 0: return IntCompare(n1, n2); 
      case 1: return StrCompare(n1, n2);
    }   
    return 0;
  }
  // comparador de inteiro
  private int IntCompare(Node n1, Node n2) {
    int a = (int) n1.getKey();
    int b = (int) n2.getKey(); 
    if (a > b) return 1;
    if (a < b) return -1;
    return 0;
  }
  // Comparador de String
  private int StrCompare(Node n1, Node n2) {
    String a = (String) n1.getKey();
    String b = (String) n2.getKey(); 
    int r, t;
    char A, B;
    t = Math.max(a.length(), b.length());
    for (int i = 0; i < t; i++) {
      A = a.charAt(i);
      B = b.charAt(i);
      if (A == B) continue;
      if (A > B) return 1;
      if (A < B) return -1;
    }
    return 0;
  }
  // Retorna o tipo do comparador
  public String getStrType() {
    switch (type) {
      case 0: return "int"; 
      case 1: return "String";
    }   
    return "does not exist this type";
  }
  // Retorna o tipo do comparador
  public int getType() {
    return type;
  }
}