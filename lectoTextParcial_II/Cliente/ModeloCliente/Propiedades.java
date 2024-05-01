package ModeloCliente;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propiedades {
	int envioPort; 
    int reciboPort;
  
    
    
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
     * Constructor para inicializar las propiedades desde un archivo de propiedades.
     * @throws IOException Si hay un error de entrada/salida.
     */
    public Propiedades() throws IOException {    
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream("Cliente/DATACliente/Cliente.properties");
        prop.load(input);
        
  
        
        envioPort = Integer.parseInt(prop.getProperty("envioIP"));
        reciboPort = Integer.parseInt(prop.getProperty("reciboIP"));
    }
}
