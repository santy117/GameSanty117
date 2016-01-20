package mapa.tile;

import graficos.Pantalla;
import graficos.Sprite;

public class VacioTile extends Tile {

	public VacioTile(Sprite sprite) {
		super(sprite);
	}
	
	public void mostrar(int x, int y, Pantalla pantalla){
		pantalla.mostrarTile(x, y, this);
	}

}
