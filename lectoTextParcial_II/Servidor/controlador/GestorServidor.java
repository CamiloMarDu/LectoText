package controlador;

import java.io.IOException;
import java.net.Socket;

import Modelo.Conexion;
import vista.WServidor;

public class GestorServidor {
	WServidor vista;
	public GestorServidor() {
		vista=new WServidor();
		
		vista.setVisible(true);
        vista.setResizable(false);
        vista.setTitle("LectoText: SERVIDOR");
	}
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
