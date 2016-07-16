package com.base.engine.inputhandling;

import org.lwjgl.glfw.GLFWKeyCallback;
import static org.lwjgl.glfw.GLFW.*;
/**
 * This class is the handler for all Keyboard inputs for the engine.
 * @author Robert Barrows
 * @version 5/7/2016
 */
public class Keyboard extends GLFWKeyCallback{

	public static boolean[] keys = new boolean[65536];
	
	/** 
	* The GLFWKeyCallback class is abstract and thus this method
	* can't be instantiated by itself and must instead be extended.
	* 
	* This method checks to see if the key has been pressed and sets the array accordingly.
	* 
	* @param window
	* @param key is the index in the array for the key
	* @param scancode
	* @param action is the type of action that has been performed
	* @param mods
	*/ 
	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		keys[key] = action != GLFW_RELEASE;
	}
	
	/**
	 * This method is used to know when a key is pressed.
	 * @param keycode is the GLFW key code for the given key.
	 * @return true if a given key is pressed
	 */
	public static boolean isKeyDown(int keycode) {
		return keys[keycode];
	}
	
}
