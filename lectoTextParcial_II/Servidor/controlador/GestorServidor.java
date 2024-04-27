package controlador;

import vista.WServidor;

public class GestorServidor {
	private WServidor vista;
	public GestorServidor() {
		vista=new WServidor();
		
		vista.setVisible(true);
        vista.setResizable(false);
        vista.setTitle("LectoText: SERVIDOR");
	}
}
