package grafos;

public class arista {
    private final nodo nodoOrigen;
    private final nodo nodoDestino;

    public arista(nodo nodoOrigen, nodo nodoDestino) {
        this.nodoOrigen = nodoOrigen;
        this.nodoDestino = nodoDestino;
    }

    public nodo getNodoOrigen() {
        return nodoOrigen;
    }

    public nodo getNodoDestino() {
        return nodoDestino;
    }
    
    
}
