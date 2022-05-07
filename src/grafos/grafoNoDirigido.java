package grafos;

import java.util.ArrayList;

public class grafoNoDirigido extends grafo {
    
    @Override
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
    
    @Override
    protected boolean aristaValida(nodo nodoOrigen, nodo nodoDestino, int n){
        if(n<0) return true;
        return (((aristas.get(n).getNodoOrigen()==nodoOrigen) && (aristas.get(n).getNodoDestino()==nodoDestino))
                ||
                ((aristas.get(n).getNodoOrigen()==nodoDestino) && (aristas.get(n).getNodoDestino()==nodoOrigen)))
                ? false
                : aristaValida(nodoOrigen, nodoDestino, n-1);
        
    }
    
    @Override
    public arista getAristasByNodo(nodo nodoOrigen, ArrayList<arista> aristasIgnoradas, boolean haciendoTrayecto){
        arista aristaEncontrada = null;
        for(int i=0; i<aristas.size(); i++){
            if(aristas.get(i).getNodoOrigen()==nodoOrigen){
                boolean flag = aristasIgnoradas.contains(aristas.get(i));
                if(!flag){
                    aristaEncontrada=aristas.get(i);
                    break;
                }else if(flag && haciendoTrayecto && aristasIgnoradas.get(0) == aristas.get(i)){
                    aristaEncontrada=aristas.get(i);
                    break;
                }
            }
        }
        return aristaEncontrada;
    }
    
}
