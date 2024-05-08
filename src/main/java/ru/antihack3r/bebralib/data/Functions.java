/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 *
 * This code is free software. It comes without any warranty, to the extent permitted by
 * applicable law. You can redistribute it and/or modify it under the terms of the
 * Do What The Fuck You Want To Public License, Version 2, as published by Sam Hocevar.
 * See http://www.wtfpl.net/ for more details.
 */

package ru.antihack3r.bebralib.data;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Common functions.
 */
public class Functions {
	
	public static final BooleanSupplier BOOL_SUPPLIER_TRUE = () -> true;
	public static final BooleanSupplier BOOL_SUPPLIER_FALSE = () -> false;
	public static final Predicate<?> PREDICATE_NONNULL = Objects::nonNull;
	
	/**
	 * Makes a new {@link Consumer} that does nothing.
	 * @return a new {@link Consumer} that does nothing.
	 * @param <T> type of param value for the new {@link Consumer} (doesn't matter).
	 */
	public static <T> Consumer<T> emptyConsumer() {
		return t -> {};
	}
	
	/**
	 * Makes a new {@link Predicate} that only returns <tt>flag</tt>.
	 * @param flag a value that should always be returned.
	 * @return a new {@link Predicate} that only returns <tt>flag</tt>.
	 * @param <T> a type of the param value for the new {@link Predicate} (doesn't matter).
	 */
	public static <T> Predicate<T> emptyPredicate(boolean flag) {
		return t -> flag;
	}
	
	/**
	 * Gets <tt>T</tt> from <tt>supplier</tt>.
	 * @param supplier the supplier, can be <tt>null</tt>.
	 * @return <tt>T</tt> supplied by <tt>supplier</tt>, or <tt>null</tt> if <tt>supplier</tt> is <tt>null</tt>.
	 */
	@Nullable
	public static <T> T nullSafeGet(@Nullable Supplier<T> supplier) {
		return supplier != null? supplier.get(): null;
	}
	
}
