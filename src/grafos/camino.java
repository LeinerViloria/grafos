package grafos;

import java.util.ArrayList;

public class camino {
    private grafo grafo;
    private int longitud;
    /*
    Caminos posible:
        --> Camino elemental o trayectoria: (Pasa por una serie de nodos una
            sola vez, a excepcion del nodo inicial, que puede ser el final)
        --> Camino simple o sendero: Pasa por una serie de aristas una sola vez.
            Todo camino elemental puede ser uno simple, pero no inversamente.
    */
    private ArrayList<arista> trayectoria;
    private ArrayList<arista> sendero;
}
