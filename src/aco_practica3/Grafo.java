package aco_practica3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Grafo {

    private int nNodos;
    private ArrayList<Arista> aristas;

    public Grafo(Path path) {
        aristas = new ArrayList<>();
        try {
            BufferedReader br = Files.newBufferedReader(path, Charset.forName("UTF-8"));
            String line;
            line = br.readLine();
            nNodos = Integer.parseInt(line);
            while ((line = br.readLine()) != null) {
                String param[] = line.split(" ");
                int nodoInicial = Integer.parseInt(param[0]);
                int nodoFinal = Integer.parseInt(param[1]);
                aristas.add(new Arista(nodoInicial, nodoFinal));
            }
        } catch (IOException ex) {
            Logger.getLogger(Grafo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Grafo(int nNodos) {
        this.nNodos  = nNodos;
        aristas = new ArrayList<>();
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }

    public void mostrarGrafo() {
        System.out.println("MOSTRAR GRAFO");
        for(Arista arista : aristas) {
            System.out.println(arista);
        }
        System.out.println("");
    }

    public int getnNodos() {
        return nNodos;
    }
    
    public void setAristas(int a, int b) {
        aristas.add(new Arista(a, b));
    }
    
    public boolean isConexo() {
        ArrayList<Integer> nodosVisitados = new ArrayList<>();
        ArrayList<Integer> cola = new ArrayList<>();
        ArrayList<Integer> hijos = new ArrayList<>();
        cola.add(aristas.get(0).getNodoInicial());
        while(!cola.isEmpty()) {
            Integer nodo = cola.get(0);
            nodosVisitados.add(nodo);
            cola.remove(nodo);
            hijos = expansion(nodo);
            for (Integer hijo : hijos) {
                if(!nodosVisitados.contains(hijo) && !cola.contains(hijo))
                    cola.add(hijo);
            }
        }
        if(nodosVisitados.size() == nNodos)
            return true;
        
        return false;
    }
    
    public ArrayList<Integer> expansion(int nodo) {
        ArrayList<Integer> hijos = new ArrayList<>();
        for (Arista arista : aristas) {
            if(arista.nodoComun(nodo)) {
                if(arista.getNodoInicial() != nodo)
                    hijos.add(arista.getNodoInicial());
                else
                    hijos.add(arista.getNodoSiguiente());
            }
        }
        return hijos;
    }
}