/*
Miniproyecto No. 1

Fernando Cardona - 2241381
Oscar Mario Muñoz - 2242481

Grupo de FPOE: 80
*/

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import modelo.Persona;
import modelo.Ronda;

public class VentanaEmergente extends JFrame {
    private JLayeredPane layeredPane;
    private JPanel panel;
    private Persona jugador;
    private Ronda ronda;
    private JLabel etiqueta1;
    private JButton boton1;
    private JButton boton2;
    
    //Constructor de la ventana emergente
    public VentanaEmergente (Persona jugador, Ronda ronda){
        this.jugador = jugador;
        this.ronda = ronda;
        this.setBounds(405, 195, 500, 320);
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
        etiqueta1 = new JLabel("<html>¿Estás seguro de finalizar el juego?</html>");
        etiqueta1.setBounds(95, 30, 285, 200);
        etiqueta1.setVerticalAlignment(SwingConstants.TOP);
        etiqueta1.setOpaque(true); 
        Color colorFondo2 = new Color(215, 250, 245);
        etiqueta1.setBackground(colorFondo2);
        Color colorBorde = new Color(7, 83, 176);
        etiqueta1.setBorder(BorderFactory.createLineBorder(colorBorde,4,false));
        Color colorLetra = new Color(51, 51, 51);
        etiqueta1.setForeground(colorLetra);
        etiqueta1.setFont(new Font("Century Gothic", 0, 33));
        layeredPane.add(etiqueta1, JLayeredPane.PALETTE_LAYER);    
    }
    
    //Establece el boton para volver a la ventana Juego correspondiente
    private void establecerBoton1() {
        boton1 = new JButton("volver");
        boton1.setFocusPainted(false);
        boton1.setBounds(115, 150, 110, 45); 
        boton1.setForeground(Color.WHITE);
        boton1.setFont(new Font("Kristen ITC", 0, 20));
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
                
                //Cierra la ventana emergente
                dispose();
            }
        };
        boton1.addActionListener(oyenteDeAccion1);
    }
    
    //Establece el boton que redirecciona a la ventana estadisticas
    private void establecerBoton2() {
        boton2 = new JButton("finalizar");
        boton2.setBounds(250, 150, 110, 45); 
        boton2.setForeground(Color.WHITE);
        boton2.setFont(new Font("Kristen ITC", 0, 20));
        Color colorFondoBtn2 = new Color(16, 113, 229);
        boton2.setBackground(colorFondoBtn2);
        Color colorBorde2 = new Color(94, 94, 94);
        boton2.setBorder(BorderFactory.createLineBorder(colorBorde2,3,true));
        layeredPane.add(boton2, JLayeredPane.MODAL_LAYER);
        
        ActionListener oyenteDeAccion2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Reproduce un sonido al presionar el boton
                reproducirSonido("click.wav");
                
                // Cierra todas las ventanas
                cerrarTodasLasVentanas();
                
                //Abre la ventana de estadisticas
                VentanaEstadisticas ventanaEstadistcas = new VentanaEstadisticas(jugador, ronda);
                ventanaEstadistcas.setVisible(true);
            }
        };
        boton2.addActionListener(oyenteDeAccion2);
    } 
    
    //Cierra todas las ventanas en ejecucion 
    public static void cerrarTodasLasVentanas() {
        Window[] windows = Window.getWindows();
        for(Window ventana : windows) {
            if(ventana instanceof JFrame) {
                ventana.dispose();
            }
        }
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

