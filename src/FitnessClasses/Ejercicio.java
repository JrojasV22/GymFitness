
package FitnessClasses;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio {
    private int id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String nivel;
    private String dificultad;

    // Lista estática de ejercicios predefinidos
    private static List<Ejercicio> ejerciciosDisponibles = new ArrayList<>();

    static {
        ejerciciosDisponibles.add(new Ejercicio(
            "Sentadillas",
            "Pierna",
            "Flexionás las rodillas y bajás la cadera como si fueras a sentarte.",
            "Media",
            "Intermedio" 
        ));

        ejerciciosDisponibles.add(new Ejercicio(
            "Press de banca",
            "Pecho",
            "Acostate en una banca y empujá una barra con peso desde tu pecho hacia arriba.",
            "Alta",
             "Avanzado"
        ));

        ejerciciosDisponibles.add(new Ejercicio(
            "Curl de bíceps",
            "Brazo",
            "Levantá una pesa desde tu muslo hasta tu hombro manteniendo el codo fijo.",
            "Baja",
            "Principiante"

        ));

        ejerciciosDisponibles.add(new Ejercicio(
            "Remo con barra",
            "Espalda",
            "Desde una posición inclinada, jalá la barra hacia tu abdomen para trabajar la espalda.",
            "Alta",
            "Avanzado"
        ));

        ejerciciosDisponibles.add(new Ejercicio(
            "Plancha",
            "Core",
            "Apoyá los antebrazos y pies en el suelo, manteniendo el cuerpo recto.",
            "Media",
            "Intermedio"
        ));
    }

    public Ejercicio(String nombre, String categoria, String descripcion, String dificultad, String nivel) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.nivel = nivel;
    }

    public Ejercicio(int id, String nombre, String categoria, String descripcion, String dificultad, String nivel) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.nivel = nivel;
    }

    // Getters y setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getCategoria() { return categoria; }
    public String getNivel() { return nivel; }
    public String getDificultad() { return dificultad; }

    public void setId(int id) { this.id = id; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public String mostrarResumen() { return nombre + " - " + categoria; }
    public String mostrarDetalle() {
        return "Nombre: " + nombre +
               "\nCategoría: " + categoria +
               "\nNivel: " + nivel +
               "\nDescripción: " + descripcion +
               "\nDificultad: " + dificultad;
    }

    public static List<Ejercicio> getEjerciciosDisponibles() { return ejerciciosDisponibles; }
}

