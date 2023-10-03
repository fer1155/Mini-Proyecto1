/*
Miniproyecto No. 1

Fernando Cardona - 2241381
Oscar Mario Muñoz - 2242481

Grupo de FPOE: 80
*/

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import modelo.Persona;
import modelo.Ronda;

public class VentanaPrincipal extends JFrame {
    private JLayeredPane layeredPane;
    private JPanel panel;
    private Persona jugador;
    private JLabel etiqueta;
    private JButton boton1;
    private JButton boton2;
    private ImageIcon imagen1;
    private ImageIcon imagen2;
    private Ronda ronda = new Ronda();
    
    //Constructor de la ventana Principal
    public VentanaPrincipal (Persona jugador){
        this.jugador = jugador;
        this.setBounds(200, 50, 900, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tamaños");
        setResizable(false);
        iniciarComponentes();
    }
    
    //Inicia los componentes graficos
    private void iniciarComponentes(){
        establecerLayeredPanel();
        establecerPanel();
        establecerEtiqueta();
        establecerBoton1();
        establecerBoton2();
        establecerImagen1();
        establecerImagen2();
    }
    
    //Establece el layeredPanel (Para trabajar con capas)
    private void establecerLayeredPanel() {
        layeredPane = new JLayeredPane();
        this.add(layeredPane);
    }
    
    //Establece el panel
    private void establecerPanel() {
        panel = new JPanel();
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        Color colorFondo = new Color(184, 245, 237);
        panel.setBackground(colorFondo);
        panel.setLayout(null);
        layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);
    }
    
    //Establece la label inicial (marco)
    private void establecerEtiqueta() {
        etiqueta = new JLabel();
        etiqueta.setBounds(140, 50, 600, 400);
        etiqueta.setOpaque(true); 
        Color colorFondo2 = new Color(215, 250, 245);
        etiqueta.setBackground(colorFondo2);
        Color colorBorde = new Color(7, 83, 176);
        etiqueta.setBorder(BorderFactory.createLineBorder(colorBorde,4,false));
        layeredPane.add(etiqueta, JLayeredPane.PALETTE_LAYER);  
    }
    
    //Establece el boton que redirecciona al juego
    private void establecerBoton1() {
        boton1 = new JButton("Jugar");
        boton1.setFocusPainted(false);
        boton1.setBounds(290, 140, 300, 60); 
        boton1.setForeground(Color.WHITE);
        boton1.setFont(new Font("Kristen ITC", 0, 30));
        Color colorFondoBtn = new Color(16, 113, 229);
        boton1.setBackground(colorFondoBtn);
        Color colorBorde = new Color(94, 94, 94);
        boton1.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(boton1, JLayeredPane.MODAL_LAYER);
        
        ActionListener oyenteDeAccion1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Reproduce un sonido al presionar el boton
                reproducirSonido("boton.wav");
                
                //Inicia la ronda
                ronda.calcularRonda();
                
                //Cierra la ventana principal
                dispose();
                
                //Abre la ventana juego
                VentanaJuegoTriangulo ventanaJuego = new VentanaJuegoTriangulo(jugador, ronda);
                ventanaJuego.setVisible(true);
            }
        };
        boton1.addActionListener(oyenteDeAccion1);
    }
    
    //Establece el boton que redirecciona a la ventana instrucciones
    private void establecerBoton2() {
        boton2 = new JButton("Instrucciones");
        boton2.setBounds(290, 230, 300, 60); 
        boton2.setForeground(Color.WHITE);
        boton2.setFont(new Font("Kristen ITC", 0, 30));
        Color colorFondoBtn2 = new Color(16, 113, 229);
        boton2.setBackground(colorFondoBtn2);
        Color colorBorde2 = new Color(94, 94, 94);
        boton2.setBorder(BorderFactory.createLineBorder(colorBorde2,3,true));
        layeredPane.add(boton2, JLayeredPane.MODAL_LAYER);
        ActionListener oyenteDeAccion2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Reproduce un sonido al presionar el boton
                reproducirSonido("boton.wav");

                //Cierra la ventana principal
                dispose();
                
                //Abre la ventana de instrucciones
                VentanaInstrucciones ventanaInstrucciones = new VentanaInstrucciones(jugador);
                ventanaInstrucciones.setVisible(true);
            }
        };
        boton2.addActionListener(oyenteDeAccion2);
    }
    
    //Establece imagen de "cuadradin"
    private void establecerImagen1() {
        imagen1 = new ImageIcon("cuadradin.png");
        JLabel etiquetaImg1 = new JLabel();
        etiquetaImg1.setBounds(40, 310, 310, 260);
        etiquetaImg1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(etiquetaImg1.getWidth(), etiquetaImg1.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaImg1, JLayeredPane.MODAL_LAYER);
    }
    
    //Establece imagen de "circulin.png"
    private void establecerImagen2() {
        imagen2 = new ImageIcon("circulin.png");
        JLabel etiquetaImg2 = new JLabel();
        etiquetaImg2.setBounds(520, 300, 330, 270);
        etiquetaImg2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(etiquetaImg2.getWidth(), etiquetaImg2.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaImg2, JLayeredPane.MODAL_LAYER);
    }
    
    //Reproduce un sonido
    private void reproducirSonido(String audio) {
        try {
            //Carga el archivo de sonido
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audio));
            Clip clip = AudioSystem.getClip();

            // Abre el clip y lo reproduce
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
