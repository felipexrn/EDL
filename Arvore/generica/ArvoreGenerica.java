import java.util.Iterator;
import java.util.ArrayList;
public class ArvoreGenerica {
	No raiz;
	int tamanho;
	public ArvoreGenerica(Object o) {
    raiz = new No(null, o);
		tamanho = 1;
	}
	public No root() {
		return raiz;
	}
	public No parent(No v) {
		return (v.parent());
	}
	public Iterator children(No v) {
		return v.children();
	}
	public boolean isInternal(No v) {
		return (v.childrenNumber() > 0);
	}
	public boolean isExternal(No v) {
		return (v.childrenNumber() == 0);
	}
	public boolean isRoot(No v) {
		return v == raiz;
	}
	public void addChild(No v, Object o) {
		No novo = new No(v, o);
		v.addChild(novo);
		tamanho++;
	}
	public Object remove(No v) {
    if (v == raiz) throw new InvalidNoException("Invalid No");
		No pai = v.parent();
		if (pai != null || isExternal(v))
			pai.removeChild(v);
		Object o = v.element();
		tamanho--;
		return o;
	}
	public void swapElements(No v, No w) {
    Object o = v.element();
    v.setElement(w.element());
    w.setElement(o);
	} 
	public int depth(No v) {
		int profundidade = profundidade(v);
		return profundidade;
	}
	private int profundidade(No v) {
		if (v == raiz) return 0;
		else return 1 + profundidade(v.parent());
	}
	public int height() {
		int altura = altura(raiz);
		return altura;
	}
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
  }
  private ArrayList<Object> preOrdem(No v, ArrayList<Object> o) {
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
	}
	public Iterator Nos() {
		ArrayList<Object> o = new ArrayList<Object>();
    ArrayList<Object> p = new ArrayList<Object>();
    o = preOrdem(raiz, o);
    o.forEach((obj) -> p.add(((No)obj))); 
		return p.iterator();
	}
	public int size() {
    return tamanho;
	}
	public boolean isEmpty() {
		return false;
	}
	public Object replace(No v, Object o) {
    Object p = v.element();
		v.setElement(o);
    return p;
	}
  public No find(Object o) {
    Iterator i = Nos();
    No v = null;
    while(i.hasNext()) {
      v = (No) i.next();
      if (v.element() == o) return v;
    }
    if(v.element() == null) throw new DoesNotExistNoException("Esto non ecxiste");
    return v;
  }
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
  }
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
  }
  public String strNos() {
    String s = "{";
    Iterator i = Nos();
    int n = tamanho;
    while(i.hasNext()) {
      s += i.next();
      n--;
      if (n > 0) s += ", ";
    }
    return s += "}";
  }
  private String strLayer(Iterator i, String s, int d) {
    if (d > height()) return s;
    while(i.hasNext()) {
      No q = (No) i.next();
      if (depth(q) == d) s += q.element();
      else s += " ";
      if (q.parent() != null)
        if (q.parent().childrenNumber() > 0) s += " ";
    }
    if (d < height()) {
      s += "\n";
      i = Nos();
      while(i.hasNext()) {
        No q = (No) i.next();
        if (depth(q) == d) 
          if (q.childrenNumber() > 0) s += "|";
          else s += " ";
        else s += " ";
        if (q.parent() != null)
          if (q.parent().childrenNumber() > 0) s += " ";
      }
    }    
    if (d < height()) s += "\n";
    s = strLayer(Nos(), s, d++);
    return s;
  }
  private int maxWidth() {
    int w = 0;
    int d = depth(raiz);
    int h = height();
    while(h > 0) {
      Iterator i = Nos();
      int l = 0;
      while(i.hasNext()) {
        No q = (No) i.next();
        if (depth(q) == d) l++;
      }
      w = Math.max(w, l);
      d++;
      h--;
    }
    return w;
  }
  public String strStruct() {
    System.out.println(height());
    System.out.println(tamanho);
    System.out.println(maxWidth());
    return strLayer(Nos(), "", depth(raiz));
  }
}

/*
    1
 ___|____ 
|   |    |
2   3    4
   _|_   |
  | | |  |
  5 8 9  6
         |_
         | |
         7 0
raiz é impresso na metade da largura da arvore
a tabulação dos elementos de cada camada depende da largura da árvore e
da quantidade de descendentes diretos e indiretos 

*/

