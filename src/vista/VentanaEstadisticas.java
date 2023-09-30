package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import modelo.Persona;

public class VentanaEstadisticas extends JFrame {
    private JLayeredPane layeredPane;
    private JPanel panel;
    private Persona jugador;
    private JLabel etiqueta;
    private ImageIcon imagen;
    
    public VentanaEstadisticas (Persona jugador){
        this.jugador = jugador;
        //this.setSize(900,600);
        this.setBounds(200, 50, 900, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tamaños");
        setResizable(false);
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        establecerLayeredPanel();
        establecerPanel();
        establecerEtiqueta();
        establecerImagen();
    
        System.out.println("El nombre es: " + jugador.getNombre());
    }
    
    private void establecerLayeredPanel() {
        layeredPane = new JLayeredPane();
        this.add(layeredPane);
    }
    
    private void establecerPanel() {
        panel = new JPanel();
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        Color colorFondo = new Color(184, 245, 237);
        panel.setBackground(colorFondo);
        panel.setLayout(null);
        layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);
    }
    private void establecerEtiqueta() {
        etiqueta = new JLabel("¡Gracias por jugar "+ jugador.getNombre()+"!" );
        etiqueta.setBounds(140, 50, 600, 400);
        etiqueta.setVerticalAlignment(SwingConstants.TOP);
        etiqueta.setOpaque(true); 
        Color colorFondo2 = new Color(215, 250, 245);
        etiqueta.setBackground(colorFondo2);
        Color colorBorde = new Color(7, 83, 176);
        etiqueta.setBorder(BorderFactory.createLineBorder(colorBorde,4,false));
        Color colorLetra = new Color(51, 51, 51);
        etiqueta.setForeground(colorLetra);
        etiqueta.setFont(new Font("Centaur", 1, 40));
        layeredPane.add(etiqueta, JLayeredPane.PALETTE_LAYER);    
    }

    private void establecerImagen() {
        imagen = new ImageIcon("rectangulin.png");
        JLabel etiquetaImg = new JLabel();
        etiquetaImg.setBounds(40, 330, 340, 290);
        etiquetaImg.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaImg.getWidth(), etiquetaImg.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaImg, JLayeredPane.MODAL_LAYER);
    }

}
