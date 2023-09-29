package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import modelo.Persona;

public class VentanaJuego extends JFrame {
    private JLayeredPane layeredPane;
    private JPanel panel;
    private Persona jugador;
    private ImageIcon imagen;
    private JLabel etiqueta1;
    private JButton boton1;
    private JLabel etiqueta2;
    private JLabel etiqueta3;
    private JLabel etiqueta4;
    private JLabel etiqueta5;
    private JButton boton2;
    
    public VentanaJuego (Persona jugador){
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
        establecerImagen();
        establecerEtiqueta1();
        establecerFigura1();
        establecerEtiqueta3();
        establecerEtiqueta4();
        establecerEtiqueta5();
        establecerBoton2();
        
        //establecerBoton1();
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
    
    private void establecerImagen() {
        imagen = new ImageIcon("linea.png");
        JLabel etiquetaImg = new JLabel();
        etiquetaImg.setBounds(200, 0, 80, 590);
        etiquetaImg.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaImg.getWidth(), etiquetaImg.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaImg, JLayeredPane.PALETTE_LAYER);
    }
    
    private void establecerEtiqueta1() {
        etiqueta1 = new JLabel("Jugador: " + jugador.getNombre());
        etiqueta1.setBounds(10, 20, 243, 50);
        Color colorLetra = new Color(51, 51, 51);
        etiqueta1.setForeground(colorLetra);
        etiqueta1.setFont(new Font("Kristen ITC", 1, 20));
        //etiqueta1.setOpaque(true); 
        //Color colorFondo2 = new Color(215, 250, 245);
        //etiqueta1.setBackground(colorFondo2);
        //Color colorBorde = new Color(7, 83, 176);
        //etiqueta1.setBorder(BorderFactory.createLineBorder(colorBorde,4,false));
        layeredPane.add(etiqueta1, JLayeredPane.PALETTE_LAYER);  
    }
    
    private void establecerBoton1() {        
        boton1 = new JButton(); 
        boton1.setBounds(50, 450, 80, 80); 
        ImageIcon imagen2 = new ImageIcon("triangulo.png");
        boton1.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
        Color colorFondoBt = new Color(184, 245, 237);
        boton1.setBackground(colorFondoBt);
        layeredPane.add(boton1, JLayeredPane.PALETTE_LAYER);
    }
    
    private void establecerFigura1() {
        ImageIcon figuraTriangulo = new ImageIcon("triangulo.png");
        etiqueta2 = new JLabel();
        etiqueta2.setBounds(50, 160, 110, 100); 
        etiqueta2.setIcon(new ImageIcon(figuraTriangulo.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiqueta2, JLayeredPane.PALETTE_LAYER);
        
        etiqueta2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Aquí puedes realizar alguna acción cuando se hace clic en la imagen
                System.out.println("HOlaaaaaaaa");
            }
        });
    }

    private void establecerEtiqueta3() {
         etiqueta3 = new JLabel("Aciertos: ");
         etiqueta3.setBounds(270, 20, 243, 50);
         Color colorLetra = new Color(51, 51, 51);
         etiqueta3.setForeground(colorLetra);
         etiqueta3.setFont(new Font("Kristen ITC", 1, 20));
         //etiqueta1.setOpaque(true); 
         //Color colorFondo2 = new Color(215, 250, 245);
         //etiqueta1.setBackground(colorFondo2);
         //Color colorBorde = new Color(7, 83, 176);
         //etiqueta1.setBorder(BorderFactory.createLineBorder(colorBorde,4,false));
         layeredPane.add(etiqueta3, JLayeredPane.PALETTE_LAYER);  
    }

    private void establecerEtiqueta4() {
        etiqueta4 = new JLabel("Fallos: ");
        etiqueta4.setBounds(720, 20, 243, 50);
        Color colorLetra = new Color(51, 51, 51);
        etiqueta4.setForeground(colorLetra);
        etiqueta4.setFont(new Font("Kristen ITC", 1, 20));
        //etiqueta1.setOpaque(true); 
        //Color colorFondo2 = new Color(215, 250, 245);
        //etiqueta1.setBackground(colorFondo2);
        //Color colorBorde = new Color(7, 83, 176);
        //etiqueta1.setBorder(BorderFactory.createLineBorder(colorBorde,4,false));
        layeredPane.add(etiqueta4, JLayeredPane.PALETTE_LAYER);  
    }

    private void establecerEtiqueta5() {
        etiqueta5 = new JLabel("Figura No: ");
        etiqueta5.setBounds(270, 490, 243, 50);
        Color colorLetra = new Color(51, 51, 51);
        etiqueta5.setForeground(colorLetra);
        etiqueta5.setFont(new Font("Kristen ITC", 1, 20));
        //etiqueta1.setOpaque(true); 
        //Color colorFondo2 = new Color(215, 250, 245);
        //etiqueta1.setBackground(colorFondo2);
        //Color colorBorde = new Color(7, 83, 176);
        //etiqueta1.setBorder(BorderFactory.createLineBorder(colorBorde,4,false));
        layeredPane.add(etiqueta5, JLayeredPane.PALETTE_LAYER);  
    }

    private void establecerBoton2() {
        boton2 = new JButton("Finalizar");
        boton2.setFocusPainted(false);
        boton2.setBounds(715, 490, 110, 45); 
        boton2.setForeground(Color.WHITE);
        boton2.setFont(new Font("Britannic Bold", 0, 22));
        Color colorFondoBtn2 = new Color(232, 19, 19);
        boton2.setBackground(colorFondoBtn2);
        Color colorBorde = new Color(94, 94, 94);
        boton2.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(boton2, JLayeredPane.MODAL_LAYER);
        
        ActionListener oyenteDeAccion1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Abre la ventana emergente
                VentanaEmergente ventanaEmergente = new VentanaEmergente(jugador);
                ventanaEmergente.setVisible(true);
            }
        };
        
        boton2.addActionListener(oyenteDeAccion1);
    }
}
