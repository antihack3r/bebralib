/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/rusnuker/bebralib
 */

package ru.antihack3r.bebralib.data;

import java.util.Objects;
import java.util.function.Predicate;

public class Conditions {
	
	public static final Predicate<Object> NON_NULL = Objects::nonNull;
	
}
