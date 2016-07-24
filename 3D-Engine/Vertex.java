package com.base.engine;

import com.base.engine.math.Vector3f;
/**
 * 
 * @author Robert Barrows
 * @version 6/2/2016
 */
public class Vertex {
	public static final int SIZE = 3;
	
	private Vector3f pos;
	
	/**
	 * 
	 * @param position
	 */
	public Vertex(Vector3f position){
		pos = position;
	}
	/**
	 * 
	 * @return
	 */
	public Vector3f getPosition() {
		return pos;
	}
	/**
	 * 
	 * @param pos
	 */
	public void setPosition(Vector3f pos) {
		this.pos = pos;
	}
}
