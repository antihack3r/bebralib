/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 */

package ru.antihack3r.bebralib.data;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;
import java.util.Objects;

public class Pair<K, V> implements Map.Entry<K, V>, Cloneable {
	
	private K key;
	private V value;
	
	/**
	 * Constructs a new empty pair.
	 */
	public Pair() {}
	
	/**
	 * Constructs a new {@link Pair} with the given key and value.
	 * @param key a new key.
	 * @param value a new value.
	 */
	public Pair(@Nullable K key, @Nullable V value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Returns the key corresponding to this entry.
	 *
	 * @return the key corresponding to this entry
	 */
	@Override
	public @Nullable K getKey() {
		return key;
	}
	
	/**
	 * Returns the value corresponding to this entry.
	 *
	 * @return the value corresponding to this entry
	 */
	@Override
	public @Nullable V getValue() {
		return null;
	}
	
	/**
	 * Replaces the key corresponding to this entry with the specified
	 * key (optional operation).
	 * @param newKey new key to be stored in this entry
	 * @return old key corresponding to the entry
	 */
	public @Nullable K setKey(@Nullable K newKey) {
		K oldKey = this.key;
		this.key = newKey;
		return oldKey;
	}
	
	/**
	 * Replaces the value corresponding to this entry with the specified
	 * value (optional operation).
	 * @param newValue new value to be stored in this entry
	 * @return old value corresponding to the entry
	 */
	@Override
	public @Nullable V setValue(@Nullable V newValue) {
		V oldValue = this.value;
		this.value = newValue;
		return oldValue;
	}
	
	/**
	 * Clones this pair. Returns a new pair with the same values passed into the constructor.
	 * @return a new pair with the same values
	 */
	@Override
	public @Nonnull Pair<K, V> clone() {
		try { super.clone(); } catch (CloneNotSupportedException ignored) {}
		return new Pair<>(this.key, this.value);
	}
	
	/**
	 * Compares the specified object with this pair for equality.
	 * Returns <tt>true</tt> if the given object is also a pair and
	 * the two pairs represent the same mapping.  More formally, two
	 * pairs <tt>e1</tt> and <tt>e2</tt> represent the same mapping
	 * if<pre>
	 *     (e1.getKey()==null ?
	 *      e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &amp;&amp;
	 *     (e1.getValue()==null ?
	 *      e2.getValue()==null : e1.getValue().equals(e2.getValue()))
	 * </pre>
	 * This ensures that the <tt>equals</tt> method works properly across
	 * different implementations of the pair.
	 *
	 * @param o object to be compared for equality with this pair
	 * @return <tt>true</tt> if the specified object is equal to this pair
	 */
	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
		Pair<?, ?> pair = (Pair<?, ?>) o;
		return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
	}
	
	/**
	 * Returns the hash code value for this pair.  The hash code
	 * of a pair <tt>e</tt> is defined to be: <pre>
	 *     (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
	 *     (e.getValue()==null ? 0 : e.getValue().hashCode())
	 * </pre>
	 * This ensures that <tt>e1.equals(e2)</tt> implies that
	 * <tt>e1.hashCode()==e2.hashCode()</tt> for any two pairs
	 * <tt>e1</tt> and <tt>e2</tt>, as required by the general
	 * contract of <tt>Object.hashCode</tt>.
	 *
	 * @return the hash code value for this pair
	 * @see Object#hashCode()
	 * @see Object#equals(Object)
	 * @see #equals(Object)
	 */
	@Override
	public int hashCode() {
		return (this.key == null? 0: this.key.hashCode()) ^ (this.value == null? 0: this.value.hashCode());
	}
	
	/**
	 * Returns a string representation of the object. In general, the
	 * {@code toString} method returns a string that
	 * "textually represents" this object. The result should
	 * be a concise but informative representation that is easy for a
	 * person to read.
	 * It is recommended that all subclasses override this method.
	 * <p>
	 * The {@code toString} method for class {@code Object}
	 * returns a string consisting of the name of the class of which the
	 * object is an instance, the at-sign character `{@code @}', and
	 * the unsigned hexadecimal representation of the hash code of the
	 * object. In other words, this method returns a string equal to the
	 * value of:
	 * <blockquote>
	 * <pre>
	 * getClass().getName() + '@' + Integer.toHexString(hashCode())
	 * </pre></blockquote>
	 *
	 * @return a string representation of the object.
	 */
	@Override
	public @Nonnull String toString() {
		return "[" + this.key + ", " + this.value + "]";
	}
}
