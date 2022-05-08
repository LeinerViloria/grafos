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
            
            try {
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
            
            grafoNoDirigido grafoAux = new grafoNoDirigido();
            grafoAux.aristas = grafo.getAristas();
            
            ArrayList<arista> trayectoArmado = new ArrayList<>();
            ArrayList<arista> aristasIgnoradas = new ArrayList<>();

            try {
                while(!terminado){
                    arista aristaIgnorada = grafoAux.getAristaInversa(aux, grafo.getAristas().size()-1);
                    trayectoArmado.add(aux);
                    trayectoArmado.add(aristaIgnorada);

                    nodo finalAux = aux.getNodoDestino();
                    aux = grafo.getAristasByNodoForTrayecto(finalAux, trayectoArmado, aristasIgnoradas);

                    if(aux!=null && aux!=comienzo){
                        if(grafo.getAristasByNodoForTrayecto(aux.getNodoDestino(), trayectoArmado, aristasIgnoradas)==null){
                            aristasIgnoradas.add(aux);
                            aux = trayectoria.get(trayectoria.size()-1);
                        }else{
                            trayectoria.add(aux);
                        }
                    }
                    if(aux!=null){
                        if(aux==comienzo){
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
