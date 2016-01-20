package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
//import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import control.*;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.tile.Tile;

public class Juego extends Canvas implements Runnable{
	private static final long serialVersionUID= 1L;
	
	private static volatile boolean enFuncionamiento=false;
	private static final String NOMBRE = "Juego";
	private static final Dimension screenSize = new Dimension(800, 600); //Toolkit.getDefaultToolkit().getScreenSize();
	private static int aps=0;
	private static int fps=0;
	private static int x = 0;
	private static int y = 0;
	private static JFrame ventana;
	private static Thread thread;
	private static Teclado teclado;
	private static Pantalla pantalla;
	private static BufferedImage imagen = new BufferedImage(screenSize.width, screenSize.height, BufferedImage.TYPE_INT_RGB);
	private static final ImageIcon icono = new ImageIcon(Juego.class.getResource("/Iconos/iconoPrueba.png"));
	public static int[] pixels = ((DataBufferInt)imagen.getRaster().getDataBuffer()).getData();

	
	private Juego(){
		
		setPreferredSize(screenSize);
		
		pantalla = new Pantalla(screenSize.height, screenSize.width);
		
		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setIconImage(icono.getImage());
		ventana.setLayout(new BorderLayout());
		ventana.add(this,BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		teclado = new Teclado();
		addKeyListener(teclado);
		
		}
	
	public static void main(String[] args){
		Juego juego = new Juego();
		juego.iniciar();
	}
	
	private synchronized void iniciar(){
		enFuncionamiento=true;
		thread = new Thread(this,"Graficos");
		thread.start();
	}
	
	private synchronized void detener(){
		enFuncionamiento=false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private void actualizar(){
		teclado.actualizar();
		if(teclado.arriba){
			y++;
		}
		
		if(teclado.abajo){
			y--;
		}
		
		if(teclado.derecha){
			x++;
		}
		
		if(teclado.izquierda){
			x--;
		}
		
		aps++;
	}
	
	private void mostrar(){
		BufferStrategy estrategia = getBufferStrategy();
		
		if(estrategia ==null){
			createBufferStrategy(3);
			return;
		}
		pantalla.limpiar();
		pantalla.mostrar(x, y);
		
		System.arraycopy(pantalla.pixels, 0, pixels, 0, pixels.length);
		//		Este metodo hace lo mismo que el bucle
		//		for(int i=0; i<pixels.length; i++){
		//			pixels[i] = pantalla.pixels[i];
		//		}
		
		Graphics g = estrategia.getDrawGraphics();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.WHITE);
		g.drawRect(screenSize.width/2, screenSize.height/2, 15, 15);
		g.dispose();
		
		estrategia.show();
		
		fps++;
	}
	
	public void run() {
		final int NS_POR_SEGUNDO=1000000000;
		final byte APS_OBJETIVO=60;
		final double NS_POR_ACTUALIZACION=NS_POR_SEGUNDO/APS_OBJETIVO;
		
		long referenciaAactualizacion=System.nanoTime();
		long referenciaContador=System.nanoTime();
		
		double tiempoTranscurrido;
		double delta= 0;
		
		requestFocus();
		
		while(enFuncionamiento){
			final long inicioBucle = System.nanoTime();
			tiempoTranscurrido= inicioBucle - referenciaAactualizacion;
			referenciaAactualizacion= inicioBucle;
			
			delta += tiempoTranscurrido/NS_POR_ACTUALIZACION;
			while(delta >=1){
				actualizar();
				delta--;
			}
			mostrar();
			
			if(System.nanoTime() -referenciaContador > NS_POR_SEGUNDO){
				ventana.setTitle(NOMBRE + " || APS: "+aps+" || FPS: "+ fps);
				aps=0;
				fps=0;
				referenciaContador=System.nanoTime();
			}
		}
		
	}
}
