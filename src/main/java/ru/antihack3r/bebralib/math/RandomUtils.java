/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 */

package ru.antihack3r.bebralib.math;

import java.util.Random;

public class RandomUtils {
	
	public static Random RANDOM = new Random();
	
	public static void resetRandom() {
		RANDOM = new Random();
	}
	
	public static int nextInt(int min, int max) {
		return RANDOM.nextInt(max - min) + min;
	}
	
	public static double nextDouble(double min, double max) {
		return Meth.interpolate(min, max, RANDOM.nextDouble());
	}
	
	public static float nextFloat(float min, float max) {
		return Meth.interpolate(min, max, RANDOM.nextFloat());
	}
	
}
