/*
Miniproyecto No. 1

Fernando Cardona - 2241381
Oscar Mario Muñoz - 2242481

Grupo de FPOE: 80
*/

package modelo;

public class Ronda {
    private int ronda;
    private int aciertos;
    private int fallos;
    private int numeroIntentos;
    private int porcentajeAciertos;
    private int porcentajeFallos;

    //Constructor de ronda
    public Ronda() {
        this.ronda = 0;
        this.aciertos = 0;
        this.fallos = 0;
        this.numeroIntentos = 0;
        this.porcentajeAciertos = 0;
        this.porcentajeFallos = 0;
    }

    //Getters
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
  
    //Calcula el numero de rondas
    public int calcularRonda(){
        ronda += 1;
        return ronda;
    }
    
    //Calcula el numero de aciertos
    public int calcularAciertos(){
        aciertos += 1;
        return aciertos;
    }
    
    //Calcula el numero de fallos
    public int calcularFallos(){
        fallos += 1;
        return fallos;
    }   
    
    //Calcula el porcentaje de aciertos
    public int calcularPorcentajeAciertos (){
        if (getIntentos()!=0){
            porcentajeAciertos = (aciertos * 100 ) / getIntentos();
        }else {
            porcentajeAciertos = 0;
        }
        
        return porcentajeAciertos;
    }
    
    //Calcula el porcentaje de fallos
    public int calcularPorcentajeFallos (){
        if (getIntentos()!=0){
            porcentajeFallos = (fallos * 100 ) / getIntentos();
        }else {
            porcentajeFallos = 0;
        }
 
        return porcentajeFallos;
    }
}
