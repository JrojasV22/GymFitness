
package gimnasiosfidness;

import java.util.ArrayList;
import java.util.List;

public class Rutina {
    private String nombre;
    private List<Ejercicio> ejercicios;

    public Rutina(String nombre) {
        this.nombre = nombre;
        this.ejercicios = new ArrayList<>();
    }

    public void agregarEjercicio(Ejercicio e) {
        ejercicios.add(e);
    }

    public String mostrarResumen() {
        return "Rutina: " + nombre + " (" + ejercicios.size() + " ejercicios)";
    }

    public String verRutina() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rutina: ").append(nombre).append("\n");
        for (Ejercicio e : ejercicios) {
            sb.append("- ").append(e.mostrarResumen()).append("\n");
        }
        return sb.toString();
    }

    public String getNombre() { return nombre; }
    public List<Ejercicio> getEjercicios() { return ejercicios; }
}
