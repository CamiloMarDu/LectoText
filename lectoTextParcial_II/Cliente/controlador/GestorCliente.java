package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

import ModeloCliente.Conexion;
import vista.WCliente;


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
    Socket comunication2 = null; // para recivir msg
	
	public GestorCliente() throws IOException {
		vista=new WCliente();
		
		//Peticion de datos para decidir si se abre o no la ventana
		IP_SERVER=vista.pedirIp();
	
		usuario=vista.pedirDato("Usuario:");
		Contraseña=vista.pedirDato("Contraseña:");
		estado="false";
		conexion();
		boolean veri =verificarUsuario();
		
		if (!veri) {
	        
	        System.exit(0);
	   
		}
		vista.setVisible(true);
        vista.setResizable(false);
        vista.setLocationRelativeTo(null);
        vista.setTitle("LectoText: LA APP INCLUSIVA (Cliente)");
        
        this.vista.getBtnLeer().addActionListener(this);
        this.vista.getBtnLeer().setActionCommand("leer");

        this.vista.getBtnSalir().addActionListener(this);
        this.vista.getBtnSalir().setActionCommand("salir");
		
		
        
	}
	
	//Acciones de los botones
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 switch (e.getActionCommand()) {
         case "salir":
        	 if (this.vista.avisoCerrarVentana() == JOptionPane.YES_NO_OPTION) {
                 
        		 
             }
             break;
         case "leer":
           
             break;
		 }
	}
	public void conexion() throws IOException {
        try {
            Conexion con = new Conexion(IP_SERVER);
            entrada = new DataInputStream(con.getComunication().getInputStream());
            salida = new DataOutputStream(con.getComunication().getOutputStream());
            entrada2 = new DataInputStream(con.getComunication2().getInputStream());
            
        } catch (IOException e) {
        	vista.enConsola("\tEl servidor no esta levantado");
        	vista.enConsola("\t=============================");
        }
        new threadCliente(entrada2, vista).start();
    }
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

	private boolean verificarUsuario() {
	    try {
	        // Envía los datos al servidor para verificar
	        salida.writeUTF(usuario);
	        salida.writeUTF(Contraseña);
	        salida.writeUTF(IP_SERVER);
	        salida.writeUTF(estado);

	        // Espera la respuesta del servidor
	        String respuesta = entrada.readUTF();
	        return !respuesta.equals("servidor>>CLIENTE NO EXISTE");
	    } catch (IOException e) {
	        vista.enConsola("Error de comunicación con el servidor.");
	        return false;
	    }
	
}
}
