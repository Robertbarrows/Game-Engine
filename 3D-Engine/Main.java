package com.base.engine;

import org.lwjgl.opengl.GL;

import com.base.game.Game;

/**
 * This class holds the main method for the 3D engine.
 * This is also the class that does the main engine processing.
 * @author Robert Barrows
 * @version 5/31/2016
 */
public class MainComponent {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "RPG Game";
	public static final double FRAME_CAP = 5000.0;
	
	private boolean isRunning;
	private Game game;
	
	/**
	 * This constructor is used to create the main items of the 3D engine
	 */
	public MainComponent(){
		RenderUtil.initGraphics(); 
		isRunning = false;
		game = new Game();
	}
	/**
	 * This method is to start the engine.
	 */
	public void start(){
		if(isRunning){
			return;
		}
		run();
	}
	/**
	 * This method is to stop the engine.
	 */
	public void stop(){
		if(!isRunning){
			return;
		}
		isRunning = false;
	}
	/**
	 * This method is to run the engine.
	 */
	private void run(){
		
		isRunning = true;
		
		int frames = 0;
		int frameCounter = 0;
		
		final double frameTime = 1.0 / FRAME_CAP;
		long lastTime = Time.getTime();
		double unprocessedTime = 0;
		
		while(isRunning){
			boolean isUpdated = false;
			
			long startTime = Time.getTime();
			long pastTime = startTime - lastTime;
			lastTime = startTime;
			unprocessedTime += pastTime / (double)Time.SECOND;
			frameCounter += pastTime;
			
			while(unprocessedTime > frameTime){
				isUpdated = true;
				
				unprocessedTime -= frameTime;
				
				if(Window.getCloseRequested()){
					stop();
				}
				
				Time.setDelta(frameTime);
				
				game.input();
				game.update();
				
				if(frameCounter >= Time.SECOND){
					System.out.println(frames);      //THIS A FPS COUNTER PRINT.
					frames = 0;
					frameCounter = 0;
				}
			}
			if(isUpdated){
				render();
				frames++;
			}else{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					System.err.println("Issue with Thread sleeping: " + e);
				}
			}
		}
		cleanUp();
	}
	/**
	 * This method displays the information on the screen.
	 */
	private void render(){
		RenderUtil.clearScreen(); 
		game.render();
		Window.render();
		
	}
	/**
	 * This method cleans up all the memory allocation.
	 */
	private void cleanUp(){
		Window.dispose();
	}
	/**
	 * This is the main method which runs all the main processing
	 * @param args
	 */
	public static void main(String[] args) {
		Window.createWindow(WIDTH, HEIGHT, TITLE);
		GL.createCapabilities();
		MainComponent main = new MainComponent();
		
		main.start();
		
	}

}
