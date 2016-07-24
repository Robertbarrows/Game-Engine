package com.base.engine.math;
/**
 * This class is for vectors with 2 floats
 * @author Robert Barrows
 * @version 6/2/2016
 */
public class Vector2f {
	private float x;
	private float y;
	/**
	 * This constructor creates a Vector2f from the provided floats
	 * @param x is the horizontal location
	 * @param y is the vertical location
	 */
	public Vector2f(float x, float y){
		this.x = x;
		this.y = y;
	}
	/**
	 * This method gets the length of the vector
	 * @return the length of the vector
	 */
	public float length(){
		return (float) Math.sqrt(x * x + y * y);
	}
	/**
	 * This method returns the dot product of two vectors
	 * @param r is a Vector2f
	 * @return the dot product of this vector and the parameter vector
	 */
	public float dotProduct(Vector2f r){
		return x * r.getX() + y * r.getY();
	}
	/**
	 * 
	 * @return
	 */
	public Vector2f normalize(){
		float length = this.length();
		
		x /= length;
		y /= length;
		
		return this;
	}
	/**
	 * 
	 * @param angle
	 * @return
	 */
	public Vector2f rotate(float angle){
		double radian =  Math.toRadians(angle);
		double cos = Math.cos(radian);
		double sin = Math.sin(radian);
		return new Vector2f((float)(x * cos - y * sin),(float)(x * sin + y * cos));
	}
	/**
	 * 
	 * @param r
	 * @return
	 */
	public Vector2f add(Vector2f r){
		return new Vector2f(x + r.getX(), y + r.getY());
	}
	/**
	 * 
	 * @param f
	 * @return
	 */
	public Vector2f add(float f){
		return new Vector2f(x + f, y + f);
	}
	/**
	 * 
	 * @param r
	 * @return
	 */
	public Vector2f subtract(Vector2f r){
		return new Vector2f(x - r.getX(), y - r.getY());
	}
	/**
	 * 
	 * @param f
	 * @return
	 */
	public Vector2f subtract(float f){
		return new Vector2f(x - f, y - f);
	}
	/**
	 * 
	 * @param r
	 * @return
	 */
	public Vector2f multiply(Vector2f r){
		return new Vector2f(x * r.getX(), y * r.getY());
	}
	/**
	 * 
	 * @param f
	 * @return
	 */
	public Vector2f multiply(float f){
		return new Vector2f(x * f, y * f);
	}
	/**
	 * 
	 * @param r
	 * @return
	 */
	public Vector2f divide(Vector2f r){
		return new Vector2f(x / r.getX(), y / r.getY());
	}
	/**
	 * 
	 * @param f
	 * @return
	 */
	public Vector2f divide(float f){
		return new Vector2f(x / f, y / f);
	}
	/**
	 * 
	 * @return
	 */
	public float getX() {
		return x;
	}
	/**
	 * 
	 * @param x
	 */
	public void setX(float x) {
		this.x = x;
	}
	/**
	 * 
	 * @return
	 */
	public float getY() {
		return y;
	}
	/**
	 * 
	 * @param y
	 */
	public void setY(float y) {
		this.y = y;
	}
	/**
	 * 
	 */
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
