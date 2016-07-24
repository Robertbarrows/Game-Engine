package com.base.engine.math;
/**
 * 
 * @author Robert Barrows
 * @version 6/2/2016
 */
public class Matrix4f {
	
	private float[][] matrix;
	private static final int MATRIX_SIZE = 4;
	/**
	 * 
	 */
	public Matrix4f(){
		matrix = new float[MATRIX_SIZE][MATRIX_SIZE];
	}
	/**
	 * 
	 * @return
	 */
	public Matrix4f initIdentity(){
		matrix[0][0] = 1; matrix[0][1] = 0;  matrix[0][2] = 0;  matrix[0][3] = 0;
		matrix[1][0] = 0; matrix[1][1] = 1;  matrix[1][2] = 0;  matrix[1][3] = 0;
		matrix[2][0] = 0; matrix[2][1] = 0;  matrix[2][2] = 1;  matrix[2][3] = 0;
		matrix[3][0] = 0; matrix[3][1] = 0;  matrix[3][2] = 0;  matrix[3][3] = 1;
		
		return this;
	}
	/**
	 * 
	 * @param r
	 * @return
	 */
	public Matrix4f multiply(Matrix4f r){
		Matrix4f resultMatrix = new Matrix4f();
		
		for(int i = 0; i < MATRIX_SIZE; i++){
			for(int j = 0; j < MATRIX_SIZE; j++){
				resultMatrix.set(i, j, matrix[i][0] * r.get(0, j) +
									   matrix[i][1] * r.get(1, j) +
									   matrix[i][2] * r.get(2, j) +
									   matrix[i][3] * r.get(3, j));
			}
		}
		return resultMatrix;
	}
	/**
	 * 
	 * @return
	 */
	public float[][] getMatrix() {
		return matrix;
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public float get(int x, int y){
		return matrix[x][y];
	}
	/**
	 * 
	 * @param matrix
	 */
	public void setMatrix(float[][] matrix) {
		this.matrix = matrix;
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @param value
	 */
	public void set(int x, int y, float value){
		matrix[x][y] = value;
	}
}
