package modelo;

public class Ronda {
    private int ronda;
    private int aciertos;
    private int fallos;

    public Ronda() {
        this.ronda = 0;
        this.aciertos = 0;
        this.fallos = 0;
    }

    public int getRonda() {
        return ronda;
    }

    public int getAciertos() {
        return aciertos;
    }
    
    public int getFallos() {
        return fallos;
    }
  
    public int calcularRonda(){
        ronda += 1;
        return ronda;
    }
    
    public int calcularAciertos(){
        aciertos += 1;
        return aciertos;
    }
    
    public int calcularFallos(){
        fallos += 1;
        return fallos;
    }   
}
