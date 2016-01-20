package mapa.tile;

import graficos.Pantalla;
import graficos.Sprite;

public abstract class Tile {
	public int x;
	public int y;
	
	public Sprite sprite;
	
	//Coleccion de tiles
	public static final Tile asfalto = new AsfaltoTile(Sprite.asfalto);
	public static final Tile espacio = new EspacioTile(Sprite.espacio);
	public static final Tile nave = new NaveTile(Sprite.espacio);
	public static final Tile vacio = new VacioTile(Sprite.vacio);
	
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
