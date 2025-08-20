
package FitnessClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Rutina implements Serializable {
    private String nombre;
    private List<Ejercicio> ejercicios;

    public Rutina(String nombre, List<Ejercicio> ejercicios) {
        this.nombre = nombre;
        this.ejercicios = ejercicios;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }
}
