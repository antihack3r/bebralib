/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/rusnuker/bebralib
 */

package ru.antihack3r.bebralib.data;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.function.Predicate;

public class Conditions {
	
	public static final Predicate<Object> NON_NULL = Objects::nonNull;
	
	private void lmao() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		Constructor<? extends Math> c = Math.class.getDeclaredConstructor();
		c.setAccessible(true);
		c.newInstance();
		c.setAccessible(false);
	}
	
}
