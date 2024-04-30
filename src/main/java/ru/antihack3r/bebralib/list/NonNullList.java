/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 */

package ru.antihack3r.bebralib.list;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A list in which all the elements are guaranteed to be non-null.
 *
 * @param <E> A type of the list.
 */
public class NonNullList<E> extends ArrayList<E> {
	
	/**
	 * Constructs a list containing the elements of the specified
	 * collection, in the order they are returned by the collection's
	 * iterator, and filtered from null values.
	 *
	 * @param c the collection whose elements are to be placed into this list
	 */
	public NonNullList(@Nonnull Collection<? extends E> c) {
		super(c.stream().filter(Objects::nonNull).collect(Collectors.toList()));
	}
	
	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * More formally, returns <tt>true</tt> if and only if this list contains
	 * at least one element <tt>e</tt> such that <tt>o.equals(e)</tt>.
	 *
	 * @param o element whose presence in this list is to be tested
	 * @return <tt>false</tt> if this list doesn't contain the specified element,
	 * or if the specified element is null, true otherwise.
	 */
	@Override
	public boolean contains(@Nonnull Object o) {
		if (o == null) return false;
		return super.contains(o);
	}
	
	/**
	 * Returns the index of the first occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element.
	 * More formally, returns the lowest index <tt>i</tt> such that
	 * <tt>o.equals(get(i))</tt>, or -1 if there is no such index.
	 * @param o element to search for
	 * @return the index of the first occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element or if <tt>o</tt> is null
	 */
	@Override
	public int indexOf(@Nonnull Object o) {
		if (o == null) return -1;
		return super.indexOf(o);
	}
	
	/**
	 * Returns the index of the last occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element.
	 * More formally, returns the highest index <tt>i</tt> such that
	 * <tt>o.equals(get(i)))</tt>, or -1 if there is no such index.
	 * @param o element to search for
	 * @return the index of the last occurrence of the specified element
	 * in this list, or -1 if this list does not contain the element or if <tt>o</tt> is null
	 */
	@Override
	public int lastIndexOf(@Nonnull Object o) {
		if (o == null) return -1;
		return super.lastIndexOf(o);
	}
	
	/**
	 * Replaces the element at the specified position in this list with
	 * the specified element.
	 *
	 * @param index   index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 * @throws NullPointerException if <tt>element</tt> is null
	 */
	@Override
	public E set(int index, @Nonnull E element) {
		throwIfNull(element);
		return super.set(index, element);
	}
	
	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param element element to be appended to this list
	 * @return <tt>true</tt> (as specified by {@link Collection#add})
	 * @throws NullPointerException if <tt>element</tt> is null
	 */
	@Override
	public boolean add(@Nonnull E element) {
		throwIfNull(element);
		return super.add(element);
	}
	
	/**
	 * Inserts the specified element at the specified position in this
	 * list. Shifts the element currently at that position (if any) and
	 * any subsequent elements to the right (adds one to their indices).
	 *
	 * @param index   index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 * @throws NullPointerException if <tt>element</tt> is null
	 */
	@Override
	public void add(int index, @Nonnull E element) {
		throwIfNull(element);
		super.add(index, element);
	}
	
	/**
	 * Removes the first occurrence of the specified element from this list,
	 * if it is present.  If the list does not contain the element, it is
	 * unchanged.  More formally, removes the element with the lowest index
	 * <tt>i</tt> such that <tt>o.equals(get(i))</tt> (if such an element
	 * exists).  Returns <tt>true</tt> if this list contained the specified
	 * element (or equivalently, if this list changed as a result of the call).
	 *
	 * @param o element to be removed from this list, if present
	 * @return <tt>false</tt> if this list didn't contain the specified element,
	 * or if <tt>o</tt> is null
	 */
	@Override
	public boolean remove(@Nonnull Object o) {
		if (o == null) return false;
		return super.remove(o);
	}
	
	/**
	 * Appends all the elements in the specified collection to the end of
	 * this list, in the order that they are returned by the
	 * specified collection's Iterator.  The behavior of this operation is
	 * undefined if the specified collection is modified while the operation
	 * is in progress.  (This implies that the behavior of this call is
	 * undefined if the specified collection is this list, and this
	 * list is nonempty.)
	 *
	 * @param c collection containing elements to be added to this list
	 * @return <tt>true</tt> if this list changed as a result of the call
	 * @throws NullPointerException if the specified collection is null,
	 * or if at least one of the elements of the specified collection is null
	 */
	@Override
	public boolean addAll(@Nonnull Collection<? extends E> c) {
		for (E element: c) NonNullList.throwIfNull(element);
		return super.addAll(c);
	}
	
	/**
	 * Inserts all the elements in the specified collection into this
	 * list, starting at the specified position.  Shifts the element
	 * currently at that position (if any) and any subsequent elements to
	 * the right (increases their indices).  The new elements will appear
	 * in the list in the order that they are returned by the
	 * specified collection's iterator.
	 *
	 * @param index index at which to insert the first element from the
	 *              specified collection
	 * @param c     collection containing elements to be added to this list
	 * @return <tt>true</tt> if this list changed as a result of the call
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 * @throws NullPointerException      if the specified collection is null,
	 * or if at least one of the elements of the specified collection is null
	 */
	@Override
	public boolean addAll(int index, @Nonnull Collection<? extends E> c) {
		for (E element: c) NonNullList.throwIfNull(element);
		return super.addAll(index, c);
	}
	
	private static void throwIfNull(Object object) {
		if (object == null)
			throw new NullPointerException();
	}
	
}
