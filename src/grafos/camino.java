package grafos;

import java.util.ArrayList;

public abstract class camino {
    protected final grafo grafo;
    protected int longitud;
    /*
    Caminos posible:
        --> Camino elemental o trayectoria: (Pasa por una serie de nodos una
            sola vez, a excepcion del nodo inicial, que puede ser el final)
        --> Camino simple o sendero: Pasa por una serie de aristas una sola vez.
            Todo camino elemental puede ser uno simple, pero no inversamente.
    */
    protected ArrayList<arista> trayectoria;
    protected ArrayList<arista> sendero;
    protected int indiceAristaInicialEnTrayectoria;
    protected int indiceAristaInicialEnSendero;

    public camino(grafo grafo) {
        this.grafo = grafo;
        this.indiceAristaInicialEnTrayectoria=0;
        this.indiceAristaInicialEnSendero=0;
        nuevoTrayecto();
        nuevoSendero();
    }
    
    protected final void nuevoSendero(){
        this.sendero = new ArrayList<>();
    }
    
    protected final void nuevoTrayecto(){
        this.trayectoria = new ArrayList<>();
    }

    public int getLongitud() {
        return longitud;
    }

    public int getLongitudSendero() {
        return sendero.size();
    }

    public int getLongitudTrayectoria() {
        return trayectoria.size();
    }

    public ArrayList<arista> getTrayectoria() {
        return trayectoria;
    }

    public ArrayList<arista> getSendero() {
        return sendero;
    }
    
    public abstract void construirSendero();
            
    public abstract void construirTrayectoria();
    
}
