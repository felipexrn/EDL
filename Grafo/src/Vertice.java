package Grafo.src;
import java.util.ArrayList;
public class Vertice{
    private Object o;
    private ArrayList<Aresta> aEntradas;
    private ArrayList<Aresta> aSaidas;
    public Vertice(Object o) {
        this.o = o;
        aEntradas = new ArrayList();
        aSaidas = new ArrayList();
    }
    public Object get() {
        return this.o;
    }
    public void set(Object o) {
        this.o = o;
    }
    public void addEntrada(Aresta e) {
        aEntradas.add(e);
    }
    public void addSaida(Aresta e) {
        aSaidas.add(e);
    }
    public void removeEntrada(Aresta e) {
        aEntradas.remove(e);
    }
    public void removeSaida(Aresta e) {
        aSaidas.remove(e);
    }
    public ArrayList<Aresta> getEntradas() {
        return this.aEntradas;
    }
    public ArrayList<Aresta> getSaidas() {
        return this.aSaidas;
    }
}