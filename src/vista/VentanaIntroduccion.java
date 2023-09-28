
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class VentanaIntroduccion extends JFrame {  
    private JPanel panel;
    private JLabel etiqueta;
    private ImageIcon imagen;
    
    
    public VentanaIntroduccion (){
        this.setSize(900,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tamaños");
        setResizable(false);
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        establecerPanel();
        establecerImagen();
        establecerEtiqueta();
    }

    private void establecerPanel() {
        panel = new JPanel(); 
        this.getContentPane().add(panel);
        Color colorFondo = new Color(184, 245, 237);
        panel.setBackground(colorFondo);
        panel.setLayout(null);
    }

    private void establecerEtiqueta() {
        etiqueta = new JLabel("<html>¡Saludos, pequeños aventureros! Soy Rectangulin, el guardián de este mágico juego que están a punto de explorar, pero antes escribe tu nombre.</html>");
        etiqueta.setBounds(140, 70, 600, 400);
        etiqueta.setVerticalAlignment(SwingConstants.TOP);
        etiqueta.setOpaque(true); 
        Color colorFondo2 = new Color(215, 250, 245);
        etiqueta.setBackground(colorFondo2);
        Color colorBorde = new Color(7, 83, 176);
        etiqueta.setBorder(BorderFactory.createLineBorder(colorBorde,4,false));
        Color colorLetra = new Color(51, 51, 51);
        etiqueta.setForeground(colorLetra);
        etiqueta.setFont(new Font("Centaur", 0, 40));
        panel.add(etiqueta);    
    }

    private void establecerImagen() {
        imagen = new ImageIcon("rectangulin.png");
        JLabel etiquetaImg = new JLabel();
        etiquetaImg.setBounds(50, 400, 200, 200);
        etiquetaImg.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaImg.getWidth(), etiquetaImg.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etiquetaImg);
    }
}
