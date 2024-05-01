package controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import ModeloCliente.Propiedades;
import vista.WCliente;



public class threadCliente extends Thread {
    /** Flujo de entrada de datos desde el servidor. */
    DataInputStream entrada;
    OutputStream salida;
    /** Instancia de la ventana del cliente. */
   
    /** Instancia para acceder a las propiedades del sistema. */
    Propiedades props = new Propiedades();
    /** Array de palabras prohibidas obtenidas de las propiedades. */
    WCliente ventCliente;

    /**
     * Constructor de la clase threadCliente.
     * @param entrada Flujo de entrada de datos desde el servidor.
     * @param vcli Instancia de la ventana del cliente.
     * @throws IOException Si ocurre un error de E/S.
     */
    public threadCliente(DataInputStream entrada, WCliente VentanaCliente) throws IOException {
        this.entrada = entrada;
        this.ventCliente=VentanaCliente;
    }
    public void run() {
      
        while (true) {
            try {
            	int opcion = entrada.readInt();
                }
             catch (IOException e) {
            	ventCliente.enConsola("Error en la comunicación " + "Información para el usuario");
                break;
            }
        
    ventCliente.enConsola("se desconecto el servidor");
    }
}
}

