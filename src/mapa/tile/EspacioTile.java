package mapa.tile;

import graficos.Pantalla;
import graficos.Sprite;

public class EspacioTile extends Tile {

	public EspacioTile(Sprite sprite) {
		super(sprite);
	}
	
	public void mostrar(int x, int y, Pantalla pantalla){
		pantalla.mostrarTile(x, y, this);
	}

}
