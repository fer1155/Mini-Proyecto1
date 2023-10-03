/*
Miniproyecto No. 1

Fernando Cardona - 2241381
Oscar Mario Muñoz - 2242481

Grupo de FPOE: 80
*/

package modelo;

public class Persona {
    private String nombre;

    //Constructor de persona
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    //Getter
    public String getNombre() {
        return nombre;
    }

    //Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
