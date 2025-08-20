
package FitnessClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // URL de conexión a la base de datos GimnasiosFitness
    private static final String URL = "jdbc:mysql://localhost:3306/GimnasiosFitness?useSSL=false&serverTimezone=UTC";
    // Usuario y contraseña de MySQL
    private static final String USUARIO = "root";      
    private static final String CLAVE = "Tata1998";          

    // Método para obtener una conexión a la base de datos
    public static Connection getConexion() {
        Connection conexion = null;
        try {
            // Intentar establecer la conexión con la base de datos
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return conexion;
    }
}