/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/rusnuker/bebralib
 */

package ru.antihack3r.bebralib.list;

import java.util.*;

/**
 *
 * @param <E>
 */
public class NonNullList<E> extends AbstractList<E> {
	
	private final ArrayList<E> delegate;
	private final E defaultElement;
	
	public static <E> NonNullList<E> create()
	{
		return new NonNullList<>();
	}
	
	public static <E> NonNullList<E> withSize(int size, E fill) {
		if (fill == null)
			throw new NullPointerException("fill is null");
		
		if (size < 0)
			throw new IllegalArgumentException("size is negative");
		
		ArrayList<E> list = new ArrayList<>();
		for (int i = 0; i < size; i += 1)
			list.add(fill);
		
		return new NonNullList<>(list, fill);
	}
	
	@SafeVarargs
	public static <E> NonNullList<E> from(E defaultElementIn, E... elements) {
		return new NonNullList<>(new ArrayList<>(Arrays.asList(elements)), defaultElementIn);
	}
	
	protected NonNullList()
	{
		this(new ArrayList<>(), null);
	}
	
	protected NonNullList(ArrayList<E> delegateIn, E defaultElementIn) {
		this.delegate = delegateIn;
		this.defaultElement = defaultElementIn;
	}
	
	public E get(int index) {
		return this.delegate.get(index);
	}
	
	public E set(int index, E element) {
		if (element == null)
			throw new NullPointerException("element is null");
		
		return this.delegate.set(index, element);
	}
	
	public void add(int index, E element) {
		if (element == null)
			throw new NullPointerException("element is null");
		
		this.delegate.add(index, element);
	}
	
	public E remove(int index) {
		return this.delegate.remove(index);
	}
	
	public int size() {
		return this.delegate.size();
	}
	
	public void clear() {
		if (this.defaultElement == null)
			super.clear();
		else
			Collections.fill(this, this.defaultElement);
	}
	
}
