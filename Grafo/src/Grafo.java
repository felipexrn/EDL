package Grafo.src;
import java.util.ArrayList;
public class Grafo {
    private ArrayList<Aresta> arestas;
    private ArrayList<Vertice> vertices;
    public Grafo() {
        arestas = new ArrayList();
        vertices = new ArrayList();
    }

    // Retorna um array armazenando os vértices finais da aresta e.
    public ArrayList<Vertice> finalVertices(Aresta e) {
        return e.getVertices();
    }

    // Retorna o vértice oposto de v em e, ou seja, o vértice final da 
    // aresta e separado do vértice v. Um erro ocorre se e não é
    // incidente a v
    public Vertice oposto(Vertice v, Aresta e) {
        ArrayList<Vertice> vertices = finalVertices(e);
        Vertice vEntrada = vertices.get(0);  
        Vertice vSaida = vertices.get(1);
        Vertice vOposto = null;
        if (vEntrada == v) vOposto = vSaida;
        else if (vSaida == v)  vOposto = vEntrada;
        if (vOposto != null) return vOposto;
        throw new RuntimeException("'e' não e incidente a 'v'");
    }

    // Retorna true se v e w são adjacentes
    public Boolean eAdjacente(Vertice v, Vertice w) {
        Boolean resultado = false;
        ArrayList<Aresta> aEntradas = v.getEntradas();
        ArrayList<Aresta> aSaidas = v.getSaidas();
        for (int i = 0; i < aEntradas.size(); i++) {
            if (oposto(v, aEntradas.get(i)) == w) {
                resultado = true;
                break;
            }
        }
        if (!resultado) {
            for (int i = 0; i < aSaidas.size(); i++) {
                if (oposto(v, aSaidas.get(i)) == w) {
                    resultado = true;
                    break;
                }
            }
        }
        return resultado;
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
        this.vertices.add(v);
        return v;
    }

    // Insere e retorna uma nova aresta não-dirigida (v,w) armazenando o elemento o
    public Aresta inserirAresta(Vertice v, Vertice w, Object o) {
        Aresta e = new Aresta(v, w, o); 
        this.arestas.add(e);
        v.addEntrada(e);
        v.addSaida(e);
        w.addEntrada(e);
        w.addSaida(e);
        return e;
    }

    // Remove o vértice v ( e todas as arestas incidentes) e retorna o elemento armazenado em v
    public Object removeVertice(Vertice v) {
        ArrayList<Aresta> aEntradas = v.getEntradas();
        ArrayList<Aresta> aSaidas = v.getSaidas();
        for (int i = 0; i < aEntradas.size(); i++) {
            removeAresta(aEntradas.get(i));
        }
        for (int i = 0; i < aSaidas.size(); i++) {
            removeAresta(aSaidas.get(i));
        }
        return v.get();
    }

    // Remove a aresta e, retornando o elemento armazenado
    public Object removeAresta(Aresta e) {
        ArrayList<Vertice> finalVertices = finalVertices(e); 
        Vertice vEntrada = finalVertices.get(0);
        Vertice vSaida = finalVertices.get(1);
        vEntrada.removeEntrada(e);
        vSaida.removeSaida(e);
        arestas.remove(e);
        return e.get();
    }

    // mostrar grafo
    public void mostrar() {
        for (int i = 0; i < vertices.size(); i++) {
            Vertice v = vertices.get(i);

            // mostra arestas de saida
            ArrayList<Aresta> aSaidas = v.getSaidas();
            for (int j = 0; j < aSaidas.size(); j++) {
                Aresta a = aSaidas.get(j);
                System.out.print(v.get());
                System.out.print(" -> ");
                System.out.println(oposto(v, a).get());
            }
            /*
            // mostra arestas de entrada
            ArrayList<Aresta> aEntradas = v.getEntradas();
            for (int j = 0; j < aEntradas.size(); j++) {
                Aresta a = aEntradas.get(j);
                System.out.print(v.get());
                System.out.print(" <- ");
                System.out.println(oposto(v, a).get());
            }
            */
        }
    }

}