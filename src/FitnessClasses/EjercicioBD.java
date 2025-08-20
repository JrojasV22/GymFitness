
package FitnessClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjercicioBD {
    // Método para guardar un ejercicio en la base de datos
    public void guardar(Ejercicio ejercicio) {
        // Consulta SQL con parámetros para insertar un nuevo ejercicio
        String sql = "INSERT INTO ejercicio(nombre, categoria, descripcion, dificultad, nivel) VALUES (?, ?, ?, ?, ?)";
        
        try (
            // Obtener conexión a la base de datos usando la clase ConexionBD
            Connection conn = ConexionBD.getConexion();
            // Preparar la sentencia SQL con opción de obtener las llaves generadas automáticamente
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            // Asignar valores de la clase Ejercicio a los parámetros de la consulta
            stmt.setString(1, ejercicio.getNombre());
            stmt.setString(2, ejercicio.getCategoria());
            stmt.setString(3, ejercicio.getDescripcion());
            stmt.setString(4, ejercicio.getDificultad());
            stmt.setString(5, ejercicio.getNivel());
            
            // Ejecutar la inserción en la base de datos
            stmt.executeUpdate();

            // Obtener el ID generado automáticamente por la base de datos
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                ejercicio.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
