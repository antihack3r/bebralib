/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 */

package ru.antihack3r.bebralib.math;

/**
 * Timer, or stopwatch, is a simple time-measuring tool that operates via {@link Timer#hasPassed(long)},
 * {@link Timer#hasPassedReset(long)} and {@link Timer#reset()}.
 */
public class Timer {
	
	private long startTime = 0L;
	
	/**
	 * Constructs a new {@link Timer}.
	 */
	public Timer() {}
	
	/**
	 * Resets the timer.
	 */
	public void reset() {
		this.startTime = getMillis();
	}
	
	/**
	 * Returns <tt>true</tt> if the specified <tt>delay</tt> has passed.
	 * @param delay The delay, in milliseconds.
	 * @return <tt>true</tt> if the specified <tt>delay</tt> has passed, <tt>false</tt> otherwise.
	 */
	public boolean hasPassed(long delay) {
		return getMillis() - this.startTime >= delay;
	}
	
	private static long getMillis() {
		return System.nanoTime() / 1000000L;
	}
	
	/**
	 * Resets the timer and returns <tt>true</tt> if the specified <tt>delay</tt> has passed.
	 * @param delay The delay, in milliseconds.
	 * @return <tt>true</tt> if the specified <tt>delay</tt> has passed, <tt>false</tt> otherwise.
	 */
	public boolean hasPassedReset(long delay) {
		if (this.hasPassed(delay)) {
			this.reset();
			return true;
		} else {
			return false;
		}
	}
	
}
