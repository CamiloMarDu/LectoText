package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

import vista.WCliente;
import ModeloCliente.Conexion;

/**
 * Gestiona la interacción del cliente LectoText.
 */
public class GestorCliente implements ActionListener {
    private WCliente vista;
    String usuario;
    String Contraseña;
    String estado;
    public static String IP_SERVER;

    DataInputStream entrada = null;
    DataOutputStream salida = null;
    DataInputStream entrada2 = null;
    Socket comunication = null; // para la comunicacion
    Socket comunication2 = null; // para recibir msg

    /**
     * Constructor de la clase GestorCliente.
     * @throws IOException Si hay un error de entrada/salida.
     */
    public GestorCliente() throws IOException {
        vista = new WCliente();

        // Peticion de datos para decidir si se abre o no la ventana
        IP_SERVER = vista.pedirIp();

        usuario = vista.pedirDato("Usuario:");
        Contraseña = vista.pedirDato("Contraseña:");
        estado = "false";
        conexion();
        boolean veri = verificarUsuario();

        if (!veri) {
            vista.aviso("ESTE USUARIO NO ESTA REGISTRADO");
            System.exit(0);
        }
        saludar();
        vista.fieldCliente.setText(usuario);
        vista.setVisible(true);
        vista.setResizable(false);
        vista.setLocationRelativeTo(null);
        vista.setTitle("LectoText: LA APP INCLUSIVA (Cliente)");

        // Asigna los listeners a los botones
        this.vista.getBtnLeer().addActionListener(this);
        this.vista.getBtnLeer().setActionCommand("leer");

        this.vista.getBtnSalir().addActionListener(this);
        this.vista.getBtnSalir().setActionCommand("salir");

    }

    // Acciones de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "salir":
                if (this.vista.avisoCerrarVentana() == JOptionPane.YES_NO_OPTION) {
                    despedir();
                    System.exit(0);
                }
                break;
            case "leer":
                leer(vista.txaMostrar.getText());
                break;
        }
    }

    /**
     * Establece la conexión con el servidor.
     * @throws IOException Si hay un error de entrada/salida.
     */
    public void conexion() throws IOException {
        try {
            Conexion con = new Conexion(IP_SERVER);
            entrada = new DataInputStream(con.getComunication().getInputStream());
            salida = new DataOutputStream(con.getComunication().getOutputStream());
            entrada2 = new DataInputStream(con.getComunication2().getInputStream());

        } catch (IOException e) {
            vista.enConsola("\tEl servidor no está levantado");
            vista.enConsola("\t=============================");
        }

    }

    /**
     * Inicia el flujo de datos con el servidor.
     */
    public void flujo() {
        try {
            salida.writeUTF(usuario);
            salida.writeUTF(Contraseña);
            salida.writeUTF(IP_SERVER);
            salida.writeUTF(estado);
            salida.flush();

        } catch (IOException e) {
            vista.enConsola("error...." + e);
        }
    }

    /**
     * Verifica si el usuario está registrado en el servidor.
     * @return true si el usuario está registrado, false de lo contrario.
     */
    private boolean verificarUsuario() {
        try {
            salida.writeUTF(usuario);
            salida.writeUTF(Contraseña);
            salida.writeUTF(IP_SERVER);
            salida.writeUTF(estado);

            String respuesta = entrada.readUTF();
            return !respuesta.equals("servidor>>CLIENTE NO EXISTE");
        } catch (IOException e) {
            vista.enConsola("Error de comunicación con el servidor.");
            return false;
        }

    }

    /**
     * Envía un texto al servidor para ser leído.
     * @param texto El texto a ser leído.
     */
    public void leer(String texto) {
        try {
            String idioma = vista.getSelection(vista.groupIdiomas).getText();
            salida.writeUTF(idioma);
            salida.writeUTF(texto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Envía un saludo al servidor.
     */
    public void saludar() {
        leer("bienvenido " + usuario);
    }

    /**
     * Envía una despedida al servidor.
     */
    public void despedir() {
        leer("adios " + usuario);
    }
}

