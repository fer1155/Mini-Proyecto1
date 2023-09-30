package modelo;

public class Ronda {
    private int ronda;

    public Ronda() {
        this.ronda = 1;
    }

    public int getRonda() {
        return ronda;
    }
    
    public int calcularRonda(){
        ronda += 1;
        return ronda;
    }
    
    
}
