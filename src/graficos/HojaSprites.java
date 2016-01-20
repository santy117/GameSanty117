package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HojaSprites {
	private final int ancho;
	private final int alto;
	public final int[] pixeles;
	
	//Coleccion de hojas de sprites
	public static HojaSprites hojaSprites1 = new HojaSprites("/Texturas/HojaSprites.png", 320, 320);
	
	//Fin de la colecci�n

	public HojaSprites(final String ruta, final int ancho, final int alto){
		this.ancho=ancho;
		this.alto=alto;
		
		pixeles= new int[ancho * alto];
		
	BufferedImage imagen;
	try {
		imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
		imagen.getRGB(0,0,ancho,alto,pixeles,0,ancho);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
	public int getAncho(){
		return ancho;
	}
}
