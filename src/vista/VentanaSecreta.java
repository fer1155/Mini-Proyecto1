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

public class VentanaSecreta extends JFrame {
    private JLayeredPane layeredPane;
    private JPanel panel;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JButton boton1;
    private ImageIcon imagen;

    //Constructor de la ventana secreta
    public VentanaSecreta (){
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
        establecerEtiqueta2();
        establecerBoton1();
        establecerImagen();
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
    
    //Establece label
    private void establecerEtiqueta() {
        etiqueta1 = new JLabel("Fernando Cardona - 2241381");
        etiqueta1.setBounds(95, 90, 285, 40);
        Color colorLetra = new Color(51, 51, 51);
        etiqueta1.setForeground(colorLetra);
        etiqueta1.setFont(new Font("Century Gothic", 1, 20));
        layeredPane.add(etiqueta1, JLayeredPane.PALETTE_LAYER);    
    }
    
    //Establece label
    private void establecerEtiqueta2() {
        etiqueta2 = new JLabel("Oscar Mario Muñoz - 2242481");
        etiqueta2.setBounds(95, 130, 300, 40);
        Color colorLetra = new Color(51, 51, 51);
        etiqueta2.setForeground(colorLetra);
        etiqueta2.setFont(new Font("Century Gothic", 1, 20));
        layeredPane.add(etiqueta2, JLayeredPane.PALETTE_LAYER);    
    }
    
    //Establece el boton para volver a la ventana estadisticas
    private void establecerBoton1() {
        boton1 = new JButton("volver");
        boton1.setFocusPainted(false);
        boton1.setBounds(40, 200, 100, 40); 
        boton1.setForeground(Color.WHITE);
        boton1.setFont(new Font("Kristen ITC", 0, 20));
        boton1.setBackground(Color.RED);
        Color colorBorde = new Color(94, 94, 94);
        boton1.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(boton1, JLayeredPane.MODAL_LAYER);
        
        ActionListener oyenteDeAccion1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Reproduce un sonido al presionar el boton
                reproducirSonido("boton.wav");
                
                //Cierra la ventana secreta
                dispose();
            }
        };
        boton1.addActionListener(oyenteDeAccion1);
    }
    
    //Establece imagen de "Univalle"
    private void establecerImagen() {
        imagen = new ImageIcon("univalle.png");
        JLabel etiquetaImg = new JLabel();
        etiquetaImg.setBounds(35, 10, 400, 80);
        etiquetaImg.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaImg.getWidth(), etiquetaImg.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaImg, JLayeredPane.MODAL_LAYER);
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

