package controlador;

import java.io.IOException;

/**
 * Clase principal que inicia el cliente LectoText.
 */
public class ClienteLectoText {
    /**
     * Método principal que inicia el cliente LectoText.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     * @throws IOException Si hay un error de entrada/salida.
     */
    public static void main(String[] args) throws IOException {
        // Crea una instancia del GestorCliente para iniciar el cliente LectoText
        new GestorCliente();
    }
}

