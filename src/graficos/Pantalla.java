package graficos;

import mapa.tile.Tile;

public final class Pantalla {
		private final int alto;
		private final int ancho;
		
		public final int[] pixels;
		
		//Temporal
		private final static int ladoSprite = 32;
		private final static int mascara = ladoSprite-1;
		//Fin
		
		public Pantalla(final int alto, final int ancho){
			this.alto = alto;
			this.ancho = ancho;
			
			pixels = new int[ancho*alto];
		}
		
		public void limpiar(){
			for(int i =0; i<pixels.length; i++){
				pixels[i]=0;
			}
		}
		
		public void mostrar(final int compensacionX, final int compensacionY){
			for(int y =0; y< alto; y++){
				int posicionY = y+compensacionY;
				
				if(posicionY<0||posicionY>=alto)
					continue;
				
				for(int x =0; x< ancho; x++){
					int posicionX = x+compensacionX;
					
					if(posicionX<0||posicionX>= ancho)
						continue;
					//Temporal
					pixels[(posicionX)+posicionY*ancho]= Sprite.asfalto.pixeles[(x & mascara) +(y & mascara)*ladoSprite];
				}
				
			}
		}
		
		public void mostrarTile(int compensacionX, int compensacionY, Tile tile){
			for(int y=0; y< tile.sprite.getLado(); y++){
				int posicionY = y+compensacionY;
				for(int x=0; x<tile.sprite.getLado(); x++){
					int posicionX = x+compensacionX;
					if(posicionX<0||posicionX>ancho||posicionY<0||posicionY>alto)
						break;
					pixels[posicionX + posicionY*ancho]= tile.sprite.pixeles[x+y*tile.sprite.getLado()];
				}
			}
		}
		
		public int getAncho(){
			return this.ancho;
		}
		
		public int getAlto(){
			return this.alto;
		}
}
