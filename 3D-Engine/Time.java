package com.base.engine;
/**
 * This class is used for processing time events.
 * @author Robert Barrows
 * @version 5/31/2016
 */
public class Time {
	
	public static final long SECOND = (long) 1000000000;

	private static double delta;
	/**
	 * This method gets the system time in nanoseconds.
	 * @return time in nanoseconds.
	 */
	public static long getTime(){
		return System.nanoTime();
	}
	/**
	 * 
	 * @return
	 */
	public static double getDelta(){
		return Time.delta;
	}
	/**
	 * 
	 * @param d
	 */
	public static void setDelta(double d){
		Time.delta = d;
	}
}
