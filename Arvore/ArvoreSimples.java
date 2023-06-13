import java.util.Iterator;
import java.util.ArrayList;
public class ArvoreSimples {
	No raiz;
	int tamanho;
	public ArvoreSimples(Object o) {
		// pai do raiz sempre e null
    raiz = new No(null, o);
		tamanho = 1;
	} // ok
	public No root() {
		return raiz;
	} // ok
	public No parent(No v) {
		return (v.parent());
	} // ok
	public Iterator children(No v) {
		return v.children();
	} // ok
	public boolean isInternal(No v) {
		return (v.childrenNumber() > 0);
	} // ok
	public boolean isExternal(No v) {
		return (v.childrenNumber() == 0);
	} // ok
	public boolean isRoot(No v) {
		return v == raiz;
	} // ok
	public void addChild(No v, Object o) {
		No novo = new No(v, o);
		v.addChild(novo);
		tamanho++;
	} // ok
	public Object remove(No v) {
    if (v == raiz) throw new InvalidNoException("Invalid No");
		No pai = v.parent();
		if (pai != null || isExternal(v))
			pai.removeChild(v);
		Object o = v.element();
		tamanho--;
		return o;
	} // ok
	public void swapElements(No v, No w) {
    Object o = v.element();
    v.setElement(w.element());
    w.setElement(o);
	}  // ok
	public int depth(No v) {
		int profundidade = profundidade(v);
		return profundidade;
	} // ok
	private int profundidade(No v) {
		if (v == raiz) return 0;
		else return 1 + profundidade(v.parent());
	} // ok
	public int height() {
		int altura = altura(raiz);
		return altura;
	} // ok
  private int altura(No v) {
    if (isExternal(v)) return 0;
    else {
      int h = 0;
      Iterator filhos = children(v);
      while(filhos.hasNext()){
        h = Math.max(h, altura((No)filhos.next()));
      }
      return 1 + h;
    }
  } // ok
  private ArrayList<Object> preOrdem(No v, ArrayList<Object> o) {
    //Iterator c = null;
    o.add(v);
    if (v.childrenNumber() > 0) {
      Iterator c = v.children();
      while(c.hasNext()) {
        preOrdem((No)c.next(), o);
      }
    }
    return o;
  }
	public Iterator elements() {
    ArrayList<Object> o = new ArrayList<Object>();
    ArrayList<Object> p = new ArrayList<Object>();
    o = preOrdem(raiz, o);
    o.forEach((obj) -> p.add(((No)obj).element())); 
		return p.iterator();
	} // ok
	public Iterator Nos() {
		ArrayList<Object> o = new ArrayList<Object>();
    ArrayList<Object> p = new ArrayList<Object>();
    o = preOrdem(raiz, o);
    o.forEach((obj) -> p.add(((No)obj))); 
		return p.iterator();
	}
	public int size() {
    return tamanho;
	} // ok
	public boolean isEmpty() {
		return false;
	} // ok
	public Object replace(No v, Object o) {
	 // Metodo que serve de exercicio
    Object p = v.element();
		v.setElement(o);
    return p;
	} // ok
  private No findObject(No v, Object o) {
    if (isInternal(v)) {
      Iterator filhos = children(v);
      while(filhos.hasNext()){
        No p = (No)filhos.next();
        if (p.element() == o) {
          v = p;
          return v;
        }
      }
      filhos = children(v);
      while(filhos.hasNext()){
        v = findObject((No)filhos.next(), o);
      }
    } else {
      if (v.element() == o) return v;
    }
    return v;
  } // ok
  public No find(Object o) {
    if (raiz.element() == o) return raiz;
    No v = findObject(raiz, o);  
    if(v.element() != o) throw new DoesNotExistNoException("Esto non ecxiste");
    return v;
  } // ok
  public String strChildren(No v) {
    String s = "{";
    Iterator c = children(v);
    int n = v.childrenNumber();
    while(c.hasNext()) {
      s += ((No)c.next()).element();
      n--;
      if (n > 0) s += ", ";
    }
    return s += "}";
  } // ok
  public String strElements() {
    Iterator i = elements();
    int n = tamanho;
    String s = "{";
    while(i.hasNext()) {
      s += i.next();
      n--;
      if (n > 0) s += ", ";
    }
    return s += "}";
  } // ok
  public String strNos() {
    String s = "{";
    Iterator i = Nos();
    int n = tamanho;
    while(i.hasNext()) {
      s += i.next();
      n--;
      if (n > 0) s += ", ";
    } // ok
    return s += "}";
  }
  private String strLayer(Iterator i, String s, int depth) {
    if (depth > height()) return "";
    while(i.hasNext()) {
      No q = (No) i.next();
      if (depth(q) == depth) s += q.element();
      if (q.parent() != null)
        if (q.parent().childrenNumber() > 0) s += " ";
    }
    s += "\n";
    i = Nos();
    while(i.hasNext()) {
      No q = (No) i.next();
      if (depth(q) == depth) 
        if (q.childrenNumber() > 0) s += "|";
      else s += " ";
      if (q.parent() != null)
        if (q.parent().childrenNumber() > 0) s += " ";
    }
    if (depth < height()) s += "\n";
    s += strLayer(Nos(), s, depth+1);
    return s;
  }
  public String strStruct() {
    return strLayer(Nos(), "", depth(raiz));
  }
}

/*
1 
|
2 3 4
  | |   
  5 6
    |
    7
*/

