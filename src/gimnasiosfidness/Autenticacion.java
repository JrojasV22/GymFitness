
package gimnasiosfidness;

import java.util.ArrayList;
import java.util.List;

public class Autenticacion {
    private List<Usuario> usuariosRegistrados;

    public Autenticacion() {
        usuariosRegistrados = new ArrayList<>();
        usuariosRegistrados.add(new Usuario("Usuario", "Usuario@gmail.com", "1234")); 
    }   
 
    public Usuario validarCredenciales(String nombre, String contraseña) throws Exception {
        for (Usuario u : usuariosRegistrados) {
            if (u.iniciarSesion(nombre, contraseña)) {
                return u;
            }
        }
        throw new Exception("Usuario o contraseña incorrectos");
    } 
}
