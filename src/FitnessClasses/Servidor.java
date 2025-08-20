

package FitnessClasses;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Consumer;

public class Servidor extends Thread {
    protected static final int PUERTO = 12341;  // Puerto en el que escuchará el servidor
    private volatile boolean activo = true;     // Controla si el servidor sigue corriendo
    private Consumer<String> log;               // Función para mostrar mensajes en la GUI o consola
    private ServerSocket vSocketServidor;       // Socket para aceptar conexiones de cliente
    private static int totalClientes = 0;       // Contador de clientes conectados
    
    // Instancia de Autenticacion para manejar usuarios
    private Autenticacion autenticacion = new Autenticacion();

    // Constructor recibe un Consumer para mostrar logs
    public Servidor(Consumer<String> log) {
        this.log = log;
        
        
    }

    // Método para detener el servidor y cerrar el socket
    public void detenerServidor() {
        activo = false;
        try {
            if (vSocketServidor != null && !vSocketServidor.isClosed()) {
                vSocketServidor.close();
            }
        } catch (IOException e) {
            log.accept("Error al cerrar el servidor: " + e.getMessage());
        }
    }
    

    // Método principal del hilo servidor
    @Override
    public void run() {
        try {
            vSocketServidor = new ServerSocket(PUERTO);  // Inicia el socket servidor
            log.accept("Servidor iniciado en puerto: " + PUERTO);

            // Bucle para aceptar clientes mientras el servidor esté activo
            while (activo) {
                Socket cliente = vSocketServidor.accept();
                log.accept("Cliente conectado: " + cliente.getInetAddress());
                
                // Crea un hilo para manejar cada cliente de forma independiente
                new Thread(() -> manejarCliente(cliente)).start();
            }
        } catch (IOException e) {
            if(activo) log.accept("Error en servidor: " + e.getMessage());
        }
    }

    
    // Método para manejar la comunicación con un cliente
    private void manejarCliente(Socket clienteSocket) {
        try (
            ObjectOutputStream salida = new ObjectOutputStream(clienteSocket.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(clienteSocket.getInputStream())
        ) {
            String accion = (String) entrada.readObject();  // Lee la acción que quiere hacer el cliente
            log.accept("Acción recibida: " + accion);

            switch (accion) {
                
               
             
                case "login":
                    // Validar credenciales usando Autenticacion
                    String usuario = (String) entrada.readObject();
                    String pass = (String) entrada.readObject();
                    try {
                        Usuario u = autenticacion.validarCredenciales(usuario, pass);
                        totalClientes++; // Incrementa el contador de clientes
                        log.accept("Cliente autenticado: " + u.getNombre() + ". Total de clientes: " + totalClientes);
                        salida.writeObject("Acceso permitido.");
                    } catch (Exception ex) {
                        salida.writeObject("Usuario o contraseña incorrectos.");
                        log.accept("Error login: " + ex.getMessage());
                    }
                    break;

                case "guardarRutina":
                    Rutina rutina = (Rutina) entrada.readObject();
                    // Guardar la rutina en la BD creando la tabla con el nombre de la rutina
                    RutinaBD.guardarRutina(rutina.getNombre(), rutina.getEjercicios());
                    salida.writeObject("Rutina guardada correctamente en BD.");
                    break;

                default:
                    salida.writeObject("Acción no reconocida: " + accion);
            }
        } catch (Exception e) {
            log.accept("Error manejando cliente: " + e.getMessage());
        }
    }
}
