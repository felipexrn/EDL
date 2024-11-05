package Arvore.src.binaria;
import java.util.*;
import java.util.function.Consumer;
import Arvore.src.avl.NodeAvl;
import Arvore.src.rn.NodeRn;
// comparador de strings ou inteiros
// Use t=0 para comparar inteiros
// Use t=1 para comparar strings
// Use t=2 para comparar doubles
public class GenericComparator<T extends Comparable<T>> {
  private String[] types = {"int", "String", "Double"};
  private int type;
  private Node<T> nodeType;
  public GenericComparator(int type) {
    setType(type);
  }
  public String setType(int t) {
    if ((type < 0) || (type >= types.length)) return "does not exist this type";
    else {
      // t=0 para inteiros
      // t=1 para strings
      // t=2 para double
      type = t;
      return types[type];
    }
  }
  public int compareTo(Node<T> n1, Node<T> n2) {
    switch (type) {
        case 0: return IntCompare(n1, n2); 
        case 1: return StrCompare(n1, n2);
        case 2: return DoubleCompare(n1, n2);
        default: return 0;
    }
  }
  /*public int compareTo(Object n1, Object n2) {
    int nodeType = getNodeType(n1);
    switch(nodeType) {
      case 0:
        n1 = (Node) n1;
        n2 = (Node) n2;
        break;
      case 1:
        n1 = (NodeAvl) n1;
        n2 = (NodeAvl) n2;
        break;
      case 2:
        n1 = (NodeRn) n1;
        n2 = (NodeRn) n2;
        break;
    }
    // seleciona o tipo de comparação de acordo com type
    switch (type) {
      case 0: return IntCompare(n1, n2); 
      case 1: return StrCompare(n1, n2);
      case 2: return DoubleCompare(n1, n2);
    }   
    return 0;
  }*/


  private int IntCompare(Node<T> n1, Node<T> n2) {
    return Integer.compare((Integer) n1.getKey(), (Integer) n2.getKey());
  }

  private int StrCompare(Node<T> n1, Node<T> n2) {
      return ((String) n1.getKey()).compareTo((String) n2.getKey());
  }

  private int DoubleCompare(Node<T> n1, Node<T> n2) {
      return Double.compare((Double) n1.getKey(), (Double) n2.getKey());
  }



  // comparador de int
  /*private int IntCompare(Node<T> n1, Node<T> n2) {
    Integer a = (Integer) n1.getKey();
    Integer b = (Integer) n2.getKey(); 
    if (a > b) return 1;
    if (a < b) return -1;
    return 0;
  }
  // Comparador de String
  private int StrCompare(Node<T> n1, Node<T> n2) {
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
  // comparador de double
  private int DoubleCompare(Node<T> n1, Node<T> n2) {
    Double a = (Double) n1.getKey();
    Double b = (Double) n2.getKey(); 
    if (a > b) return 1;
    if (a < b) return -1;
    return 0;
  }*/
  // Retorna o tipo do comparador
  public int getType() {
    return type;
  }
  // Retorna quatidade de tipos de comparadores
  public int getQtdTypes() {
    return types.length;
  }
  // Retorna o tipo do comparador
  public String getStrType() {
    if ((type < 0) || (type >= types.length)) return "does not exist this type";
    else return types[type];
  }
  // Retorna lista de tipos de comparadores
  public String getStrTypes() {
    String s = "";
    for (int i = 0; i < types.length; i++) {
      s += types[i];
      s += "\n";
    }
    return s;
  }
  // teste de comparadores
  /*public String testComparator() {
    String r = ""; // resultado final do teste
    String p = ""; // resultado parcial do teste
    
    Node<Integer> n1 = new Node<>(null, 0);
    Node<Integer> n2 = new Node<>(null, 1);
    try {if (IntCompare(n1, n2) < 0) p = "ok";}
    catch(Exception e) {p = "error";}
    r += String.format("%s - %s\n",types[0], p);
    
    Node<String> n3 = new Node<>(null, "A");
    Node<String> n4 = new Node<>(null, "B");
    try {if (StrCompare(n3, n4) < 0) p = "ok";}
    catch(Exception e) {p = "error";}
    r += String.format("%s - %s\n",types[1], p);
    
    Node<Double> n5 = new Node<>(null, 0.1);
    Node<Double> n6 = new Node<>(null, 0.2);
    try {if (DoubleCompare(n5, n6) < 0) p = "ok";}
    catch(Exception e) {p = "error";}
    r += String.format("%s - %s\n",types[2], p);
    
    return r;
  }*/
  /*public int getNodeType(Object o) {
    Node bst;
    NodeAvl avlt;
    NodeRn rnt;
    try {
      bst = (Node) o;
      return 0;
    }
    catch(Exception e) {
      try {
        avlt = (NodeAvl) o;
        return 1;
      }
      catch(Exception e) {
        try {
          rnt = (NodeRn) o;
          return 2;
        }
        catch(Exception e) {
          System.out.println(e);
        }
      }
    }
  }*/
  public int getNodeType() {
    if (nodeType instanceof Node) return 0;
    if (nodeType instanceof NodeAvl) return 1;
    if (nodeType instanceof NodeRn) return 2;
    return -1; // Retorno padrão para casos inválidos
  }
  public String getStrNodeType() {
    if (nodeType instanceof Node) return "Node";
    if (nodeType instanceof NodeAvl) return "NodeAvl";
    if (nodeType instanceof NodeRn) return "NodeRn";
    return "Tipo de Node não conhecido"; // Retorno padrão para casos inválidos
  }
}