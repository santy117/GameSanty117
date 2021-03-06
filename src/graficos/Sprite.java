package graficos;

public final class Sprite {
	private final int lado;
	
	private int x;
	private int y;
	
	public int[] pixeles;
	private HojaSprites hoja;
	
	//Coleccion de sprites
	public static Sprite asfalto = new Sprite(32, 0, 0, HojaSprites.hojaSprites1);
	public static Sprite espacio = new Sprite(32, 2, 0, HojaSprites.hojaSprites1);
	public static Sprite nave = new Sprite(32, 1, 0, HojaSprites.hojaSprites1);
	public static Sprite vacio = new Sprite(32, 0);
	
	//Fin de la coleccion
	
	public Sprite(final int lado, final int color){
		this.lado = lado;
		pixeles = new int[lado*lado];
		for(int i=0; i< pixeles.length; i++){
			pixeles[i] = color;
		}
	}
	
	public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja){
		this.lado=lado;
		
		pixeles= new int[lado*lado];
		// Aunque parezca que es al reves, las y abarcan las filas y las x las columnas
		this.x=columna*lado;
		this.y=fila*lado;
		this.hoja=hoja;
		for (int y=0;y<lado;y++){
			for(int x=0;x<lado;x++){
				pixeles[x + y * lado]= hoja.pixeles[(x+this.x)+(y+this.y)* hoja.getAncho()];
			}
		}
	}
	
	public int getLado(){
		return this.lado;
	}
}
