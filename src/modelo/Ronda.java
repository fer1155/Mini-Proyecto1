package modelo;

public class Ronda {
    private int ronda;
    private int aciertos;
    private int fallos;
    private int numeroIntentos;
    private int porcentajeAciertos;
    private int porcentajeFallos;

    public Ronda() {
        this.ronda = 0;
        this.aciertos = 0;
        this.fallos = 0;
        this.numeroIntentos = 0;
        this.porcentajeAciertos = 0;
        this.porcentajeFallos =0;
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
    
    public int getIntentos(){
        numeroIntentos = (aciertos + fallos);
        return numeroIntentos;
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
    
    public int calcularPorcentajeAciertos (){
        porcentajeAciertos = (aciertos * 100 )/getIntentos();
        return porcentajeAciertos;
    }
    
    public int calcularPorcentajeFallos (){
        porcentajeFallos = (fallos * 100 )/getIntentos();
        return porcentajeFallos;
    }
}
