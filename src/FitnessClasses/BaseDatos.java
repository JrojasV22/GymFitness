

package FitnessClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BaseDatos {
    // Driver JDBC para MySQL
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    // URL de conexión a la base de datos específica
    private static final String bbdd = "jdbc:mysql://localhost:3306/GimnasiosFitness?useSSL=false&serverTimezone=UTC";
    // Usuario y contraseña de MySQL
    private static final String usuario = "root";
    private static final String clave = "Tata1998";

    // Método para inicializar la base de datos
    public static void inicializar() {


        try {
            // Cargar el driver de MySQL
            Class.forName(driver);
            // Conexión a MySQL sin seleccionar base de datos, para crearla si no existe
            String urlSinBD = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
            try (Connection conn = DriverManager.getConnection(urlSinBD, usuario, clave);
                 Statement stmt = conn.createStatement()) {
                
                // Crear base de datos GimnasiosFitness si no existe, con codificación UTF-8
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS GimnasiosFitness CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;");
            }

            System.out.println("Base de datos GimnasiosFitness verificada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
}

