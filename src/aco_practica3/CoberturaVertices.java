package aco_practica3;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class CoberturaVertices {
    private Grafo grafo;
    private ArrayList<Integer> S;
    
    public CoberturaVertices(Grafo grafo) {
        this.grafo = grafo;
        this.S = S = new ArrayList<>();
    }
    
    public ArrayList<Integer> execCV() {
        ArrayList<Arista> E;
        ArrayList<Arista> E_prima;
        
        E = grafo.getAristas();
        
        while (!E.isEmpty()) {
            Random rand = new Random();
            Arista sample = E.get(rand.nextInt(E.size()));
            E_prima = aristasIncidentes(E, sample);
            S.add(sample.getNodoInicial());
            S.add(sample.getNodoSiguiente());
            // E = E - E'
            for(Arista a : E_prima) {
                E.remove(a);
            }
            E_prima.clear();
        }
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.addAll(S);
        S.clear();
        S.addAll(lhs);
        return S;
    }
    
    private ArrayList<Arista> aristasIncidentes(ArrayList<Arista> E, Arista sample) {
        ArrayList<Arista> E_prima = new ArrayList<>();
        
        for (Arista arista : E) {
            if(arista.nodoComun(sample)) E_prima.add(arista);
        }
        return E_prima;
    }
    
    @Override
    public String toString() {
        String out = "";
        if(!S.isEmpty()) {
            out += "Vértices de cobertura : { ";
            for (Integer vertices : S) {
                out += vertices + ", ";
            }
            out += "}";
            return out;
        }
        return "Vértices de cobertur : {}";
    }
}