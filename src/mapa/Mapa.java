package mapa;

import graficos.Pantalla;
import mapa.tile.Tile;

public abstract class Mapa {
	protected int ancho;
	protected int alto;
	
	protected int[] tiles;
	
	public Mapa(int ancho, int alto){
		this.ancho = ancho;
		this.alto = alto;
		
		tiles = new int[ancho*alto];
		generarMapa();
	}
	
	public Mapa(String ruta){
		cargarMapa(ruta);
	}
	
	protected void generarMapa(){
		
	}
	
	public void cargarMapa(String ruta){
		
	}
	
	public void actualizar(){
		
	}
	
	public void mostrar(int compensacionX, int compensacionY, Pantalla pantalla){
		//Codigo que se sustituira
		int oeste = compensacionX >>5;	//Se mueve hacia la derecha 5 posiciones "divide entre 32"
		int este = (compensacionX+pantalla.getAncho())>>5;
		int norte = compensacionY>>5;
		int sur = (compensacionY+pantalla.getAlto())>>5;
		
	}

	public Tile getTile(final int x, final int y){
		switch(x+y*ancho){
			case 0: 
				return Tile.asfalto;
			default:
				return Tile.vacio;
		}
	}
}
