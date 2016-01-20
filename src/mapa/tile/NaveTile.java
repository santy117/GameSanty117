package mapa.tile;

import graficos.Pantalla;
import graficos.Sprite;

public class NaveTile extends Tile {

	public NaveTile(Sprite sprite) {
		super(sprite);
	}
	
	public void mostrar(int x, int y, Pantalla pantalla){
		pantalla.mostrarTile(x, y, this);
	}
	
	public boolean solido(){
		return true;
	}

}
