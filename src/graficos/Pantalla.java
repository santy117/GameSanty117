package graficos;

import mapa.tile.Tile;

public final class Pantalla {
		private final int alto;
		private final int ancho;
		
		private int diferenciaX;
		private int diferenciaY;
		
		public final int[] pixels;
		
		public Pantalla(final int alto, final int ancho){
			this.alto = alto;
			this.ancho = ancho;
			
			pixels = new int[ancho*alto];
		}
		
		public void setDiferencia(int diferenciaX, int diferenciaY){
			this.diferenciaX = diferenciaX;
			this.diferenciaY = diferenciaY;
		}
		
		public void limpiar(){
			for(int i =0; i<pixels.length; i++){
				pixels[i]=0;
			}
		}
		
		public void mostrarTile(int compensacionX, int compensacionY, Tile tile){
			compensacionX -= diferenciaX;
			compensacionY -= diferenciaY;
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
