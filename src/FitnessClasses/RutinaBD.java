

package FitnessClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class RutinaBD {
    
    // Datos de conexión a la base de datos
    private static final String bbdd = "jdbc:mysql://localhost:3306/GimnasiosFitness?useSSL=false&serverTimezone=UTC";
    private static final String usuario = "root";
    private static final String clave = "Tata1998";

    // Método para guardar una rutina en la base de datos
    // Crea una tabla nueva con el nombre de la rutina si no existe y guarda los ejercicios
    public static void guardarRutina(String nombreRutina, List<Ejercicio> ejercicios) {
        String nombreTabla = nombreRutina.replaceAll("\\s+", "_"); // Reemplaza espacios por guiones bajos en el nombre de la tabla

                    try (Connection conn = DriverManager.getConnection(bbdd, usuario, clave);
                     Statement stmt = conn.createStatement()) {

                    // Crear tabla de la rutina si no existe
                    String crearTabla = "CREATE TABLE IF NOT EXISTS `" + nombreTabla + "` (" +
                                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                                        "nombre VARCHAR(100) NOT NULL," +
                                        "categoria VARCHAR(50)," +
                                        "descripcion TEXT," +
                                        "nivel VARCHAR(20)," +
                                        "dificultad VARCHAR(20)" +
                                        ")";
                    stmt.executeUpdate(crearTabla);

                     // Preparar SQL para insertar cada ejercicio en la tabla
                    String sql = "INSERT INTO `" + nombreTabla + "` (nombre, categoria, descripcion, nivel, dificultad) VALUES (?, ?, ?, ?, ?)";
                    try (PreparedStatement ps = conn.prepareStatement(sql)) {
                        
                        // Insertar cada ejercicio de la lista
                        for (Ejercicio e : ejercicios) {
                            ps.setString(1, e.getNombre());
                            ps.setString(2, e.getCategoria());
                            ps.setString(3, e.getDescripcion());
                            ps.setString(4, e.getNivel());
                            ps.setString(5, e.getDificultad());
                            ps.executeUpdate(); // Ejecuta inserción
                            System.out.println("Ejercicio agregado: " + e.getNombre());
                        }
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


    }

