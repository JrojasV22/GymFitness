
package FitnessClasses;


public class Usuario {
    private String nombre;
    private String correo;
    private String contraseña;

    public Usuario(String nombre, String correo, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public boolean iniciarSesion(String nombre, String contraseña) {
        return this.nombre.equals(nombre) && this.contraseña.equals(contraseña);
    }

    public String mostrarPerfil() {
        return "Nombre: " + nombre + "\nCorreo: " + correo;
    }

    public String getNombre() {
        return nombre;
    }
    public String getCorreo() { 
        return correo; 
    }
    public String getContraseña() { 
        return correo; 
    }
}
