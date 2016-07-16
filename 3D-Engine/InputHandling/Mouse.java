package com.base.engine.input.handler;

import org.lwjgl.glfw.GLFWCursorPosCallback;

/**
 * This class is the handler for all mouse inputs for the game.
 * @author Robert Barrows
 * @version 7/16/2016
 */
public class MouseHandler extends GLFWCursorPosCallback {
	
	public static double xPosition;
	public static double yPosition;
	
	/** 
	* The GLFWCurserPosCallback class is abstract and thus this method
	* can't be instantiated by itself and must instead be extended.
	* @param window
	* @param xpos is the horizontal position of the cursor.
	* @param ypos is the vertical position of the cursor.
	*/ 
	@Override
	public void invoke(long window, double xpos, double ypos) {
		xPosition = xpos;
		yPosition = ypos;
	}
	/**
	 * gets the current horizontal position of the cursor in the window 
	 * @return the horizontal position of the cursor
	 */
	public static double getXPos(){
		return xPosition;
	}
	/**
	 * gets the current vertical position of the cursor in the window
	 * @return the vertical position of the cursor 
	 */
	public static double getYPos(){
		return yPosition;
	}
}

