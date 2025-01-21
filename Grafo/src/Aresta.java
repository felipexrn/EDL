package Grafo.src;
import java.util.ArrayList;
public class Aresta{
    private Object obj;
    private ArrayList<Vertice> vertices;
    public Aresta(Vertice v1, Vertice v2, Object o) {
        obj = o;
         vertices = new ArrayList<Vertice>();
        vertices.add(v1);
        vertices.add(v2);
    }
    public Object get() {
        return obj;
    }
    public ArrayList getVertices() {
        return vertices;
    }
}