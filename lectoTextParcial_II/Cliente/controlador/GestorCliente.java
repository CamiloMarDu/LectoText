package controlador;

import vista.WCliente;

public class GestorCliente {
	private WCliente vista;
	
	public GestorCliente() {
		vista=new WCliente();
		
		vista.setVisible(true);
        vista.setResizable(false);
        vista.setLocationRelativeTo(null);
        vista.setTitle("LectoText: LA APP INCLUSIVA");
	}
}
