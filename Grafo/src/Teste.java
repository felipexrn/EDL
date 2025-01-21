import Grafo.src.*;
import java.util.ArrayList;
public class Teste {
    public static void main(String[] args) {
        
        // vertices
        Object n1 = 10;
        Object n2 = 20;
        Vertice v1 = new Vertice(n1);
        Vertice v2 = new Vertice(n2); 
        
        System.out.println(v1.get());
        System.out.println(v2.get());

        // arestas
        Object l1 = "A";
        Aresta a = new Aresta(v1, v2, l1);

        System.out.println(a.get());
        ArrayList<Vertice> vertices = a.getVertices();
        System.out.println(vertices.get(0).get());
        System.out.println(vertices.get(1).get());


    }
}