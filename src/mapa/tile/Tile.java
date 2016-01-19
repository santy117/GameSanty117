package mapa.tile;

import graficos.Pantalla;
import graficos.Sprite;

public abstract class Tile {
	public int x;
	public int y;
	
	public Sprite sprite;
	
	//Coleccion de tiles
	public static final Tile asfalto = new AsfaltoTile(Sprite.asfalto);
	
	//Fin de la coleccion de tiles
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}

	public void mostrar(int x, int y, Pantalla pantalla){
		
	}
	
	public boolean solido(){
		return false;
	}
}
