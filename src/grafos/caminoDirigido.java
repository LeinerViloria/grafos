package grafos;

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

            while(!terminado){
                nodo finalAux = aux.getNodoDestino();
                aux = grafo.getAristasByNodo(finalAux, sendero, false);
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
    
    @Override
    public void construirTrayectoria(){
        nuevoTrayecto();
        if(!grafo.getAristas().isEmpty()){
            arista aux = grafo.getAristas().get(indiceAristaInicialEnTrayectoria);
            arista comienzo = aux;
            trayectoria.add(aux);
            boolean terminado = false;

            while(!terminado){
                nodo finalAux = aux.getNodoDestino();
                aux = grafo.getAristasByNodo(finalAux, trayectoria, true);
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
