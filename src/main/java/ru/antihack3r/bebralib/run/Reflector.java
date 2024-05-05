/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 */

package ru.antihack3r.bebralib.run;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Reflector {
	
	public static Method getDeclaredMethod(Class<?> clazz, String methodName, Class<?>... argTypes) {
		try {
			return clazz.getDeclaredMethod(methodName, argTypes);
		} catch (NoSuchMethodException e) {
			return null;
		}
	}
	
	public static Class<?>[] getTypes(Object... args) {
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
	 * @return a new {@link Class} loaded from the given array, ready to be used. 
	 * Note that {@link Class#forName(String)} won't be able to resolve the class
	 * loaded this way; it exists only here. 
	 */
	public static @Nullable Class<?> loadClassFromBytes(byte @Nonnull [] array) {
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
