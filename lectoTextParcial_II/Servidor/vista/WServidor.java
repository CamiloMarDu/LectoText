package vista;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;

/**
 * Clase que representa la ventana del servidor.
 */
public class WServidor extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Constructor de la ventana del servidor.
     */
    public WServidor() {
        iniciarVentana();
    }

    /**
     * Inicializa la ventana del servidor.
     */
    public void iniciarVentana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 200);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogoLectoText = new JLabel("");
        lblLogoLectoText.setBounds(10, 25, 100, 100);
        imagenEnLabel("src/imgs/logoLectoText.png", lblLogoLectoText);

        JLabel lblNewLabel = new JLabel("<html>SERVIDOR ACTIVO");
        lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        lblNewLabel.setBounds(125, 101, 217, 49);
        contentPane.add(lblNewLabel);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("");
        rdbtnNewRadioButton.setSelected(true);
        rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
        rdbtnNewRadioButton.setBounds(348, 114, 21, 23);
        rdbtnNewRadioButton.setEnabled(false);
        contentPane.add(rdbtnNewRadioButton);

        JLabel lblNewLabel_1 = new JLabel("<html>LectoText: App Inclusiva");
        lblNewLabel_1.setBounds(120, 25, 209, 65);
        lblNewLabel_1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 25));
        contentPane.add(lblNewLabel_1);
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

    /**
     * Coloca la imagen en el label correspondiente.
     * @param imagen La ruta de la imagen.
     * @param label El label en el que se colocará la imagen.
     */
    public void imagenEnLabel(String imagen, JLabel label) {
        ImageIcon img_foto = new ImageIcon(imagen);
        Image imgIns = img_foto.getImage();
        Image newImg = imgIns.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(newImg);
        label.setIcon(finalImage);
        contentPane.add(label);
    }
}

