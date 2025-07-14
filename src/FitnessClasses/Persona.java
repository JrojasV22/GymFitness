
package FitnessClasses;


public class Persona {
    protected String nombre;
    

    public Persona(String nombre) {
        this.nombre = nombre;
        
    }

    public String getNombre() {
        return nombre;
    }

   

    public String mostrarPerfil() {
        return "Nombre: " + nombre ;
    }
}
