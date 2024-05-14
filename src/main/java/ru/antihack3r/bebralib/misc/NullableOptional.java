/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 *
 * This code is free software. It comes without any warranty, to the extent permitted by
 * applicable law. You can redistribute it and/or modify it under the terms of the
 * Do What The Fuck You Want To Public License, Version 2, as published by Sam Hocevar.
 * See http://www.wtfpl.net/ for more details.
 */

package ru.antihack3r.bebralib.misc;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.*;

/**
 * A container object which may or may not contain a nullable value.
 * If a value is present, {@link #isPresent()} will return {@code true} and
 * {@link #get()} will return the value, otherwise {@link #isPresent()} will
 * return {@code false} and {@link #get()} will throw {@link NoSuchElementException}.
 *
 * <p>Additional methods that depend on the presence or absence of a contained
 * value are provided, such as {@link #orElse(Object)} (return a default value
 * if value not present) and {@link #ifPresent(Consumer)} (execute a block of
 * code if the value is present).
 *
 * <p>This is a <a href="../lang/doc-files/ValueBased.html">value-based</a>
 * class; use of identity-sensitive operations (including reference equality
 * ({@code ==}), identity hash code, or synchronization) on instances of
 * {@code NullableOptional} may have unpredictable results and should be
 * avoided.
 */
public class NullableOptional<T> {
	
	/**
	 * The value. May be null.
	 */
	@Nullable
	private final T value;
	
	/**
	 * Is set to true when the value is present.
	 */
	private final boolean present;
	
	/**
	 * Constructs an empty {@link NullableOptional}. The constructor
	 * is private for the funny.
	 */
	private NullableOptional() {
		this.value = null;
		this.present = false;
	}
	
	/**
	 * Constructs a new {@link NullableOptional} instance with
	 * the value present.
	 *
	 * @param value the value.
	 */
	public NullableOptional(@Nullable T value) {
		this.value = value;
		this.present = true;
	}
	
	/**
	 * Constructs a new empty {@link NullableOptional} instance
	 * with the value <b>not</b> present and returns it.
	 */
	public static <T> NullableOptional<T> empty() {
		return new NullableOptional<>();
	}
	
	/**
	 * Returns <tt>true</tt> if the value is present, <tt>false</tt>
	 * otherwise.
	 * @return <tt>true</tt> if the value is present, <tt>false</tt>
	 * otherwise.
	 *
	 * @see #isEmpty()
	 */
	public boolean isPresent() {
		return this.present;
	}
	
	/**
	 * Returns <tt>true</tt> if the value is <b>not</b> present,
	 * <tt>false</tt> otherwise.
	 * @return <tt>true</tt> if the value is <b>not</b> present,
	 * <tt>false</tt> otherwise.
	 *
	 * @see #isPresent()
	 */
	public boolean isEmpty() {
		return !this.present;
	}
	
	/**
	 * Returns the value stored in this {@link NullableOptional}.
	 * Note that unlike {@link java.util.Optional the original thing},
	 * this method can actually return <tt>null</tt>, even if
	 * {@link #isPresent()} returns <tt>true</tt>.
	 *
	 * @return the value stored in this {@link NullableOptional}.
	 */
	@Nullable
	public T get() {
		if (this.isEmpty())
			throw new NoSuchElementException();
		
		return this.value;
	}
	
	/**
	 * If a value is present, invoke the specified consumer with the value
	 * stored in this {@link NullableOptional}, otherwise do nothing.
	 *
	 * @param consumer a consumer to be invoked if a value is present.
	 * @throws NullPointerException if a value is present and {@code consumer} is
	 * <tt>null</tt>.
	 */
	public void ifPresent(@Nonnull Consumer<? super T> consumer) {
		if (this.isPresent())
			consumer.accept(this.value);
	}
	
	/**
	 * If a value is present, and the value matches the given predicate,
	 * return a {@link NullableOptional} describing the value, otherwise
	 * return an empty {@link NullableOptional}.
	 *
	 * @param predicate a predicate to apply to the value, if present
	 * @return a {@link NullableOptional} describing the value of this
	 * {@link NullableOptional} if a value is present and the value
	 * matches the given predicate, otherwise an empty
	 * {@link NullableOptional}.
	 * @throws NullPointerException if a value is present and the
	 * predicate is <tt>null</tt>.
	 */
	@Nonnull
	public NullableOptional<T> filter(@Nonnull Predicate<? super T> predicate) {
		if (this.isEmpty())
			return this;
		else
			return predicate.test(value)? this: empty();
	}
	
