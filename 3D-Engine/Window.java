package com.base.engine;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWVidMode;

import com.base.engine.input.handler.KeyboardHandler;
import com.base.engine.input.handler.MouseHandler;
/**
 * This method is used to create a window for the 3D engine.
 * @author Robert Barrows
 * @version 5/31/2016
 */
public class Window{
	
	private static long windowID;
	private static String windowTitle;
	private static GLFWVidMode vidmode;
	private static GLFWKeyCallback keyCallback;
	private static GLFWCursorPosCallback mouseCallback;
	

	/**
	 * This method creates the window.
	 * @param width is the horizontal axis of the window created.
	 * @param height is the vertical axis of the window created.
	 * @param title is the name of the window created.
	 */
	public static void createWindow(int width, int height, String title){
		
		windowTitle = title;
		
		// Initializes our window creator library - GLFW 
		// This basically means, if this glfwInit() doesn't run properly
		// print an error to the console
		if(glfwInit() != GL_TRUE){
			// Throw an error.
			System.err.println("GLFW initialization failed!");
		}
		
		// Allows our window to be resizable
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		
		// Creates our window. You'll need to declare private long window at the
		// top of the class though. 
		// We pass the width and height of the game we want as well as the title for
		// the window. The last 2 NULL parameters are for more advanced uses and you
		// shouldn't worry about them right now.
		windowID = glfwCreateWindow(width, height, title, NULL, NULL);
	
		// This code performs the appropriate checks to ensure that the
		// window was successfully created. 
		// If not then it prints an error to the console
		if(windowID == NULL){
			// Throw an Error
			System.err.println("Could not create our Window!");
		}
		
		glfwSetKeyCallback(windowID, keyCallback = new KeyboardHandler());
		glfwSetCursorPosCallback(windowID, mouseCallback = new MouseHandler());
		
		// Initializes vidmode which then queries 
		// to see what the primary monitor is. 
		vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		// Sets the initial position of our game window. 
		glfwSetWindowPos(windowID, 100, 100);
		// Sets the context of GLFW, this is vital for our program to work.
		glfwMakeContextCurrent(windowID);
		// finally shows our created window in all it's glory.
		glfwShowWindow(windowID);
		
	}
	/**
	 * this method checks for window events.
	 */
	public static void update(){
		// Polls for any window events such as the window closing etc.
		glfwPollEvents();
	}
	/**
	 * This method renders the window and checks for window events.
	 */
	public static void render(){
		// Swaps out our buffers
		glfwSwapBuffers(windowID);
		update();
	}
	/**
	 * This method ends user interface.
	 */
	public static void dispose(){
		glfwTerminate();
		if(!keyCallback.isDestroyed()){
			keyCallback.release();
		}
		if(!mouseCallback.isDestroyed()){
			mouseCallback.release();
		}
	}
	/**
	 * This method returns true if the window is supposed to close otherwise false.
	 * @return true if window is to be closed or false if window is to be open.
	 */
	public static boolean getCloseRequested(){
		return glfwWindowShouldClose(windowID) == GL_TRUE;
	}
	/**
	 * This method gets the window's height.
	 * @return the window's height.
	 */
	public static int getHeight(){
		return vidmode.height();
	}
	/**
	 * This method gets the window's width.
	 * @return the window's width.
	 */
	public static int getWidth(){
		return vidmode.width();
	}
	/**
	 * This method gets the window's title.
	 * @return the window's title.
	 */
	public static String getTitle(){
		return windowTitle;
	}
}
