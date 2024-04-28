/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/rusnuker/bebralib
 */

package ru.antihack3r.bebralib.math;

/**
 * Timer, or stopwatch, is a simple time-measuring took
 */
public class Timer {
	
	private long startTime = 0L;
	
	public Timer() {}
	
	public void reset() {
		this.startTime = getMillis();
	}
	
	public boolean hasPassed(long delay) {
		return getMillis() - this.startTime >= delay;
	}
	
	private static long getMillis() {
		return System.nanoTime() / 1000000L;
	}
	
	public boolean hasPassedReset(long delay) {
		if (this.hasPassed(delay)) {
			this.reset();
			return true;
		} else {
			return false;
		}
	}
	
}