	/**
	 * If a value is present, apply the provided mapping function to it,
	 * and return a {@link NullableOptional} describing the result,
	 * or an empty {@link NullableOptional} if a value is not present.
	 *
	 * @apiNote This method supports post-processing on optional values, without
	 * the need to explicitly check for a return status.  For example, the
	 * following code traverses a stream of file names, selects one that has
	 * not yet been processed, and then opens that file, returning an
	 * {@code Optional<FileInputStream>}:
	 *
	 * <pre>{@code
	 *     Optional<FileInputStream> fis =
	 *         names.stream().filter(name -> !isProcessedYet(name))
	 *                       .findFirst()
	 *                       .map(name -> new FileInputStream(name));
	 * }</pre>
	 *
	 * Here, {@code findFirst} returns an {@code NullableOptional<String>}, and then
	 * {@code map} returns an {@code NullableOptional<FileInputStream>} for the desired
	 * file if one exists.
	 *
	 * @param <U> The type of the result of the mapping function.
	 * @param mapper a mapping function to apply to the value, if present
	 * @return an {@link NullableOptional} describing the result of applying a mapping
	 * function to the value of this {@link NullableOptional}, if a value is present,
	 * or an empty {@link NullableOptional} if a value is not present.
	 * @throws NullPointerException if a value is present and the mapping function is <tt>null</tt>.
	 */
	@Nonnull
	public <U> NullableOptional<U> map(@Nonnull Function<? super T, ? extends U> mapper) {
		if (this.isEmpty())
			return empty();
		else {
			return new NullableOptional<>(mapper.apply(this.value));
		}
	}
	
	/**
	 * If a value is present, apply the provided {@link NullableOptional}-bearing
	 * mapping function to it, return that result, otherwise return an empty
	 * {@link NullableOptional}.  This method is similar to {@link #map(Function)},
	 * but the provided mapper is one whose result is already an {@link NullableOptional},
	 * and if invoked, {@code flatMap} does not wrap it with an additional
	 * {@link NullableOptional}.
	 *
	 * @param <U> The type parameter to the {@link NullableOptional} returned by
	 * the mapping function.
	 * @param mapper a mapping function to apply to the value, if present.
	 * @return the result of applying an {@link NullableOptional}-bearing mapping
	 * function to the value of this {@link NullableOptional}, if a value is present,
	 * otherwise an empty {@link NullableOptional}.
	 * @throws NullPointerException if a value is present and the mapping function is
	 * <tt>null</tt>.
	 */
	@Nullable
	public <U> NullableOptional<U> flatMap(@Nonnull Function<? super T, NullableOptional<U>> mapper) {
		if (this.isEmpty())
			return empty();
		else {
			return mapper.apply(this.value);
		}
	}
	
	/**
	 * Return the value if present, otherwise return {@code other}.
	 *
	 * @param other the value to be returned if there is no value present, may
	 * be null.
	 * @return the value, if present, otherwise {@code other}.
	 */
	@Nullable
	public T orElse(@Nullable T other) {
		return this.isPresent()? this.value: other;
	}
	
	/**
	 * Return the value if present, otherwise invoke {@code other} and return
	 * the result of that invocation.
	 *
	 * @param other a {@link Supplier} whose result is returned if no value
	 * is present.
	 * @return the value if present otherwise the result of {@link #get()}.
	 * @throws NullPointerException if a value is not present and {@code other} is
	 * null.
	 */
	@Nullable
	public T orElseGet(@Nonnull Supplier<? extends T> other) {
		return this.isPresent()? this.value: other.get();
	}
	
	/**
	 * Return the value if present, otherwise throw an exception
	 * returned by the specified {@link Supplier}.
	 *
	 * @apiNote A method reference to the exception constructor with an empty
	 * argument list can be used as a supplier. For example,
	 * {@code IllegalStateException::new}
	 *
	 * @param <X> Type of the exception to be thrown.
	 * @param exceptionSupplier The supplier which will return the exception to
	 * be thrown.
	 * @return the present value.
	 * @throws X if there is no value present.
	 * @throws NullPointerException if no value is present and
	 * {@code exceptionSupplier} is null.
	 */
	@Nullable
	public <X extends Throwable> T orElseThrow(@Nonnull Supplier<? extends X> exceptionSupplier) throws X {
		if (this.isPresent()) {
			return this.value;
		} else {
			throw exceptionSupplier.get();
		}
	}
	
	/**
	 * Indicates whether a specified object is equal to this
	 * {@link NullableOptional}. The other object is considered equal if:
	 * <ul>
	 * <li>it is also a {@link NullableOptional},
	 * <li>both instances are empty, or
	 * <li>the present values are "equal to" each other via {@code equals()}.
	 * </ul>
	 *
	 * @param o an object to be tested for equality.
	 * @return {@code true} if the other object is "equal to" this object,
	 * otherwise {@code false}.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		
		if (!(o instanceof NullableOptional)) {
			return false;
		}
		
		NullableOptional<?> that = (NullableOptional<?>) o;
		return this.isPresent() == that.isPresent() && Objects.equals(this.value, that.value);
	}
	
	/**
	 * Returns the hash code value of the present value, if any, or 0 (zero) if
	 * no value is present.
	 *
	 * @return hash code value of the present value or 0 if no value is present
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.value, this.present);
	}
	
	/**
	 * Returns a non-empty string representation of this {@link NullableOptional}
	 * suitable for debugging. The exact presentation format is unspecified and
	 * may vary between implementations and versions.
	 *
	 * @implSpec if a value is present, the result must include its string
	 * representation in the result. Empty and present
	 * {@link NullableOptional}s must be unambiguously differentiable.
	 *
	 * @return a string representation of this {@link NullableOptional} instance.
	 */
	@Override
	@Nonnull
	public String toString() {
		return "NullableOptional " + (this.isEmpty()? "(empty)": "") + " of " + this.value;
	}
	
}
