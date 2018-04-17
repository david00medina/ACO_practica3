package aco_practica3;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
 
public class Main {

    public static void main(String[] args) {
        System.out.println("===== CASO 1: GRAFO DIAPOSITIVA ======");
        Path path = Paths.get("grafo2.txt");
        Grafo g1 = new Grafo(path);
        g1.mostrarGrafo();
        CoberturaVertices cv = new CoberturaVertices(g1);
        ArrayList<Integer> S1 = cv.exec();
        cv.isSolucion();
        System.out.println(cv);
        
        System.out.println("\n\n===== CASO 2: GRAFO CON RUTAS PARALELAS ======");
        path = Paths.get("grafo1.txt");
        Grafo g2 = new Grafo(path);
        g2.mostrarGrafo();
        CoberturaVertices cv2 = new CoberturaVertices(g2);
        ArrayList<Integer> S2 = cv2.exec();
        cv2.isSolucion();
        System.out.println(cv2);
    }
    
}