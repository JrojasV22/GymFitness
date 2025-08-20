
package FitnessClasses;

import java.util.ArrayList;
import java.util.List;

public class Autenticacion {
    // Lista que guarda los usuarios registrados en el sistema
    private List<Usuario> usuariosRegistrados;

    //Inicializa la lista de usuarios y agrega un usuario por defecto
    public Autenticacion() {
        usuariosRegistrados = new ArrayList<>();
        // Usuario por defecto: Admin con contraseña "1234"
        usuariosRegistrados.add(new Usuario("Admin", "1234")); 
    }   
 
    // Método para validar las credenciales de un usuario
    public Usuario validarCredenciales(String nombre, String contraseña) throws Exception {
        for (Usuario u : usuariosRegistrados) {
            // Verifica si el usuario y la contraseña coinciden
            if (u.iniciarSesion(nombre, contraseña)) {
                return u;
            }
        }
        // Lanza excepción si no se encuentra ningún usuario válido
        throw new Exception("Usuario o contraseña incorrectos");
    } 
}
