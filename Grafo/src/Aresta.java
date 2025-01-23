package Grafo.src;
import java.util.ArrayList;
public class Aresta{
    private Object o;
    private Vertice vEntrada;
    private Vertice vSaida;
    public Aresta(Vertice v1, Vertice v2, Object o) {
        this.o = o;
        vEntrada = v1;
        vSaida = v2;
    }
    public Object get() {
        return this.o;
    }
    public void set(Object o) {
        this.o = o;
    }
    public ArrayList<Vertice> getVertices() {
        ArrayList<Vertice> vertices = new ArrayList<Vertice>();
        vertices.add(vEntrada);
        vertices.add(vSaida);
        return vertices;
    }
}