/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 *
 * This code is free software. It comes without any warranty, to the extent permitted by
 * applicable law. You can redistribute it and/or modify it under the terms of the
 * Do What The Fuck You Want To Public License, Version 2, as published by Sam Hocevar.
 * See http://www.wtfpl.net/ for more details.
 */

package ru.antihack3r.bebralib.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * A thread-safe stack. The top of the stack is at the beginning of the delegate.
 * @param <T> The element type for the stack.
 */
public class Stack<T> {
	
	/**
	 * The delegate list.
	 */
	private final ArrayList<T> delegate;
	
	/**
	 * A field used to lock.
	 */
	private final Object lock;
	
	/**
	 * Constructs a new empty {@link Stack}.
	 */
	public Stack() {
		this.delegate = new ArrayList<>();
		this.lock = this;
	}
	
	/**
	 * Constructs a new {@link Stack}, containing elements of the specified collection,
	 * in the order that they are in the specified collection.
	 */
	public Stack(Collection<T> initialElements) {
		this.delegate = new ArrayList<>(initialElements);
		this.lock = this;
	}
	
	/**
	 * Constructs a new {@link Stack}, containing elements of the specified array,
	 * in the order that they are in the specified array.
	 */
	public Stack(T[] initialElements) {
		this.delegate = new ArrayList<>(Arrays.asList(initialElements));
		this.lock = this;
	}
	
	/**
	 * Pushes the given element onto the top of the stack.
	 * @param thing the element that must be pushed to the top of the stack.
	 */
	public void push(T thing) {
		synchronized (this.lock) {
			this.delegate.add(0, thing);
		}
	}
	
	/**
	 * Pops the top-most element off the stack and returns it.
	 * @return the top of the stack.
	 * @throws NoSuchElementException if the stack is empty.
	 */
	public T pop() {
		synchronized(this.lock) {
			if (this.delegate.isEmpty())
				throw new NoSuchElementException();
			
			return this.delegate.remove(0);
		}
	}
	
	/**
	 * Peeks at an element in the stack.
	 * @param index the index of the element on the stack (0 represents the top of the stack).
	 * @return the <tt>index</tt>th element of the stack.
	 * @throws IndexOutOfBoundsException if <tt>index</tt> is out of this stack's bounds.
	 * @throws NoSuchElementException if the stack is empty.
	 */
	public T peek(int index) {
		synchronized(this.lock) {
			if (this.delegate.isEmpty())
				throw new NoSuchElementException();
			
			return this.delegate.get(index);
		}
	}
	
	/**
	 * Peeks at the first element in the stack.
	 * @return the first element of the stack.
	 * @throws NoSuchElementException if the stack is empty.
	 */
	public T top() {
		return peek(0);
	}

	/**
	 * Peeks at the last element in the stack.
	 * @return the last element of the stack.
	 * @throws NoSuchElementException if the stack is empty.
	 */
	public T bottom() {
		return peek(this.delegate.size() - 1);
	}
	
	/**
	 * Returns <tt>true</tt> if the stack is empty.
	 * @return <tt>true</tt> if the stack is empty, <tt>false</tt>
	 * otherwise.
	 */
	public boolean isEmpty() {
		synchronized(this.lock) {
			return this.delegate.isEmpty();
		}
	}
	
	/**
	 * Returns the size of the stack.
	 * @return size of the stack.
	 */
	public int size() {
		synchronized(this.lock) {
			return this.delegate.size();
		}
	}
	
}
