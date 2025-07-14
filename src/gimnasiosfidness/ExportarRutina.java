
package gimnasiosfidness;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExportarRutina {
    private String rutaDestino;

    public ExportarRutina(String rutaDestino) {
        this.rutaDestino = rutaDestino;
    }

    public void exportar(Rutina rutina) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(rutaDestino));
        writer.println("Rutina: " + rutina.getNombre());
        for (Ejercicio e : rutina.getEjercicios()) {
            writer.println(e.mostrarDetalle());
            writer.println();
        }
        writer.close();
    }
}
