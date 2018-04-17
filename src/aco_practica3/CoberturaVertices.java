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
    
    public ArrayList<Integer> exec() {
        if(this.grafo.isConexo()){
            System.out.println("[+] PRUEBA : El grafo es conexo");
            return execCV();
        }
        
        System.out.println("[+] PRUEBA : El grafo no es conexo");
        return new ArrayList<Integer>();
    }
    
    private ArrayList<Integer> execCV() {
        ArrayList<Arista> E;
        ArrayList<Arista> E_prima;
        
        E = (ArrayList<Arista>)grafo.getAristas().clone();
        
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
    
    public boolean isSolucion() {
        ArrayList<Integer> cola = new ArrayList<>();
        ArrayList<Integer> nodosCubiertos = new ArrayList<>();
        ArrayList<Integer> hijos = new ArrayList<>();
        
        cola.addAll(S);
        while(!cola.isEmpty()) {
            Integer nodo = cola.get(0);
            if(!nodosCubiertos.contains(nodo))
                nodosCubiertos.add(nodo);
            cola.remove(0);
            hijos = grafo.expansion(nodo);
            for (Integer hijo : hijos) {
                if(!nodosCubiertos.contains(hijo) && !cola.contains(hijo))
                    nodosCubiertos.add(hijo);
            }
        }
        if(grafo.getnNodos() == nodosCubiertos.size()) {
            System.out.println("[+] PRUEBA : La solución cubre todos los vértices.");
            return true;
        }
        
        System.out.println("[+] PRUEBA : La solución NO cubre todos los vértices.");
        return false;
    }
    
    @Override
    public String toString() {
        String out = "";
        if(!S.isEmpty()) {
            out += "Vértices de cobertura : { ";
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