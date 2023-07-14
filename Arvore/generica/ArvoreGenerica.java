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
  private ArrayList<Object> mediaOrdem(No v, ArrayList<Object> o, int n) {
    int m;
    Iterator c;
    No d;
    m = v.childrenNumber();
    if (m > 0) {
      c = v.children();
      while(c.hasNext()) {   
        d = (No)c.next();
        if (n < (m/2 + m%2)) {
          o = mediaOrdem(d, o, 1);
          n++;
          continue;
        }
        if (n == (m/2 + m%2)) {
          o = mediaOrdem(d, o, 1);
          o.add(v);
          n++;
          continue;
        }
        if (n > (m/2 + m%2)) {
          o = mediaOrdem(d, o, 1);
          n++;
          continue;
        }
      }
    }
    else {
      o.add(v);
    }
    return o;
  }
	public Iterator elements() {
    ArrayList<Object> o = new ArrayList<Object>();
    ArrayList<Object> p = new ArrayList<Object>();
    o = mediaOrdem(raiz, o, 1);
    o.forEach((obj) -> p.add(((No)obj).element())); 
		return p.iterator();
	}
	public Iterator Nos() {
		ArrayList<Object> o = new ArrayList<Object>();
    ArrayList<Object> p = new ArrayList<Object>();
    o = mediaOrdem(raiz, o, 1);
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
    if(v == null || v.element() == null) throw new DoesNotExistNoException("Esto non ecxiste");
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
  private String strLayer(int d) {
    String s = "";
    Iterator i;
    while(d <= height()) {
      i = Nos();
      while(i.hasNext()) {
        No q = (No) i.next();
        if (depth(q) == d) s += q.element() + " ";
        else s += "  ";
      }
      if(d <= height()) s += "\n";
      d++;
      i = Nos();
      while(i.hasNext()) {
        No q = (No) i.next();
        if (q.parent() != null) {
          if (depth(q.parent()) >= d-1) s += "__";
          else if (depth(q) == d-1)
            if (q.childrenNumber() > 0) s += "|_";
            else s += "  ";
          else s += "  ";
        }  
        else if (depth(q) == d-1 && q.childrenNumber() > 0) s += "|_";
        else s += "  "; 
      }
      if(d <= height()) s += "\n";
      i = Nos();
      if (d <= height()) {
        while(i.hasNext()) {
          No q = (No) i.next();
          if (q.parent() != null)
            if (depth(q.parent()) == d-1) s += "| ";
            else s += "  ";  
          else s += "  ";
        }
        s += "\n";
      }
    }
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
        System.out.println(i.next());
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
    return strLayer(depth(raiz));
  }
}
