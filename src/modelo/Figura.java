package modelo;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;

public class Figura extends ImageIcon{
    private Color colorAleatorio;
    private ImageIcon figuraPequeña;
    private ImageIcon figuraGrande;
    private ImageIcon figuraMediana;
    private ImageIcon figuraPequeñaConColorRandom;
    private ImageIcon figuraGrandeConColorRandom;
    private ImageIcon figuraMedianaConColorRandom;

    public Figura(String imagen) {
        ImageIcon figura = new ImageIcon(imagen);

        establecerTamañoFiguras(figura);
        generarColorRandom();
        
        figuraMedianaConColorRandom = cambiarColor(figuraMediana, colorAleatorio);
        figuraGrandeConColorRandom = cambiarColor(figuraGrande, colorAleatorio);
        figuraPequeñaConColorRandom = cambiarColor(figuraPequeña,colorAleatorio);
    }
    
    public Figura(String imagen, Color colorYaAntesGenerado) {
        ImageIcon figura = new ImageIcon(imagen);

        establecerTamañoFiguras(figura);
        generarColorRandom();
        
        figuraMedianaConColorRandom = cambiarColor(figuraMediana, colorYaAntesGenerado);
        figuraGrandeConColorRandom = cambiarColor(figuraGrande, colorYaAntesGenerado);
        figuraPequeñaConColorRandom = cambiarColor(figuraPequeña,colorYaAntesGenerado);
    }
    
    //Establece tres figuras con diferentes tamaños
    private void establecerTamañoFiguras(ImageIcon figura){
        figuraMediana = new ImageIcon(figura.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH));
        figuraGrande = new ImageIcon(figura.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        figuraPequeña = new ImageIcon(figura.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    }
    
    //Genera un color aleatorio
    private void generarColorRandom(){
        Random random = new Random();
        colorAleatorio = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
    
    //Método para cambiar el color de un ImageIcon
    private static ImageIcon cambiarColor(ImageIcon figura, Color color) {
        int ancho = figura.getIconWidth();
        int alto = figura.getIconHeight();
        
        BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = imagen.createGraphics();
        
        // Dibuja la imagen original en el BufferedImage
        figura.paintIcon(null, g, 0, 0);
        
        // Cambia el color de la imagen usando el color deseado
        g.setColor(color);
        g.setComposite(AlphaComposite.SrcAtop);
        g.fillRect(0, 0, ancho, alto);
        
        // Crea un nuevo ImageIcon a partir del BufferedImage modificado
        ImageIcon coloredIcon = new ImageIcon(imagen);
        
        return coloredIcon;
    }
    
    public ImageIcon getFiguraPequeñaConColorRandom(){
        return figuraPequeñaConColorRandom;
    }
    
    public ImageIcon getfiguraMedianaConColorRandom(){
        return figuraMedianaConColorRandom;
    }
    
    public ImageIcon getfiguraGrandeConColorRandom(){
        return figuraGrandeConColorRandom;
    }
    
    public Color getColorAleatorio(){
        return colorAleatorio;
    }
}
