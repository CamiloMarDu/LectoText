package controlador;

import java.io.IOException;
import java.net.Socket;



import Modelo.Conexion;
import vista.WServidor;



/**
 * Clase que gestiona el servidor.
 */
public class GestorServidor {
    WServidor vista;

    /**
     * Constructor de la clase GestorServidor.
     * Inicializa la vista del servidor y comienza a ejecutar el servidor.
     */
    public GestorServidor() {
        vista = new WServidor();

        vista.setVisible(true);
        vista.setResizable(false);
        vista.setTitle("LectoText: SERVIDOR");
        runServer();
    }

    /**
     * Ejecuta el servidor y maneja las conexiones de los clientes.
     */
    public void runServer() {
        boolean listening = true;
        try {
            Conexion con = new Conexion();
            vista.enConsola(".::Servidor activo :");

            while (listening) {
                Socket sock = null, sock2 = null;
                try {
                    vista.enConsola("Esperando Usuarios");
                    sock = con.getServ().accept();
                    sock2 = con.getServ2().accept();

                } catch (IOException e) {
                    vista.enConsola("Accept failed: " + con.getServ() + ", " + e.getMessage());
                    continue;
                }

                // Inicia un nuevo hilo para manejar la conexión del usuario
                threadServidor user = new threadServidor(sock, sock2, this);
                user.start();
            }
        } catch (IOException e) {
            vista.enConsola("error :" + e);
        }
    }
}
