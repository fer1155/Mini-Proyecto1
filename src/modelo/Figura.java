/*
Miniproyecto No. 1

Fernando Cardona - 2241381
Oscar Mario Muñoz - 2242481

Grupo de FPOE: 80
*/

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

    //Constructor de figura (Unica figura de la izquierda)
    public Figura(String imagen) {
        ImageIcon figura = new ImageIcon(imagen);

        establecerTamañoFiguras(figura);
        generarColorRandom();
        
        figuraGrandeConColorRandom = cambiarColor(figuraGrande, colorAleatorio);
        figuraMedianaConColorRandom = cambiarColor(figuraMediana, colorAleatorio);
        figuraPequeñaConColorRandom = cambiarColor(figuraPequeña,colorAleatorio);
    }
    
    //Constructor de figura con el colorRandom antes generado (Tres figuras de la derecha)
    public Figura(String imagen, Color colorYaAntesGenerado) {
        ImageIcon figura = new ImageIcon(imagen);

        establecerTamañoFiguras(figura);
        
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
        colorAleatorio = new Color(random.nextInt(192), random.nextInt(192), random.nextInt(192));
    }
    
    //Método para cambiar el color de un ImageIcon
    private static ImageIcon cambiarColor(ImageIcon figura, Color color) {
        int ancho = figura.getIconWidth();
        int alto = figura.getIconHeight();
        
        BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D grafico = imagen.createGraphics();
        
        //Dibuja la imagen original en el BufferedImage
        figura.paintIcon(null, grafico, 0, 0);
        
        //Cambia el color de la imagen usando el color deseado
        grafico.setColor(color);
        grafico.setComposite(AlphaComposite.SrcAtop);
        grafico.fillRect(0, 0, ancho, alto);
        
        //Crea una nueva imagen a partir del BufferedImage modificado
        ImageIcon imagenConColorModificado = new ImageIcon(imagen);
        
        return imagenConColorModificado;
    }
    
    //Getters
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
