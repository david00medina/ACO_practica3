package aco_practica3;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
 
public class Main {

    public static void main(String[] args) {
        System.out.println("===== CASO 1: GENERAL ======");
        Path path = Paths.get("grafo2.txt");
        Grafo g1 = new Grafo(path);
        g1.mostrarGrafo();
        CoberturaVertices cv = new CoberturaVertices(g1);
        ArrayList<Integer> S = cv.execCV();
        System.out.println(cv);
        for(Integer i : S) {
            System.out.println(i);
        }
    }
    
}