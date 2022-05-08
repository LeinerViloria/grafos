package grafos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class caminoDirigido extends camino{
    
    public caminoDirigido(grafo grafo) {
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

            try {
                while(!terminado){
                    nodo finalAux = aux.getNodoDestino();
                    aux = grafo.getAristasByNodoForSendero(finalAux, sendero);
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
            } catch (OutOfMemoryError e) {
                JOptionPane.showMessageDialog(null, "Error en la busqueda, "+e);
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
            
            ArrayList<arista> aristasIgnoradas  = new ArrayList<>();

            try {
                while(!terminado){
                    nodo finalAux = aux.getNodoDestino();
                    aux = grafo.getAristasByNodoForTrayecto(finalAux, trayectoria, aristasIgnoradas);
                    if(aux!=null && aux!=comienzo){
                        if(grafo.getAristasByNodoForTrayecto(aux.getNodoDestino(), trayectoria, aristasIgnoradas)==null){
                            aristasIgnoradas.add(aux);
                            aux = trayectoria.get(trayectoria.size()-1);
                        }else{
                            trayectoria.add(aux);
                        }
                    }
                    if(aux!=null){
                        if(aux==comienzo && trayectoria.size()>1){
                            terminado = true;
                        }
                    }else{
                        break;
                    }
                }
            } catch (OutOfMemoryError e) {
                JOptionPane.showMessageDialog(null, "Error en la busqueda, "+e);
            }

            if(!terminado){
                validaSiDebeRebuscar();
            }else{
                boolean trayectoRealizado = trayectoriasHechas.contains(comienzo);
                if(trayectoRealizado){
                    validaSiDebeRebuscar();
                }else{
                    trayectoriasHechas.add(comienzo);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay aristas");
        }
    }
    
    private void validaSiDebeRebuscar(){
        trayectoria.clear();
        indiceAristaInicialEnTrayectoria++;
        if(indiceAristaInicialEnTrayectoria<grafo.getAristas().size()){
            construirTrayectoria();
        }else{
            indiceAristaInicialEnTrayectoria=0;
        }
    }
}
