package mapa.tile;

import graficos.Sprite;

public class VacioTile extends Tile {

	public VacioTile(Sprite sprite) {
		super(sprite);
	}
	
	public boolean solido(){
		return true;
	}
	
}
