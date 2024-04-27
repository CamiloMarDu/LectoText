package vista;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;

public class WCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane panelTexto;
	private JTextArea txaMostrar;
	private JButton btnLeer;
	private JPanel panel;
	private JLabel lblEnunciadoCliente;
	private JSeparator separator_1;
	private JTextField fieldCliente;
	private JButton btnSalir;

	
	//Getters y Setters
	public JButton getBtnLeer() {
		return btnLeer;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}

	/**
	 * Create the frame.
	 */
	public WCliente() {
		iniciar();
	}
	public void iniciar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txaMostrar=new JTextArea();
		txaMostrar.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txaMostrar.setLineWrap(true);
		
		panelTexto=new JScrollPane(txaMostrar);
		panelTexto.setBounds(160, 280, 400, 150);
		contentPane.add(panelTexto);
		

		
		btnLeer = new JButton("LEER");
		btnLeer.setSize(400, 45);
		btnLeer.setLocation(160, 430);
		btnLeer.setFont(new Font("Roboto", Font.BOLD, 30));
		contentPane.add(btnLeer);
		
		JLabel lblEnunciado = new JLabel("<html>Digite el texto a leer:");
		lblEnunciado.setFont(new Font("Roboto", Font.BOLD, 18));
		lblEnunciado.setForeground(new Color(255, 255, 255));
		lblEnunciado.setBounds(10, 330, 130, 69);
		contentPane.add(lblEnunciado);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 584, 120);
		contentPane.add(panel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(10, 258, 564, 2);
		contentPane.add(separator);
		
		lblEnunciadoCliente = new JLabel("Cliente:");
		lblEnunciadoCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnunciadoCliente.setForeground(new Color(255, 255, 255));
		lblEnunciadoCliente.setBounds(40, 148, 65, 19);
		contentPane.add(lblEnunciadoCliente);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Roboto", Font.BOLD, 18));
		btnSalir.setBounds(459, 216, 101, 31);
		contentPane.add(btnSalir);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(40, 192, 279, 2);
		contentPane.add(separator_1);
		
		fieldCliente = new JTextField();
		fieldCliente.setEnabled(false);
		fieldCliente.setEditable(false);
		fieldCliente.setBounds(119, 150, 200, 20);
		contentPane.add(fieldCliente);
		fieldCliente.setColumns(10);
	}
	
	
	public String pedirDato(String mensajeSoli) {
		return JOptionPane.showInputDialog(mensajeSoli);
    }
	
	/**
	 * Muestra un aviso para confirmar el cierre de la ventana.
	 * @return La opción seleccionada por el usuario (Sí o No).
	 */
	public int avisoCerrarVentana() {
		int val= JOptionPane.showConfirmDialog(null,"¿Está seguro que cerrar la ventana?", "Avertencia", JOptionPane.YES_NO_OPTION);
		return val;
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
