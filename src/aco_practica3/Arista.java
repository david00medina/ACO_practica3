package aco_practica3;

public class Arista {

    private int nodoInicial;
    private int nodoSiguiente;

    public Arista(int nodoInicial, int nodoSiguiente) {
        this.nodoInicial = nodoInicial;
        this.nodoSiguiente = nodoSiguiente;
    }

    public int getNodoInicial() {
        return nodoInicial;
    }

    public int getNodoSiguiente() {
        return nodoSiguiente;
    }

    public void setNodoInicial(int nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    public void setNodoSiguiente(int nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }
    
    public boolean nodoComun(Arista a) {
        if(a.getNodoInicial() == this.getNodoInicial()) return true;
        if(a.getNodoSiguiente() == this.getNodoInicial()) return true;
        if(a.getNodoInicial() == this.getNodoSiguiente()) return true;
        if(a.getNodoSiguiente() == this.getNodoSiguiente()) return true;
        return false;
    }
    
    @Override
    public String toString() {
        return "Vértice(" + nodoInicial  + ") -----> Vértice(" + nodoSiguiente + ")";
    }
    
    @Override
    public boolean equals(Object a) {
        if(a == null) return false;
        if(a == this) return true;
        if(((Arista) a).getNodoInicial() == nodoInicial) return true;
        if(((Arista) a).getNodoSiguiente() == nodoSiguiente) return true;
        return false;
    }
}