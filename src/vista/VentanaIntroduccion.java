package vista;

import modelo.Persona;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.*;

public class VentanaIntroduccion extends JFrame {  
    private JLayeredPane layeredPane;
    private JPanel panel;
    private JLabel etiqueta;
    private ImageIcon imagen;
    private JTextField cajaTexto;
    private JButton boton1;
    
    public VentanaIntroduccion (){
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
        establecerCajaDeTexto();
        establecerBoton();
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
        etiqueta = new JLabel("<html>¡Saludos, pequeños aventureros! Soy Rectangulin, el guardián de este mágico juego que están a punto de explorar, pero antes escribe tu nombre.</html>");
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

    private void establecerCajaDeTexto() {
        cajaTexto = new JTextField();
        cajaTexto.setBounds(400, 330, 300, 50);
        cajaTexto.setFont(new Font("Centaur", 1, 28));
        Color colorBorde = new Color(94, 94, 94);
        cajaTexto.setBorder(BorderFactory.createLineBorder(colorBorde,4,true));
        layeredPane.add(cajaTexto, JLayeredPane.MODAL_LAYER);
    }

    private void establecerBoton() {
        boton1 = new JButton("Iniciar Juego");
        boton1.setBounds(500, 480, 200, 40); 
        boton1.setForeground(Color.WHITE);
        boton1.setFont(new Font("Kristen ITC", 0, 25));
        Color colorFondoBtn = new Color(16, 113, 229);
        boton1.setBackground(colorFondoBtn);
        Color colorBorde = new Color(94, 94, 94);
        boton1.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(boton1, JLayeredPane.PALETTE_LAYER);
        
        ActionListener oyenteDeAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Persona jugador = new Persona(cajaTexto.getText());
                
                // Cierra la ventana introduccion
                dispose();
                // Abre la ventana principal
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(jugador);
                ventanaPrincipal.setVisible(true);
            }
        };
        
        boton1.addActionListener(oyenteDeAccion);
    }
}
