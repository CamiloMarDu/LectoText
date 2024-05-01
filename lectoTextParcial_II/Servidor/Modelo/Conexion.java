package Modelo;

import java.io.IOException;
import java.net.ServerSocket;





public class Conexion {
	private ServerSocket serv; // para comunicación
    private ServerSocket serv2; // para enviar mensajes
    private Propiedades prop;

    /**
     * Constructor para establecer la conexión del servidor.
     * @throws IOException Si hay un error de entrada/salida.
     */
    public Conexion() throws IOException {
        prop = new Propiedades();

        serv = new ServerSocket(prop.getEnvioPort());
        serv2 = new ServerSocket(prop.getReciboPort());
    }

    /**
     * Obtiene el socket del servidor para la comunicación.
     * @return El socket del servidor.
     */
    public ServerSocket getServ() {
        return serv;
    }

    /**
     * Establece el socket del servidor para la comunicación.
     * @param serv El socket del servidor.
     */
    public void setServ(ServerSocket serv) {
        this.serv = serv;
    }

    /**
     * Obtiene el socket del servidor para enviar mensajes.
     * @return El socket del servidor.
     */
    public ServerSocket getServ2() {
        return serv2;
    }

    /**
     * Establece el socket del servidor para enviar mensajes.
     * @param serv2 El socket del servidor.
     */
    public void setServ2(ServerSocket serv2) {
        this.serv2 = serv2;
    }  
}
