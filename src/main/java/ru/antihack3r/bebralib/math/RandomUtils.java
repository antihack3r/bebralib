/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 */

package ru.antihack3r.bebralib.math;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

/**
 * Produces randomness.
 */
public class RandomUtils {
	
	/**
	 * RNG used.
	 */
	private static Random RANDOM = new Random();
	
	/**
	 * Resets the RNG used by this class.
	 */
	public static void resetRandom() {
		RANDOM = new Random();
	}
	
	/**
	 * Sets the specified RNG for use in this class.
	 * @param newRandom a new RNG.
	 */
	public static void setRandom(@Nullable Random newRandom) {
		if (newRandom == null)
			resetRandom();
		else
			RANDOM = newRandom;
	}
	
	/**
	 * Gets the current RNG used by this class.
	 * @return the current RNG used by this class.
	 */
	public static @Nonnull Random getRandom() {
		return RANDOM;
	}
	
	/**
	 * Generates a random <tt>int</tt> value between <tt>min</tt> and <tt>max</tt>, all-inclusive.
	 * @param min the lower bound, inclusive.
	 * @param max the upper bound, inclusive.
	 * @return a random <tt>int</tt> value between <tt>min</tt> and <tt>max</tt>.
	 * @see Random#nextInt(int)
	 */
	public static int nextInt(int min, int max) {
		return RANDOM.nextInt(max - min + 1) + min;
	}
	
	/**
	 * Generates a random <tt>double</tt> value between <tt>min</tt> (inclusive) and <tt>max</tt> (exclusive).
	 * @param min the lower bound, inclusive.
	 * @param max the upper bound, exclusive.
	 * @return a random <tt>double</tt> value between <tt>min</tt> (inclusive) and <tt>max</tt> (exclusive).
	 * @see Random#nextDouble()
	 */
	public static double nextDouble(double min, double max) {
		return Meth.interpolate(min, max, RANDOM.nextDouble());
	}
	
	/**
	 * Generates a random <tt>float</tt> value between <tt>min</tt> (inclusive) and <tt>max</tt> (exclusive).
	 * @param min the lower bound, inclusive.
	 * @param max the upper bound, exclusive.
	 * @return a random <tt>float</tt> value between <tt>min</tt> (inclusive) and <tt>max</tt> (exclusive).
	 * @see Random#nextFloat()
	 */
	public static float nextFloat(float min, float max) {
		return Meth.interpolate(min, max, RANDOM.nextFloat());
	}
	
}
