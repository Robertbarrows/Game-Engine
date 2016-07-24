package com.base.engine.math;
/**
 * 
 * @author Robert Barrows
 * @version 6/2/2016
 */
public class Vector3f {
	
	private float x;
	private float y;
	private float z;
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector3f(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	/**
	 * 
	 * @return
	 */
	public float length(){
		return (float) Math.sqrt(x * x + y * y + z * z);
	}
	/**
	 * 
	 * @param r
	 * @return
	 */
	public float dotProduct(Vector3f r){
		return x * r.getX() + y * r.getY() + z * r.getZ();
	}
	/**
	 * 
	 * @param r
	 * @return
	 */
	public Vector3f crossProduct(Vector3f r){
		float xCross = y * r.getZ() - z * r.getY();
		float yCross = z * r.getX() - x * r.getZ();
		float zCross = x * r.getY() - y * r.getX();
		return new Vector3f(xCross, yCross, zCross);
	}
	/**
	 * 
	 * @return
	 */
	public Vector3f normalize(){
		float length = this.length();
		
		x /= length;
		y /= length;
		z /= length;
		
		return this;
	}
	/**
	 * 
	 * @return
	 */
	public Vector3f rotate(){
		return null;  //TODO: Needs to be implemented.
	}
	/**
	 * 
	 * @param r
	 * @return
	 */
	public Vector3f add(Vector3f r){
		return new Vector3f(x + r.getX(), y + r.getY(), z + r.getZ());
	}
	/**
	 * 
	 * @param f
	 * @return
	 */
	public Vector3f add(float f){
		return new Vector3f(x + f, y + f, z + f);
	}
	/**
	 * 
	 * @param r
	 * @return
	 */
	public Vector3f subtract(Vector3f r){
		return new Vector3f(x - r.getX(), y - r.getY(), z - r.getZ());
	}
	public Vector3f subtract(float f){
		return new Vector3f(x - f, y - f, z - f);
	}
	/**
	 * 
	 * @param r
	 * @return
	 */
	public Vector3f multiply(Vector3f r){
		return new Vector3f(x * r.getX(), y * r.getY(), z * r.getZ());
	}
	/**
	 * 
	 * @param f
	 * @return
	 */
	public Vector3f multiply(float f){
		return new Vector3f(x * f, y * f, z * f);
	}
	/**
	 * 
	 * @param r
	 * @return
	 */
	public Vector3f divide(Vector3f r){
		return new Vector3f(x / r.getX(), y / r.getY(), z / r.getZ());
	}
	/**
	 * 
	 * @param f
	 * @return
	 */
	public Vector3f divide(float f){
		return new Vector3f(x / f, y / f, z / f);
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
	 * @return
	 */
	public float getZ() {
		return z;
	}
	/**
	 * 
	 * @param z
	 */
	public void setZ(float z) {
		this.z = z;
	}
}
