package grafos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class caminoNoDirigido extends camino{
    
    public caminoNoDirigido(grafo grafo) {
        super(grafo);
    }
    
    @Override
    public void construirSendero(){
        nuevoSendero();
        if(!grafo.getAristas().isEmpty()){
            indiceAristaInicialEnSendero = (int) (Math.random() * grafo.getAristas().size());
        
            arista aux = grafo.getAristas().get(indiceAristaInicialEnSendero);
            arista comienzo = aux;
            sendero.add(aux);
            boolean terminado = false;

            grafoNoDirigido grafoAux = new grafoNoDirigido();
            grafoAux.aristas = grafo.getAristas();
            
            ArrayList<arista> aristasIgnoradas = new ArrayList<>();
            
            while(!terminado){
                
                arista aristaIgnorada = grafoAux.getAristaInversa(aux, grafo.getAristas().size()-1);
                aristasIgnoradas.add(aux);
                aristasIgnoradas.add(aristaIgnorada);
            
                nodo finalAux = aux.getNodoDestino();
                
                aux = grafo.getAristasByNodoForSendero(finalAux, aristasIgnoradas);
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
                aristasIgnoradas.clear();
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay aristas");
        }
    }
    
    @Override
    public void construirTrayectoria(){
        nuevoTrayecto();
        if(!grafo.getAristas().isEmpty()){
            arista aux = grafo.getAristas().get(indiceAristaInicialEnTrayectoria);
            arista comienzo = aux;
            trayectoria.add(aux);
            boolean terminado = false;
            
            grafoNoDirigido grafoAux = new grafoNoDirigido();
            grafoAux.aristas = grafo.getAristas();
            
            ArrayList<arista> aristasIgnoradas = new ArrayList<>();

            while(!terminado){
                
                arista aristaIgnorada = grafoAux.getAristaInversa(aux, grafo.getAristas().size()-1);
                aristasIgnoradas.add(aux);
                aristasIgnoradas.add(aristaIgnorada);
                
                nodo finalAux = aux.getNodoDestino();
                aux = grafo.getAristasByNodoForTrayecto(finalAux, null, aristasIgnoradas);
                
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
            }else{
                boolean trayectoRealizado = trayectoriasHechas.contains(comienzo);
                if(trayectoRealizado){
                    trayectoria.clear();
                    indiceAristaInicialEnTrayectoria++;
                    if(indiceAristaInicialEnTrayectoria<grafo.getAristas().size()){
                        construirTrayectoria();
                    }
                }else{
                    trayectoriasHechas.add(comienzo);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay aristas");
        }
    }
}
