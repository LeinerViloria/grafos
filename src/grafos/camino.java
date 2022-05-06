package grafos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class camino {
    private final grafo grafo;
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
    private int indiceAristaInicialEnTrayectoria;
    private int indiceAristaInicialEnSendero;

    public camino(grafo grafo) {
        this.grafo = grafo;
        this.indiceAristaInicialEnTrayectoria=0;
        this.indiceAristaInicialEnSendero=0;
        nuevoTrayecto();
        nuevoSendero();
    }
    
    private void nuevoSendero(){
        this.sendero = new ArrayList<>();
    }
    
    private void nuevoTrayecto(){
        this.trayectoria = new ArrayList<>();
    }

    public int getLongitud() {
        return longitud;
    }

    public ArrayList<arista> getTrayectoria() {
        return trayectoria;
    }

    public ArrayList<arista> getSendero() {
        return sendero;
    }
    
    public void construirSendero(){
        nuevoSendero();
        if(!grafo.getAristas().isEmpty()){
            indiceAristaInicialEnSendero = (int) (Math.random() * grafo.getAristas().size());
        
            arista aux = grafo.getAristas().get(indiceAristaInicialEnSendero);
            arista comienzo = aux;
            sendero.add(aux);
            boolean terminado = false;

            while(!terminado){
                nodo finalAux = aux.getNodoDestino();
                aux = grafo.getAristasByNodo(finalAux, sendero);
                if(aux!=null && aux!=comienzo){
                    sendero.add(aux);
                }

                if(aux!=null){
                    if(aux==comienzo || aux.getNodoDestino()==comienzo.getNodoOrigen()){
                        terminado = true;
                    }
                }else{
                    break;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay aristas");
        }
    }
    
    public void construirTrayectoria(){
        nuevoTrayecto();
        if(!grafo.getAristas().isEmpty()){
            arista aux = grafo.getAristas().get(indiceAristaInicialEnTrayectoria);
            arista comienzo = aux;
            trayectoria.add(aux);
            boolean terminado = false;

            while(!terminado){
                nodo finalAux = aux.getNodoDestino();
                aux = grafo.getAristasByNodo(finalAux, trayectoria);
                if(aux!=null && aux!=comienzo){
                    trayectoria.add(aux);
                }
                if(aux!=null){
                    if(aux==comienzo){
                        terminado = true;
                    }
                }else{
                    break;
                }
            }

            if(!terminado){
                trayectoria.clear();
                indiceAristaInicialEnTrayectoria++;
                if(indiceAristaInicialEnTrayectoria<grafo.getAristas().size()){
                    construirTrayectoria();
                }else{
                    indiceAristaInicialEnTrayectoria=0;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay aristas");
        }
    }
    
    public void obtenerUnaArista(nodo nodoOrigen){
        
    }
    
}
