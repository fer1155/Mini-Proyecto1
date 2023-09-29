package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.*;
import modelo.Persona;

public class VentanaPrincipal extends JFrame {
    private JPanel panel;
    private JLabel etiqueta;
    private Persona jugador;
    private JButton boton1;
    private JButton boton2;
    private JLayeredPane layeredPane;
    
    public VentanaPrincipal (Persona jugador){
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
        establecerBoton1();
        establecerBoton2();
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
        etiqueta = new JLabel();
        etiqueta.setBounds(140, 50, 600, 400);
        etiqueta.setOpaque(true); 
        Color colorFondo2 = new Color(215, 250, 245);
        etiqueta.setBackground(colorFondo2);
        Color colorBorde = new Color(7, 83, 176);
        etiqueta.setBorder(BorderFactory.createLineBorder(colorBorde,4,false));
        layeredPane.add(etiqueta, JLayeredPane.PALETTE_LAYER);  
    }
    
    private void establecerBoton1() {
        boton1 = new JButton("Jugar");
        boton1.setBounds(290, 140, 300, 60); 
        boton1.setForeground(Color.WHITE);
        boton1.setFont(new Font("Kristen ITC", 0, 30));
        Color colorFondoBtn = new Color(16, 113, 229);
        boton1.setBackground(colorFondoBtn);
        Color colorBorde = new Color(94, 94, 94);
        boton1.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(boton1, JLayeredPane.MODAL_LAYER);
    }
    
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
    } 
}
