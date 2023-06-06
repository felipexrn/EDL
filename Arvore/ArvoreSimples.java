import java.util.Iterator;
import java.util.ArrayList;
public class ArvoreSimples {
	No raiz;
	int tamanho;
	public ArvoreSimples(Object o) {
		// pai do raiz sempre e null
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
	// Remove um No
	//  So pode remover Nos externos e que tenham um pai (nao seja raiz)
	public Object remove(No v) throws InvalidNoException {
		No pai = v.parent();
		if (pai != null || isExternal(v))
			pai.removeChild(v);
		else
			throw new InvalidNoException();
		Object o = v.element();
		tamanho--;
		return o;
	}
	public void swapElements(No v, No w) {
		/* Metodo que serve de exercicio
		  Este metodo devera fazer com que o objeto
		  que estava na posicao v fique na posicao w
		  e fazer com que o objeto que estava na posicao w
		  fique na posicao v
		*/  
	}
	public int depth(No v) {
		int profundidade = profundidade(v);
		return profundidade;
	}
	private int profundidade(No v) {
		if (v == raiz)
			return 0;
		else
			return 1 + profundidade(v.parent());
	}
	public int height() {
		// Metodo que serve de exercicio
		int altura = 0;
		return altura;
	}
	// Retorna um iterator com os elementos armazenados na arvore
	public Iterator elements() {
		// Metodo que serve de exercicio
		return null;
	}
	// Retorna um iterator com as posicoes (Nos) da arvore
	public Iterator Nos() {
		// Metodo que serve de exercicio
		return null;
	}
	// Retorna o numero de Nos da arvore
	public int size() {
	 // Metodo que serve de exercicio
		return 0;
	}
	// Retorna se a arvore esta vazia. Sempre vai ser falso, pois nao permitimos remover a raiz
	public boolean isEmpty() {
		return false;
	}
	public Object replace(No v, Object o) {
	 // Metodo que serve de exercicio
		return null;
	}
	public class No {
		private Object o;
		private No pai;
		private ArrayList filhos = new ArrayList();
		public No(No pai, Object o) {
			this.pai = pai;
			this.o = o;
		}
		public Object element() {
			return o;
		}
		public No parent() {
			return pai;
		}
		public void setElement(Object o) {
			this.o = o;
		}
		public void addChild(No o) {
			filhos.add(o);
		}
		public void removeChild(No o) {
			filhos.remove(o);
		}
		public int childrenNumber() {
			return filhos.size();
		}
		public Iterator children() {
			return filhos.iterator();
		}
	}
}
