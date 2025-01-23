import Grafo.src.*;
import java.util.ArrayList;
public class Teste {
    public static void main(String[] args) {
        
        // teste vertices
        System.out.println("teste vertices");
        Object n1 = 10;
        Object n2 = 20;
        Vertice v1 = new Vertice(n1);
        Vertice v2 = new Vertice(n2); 
        
        System.out.println(v1.get());
        System.out.println(v2.get());

        // teste arestas
        System.out.println("teste arestas");
        Object l1 = "A";
        Aresta a1 = new Aresta(v1, v2, l1);

        System.out.println(a1.get());
        ArrayList<Vertice> vertices = a1.getVertices();
        System.out.print(vertices.get(0).get());
        System.out.print(" <=> ");
        System.out.println(vertices.get(1).get());

        // teste do TAD grafo
        System.out.println("teste grafo");
        Grafo g1 = new Grafo();
        Vertice v3 = g1.inserirVertice(n1);
        Vertice v4 = g1.inserirVertice(n2);
        g1.inserirAresta(v3, v4, l1);

        g1.mostrar();

    }
}