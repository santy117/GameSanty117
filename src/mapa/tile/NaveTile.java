package mapa.tile;

import graficos.Sprite;

public class NaveTile extends Tile {

	public NaveTile(Sprite sprite) {
		super(sprite);
	}
	
	public boolean solido(){
		return true;
	}

}
