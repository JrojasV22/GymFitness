
package FitnessClasses;


public class Usuario extends Persona {
    private String contraseña;

    public Usuario(String nombre, String contraseña) {
        super(nombre);
        this.contraseña = contraseña;
    }

    public boolean iniciarSesion(String nombre, String contraseña) {
        return this.nombre.equals(nombre) && this.contraseña.equals(contraseña);
    }

    @Override
    public String mostrarPerfil() {
        return super.mostrarPerfil() + "\n(Tipo: Usuario)";
    }

    public String getContraseña() {
        return contraseña;
    }
}
