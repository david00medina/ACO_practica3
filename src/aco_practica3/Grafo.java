package aco_practica3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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
        for (Arista arista : aristas) {
            System.out.println("Soy el nodo " + arista.getNodoInicial() 
                        + " voy a " + arista.getNodoSiguiente());
        }
        System.out.println("");
    }

    public int getnNodos() {
        return nNodos;
    }
    
    public void setAristas(int a, int b) {
        aristas.add(new Arista(a, b));
    }
}