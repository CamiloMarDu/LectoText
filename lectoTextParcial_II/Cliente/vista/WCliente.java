package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.Enumeration;

public class WCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JScrollPane panelTexto;
    public JTextArea txaMostrar;
    private JButton btnLeer;
    private JPanel panel;
    private JLabel lblEnunciadoCliente;
    public JTextField fieldCliente;
    private JButton btnSalir;
    private JLabel lblNewLabel;

    public final ButtonGroup groupIdiomas = new ButtonGroup();
    public JRadioButton rdbtnEspañol;
    public JRadioButton rdbtnIngles;
    public JRadioButton rdbtnFrances;

    // Getters y Setters
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
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        txaMostrar = new JTextArea();
        txaMostrar.setFont(new Font("Monospaced", Font.PLAIN, 18));
        txaMostrar.setLineWrap(true);

        panelTexto = new JScrollPane(txaMostrar);
        panelTexto.setBounds(160, 280, 400, 150);
        contentPane.add(panelTexto);

        btnLeer = new JButton("   LEER");
        btnLeer.setSize(400, 45);
        btnLeer.setLocation(160, 430);
        btnLeer.setFont(new Font("Roboto", Font.BOLD, 30));
        imagenEnBoton("src/imgs/logoParlante.png", btnLeer, 50);

        JLabel lblEnunciado = new JLabel("<html>Digite el texto a leer:");
        lblEnunciado.setFont(new Font("Roboto", Font.BOLD, 18));
        lblEnunciado.setForeground(Color.WHITE);
        lblEnunciado.setBounds(20, 280, 130, 69);
        contentPane.add(lblEnunciado);

        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 584, 120);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblLogoLectoText = new JLabel("");
        lblLogoLectoText.setBounds(27, 11, 110, 98);
        imagenEnLabel("src/imgs/logoLectoText.png", lblLogoLectoText);

        lblNewLabel = new JLabel("LectoText: App Inclusiva");
        lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
        lblNewLabel.setBounds(147, 28, 379, 59);
        panel.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setForeground(Color.WHITE);
        separator.setBounds(10, 258, 564, 2);
        contentPane.add(separator);

        lblEnunciadoCliente = new JLabel("Cliente:");
        lblEnunciadoCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEnunciadoCliente.setForeground(Color.WHITE);
        lblEnunciadoCliente.setBounds(40, 148, 65, 19);
        contentPane.add(lblEnunciadoCliente);

        btnSalir = new JButton("SALIR");
        btnSalir.setFont(new Font("Roboto", Font.BOLD, 18));
        btnSalir.setBounds(459, 216, 101, 31);
        contentPane.add(btnSalir);

        JSeparator separatorCliente = new JSeparator();
        separatorCliente.setForeground(Color.WHITE);
        separatorCliente.setBounds(40, 192, 279, 2);
        contentPane.add(separatorCliente);

        fieldCliente = new JTextField();
        fieldCliente.setEnabled(false);
        fieldCliente.setEditable(false);
        fieldCliente.setBounds(119, 150, 200, 20);
        contentPane.add(fieldCliente);
        fieldCliente.setColumns(10);

        rdbtnFrances = new JRadioButton("Francés");
        groupIdiomas.add(rdbtnFrances);
        rdbtnFrances.setFont(new Font("Roboto", Font.BOLD, 16));
        rdbtnFrances.setForeground(Color.WHITE);
        rdbtnFrances.setBackground(Color.BLACK);
        rdbtnFrances.setBounds(20, 371, 109, 23);
        contentPane.add(rdbtnFrances);

        rdbtnEspañol = new JRadioButton("Español");
        rdbtnEspañol.setSelected(true);
        groupIdiomas.add(rdbtnEspañol);
        rdbtnEspañol.setFont(new Font("Roboto", Font.BOLD, 16));
        rdbtnEspañol.setForeground(Color.WHITE);
        rdbtnEspañol.setBackground(Color.BLACK);
        rdbtnEspañol.setBounds(20, 395, 109, 23);
        contentPane.add(rdbtnEspañol);

        rdbtnIngles = new JRadioButton("Inglés");
        groupIdiomas.add(rdbtnIngles);
        rdbtnIngles.setFont(new Font("Roboto", Font.BOLD, 16));
        rdbtnIngles.setBackground(Color.BLACK);
        rdbtnIngles.setForeground(Color.WHITE);
        rdbtnIngles.setBounds(20, 421, 109, 23);
        contentPane.add(rdbtnIngles);
    }

    /**
     * Obtiene el botón seleccionado de un grupo de botones.
     *
     * @param group Grupo de botones.
     * @return El botón seleccionado.
     */
    public static JRadioButton getSelection(ButtonGroup group) {
        for (Enumeration e = group.getElements(); e.hasMoreElements(); ) {
            JRadioButton b = (JRadioButton) e.nextElement();
            if (b.getModel() == group.getSelection()) {
                return b;
            }
        }
        return null;
    }

    /**
     * Muestra un cuadro de diálogo para ingresar un dato.
     *
     * @param mensajeSoli El mensaje solicitando el dato.
     * @return El dato ingresado por el usuario.
     */
    public String pedirDato(String mensajeSoli) {
        return JOptionPane.showInputDialog(mensajeSoli);
    }

    /**
     * Muestra un cuadro de diálogo para confirmar el cierre de la ventana.
     *
     * @return La opción seleccionada por el usuario (Sí o No).
     */
    public int avisoCerrarVentana() {
        return JOptionPane.showConfirmDialog(null, "¿Está seguro que cerrar la ventana?", "Advertencia", JOptionPane.YES_NO_OPTION);
    }

    /**
     * Muestra un cuadro de diálogo con un mensaje.
     *
     * @param mensaje El mensaje a mostrar.
     */
    public void aviso(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /**
     * Imprime un mensaje en la consola.
     *
     * @param mensaje El mensaje a imprimir.
     */
    public void enConsola(Object mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Coloca una imagen en un botón.
     *
     * @param imagen La ruta de la imagen.
     * @param boton  El botón en el que se colocará la imagen.
     * @param tam    Tamaño de la imagen, cuadrado.
     */
    public void imagenEnBoton(String imagen, JButton boton, int tam) {
        ImageIcon img_foto = new ImageIcon(imagen);
        Image imgIns = img_foto.getImage();
        Image newImg = imgIns.getScaledInstance(tam, tam, Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(newImg);
        boton.setIcon(finalImage);
        contentPane.add(boton);
    }

    /**
     * Coloca una imagen en un JLabel.
     *
     * @param imagen La ruta de la imagen.
     * @param label  El JLabel en el que se colocará la imagen.
     */
    public void imagenEnLabel(String imagen, JLabel label) {
        ImageIcon img_foto = new ImageIcon(imagen);
        Image imgIns = img_foto.getImage();
        Image newImg = imgIns.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(newImg);
        label.setIcon(finalImage);
        panel.add(label);
    }

    /**
     * Solicita al usuario la IP del servidor.
     *
     * @return La IP del servidor ingresada por el usuario.
     */
    public String pedirIp() {
        return JOptionPane.showInputDialog("Introducir IP_SERVER :", "localhost");
    }
}
