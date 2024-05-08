/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 *
 * This code is free software. It comes without any warranty, to the extent permitted by
 * applicable law. You can redistribute it and/or modify it under the terms of the
 * Do What The Fuck You Want To Public License, Version 2, as published by Sam Hocevar.
 * See http://www.wtfpl.net/ for more details.
 */

package ru.antihack3r.bebralib.run;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class Reflector {
	
	/**
	 * Checks if the class named <tt>className</tt> exists.
	 * @param className the name of the class that needs to be located.
	 * @return <tt>true</tt> if the class named <tt>className</tt> exists, <tt>false</tt> otherwise.
	 * @see Reflector#isClassVisible(String, ClassLoader) 
	 */
	public static boolean doesClassExist(@Nonnull String className) {
		try {
			Class.forName(className);
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
	
	/**
	 * Checks if the class named <tt>className</tt> exists and is reachable from caller's point of view.
	 * @param className the name of the class that needs to be located.
	 * @param callerLoader the class loader context from which the class needs to be located.
	 * (If <tt>null</tt>, returns <tt>true</tt> immediately.)
	 * @return <tt>true</tt> if the class named <tt>className</tt> exists and is reachable from caller's point of view,
	 * <tt>false</tt> otherwise.
	 * @see Reflector#doesClassExist(String)
	 */
	public static boolean isClassVisible(@Nonnull String className, @Nullable ClassLoader callerLoader) {
		if (callerLoader == null) return true;
		
		Class<?> clazz;
		try {
			clazz = Class.forName(className, false, callerLoader);
		} catch (ClassNotFoundException exc) {
			return false;
		}
		
		try {
			if (clazz.getClassLoader() == callerLoader) {
				return true;
			}
		} catch (SecurityException ex) {
			// eat the exception
		}
		
		try {
			return clazz == callerLoader.loadClass(clazz.getName());
		} catch (ClassNotFoundException exc) {
			return false;
		}
	}
	
	/**
	 * Makes an array of {@link Class} descriptors representing types of elements in <tt>args</tt>
	 * @param args an array containing elements of whatever types that are going to be returned.
	 * @return an array of {@link Class} descriptors representing types of elements in <tt>args</tt>
	 */
	public static @Nonnull Class<?>[] getTypes(@Nonnull Object... args) {
		Class<?>[] argTypes = new Class[args.length];
		int counter = 0;
		for (Object arg: args) {
			argTypes[counter] = arg.getClass();
			counter += 1;
		}
		
		return argTypes;
	}
	
	/**
	 * Loads the given byte array as a {@link Class}.
	 * @param array a byte array containing valid class-file bytes.
	 * @return a new {@link Class} loaded from the given array, ready to be used, or <tt>null</tt> if the array
	 * does not represent a valid class-file.<br>
	 * Note that {@link Class#forName(String)} won't be able to resolve the class
	 * loaded this way; it exists only here. 
	 */
	public static @Nullable Class<?> loadClassFromBytes(@Nonnull byte[] array) {
		try (ByteClassLoader bcl = new ByteClassLoader()) {
			return bcl.load(array);
		} catch (IOException e) {
			return null;
		}
	}
	
	/**
	 * @see Reflector#loadClassFromBytes(byte[]) 
	 */
	public static class ByteClassLoader extends URLClassLoader {
		
		public ByteClassLoader() {
			super(new URL[0], ByteClassLoader.class.getClassLoader());
		}
		
		public Class<?> load(byte[] bytes) {
			Class<?> clazz = defineClass(null, bytes, 0, bytes.length);
			resolveClass(clazz);
			return clazz;
		}
		
	}
	
}
