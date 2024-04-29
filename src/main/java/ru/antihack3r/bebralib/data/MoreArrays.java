/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/rusnuker/bebralib
 */

package ru.antihack3r.bebralib.data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MoreArrays {
	
	/**
	 * Performs an {@code action} for each component of an {@code array}.
	 * @param array An array.
	 * @param action An action.
	 */
	public static void forEach(byte[] array, Consumer<Byte> action) {
		for (byte _byte: array)
			action.accept(_byte);
	}
	
	/**
	 * Performs an {@code action} for each component of an {@code array}.
	 * @param array An array.
	 * @param action An action.
	 */
	public static void forEach(short[] array, Consumer<Short> action) {
		for (short _short: array)
			action.accept(_short);
	}
	
	/**
	 * Performs an {@code action} for each component of an {@code array}.
	 * @param array An array.
	 * @param action An action.
	 */
	public static void forEach(int[] array, Consumer<Integer> action) {
		for (int _int: array)
			action.accept(_int);
	}
	
	/**
	 * Performs an {@code action} for each component of an {@code array}.
	 * @param array An array.
	 * @param action An action.
	 */
	public static void forEach(long[] array, Consumer<Long> action) {
		for (long _long: array)
			action.accept(_long);
	}
	
	/**
	 * Performs an {@code action} for each component of an {@code array}.
	 * @param array An array.
	 * @param action An action.
	 */
	public static void forEach(float[] array, Consumer<Float> action) {
		for (float _float: array)
			action.accept(_float);
	}
	
	/**
	 * Performs an {@code action} for each component of an {@code array}.
	 * @param array An array.
	 * @param action An action.
	 */
	public static void forEach(double[] array, Consumer<Double> action) {
		for (double _double: array)
			action.accept(_double);
	}
	
	/**
	 * Performs an {@code action} for each component of an {@code array}.
	 * @param array An array.
	 * @param action An action.
	 */
	public static void forEach(boolean[] array, Consumer<Boolean> action) {
		for (boolean _boolean: array)
			action.accept(_boolean);
	}
	
	/**
	 * Performs an {@code action} for each component of an {@code array}.
	 * @param array An array.
	 * @param action An action.
	 */
	public static void forEach(char[] array, Consumer<Character> action) {
		for (char _char: array)
			action.accept(_char);
	}
	
	/**
	 * Performs an {@code action} for each component of an {@code array}.
	 * @param array An array.
	 * @param action An action.
	 */
	public static <T> void forEach(T[] array, Consumer<? super T> action) {
		for (T thing: array)
			action.accept(thing);
	}
	
	public static byte[] filter(byte[] array, Predicate<Byte> predicate) {
		List<Byte> list = asList(array).stream().filter(predicate).collect(Collectors.toList());
		
		byte[] newArray = new byte[list.size()];
		int counter = 0;
		for (byte thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static short[] filter(short[] array, Predicate<Short> predicate) {
		List<Short> list = asList(array).stream().filter(predicate).collect(Collectors.toList());
		
		short[] newArray = new short[list.size()];
		int counter = 0;
		for (short thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static int[] filter(int[] array, Predicate<Integer> predicate) {
		List<Integer> list = asList(array).stream().filter(predicate).collect(Collectors.toList());
		
		int[] newArray = new int[list.size()];
		int counter = 0;
		for (int thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static long[] filter(long[] array, Predicate<Long> predicate) {
		List<Long> list = asList(array).stream().filter(predicate).collect(Collectors.toList());
		
		long[] newArray = new long[list.size()];
		int counter = 0;
		for (long thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static float[] filter(float[] array, Predicate<Float> predicate) {
		List<Float> list = asList(array).stream().filter(predicate).collect(Collectors.toList());
		
		float[] newArray = new float[list.size()];
		int counter = 0;
		for (float thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static double[] filter(double[] array, Predicate<Double> predicate) {
		List<Double> list = asList(array).stream().filter(predicate).collect(Collectors.toList());
		
		double[] newArray = new double[list.size()];
		int counter = 0;
		for (double thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static boolean[] filter(boolean[] array, Predicate<Boolean> predicate) {
		List<Boolean> list = asList(array).stream().filter(predicate).collect(Collectors.toList());
		
		boolean[] newArray = new boolean[list.size()];
		int counter = 0;
		for (boolean thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static char[] filter(char[] array, Predicate<Character> predicate) {
		List<Character> list = asList(array).stream().filter(predicate).collect(Collectors.toList());
		
		char[] newArray = new char[list.size()];
		int counter = 0;
		for (char thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static <T> T[] filter(T[] array, Predicate<? super T> predicate) {
		return Arrays.stream(array).filter(predicate).toArray((size) -> newArray(array, size));
	}
	
	public static List<Byte> asList(byte[] array) {
		ArrayList<Byte> arrayList = new ArrayList<>(array.length);
		forEach(array, arrayList::add);
		return arrayList;
	}
	
	public static List<Short> asList(short[] array) {
		ArrayList<Short> arrayList = new ArrayList<>(array.length);
		forEach(array, arrayList::add);
		return arrayList;
	}
	
	public static List<Integer> asList(int[] array) {
		ArrayList<Integer> arrayList = new ArrayList<>(array.length);
		forEach(array, arrayList::add);
		return arrayList;
	}
	
	public static List<Long> asList(long[] array) {
		ArrayList<Long> arrayList = new ArrayList<>(array.length);
		forEach(array, arrayList::add);
		return arrayList;
	}
	
	public static List<Float> asList(float[] array) {
		ArrayList<Float> arrayList = new ArrayList<>(array.length);
		forEach(array, arrayList::add);
		return arrayList;
	}
	
	public static List<Double> asList(double[] array) {
		ArrayList<Double> arrayList = new ArrayList<>(array.length);
		forEach(array, arrayList::add);
		return arrayList;
	}
	
	public static List<Boolean> asList(boolean[] array) {
		ArrayList<Boolean> arrayList = new ArrayList<>(array.length);
		forEach(array, arrayList::add);
		return arrayList;
	}
	
	public static List<Character> asList(char[] array) {
		ArrayList<Character> arrayList = new ArrayList<>(array.length);
		forEach(array, arrayList::add);
		return arrayList;
	}
	
	public static <T> List<T> asList(T[] array) {
		ArrayList<T> arrayList = new ArrayList<>(array.length);
		forEach(array, arrayList::add);
		return arrayList;
	}
	
	public static byte[] asByteArray(List<Byte> list) {
		byte[] newArray = new byte[list.size()];
		int counter = 0;
		for (byte thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static short[] asShortArray(List<Short> list) {
		short[] newArray = new short[list.size()];
		int counter = 0;
		for (short thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static int[] asIntArray(List<Integer> list) {
		int[] newArray = new int[list.size()];
		int counter = 0;
		for (int thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static long[] asLongArray(List<Long> list) {
		long[] newArray = new long[list.size()];
		int counter = 0;
		for (long thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static float[] asFloatArray(List<Float> list) {
		float[] newArray = new float[list.size()];
		int counter = 0;
		for (float thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static double[] asDoubleArray(List<Double> list) {
		double[] newArray = new double[list.size()];
		int counter = 0;
		for (double thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static boolean[] asBooleanArray(List<Boolean> list) {
		boolean[] newArray = new boolean[list.size()];
		int counter = 0;
		for (boolean thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static char[] asCharArray(List<Character> list) {
		char[] newArray = new char[list.size()];
		int counter = 0;
		for (char thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	public static <T> T[] asArray(List<T> list) {
		T[] newArray = newArray(list.getClass().getComponentType(), list.size());
		int counter = 0;
		for (T thing: list) {
			newArray[counter] = thing;
			counter += 1;
		}
		
		return newArray;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] newArray(T[] arrayWithType, int size) {
		Class<?> typeOfArray = arrayWithType.getClass().getComponentType();
		return (T[]) Array.newInstance(typeOfArray, size);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] newArray(Class<?> typeOfArray, int size) {
		return (T[]) Array.newInstance(typeOfArray, size);
	}
	
}
