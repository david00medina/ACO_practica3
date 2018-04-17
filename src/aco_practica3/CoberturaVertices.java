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
            aristasIncidentes(E, sample);
            S.add(sample.getNodoInicial());
            S.add(sample.getNodoSiguiente());
        }
        return S;
    }
    
    private void aristasIncidentes(ArrayList<Arista> E, Arista sample) {
        E.removeIf(e -> (e.nodoComun(sample)));
    }
    
    @Override
    public String toString() {
        String out = "";
        if(!S.isEmpty()) {
            out += "Vértices de cobertura : { ";
            //for (Integer vertices : S) {
            //    out += vertices + ", ";
            //}
            for (int i = 0; i < S.size(); i++) {
                if(i == S.size() - 1)
                    out += S.get(i) + " }";
                else
                    out += S.get(i) + ", ";
            }
            return out;
        }
        return "Vértices de cobertur : {}";
    }
}