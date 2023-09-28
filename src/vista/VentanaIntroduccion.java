
package vista;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VentanaIntroduccion extends JFrame {  
    private JPanel panel; 
    private JLabel etiqueta;
    
    public VentanaIntroduccion (){
        this.setSize(900,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tamaños");
        setResizable(false);
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        establecerPanel();
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
        etiqueta = new JLabel("Holi");
        etiqueta.setBounds(140, 70, 600, 400);
        etiqueta.setOpaque(true); 
        etiqueta.setBackground(Color.blue);
        panel.add(etiqueta);    
    }
}
