package com.base.engine.math;

/**
 * 
 * @author Robert Barrows
 * @version 6/2/2016
 */
public class Quaternion {
	private float x;
	private float y;
	private float z;
	private float w;
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 */
	public Quaternion(float x, float y, float z, float w){
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	/**
	 * 
	 * @return
	 */
	public float length(){
		return (float) Math.sqrt(x * x + y * y + z * z + w * w);
	}
	/**
	 * 
	 * @return
	 */
	public Quaternion normalize(){
		float length = length();
		
		x /= length;
		y /= length;
		z /= length;
		w /= length;
		
		return this;
	}
	/**
	 * 
	 * @return
	 */
	public Quaternion conjugate(){
		return new Quaternion(-x, -y, -z, w);
	}
	/**
	 * 
	 * @param r
	 * @return
	 */
	public Quaternion multiply(Quaternion r){
		float w_ = w * r.getW() - x * r.getX() - y * r.getY() - z * r.getZ();
		float x_ = x * r.getW() + w * r.getX() - z * r.getY() + y * r.getZ();
		float y_ = y * r.getW() + z * r.getX() + w * r.getY() - x * r.getZ();
		float z_ = z * r.getW() - y * r.getX() + x * r.getY() + w * r.getZ();
		
		return new Quaternion(x_, y_, z_, w_);
	}
	/**
	 * 
	 * @param r
	 * @return
	 */
	public Quaternion multiply(Vector3f r){
		float w_ = -x * r.getX() - y * r.getY() - z * r.getZ();
		float x_ = w * r.getX() - z * r.getY() + y * r.getZ();
		float y_ = z * r.getX() + w * r.getY() - x * r.getZ();
		float z_ = -(y * r.getX()) + x * r.getY() + w * r.getZ();
		
		return new Quaternion(x_, y_, z_, w_);
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
	/**
	 * 
	 * @return
	 */
	public float getW() {
		return w;
	}
	/**
	 * 
	 * @param w
	 */
	public void setW(float w) {
		this.w = w;
	}
}
