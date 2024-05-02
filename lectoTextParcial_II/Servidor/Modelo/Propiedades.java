package Modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Clase para manejar las propiedades del servidor.
 */
public class Propiedades {
    int envioPort; // Puerto de envío
    int reciboPort; // Puerto de recepción

    /**
     * Obtiene el puerto de envío.
     * @return Puerto de envío.
     */
    public int getEnvioPort() {
        return envioPort;
    }

    /**
     * Obtiene el puerto de recepción.
     * @return Puerto de recepción.
     */
    public int getReciboPort() {
        return reciboPort;
    }

    /**
     * Constructor para inicializar los puertos de envío y recepción desde un archivo de propiedades.
     * @throws IOException Si hay un error de entrada/salida.
     */
    public Propiedades() throws IOException {
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream("Servidor/DATAServidor/IPs.properties");
        prop.load(input);
        
        // Lee los puertos de envío y recepción desde el archivo de propiedades
        envioPort = Integer.parseInt(prop.getProperty("envioIP"));
        reciboPort = Integer.parseInt(prop.getProperty("reciboIP"));
    }
}

