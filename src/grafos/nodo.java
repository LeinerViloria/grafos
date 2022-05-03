package grafos;

public class nodo {
    private final int valor;
    private int grados;
    private int posicionX;
    private int posicionY;

    public nodo(int valor, int posicionX, int posicionY) {
        this.valor = valor;
    }
    
    public int getX() {
        return posicionX;
    }
    
    public int getY() {
        return posicionY;
    }

    public int getValor() {
        return valor;
    }

    public int getGrados() {
        return grados;
    }

    public void setGrados(int grados) {
        this.grados = grados;
    }

    public String getTipo() {
        if(grados==0) return null;
        return (grados%2==0) ? "Par" : "Impar";
    }
    
}
