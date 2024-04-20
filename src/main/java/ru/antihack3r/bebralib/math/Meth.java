/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/rusnuker/bebralib
 */

package ru.antihack3r.bebralib.math;

/**
 * The {@code Math} class name is already taken, so this one is named {@code Meth}.<br>
 * <br>
 * {@code Meth} is a collection of utilities that will help dealing with {@code float}s, {@code double}s, {@code int}s
 * and {@code long}s. Very effective :thumbsup:
 */
public class Meth {
	
	/**
	 * Tests and determines whether the string specified contains a parsable {@code integer} value.
	 * @param s The string in question.
	 * @return true if the string specified contains a parsable {@code integer} value, false otherwise.
	 * @throws NullPointerException if {@code s} is {@code null}.
	 */
	public static boolean isInteger(String s) {
		if (s == null)
			throw new NullPointerException("the argument is null");
		
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Tests and determines whether the string specified contains a parsable {@code float} value.
	 * @param s The string in question.
	 * @return true if the string specified contains a parsable {@code float} value, false otherwise.
	 * @throws NullPointerException if {@code s} is {@code null}.
	 */
	public static boolean isFloat(String s) {
		if (s == null)
			throw new NullPointerException("the argument is null");
		
		try {
			Float.parseFloat(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Tests and determines whether the string specified contains a parsable {@code double} value.
	 * @param s The string in question.
	 * @return true if the string specified contains a parsable {@code double} value, false otherwise.
	 * @throws NullPointerException if {@code s} is {@code null}.
	 */
	public static boolean isDouble(String s) {
		if (s == null)
			throw new NullPointerException("the argument is null");
		
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Tests and determines whether the string specified contains a parsable {@code long} value.
	 * @param s The string in question.
	 * @return true if the string specified contains a parsable {@code long} value, false otherwise.
	 * @throws NullPointerException if {@code s} is {@code null}.
	 */
	public static boolean isLong(String s) {
		if (s == null)
			throw new NullPointerException("the argument is null");
		
		try {
			Long.parseLong(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Tests and determines whether the string specified contains a parsable {@code short} value.
	 * @param s The string in question.
	 * @return true if the string specified contains a parsable {@code short} value, false otherwise.
	 * @throws NullPointerException if {@code s} is {@code null}.
	 */
	public static boolean isShort(String s) {
		if (s == null)
			throw new NullPointerException("the argument is null");
		
		try {
			Short.parseShort(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Tests and determines whether the string specified contains a parsable {@code byte} value.
	 * @param s The string in question.
	 * @return true if the string specified contains a parsable {@code byte} value, false otherwise.
	 * @throws NullPointerException if {@code s} is {@code null}.
	 */
	public static boolean isByte(String s) {
		if (s == null)
			throw new NullPointerException("the argument is null");
		
		try {
			Byte.parseByte(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Returns an {@code integer} value that is the highest of those which are lower or equal to {@code value}.<br>
	 * <br>
	 * For example,<br>
	 * <code>Meth.floor(0.95F)</code> returns 0,<br>
	 * <code>Meth.floor(50.0F)</code> returns 50,<br>
	 * <code>Meth.floor(-1.5F)</code> returns -2,<br>
	 * <code>Meth.floor(Float.NaN)</code> returns 0,<br>
	 * <code>Meth.floor(Float.POSITIVE_INFINITY)</code> returns 2147483647,<br>
	 * <code>Meth.floor(Float.NEGATIVE_INFINITY)</code> returns 2147483647,<br>
	 * <code>Meth.floor(Float.MIN_VALUE)</code> returns 0, and<br>
	 * <code>Meth.floor(Float.MAX_VALUE)</code> returns 2147483647.
	 * @param value The value to be floored.
	 * @return An {@code integer} value that is the highest of those which are lower or equal to {@code value}.
	 */
	public static int floor(float value) {
		int intValue = (int) value;
		return intValue > value? intValue - 1: intValue;
	}
	
	/**
	 * Returns an {@code integer} value that is the highest of those which are lower or equal to {@code value}.<br>
	 * <br>
	 * For example,<br>
	 * <code>Meth.floor(0.95D)</code> returns 0,<br>
	 * <code>Meth.floor(50.0D)</code> returns 50,<br>
	 * <code>Meth.floor(-1.5D)</code> returns -2,<br>
	 * <code>Meth.floor(Double.NaN)</code> returns 0,<br>
	 * <code>Meth.floor(Double.POSITIVE_INFINITY)</code> returns 2147483647,<br>
	 * <code>Meth.floor(Double.NEGATIVE_INFINITY)</code> returns 2147483647,<br>
	 * <code>Meth.floor(Double.MIN_VALUE)</code> returns 0, and<br>
	 * <code>Meth.floor(Double.MAX_VALUE)</code> returns 2147483647.
	 * @param value The value to be floored.
	 * @return An {@code integer} value that is the highest of those which are lower or equal to {@code value}
	 */
	public static int floor(double value) {
		int intValue = (int) value;
		return intValue > value? intValue - 1: intValue;
	}
	
	public static int ceil(float value) {
		if (Float.isNaN(value) || value == 0F) return 0;
		if (value == Float.POSITIVE_INFINITY || value == Float.MAX_VALUE) return Integer.MAX_VALUE;
		if (value == Float.NEGATIVE_INFINITY || value == Float.MIN_VALUE) return Integer.MIN_VALUE;
		
		int intValue = (int) value;
		return intValue < value? intValue + 1: intValue;
	}
	
	/**
	 * Returns a value that is clamped between {@code minValue} and {@code maxValue}.<br>
	 * <br>
	 * For example,<br>
	 * <code>Meth.clamp(1, 2, 3)</code> returns {@code 2},<br>
	 * <code>Meth.clamp(5, 1, 3)</code> returns {@code 3},<br>
	 * <code>Meth.clamp(5, 2, 6)</code> returns {@code 5},<br>
	 * <code>Meth.clamp(1, 0, 0)</code> returns {@code 0}, and<br>
	 * <code>Meth.clamp(-10, -20, -15)</code> returns {@code -15}.
	 * @param value The value to be clamped.
	 * @param minValue The minimum result value.
	 * @param maxValue The maximum result value.
	 * @return The clamped value.
	 */
	public static int clamp(int value, int minValue, int maxValue) {
		return Math.max(minValue, Math.min(value, maxValue));
	}
	
	/**
	 * Returns a value that is clamped between {@code minValue} and {@code maxValue}.<br>
	 * <br>
	 * For example,<br>
	 * <code>Meth.clamp(1F, 2F, 3F)</code> returns {@code 2F},<br>
	 * <code>Meth.clamp(5F, 1F, 3F)</code> returns {@code 3F},<br>
	 * <code>Meth.clamp(5F, 2F, 6F)</code> returns {@code 5F},<br>
	 * <code>Meth.clamp(1F, 0F, 0F)</code> returns {@code 0F},<br>
	 * <code>Meth.clamp(-10F, -20F, -15F)</code> returns {@code -15F},<br>
	 * <code>Meth.clamp(Float.NaN, 1F, 5F)</code> returns {@code NaN}, and<br>
	 * <code>Meth.clamp(Float.POSITIVE_INFINITY, 0F, 3F)</code> returns {@code 3F}.
	 * @param value The value to be clamped.
	 * @param minValue The minimum result value.
	 * @param maxValue The maximum result value.
	 * @return The clamped value.
	 */
	public static float clamp(float value, float minValue, float maxValue) {
		return Math.max(minValue, Math.min(value, maxValue));
	}
	
	/**
	 * Returns a value that is clamped between {@code minValue} and {@code maxValue}.<br>
	 * <br>
	 * For example,<br>
	 * <code>Meth.clamp(1D, 2D, 3D)</code> returns {@code 2D},<br>
	 * <code>Meth.clamp(5D, 1D, 3D)</code> returns {@code 3D},<br>
	 * <code>Meth.clamp(5D, 2D, 6D)</code> returns {@code 5D},<br>
	 * <code>Meth.clamp(1D, 0D, 0D)</code> returns {@code 0D},<br>
	 * <code>Meth.clamp(-10D, -20D, -15D)</code> returns {@code -15D},<br>
	 * <code>Meth.clamp(Double.NaN, 1D, 5D)</code> returns {@code NaN}, and<br>
	 * <code>Meth.clamp(Double.POSITIVE_INFINITY, 0D, 3D)</code> returns {@code 3D}.
	 * @param value The value to be clamped.
	 * @param minValue The minimum result value.
	 * @param maxValue The maximum result value.
	 * @return The clamped value.
	 */
	public static double clamp(double value, double minValue, double maxValue) {
		return Math.max(minValue, Math.min(value, maxValue));
	}
	
	/**
	 * Returns a value that is clamped between {@code minValue} and {@code maxValue}.<br>
	 * <br>
	 * For example,<br>
	 * <code>Meth.clamp(1L, 2L, 3L)</code> returns {@code 2L},<br>
	 * <code>Meth.clamp(5L, 1L, 3L)</code> returns {@code 3L},<br>
	 * <code>Meth.clamp(5L, 2L, 6L)</code> returns {@code 5L},<br>
	 * <code>Meth.clamp(1L, 0L, 0L)</code> returns {@code 0L}, and<br>
	 * <code>Meth.clamp(-10L, -20L, -15L)</code> returns {@code -15L}.
	 * @param value The value to be clamped.
	 * @param minValue The minimum result value.
	 * @param maxValue The maximum result value.
	 * @return The clamped value.
	 */
	public static long clamp(long value, long minValue, long maxValue) {
		return Math.max(minValue, Math.min(value, maxValue));
	}

}
