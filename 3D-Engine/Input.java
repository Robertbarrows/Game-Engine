package com.base.engine;

import com.base.engine.input.handler.KeyboardHandler;
import com.base.engine.input.handler.MouseHandler;
import com.base.engine.math.Vector2f;
/**
 * This class is for tracking input from the player
 * @author Robert Barrows
 * @version 7/24/2016
 */
public class Input {
	/**
	 * This is a wrapper method for the KeyboardHandler isKeyDown method.
	 * @param keycode of the key to check if pressed.
	 * @return true if the key has been pressed and false otherwise.
	 */
	public static boolean getKeyDown(int keycode){
		return KeyboardHandler.isKeyDown(keycode);
	}
	/**
	 * This method checks to see if the key has stopped being pressed.
	 * @param keycode of the key to check if not pressed any more.
	 * @return true if key is not being pressed and false otherwise.
	 */
	public static boolean getKeyUp(int keycode){
		return !getKeyDown(keycode);
	}
	
	public static boolean getMouseDown(int mouseButton){
		return false; // TODO: create method to check for if mouse button is pressed.
	}
	public static boolean getMouseUp(int mouseButton){
		return false; // TODO: create method to check for if the mouse button is not being pressed.
	}
	public static Vector2f getMousePosition(){
		return new Vector2f((float) MouseHandler.getXPos(), (float) MouseHandler.getYPos());
	}
}

