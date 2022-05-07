package grafos;

import java.util.ArrayList;

/*
Se representa graficamente como un conjunto de puntos (nodos)
unidos por lineas (aristas)
*/
public abstract class grafo {
    protected ArrayList<nodo> nodos;
    protected ArrayList<arista> aristas;
    protected int totalGrados;
    protected int indice;

    public grafo() {
        this.indice = 1;
        nodos = new ArrayList<>();
        aristas = new ArrayList<>();
    }
    
    public int agregarNodo(int x, int y){
        nodo nuevoNodo = new nodo(indice, x, y);
        indice++;
        nodos.add(nuevoNodo);
        return nuevoNodo.getValor();
    }
    
    public abstract boolean crearArista(nodo nodoOrigen, nodo nodoDestino);
    
    //Verifica que esa arista esté creada
    protected abstract boolean aristaValida(nodo nodoOrigen, nodo nodoDestino, int n);
    
    protected void actualizarTotalGrados(){
        int aux = 0;
        for (nodo nodo : nodos) {
            aux += nodo.getGrados();
        }
        totalGrados = aux;
    }

    public nodo getNodoEnLista(int i) {
        return (!nodos.isEmpty() && i<nodos.size() && i>=0) ? nodos.get(i) : null;
    }

    public ArrayList<nodo> getNodos() {
        return nodos;
    }

    public ArrayList<arista> getAristas() {
        return aristas;
    }

    public int getTotalGrados() {
        return totalGrados;
    }

    public int getIndice() {
        return indice;
    }
    
    public nodo getNodo(int id, int i){
        if(i<0) return null;
        return (id == nodos.get(i).getValor()) 
                ? nodos.get(i)
                : getNodo(id, i-1);
    }
    
    public abstract arista getAristasByNodo(nodo nodoOrigen, ArrayList<arista> aristasIgnoradas, boolean haciendoTrayecto);
    
    
}
