package Grafo.src;
import java.util.ArrayList;
public class Grafo {
    private ArrayList<Aresta> arestas;
    private ArrayList<Vertice> vertices;
    public Grafo() {}

    // Retorna um array armazenando os vértices finais da aresta e.
    public ArrayList finalVertices(Aresta e) {
        return null;
    }

    // Retorna o vértice oposto de v em e, ou seja, o vértice final da 
    // aresta e separado do vértice v. Um erro ocorre se e não é
    // incidente a v
    public Vertice oposto(Vertice v, Aresta e) {
        return null;
    }

    // Retorna true se v e w são adjacentes
    public Boolean eAdjacente(Vertice v, Vertice w) {
        return false;
    }

    // Substitui o elemento armazenado do vértice V com X
    public void substituir(Vertice v, Object x) {
        v.set(x);
    }

    // Substitui o elemento armazenado na aresta e com x
    public void substituir(Aresta e, Object x) {
        e.set(x);
    }

    // Insere e retorna um novo vértice armazenando o elemento o
    public Vertice inserirVertice(Object o) {
        Vertice v = new Vertice(o);
        // inserir no grafo
        return v;
    }

    // Insere e retorna uma nova aresta não-dirigida (v,w) armazenando o elemento o
    public Aresta inserirAresta(Vertice v, Vertice w, Object o) {
        Aresta e = new Aresta(v, w, o);
        // Inserir Aresta no grafo 
        return e;
    }

    // Remove o vértice v ( e todas as arestas incidentes) e retorna o elemento armazenado em v
    public Object removeVertice(Vertice v) {
        return v.get();
    }

    // Remove a aresta e, retornando o elemento armazenado
    public Object removeAresta(Aresta e){
        return e.get();
    }

}