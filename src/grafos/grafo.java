package grafos;

import java.util.ArrayList;

/*
Se representa graficamente como un conjunto de puntos (nodos)
unidos por lineas (aristas)
*/
public class grafo {
    private ArrayList<nodo> nodos;
    private ArrayList<arista> aristas;
    private int totalGrados;
    private int indice;

    public grafo() {
        this.indice = 1;
    }
    
    public void agregarNodo(int x, int y){
        nodo nuevoNodo = new nodo(indice, x, y);
        indice++;
        nodos.add(nuevoNodo);
    }
    
    public boolean crearArista(nodo nodoOrigen, nodo nodoDestino){
        if(nodoOrigen==null || nodoDestino==null) return false;
        if(!aristaValida(nodoOrigen, nodoDestino, aristas.size()-1)) return false;
        
        arista nuevaArista = new arista(nodoOrigen, nodoDestino);
        nodoOrigen.setGrados(nodoOrigen.getGrados()+1);
        nodoDestino.setGrados(nodoDestino.getGrados()+1);
        
        aristas.add(nuevaArista);
        actualizarTotalGrados();
        
        return true;
    }
    
    //Verifica que esa arista esté creada
    private boolean aristaValida(nodo nodoOrigen, nodo nodoDestino, int n){
        if(n<0) return true;
        return (((aristas.get(n).getNodoOrigen()==nodoOrigen) && (aristas.get(n).getNodoDestino()==nodoDestino))
                ||
                ((aristas.get(n).getNodoOrigen()==nodoDestino) && (aristas.get(n).getNodoDestino()==nodoOrigen)))
                ? false
                : aristaValida(nodoOrigen, nodoDestino, n-1);
        
    }
    
    private void actualizarTotalGrados(){
        int aux = 0;
        for (nodo nodo : nodos) {
            aux += nodo.getGrados();
        }
        totalGrados = aux;
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
    
    
    
}
