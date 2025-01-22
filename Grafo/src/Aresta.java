package Grafo.src;
import java.util.ArrayList;
public class Aresta{
    private Object o;
    private Vertice v1;
    private Vertice v2;
    private int d; // 0 = v1->v2; 1 = v1<-v2; 2 = v1<=>v2
    public Aresta(Vertice v1, Vertice v2, Object o) {
        this.o = o;
        this.v1 = v1;
        this.v2 = v2;
        this.d = 2;
    }
    public Aresta(Vertice v1, Vertice v2, Object o, int d) {
        this.o = o;
        this.v1 = v1;
        this.v2 = v2;
        this.d = d;
    }
    public Object get() {
        return this.o;
    }
    public void set(Object o) {
        this.o = o;
    }
    public ArrayList getVertices() {
        ArrayList<Vertice> vertices = new ArrayList<Vertice>();
        vertices.add(v1);
        vertices.add(v2);
        return vertices;
    }
}