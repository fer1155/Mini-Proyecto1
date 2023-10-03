/*
Miniproyecto No. 1

Fernando Cardona - 2241381
Oscar Mario Muñoz - 2242481

Grupo de FPOE: 80
*/

package vista;

import modelo.Persona;
import modelo.Ronda;
import modelo.Figura;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.util.Collections;
import javax.sound.sampled.*;

public class VentanaJuegoCuadrado extends JFrame {
    private Ronda ronda;
    private Persona jugador;
    private JLayeredPane layeredPane;
    private JPanel panel;
    private ImageIcon imagen;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JLabel etiqueta3;
    private JLabel etiqueta4;
    private JLabel etiqueta5;
    private JLabel etiqueta6;
    private JLabel etiqueta7;
    private JLabel etiqueta8;
    private JButton boton2;
    private int widthImgPrincipal;
    private int heightImgPrincipal;
    private Color colorPrincipal;
    private Figura figuraPrincipal;
    private Figura figurasSecundarias;
    
    //Constructor de la ventana juego de la figura cuadrado
    public VentanaJuegoCuadrado(Persona jugador, Ronda ronda){
        this.jugador = jugador;
        this.ronda = ronda;
        this.setBounds(200, 50, 900, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tamaños");
        setResizable(false);
        iniciarComponentes();
    }
    
    //Incicia los componentes graficos
    private void iniciarComponentes(){
        establecerLayeredPanelBase();
        establecerPanel();
        establecerImagen();
        establecerEtiqueta1();
        establecerFigura1();
        establecerFiguras();
        establecerEtiqueta3();
        establecerEtiqueta4();
        establecerEtiqueta5();
        establecerBoton2();
    }
    
    //Establece el layeredPanel (Para trabajar con capas)
    private void establecerLayeredPanelBase() {
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
    
    //Establece imagen de "linea"
    private void establecerImagen() {
        imagen = new ImageIcon("linea.png");
        JLabel etiquetaImg = new JLabel();
        etiquetaImg.setBounds(200, 0, 80, 590);
        etiquetaImg.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaImg.getWidth(), etiquetaImg.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaImg, JLayeredPane.PALETTE_LAYER);
    }
    
    //Establece label del nombre del jugador
    private void establecerEtiqueta1() {
        etiqueta1 = new JLabel("Jugador: " + jugador.getNombre());
        etiqueta1.setBounds(10, 20, 240, 50);
        Color colorLetra = new Color(51, 51, 51);
        etiqueta1.setForeground(colorLetra);
        etiqueta1.setFont(new Font("Kristen ITC", 1, 20));
        layeredPane.add(etiqueta1, JLayeredPane.PALETTE_LAYER);  
    }
    
    //Establece figura de la parte izquierda
    private void establecerFigura1() {
        
        //Se crea un objeto figura que proporcionara la misma figura con tres tamaños distintios (grande, mediano, pequeño)
        figuraPrincipal = new Figura("cuadrado.png");

        //Se crea la etiquetas fija donde iran posicionadas una de las tres figuras con distintos tamaños
        etiqueta2 = new JLabel();
        etiqueta2.setBounds(50, 180, 150, 150);
        etiqueta2.setHorizontalAlignment(JLabel.CENTER);
        etiqueta2.setVerticalAlignment(JLabel.CENTER);
        layeredPane.add(etiqueta2, JLayeredPane.PALETTE_LAYER);
        
        //Se añade a una lista las tres diferentes figuras anteriormente creadas con el obejto figuraPrincipal
        ArrayList<ImageIcon> listaDeImagenes = new ArrayList<>();
        listaDeImagenes.add(figuraPrincipal.getFiguraPequeñaConColorRandom());
        listaDeImagenes.add(figuraPrincipal.getfiguraMedianaConColorRandom());
        listaDeImagenes.add(figuraPrincipal.getfiguraGrandeConColorRandom());

        //Baraja la lista de imágenes para cambiar su orden
        Collections.shuffle(listaDeImagenes);
        
        //Asiga una de las tres figuras a la etiqueta
        etiqueta2.setIcon(listaDeImagenes.get(0));
        widthImgPrincipal = listaDeImagenes.get(0).getIconWidth();
        heightImgPrincipal = listaDeImagenes.get(0).getIconHeight();
        colorPrincipal  = figuraPrincipal.getColorAleatorio();
    }
    
    //Establece label de los aciertos
    private void establecerEtiqueta3() {
         etiqueta3 = new JLabel("Aciertos: " + ronda.getAciertos());
         etiqueta3.setBounds(270, 20, 243, 50);
         Color colorLetra = new Color(51, 51, 51);
         etiqueta3.setForeground(colorLetra);
         etiqueta3.setFont(new Font("Kristen ITC", 1, 20));
         layeredPane.add(etiqueta3, JLayeredPane.PALETTE_LAYER);  
    }
    
    //Establece label de los fallos
    private void establecerEtiqueta4() {
        etiqueta4 = new JLabel("Fallos: " + ronda.getFallos());
        etiqueta4.setBounds(720, 20, 243, 50);
        Color colorLetra = new Color(51, 51, 51);
        etiqueta4.setForeground(colorLetra);
        etiqueta4.setFont(new Font("Kristen ITC", 1, 20));
        layeredPane.add(etiqueta4, JLayeredPane.PALETTE_LAYER);  
    }

    //Establece label del numero de la ronda
    private void establecerEtiqueta5() {
        etiqueta5 = new JLabel("Figura No: " + ronda.getRonda());
        etiqueta5.setBounds(270, 490, 243, 50);
        Color colorLetra = new Color(51, 51, 51);
        etiqueta5.setForeground(colorLetra);
        etiqueta5.setFont(new Font("Kristen ITC", 1, 20));
        layeredPane.add(etiqueta5, JLayeredPane.PALETTE_LAYER);  
    }
    
    //Establece el boton que redirecciona a la ventana emergente
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
                VentanaEmergente ventanaEmergente = new VentanaEmergente(jugador, ronda);
                ventanaEmergente.setVisible(true);
                
                //Reproduce el sonido al presionar el boton
                reproducirSonido("click.wav");
            }
        };
        boton2.addActionListener(oyenteDeAccion1);
    }
    
    //Establece las tres figuras de la parte derecha
    private void establecerFiguras() {
        
        //Se crea un objeto figura que proporcionara la misma figura con tres tamaños distintos (grande, mediano, pequeño)
        figurasSecundarias = new Figura("cuadrado.png", colorPrincipal);
        
        //Se crean las etiquetas fijas donde iran posicionadas las tres figuras con distintos tamaños
        etiqueta6 = new JLabel();
        etiqueta6.setBounds(310, 180, 150, 150);
        etiqueta6.setHorizontalAlignment(JLabel.CENTER);
        etiqueta6.setVerticalAlignment(JLabel.CENTER);
        layeredPane.add(etiqueta6, JLayeredPane.PALETTE_LAYER);
        etiqueta7 = new JLabel();
        etiqueta7.setBounds(500, 180, 150, 150);
        etiqueta7.setHorizontalAlignment(JLabel.CENTER);
        etiqueta7.setVerticalAlignment(JLabel.CENTER);
        layeredPane.add(etiqueta7, JLayeredPane.PALETTE_LAYER);
        etiqueta8 = new JLabel();
        etiqueta8.setBounds(680, 180, 150, 150);
        etiqueta8.setHorizontalAlignment(JLabel.CENTER);
        etiqueta8.setVerticalAlignment(JLabel.CENTER);
        layeredPane.add(etiqueta8, JLayeredPane.PALETTE_LAYER);
        
        //Se crean las etiquetas fijas donde iran posicionadas las tres figuras con dist//Se crean las etiquetas fijas donde iran posicionadas las tres figuras con dintos tamaños        
        ArrayList<ImageIcon> listaDeImagenes = new ArrayList<>();
        listaDeImagenes.add(figurasSecundarias.getFiguraPequeñaConColorRandom());
        listaDeImagenes.add(figurasSecundarias.getfiguraMedianaConColorRandom());
        listaDeImagenes.add(figurasSecundarias.getfiguraGrandeConColorRandom());

        //Baraja la lista de imágenes para cambiar su orden
        Collections.shuffle(listaDeImagenes);

        // Selecciona las tres primeras imágenes barajadas
        for(int i = 0; i < 3; i++){
            
            //Asignar imagenes a su recpectiva etiqueta (las imagenes siempre van a cambiar de lugar, las etiquetas son fijas)
            switch(i){
                case 0:
                    etiqueta6.setIcon(listaDeImagenes.get(0));
                    
                    //Validar respuesta correcta por los tamaños de la figura principal
                    if(widthImgPrincipal == listaDeImagenes.get(0).getIconWidth() && heightImgPrincipal == listaDeImagenes.get(0).getIconHeight() ){
                        mouseListenerEt6();
                    }else{
                        mouseListenerEt6Fallo(); 
                    }
                    break;
                case 1:
                    etiqueta7.setIcon(listaDeImagenes.get(1));
                    
                    //Validar respuesta correcta por los tamaños de la figura principal
                    if(widthImgPrincipal == listaDeImagenes.get(1).getIconWidth() && heightImgPrincipal == listaDeImagenes.get(1).getIconHeight() ){
                        mouseListenerEt7();
                    }else{
                        mouseListenerEt7Fallo(); 
                    }
                    break;
                case 2:
                    etiqueta8.setIcon(listaDeImagenes.get(2));
                    
                    //Validar respuesta correcta por los tamaños de la figura principal
                    if(widthImgPrincipal == listaDeImagenes.get(2).getIconWidth() && heightImgPrincipal == listaDeImagenes.get(2).getIconHeight() ){
                        mouseListenerEt8();  
                    }else{
                        mouseListenerEt8Fallo();
                    }
                    break;
            }
        }  
    }
    
    //Se ejecuta si la opcion de la etiqueta 6 es correcta, abre la ventana del juego de la figura circulo
    public void mouseListenerEt6(){
        etiqueta6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                //Aumenta el numero de rondas
                ronda.calcularRonda();
                
                //Aumenta el numero de aciertos
                ronda.calcularAciertos();
                
                //Reproduce un sonido al presionar la respuesta correcta
                reproducirSonido("acierto.wav");
                
                // Abre la ventana circulo
                VentanaJuegoCirculo ventanaCirculo = new VentanaJuegoCirculo(jugador, ronda);
                ventanaCirculo.setVisible(true);
                
                // Cierra la ventana cuadrado
                dispose();
            }
        });
    }
    
    //Se ejecuta si la opcion de la etiqueta 7 es correcta, abre la ventana del juego de la figura circulo
    public void mouseListenerEt7(){
        etiqueta7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                //Aumenta el numero de rondas
                ronda.calcularRonda();
                
                //Aumenta el numero de aciertos
                ronda.calcularAciertos();
                
                //Reproduce un sonido al presionar la respuesta correcta
                reproducirSonido("acierto.wav");
                
                // Abre la ventana circulo
                VentanaJuegoCirculo ventanaCirculo = new VentanaJuegoCirculo(jugador, ronda);
                ventanaCirculo.setVisible(true);
                
                // Cierra la ventana cuadrado
                dispose();
            }
        });
    }
    
    //Se ejecuta si la opcion de la etiqueta 8 es correcta, abre la ventana del juego de la figura circulo
    public void mouseListenerEt8(){
        etiqueta8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                //Aumenta el numero de rondas
                ronda.calcularRonda();
                
                //Aumenta el numero de aciertos
                ronda.calcularAciertos();
                
                //Reproduce un sonido al presionar la respuesta correcta
                reproducirSonido("acierto.wav");
                
                // Abre la ventana circulo
                VentanaJuegoCirculo ventanaCirculo = new VentanaJuegoCirculo(jugador, ronda);
                ventanaCirculo.setVisible(true);
                
                // Cierra la ventana cuadrado
                dispose();
            }
        });
    }
    
    //Se ejecuta si la opcion de la etiqueta 6 es incorrecta, suma 1 a fallos
    public void mouseListenerEt6Fallo(){
        etiqueta6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Reproduce un sonido al presionar la respuesta incorrecta
                reproducirSonido("fallo.wav");
                
                //Aumenta el numero de fallos
                ronda.calcularFallos();
                
                //Cambia el numero de fallos
                etiqueta4.setText("Fallos: " + ronda.getFallos());
            }
        });
    }
    
    //Se ejecuta si la opcion de la etiqueta 7 es incorrecta, suma 1 a fallos
    public void mouseListenerEt7Fallo(){
        etiqueta7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Reproduce un sonido al presionar la respuesta incorrecta
                reproducirSonido("fallo.wav");
                
                //Aumenta el numero de fallos
                ronda.calcularFallos();
                
                //Cambia el numero de fallos
                etiqueta4.setText("Fallos: " + ronda.getFallos());
            }
        });
    }
    
    //Se ejecuta si la opcion de la etiqueta 8 es incorrecta, suma 1 a fallos
    public void mouseListenerEt8Fallo(){
        etiqueta8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Reproduce un sonido al presionar la respuesta incorrecta
                reproducirSonido("fallo.wav");
                
                //Aumenta el numero de fallos
                ronda.calcularFallos();
                
                //Cambia el numero de fallos
                etiqueta4.setText("Fallos: " + ronda.getFallos());
            }
        });
    }
    
    //Reproduce un sonido
    private void reproducirSonido(String audio) {
        try {
            //Carga el archivo de sonido
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audio));
            Clip clip = AudioSystem.getClip();

            //Abre el clip y lo reproduce
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}