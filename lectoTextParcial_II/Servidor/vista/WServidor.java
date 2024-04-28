package vista;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WServidor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public WServidor() {
		iniciarVentana();
	}
	public void iniciarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,400,200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}
	
	/**
	 * Muestra un aviso con el mensaje proporcionado.
	 * @param mensaje El mensaje a mostrar.
	 */
	public void aviso(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	/**
	 * Imprime un mensaje en la consola.
	 * @param mensaje El mensaje a imprimir.
	 */
	public void enConsola(Object mensaje) {
		System.out.println(mensaje);
	}

}
