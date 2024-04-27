package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.WCliente;

public class GestorCliente implements ActionListener {
	private WCliente vista;
	
	public GestorCliente() {
		vista=new WCliente();
		//Peticion de datos para decidir si se abre o no la ventana
		
		//Creación de la ventana del cliente
		
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
	
}
