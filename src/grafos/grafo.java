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
        nodos = new ArrayList<>();
        aristas = new ArrayList<>();
    }
    
    public int agregarNodo(int x, int y){
        nodo nuevoNodo = new nodo(indice, x, y);
        indice++;
        nodos.add(nuevoNodo);
        return nuevoNodo.getValor();
    }
    
    public boolean crearArista(nodo nodoOrigen, nodo nodoDestino){
        if(nodoOrigen==null || nodoDestino==null || nodoOrigen==nodoDestino) return false;
        if(!aristaValida(nodoOrigen, nodoDestino, aristas.size()-1)) return false;
        
        arista nuevaArista = new arista(nodoOrigen, nodoDestino);
        nodoOrigen.setGrados(nodoOrigen.getGrados()+1); //De este me interesa el que sale [1]
        nodoOrigen.setDescripcionGrados(1, 1, String.valueOf(Integer.parseInt(nodoOrigen.getDescripcionGrados(1, 1))+1));
        
        nodoDestino.setGrados(nodoDestino.getGrados()+1);//De este me interesa el que entra [0]
        nodoDestino.setDescripcionGrados(0, 1, String.valueOf(Integer.parseInt(nodoDestino.getDescripcionGrados(0, 1))+1));
        
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
    
    public arista getAristasByNodo(nodo nodoOrigen, ArrayList<arista> aristasIgnoradas){
        arista aristaEncontrada = null;
        for(int i=0; i<aristas.size(); i++){
            if(aristas.get(i).getNodoOrigen()==nodoOrigen){
                boolean flag = aristasIgnoradas.contains(aristas.get(i));
                if(flag==false){
                    aristaEncontrada=aristas.get(i);
                    break;
                }
            }
        }
        return aristaEncontrada;
    }
    
    
}
