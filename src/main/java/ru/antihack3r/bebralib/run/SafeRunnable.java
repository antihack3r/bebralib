/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 *
 * This code is free software. It comes without any warranty, to the extent permitted by
 * applicable law. You can redistribute it and/or modify it under the terms of the
 * Do What The Fuck You Want To Public License, Version 2, as published by Sam Hocevar.
 * See http://www.wtfpl.net/ for more details.
 */

package ru.antihack3r.bebralib.run;

import java.util.Objects;

/**
 * <tt>SafeRunnable</tt> is just like a regular {@link Runnable}, but it catches
 * any thrown exceptions.
 */
@FunctionalInterface
public interface SafeRunnable extends Runnable {
	
	/**
	 * Runs the code.
	 */
	void runSafely();
	
	/**
	 * Calls {@link SafeRunnable#runSafely()} and catches any exceptions thrown in the process.
	 */
	@Override
	default void run() {
		try {
			runSafely();
		} catch (Throwable t) {
			//noinspection CallToPrintStackTrace
			t.printStackTrace();
		}
	}
	
	/**
	 * Combines this {@link SafeRunnable} with <tt>after</tt>, such that <tt>after</tt> will
	 * run after this {@link SafeRunnable}.
	 * @param after {@link SafeRunnable}, code of which should be run after this one.
	 * @return A new {@link SafeRunnable}.
	 */
	default SafeRunnable andThen(SafeRunnable after) {
		Objects.requireNonNull(after);
		return () -> { runSafely(); after.runSafely(); };
	}
	
}