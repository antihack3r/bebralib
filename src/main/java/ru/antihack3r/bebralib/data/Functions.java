/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
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
