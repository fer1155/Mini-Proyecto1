
package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import modelo.Persona;


public class VentanaEmergente extends JFrame {
    private JLayeredPane layeredPane;
    private JPanel panel;
    private Persona jugador;
    private JLabel etiqueta1;
    public VentanaEmergente (Persona jugador){
        this.jugador = jugador;
        //this.setSize(900,600);
        this.setBounds(405, 195, 500, 320);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tamaños");
        setResizable(false);
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        establecerLayeredPanel();
        establecerPanel();
        establecerEtiqueta();
        
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
        etiqueta1 = new JLabel("<html>¿Estás seguro de finalizar el juego?</html>");
        etiqueta1.setBounds(65, 30, 350, 200);
        //etiqueta1.setVerticalAlignment(SwingConstants.CENTER);
        etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta1.setOpaque(true); 
        Color colorFondo2 = new Color(215, 250, 245);
        etiqueta1.setBackground(colorFondo2);
        Color colorBorde = new Color(7, 83, 176);
        etiqueta1.setBorder(BorderFactory.createLineBorder(colorBorde,4,false));
        Color colorLetra = new Color(51, 51, 51);
        etiqueta1.setForeground(colorLetra);
        etiqueta1.setFont(new Font("Centaur", 1, 30));
        layeredPane.add(etiqueta1, JLayeredPane.PALETTE_LAYER);    
    }
    
   
    
    
    
}

