
package FitnessClasses;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExportarRutina {
    private String rutaDestino;// Ruta del archivo donde se guardará la rutina

    // Constructor: recibe la ruta de destino para el archivo de exportación
    public ExportarRutina(String rutaDestino) {
        this.rutaDestino = rutaDestino;
    }

    // Método que exporta una rutina a un archivo de texto
    public void exportar(Rutina rutina) throws IOException {
        // Crear un escritor de archivos hacia la ruta indicada
        PrintWriter writer = new PrintWriter(new FileWriter(rutaDestino));
        
        // Escribir el nombre de la rutina como encabezado
        writer.println("Rutina: " + rutina.getNombre());
        
        // Iterar sobre cada ejercicio de la rutina y escribir sus detalles
        for (Ejercicio e : rutina.getEjercicios()) {
            writer.println(e.mostrarDetalle());
            writer.println();
        }
        
        // Cerrar el escritor para asegurar que se guarden los dato
        writer.close();
    }
}
