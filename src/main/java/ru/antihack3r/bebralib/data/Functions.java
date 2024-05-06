/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 *
 * This code is free software. It comes without any warranty, to the extent permitted by
 * applicable law. You can redistribute it and/or modify it under the terms of the
 * Do What The Fuck You Want To Public License, Version 2, as published by Sam Hocevar.
 * See http://www.wtfpl.net/ for more details.
 */

package ru.antihack3r.bebralib.data;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Common functions.
 */
public class Functions {
	
	public static final BooleanSupplier BOOL_SUPPLIER_TRUE = () -> true;
	public static final BooleanSupplier BOOL_SUPPLIER_FALSE = () -> false;
	public static final Predicate<?> PREDICATE_NONNULL = Objects::nonNull;
	
	public static <T> Consumer<T> emptyConsumer() {
		return t -> {};
	}
	
	public static <T> Predicate<T> emptyPredicate(boolean flag) {
		return t -> flag;
	}
	
}
