package modelo;

public class Ronda {
    private int ronda;
    private int aciertos;

    public Ronda() {
        this.ronda = 0;
        this.aciertos = 0;
    }

    public int getRonda() {
        return ronda;
    }

    public int getAciertos() {
        return aciertos;
    }
    
     public int calcularAciertos(){
        aciertos += 1;
        return aciertos;
    }
    
    
    public int calcularRonda(){
        ronda += 1;
        return ronda;
    }
    
    
}
