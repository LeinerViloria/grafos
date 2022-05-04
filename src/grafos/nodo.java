package grafos;

public class nodo {
    private final int valor;
    private int grados;
    private int posicionX;
    private int posicionY;
    private String[][] descripcionGrados = {
        {"Entrada", "0"},
        {"Salida", "0"}
    };

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

    public String getDescripcionGrados(int i, int j) {
        return descripcionGrados[i][j];
    }

    public void setDescripcionGrados(int i, int j, String valor) {
        this.descripcionGrados[i][j] = valor;
    }

    public String getTipo() {
        if(grados==0) return null;
        return (grados%2==0) ? "Par" : "Impar";
    }
    
}
