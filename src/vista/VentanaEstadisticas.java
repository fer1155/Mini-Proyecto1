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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import modelo.Persona;
import modelo.Ronda;

public class VentanaEstadisticas extends JFrame {
    private JLayeredPane layeredPane;
    private JPanel panel;
    private Persona jugador;
    private Ronda ronda;
    private JLabel etiqueta;
    private JLabel etiqueta2;
    private JLabel etiqueta3;
    private JLabel etiqueta4;
    private JLabel etiqueta5;
    private JLabel etiqueta6;
    private ImageIcon imagen;
    private JButton boton;
    private JButton botonSalir;
    private JButton botonSecreto;
    
    //Constructor de la ventana Estadisticas
    public VentanaEstadisticas (Persona jugador, Ronda ronda){
        this.jugador = jugador;
        this.ronda = ronda;
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
        establecerImagen();
        establecerEtiquetas();
        establecerBoton();
        establecerBotonSalir();
        establecerBotonSecreto();
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
    
    //Establece la label inicial (marco y texto inicial)
    private void establecerEtiqueta() {
        etiqueta = new JLabel("¡Gracias por jugar " + jugador.getNombre()+"! ¡Muy bien!" );
        etiqueta.setBounds(140, 50, 600, 400);
        etiqueta.setVerticalAlignment(SwingConstants.TOP);
        etiqueta.setOpaque(true); 
        Color colorFondo2 = new Color(215, 250, 245);
        etiqueta.setBackground(colorFondo2);
        Color colorBorde = new Color(7, 83, 176);
        etiqueta.setBorder(BorderFactory.createLineBorder(colorBorde,4,false));
        Color colorLetra = new Color(51, 51, 51);
        etiqueta.setForeground(colorLetra);
        etiqueta.setFont(new Font("Bell MT", 1, 32));
        layeredPane.add(etiqueta, JLayeredPane.PALETTE_LAYER);    
    }

    //Establece imagen de "Rectangulin"
    private void establecerImagen() {
        imagen = new ImageIcon("rectangulin.png");
        JLabel etiquetaImg = new JLabel();
        etiquetaImg.setBounds(40, 330, 340, 290);
        etiquetaImg.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaImg.getWidth(), etiquetaImg.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaImg, JLayeredPane.MODAL_LAYER);
    }
    
    //Establece label de las estadisticas
    private void establecerEtiquetas() {
        etiqueta2 = new JLabel("Estas fueron tus estadisticas: " );
        etiqueta2.setBounds(145, 110,440, 50);
        etiqueta2.setFont(new Font("Bell MT", 1, 32));
        layeredPane.add(etiqueta2, JLayeredPane.MODAL_LAYER);
        
        etiqueta3 = new JLabel("Cantidad de figuras desplegadas: " + ronda.getRonda());
        etiqueta3.setBounds(145, 155,550, 50);
        etiqueta3.setFont(new Font("Bell MT", 1, 32));
        layeredPane.add(etiqueta3, JLayeredPane.MODAL_LAYER);
        
        etiqueta4 = new JLabel("Cantidad de aciertos: " + ronda.getAciertos()+" ("+ronda.calcularPorcentajeAciertos()+"%)");
        etiqueta4.setBounds(145, 240,440, 50);
        etiqueta4.setFont(new Font("Bell MT", 1, 32));
        layeredPane.add(etiqueta4, JLayeredPane.MODAL_LAYER);
        
        etiqueta5 = new JLabel("Cantidad de fallos: "+ ronda.getFallos()+" ("+ronda.calcularPorcentajeFallos()+"%)" );
        etiqueta5.setBounds(145, 290,440, 50);
        etiqueta5.setFont(new Font("Bell MT", 1, 32));
        layeredPane.add(etiqueta5, JLayeredPane.MODAL_LAYER);
        
        etiqueta6 = new JLabel("Numero de intentos: " + ronda.getIntentos());
        etiqueta6.setBounds(145, 197,500, 50);
        etiqueta6.setFont(new Font("Bell MT", 1, 32));
        layeredPane.add(etiqueta6, JLayeredPane.MODAL_LAYER);
    }
    
    //Establece el boton para volver a la ventana introduccion
    private void establecerBoton() {
        boton = new JButton("Volver a jugar");
        boton.setFocusPainted(false);
        boton.setBounds(370, 475, 165, 45); 
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Britannic Bold", 0, 22));
        Color colorFondoBtn2 = new Color(232, 19, 19);
        boton.setBackground(colorFondoBtn2);
        Color colorBorde = new Color(94, 94, 94);
        boton.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(boton, JLayeredPane.MODAL_LAYER);
        
        ActionListener oyenteDeAccion1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Reproduce un sonido al presionar el boton
                reproducirSonido("boton.wav");
                
                //Cierra la ventana estadisticas
                dispose();
                
                //Abre la ventana de introducción
                VentanaIntroduccion ventanaIntroduccion = new VentanaIntroduccion();
                ventanaIntroduccion.setVisible(true);   
            }
        };
        boton.addActionListener(oyenteDeAccion1);
    }
    
    //Establece boton para salir totalmente del juego
    private void establecerBotonSalir() {
        botonSalir = new JButton("Salir");
        botonSalir.setFocusPainted(false);
        botonSalir.setBounds(570, 475, 150, 45); 
        botonSalir.setForeground(Color.WHITE);
        botonSalir.setFont(new Font("Britannic Bold", 0, 22));
        Color colorFondoBtn2 = new Color(232, 19, 19);
        botonSalir.setBackground(colorFondoBtn2);
        Color colorBorde = new Color(94, 94, 94);
        botonSalir.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(botonSalir, JLayeredPane.MODAL_LAYER);
        
        ActionListener oyenteDeAccion1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Reproduce un sonido al presionar el boton
                reproducirSonido("click.wav");
                
                //Cierra ventana estadisticas
                dispose();
            }
        };
        botonSalir.addActionListener(oyenteDeAccion1);
    }
    
    //Establece boton secreto (creditos)
    private void establecerBotonSecreto(){
        botonSecreto = new JButton();
        boton.setFocusPainted(false);
        botonSecreto.setBounds(300, 350, 100, 45); 
        layeredPane.add(botonSecreto, JLayeredPane.PALETTE_LAYER);
        
        ActionListener oyenteDeAccion1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproducirSonido("secreto.wav");
                
                //Abre la ventana secreta
                VentanaSecreta ventanaSecreta = new VentanaSecreta();
                ventanaSecreta.setVisible(true);
                
            }
        };
        botonSecreto.addActionListener(oyenteDeAccion1);
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