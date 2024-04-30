/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 */

package ru.antihack3r.bebralib.run;

import java.util.Objects;

@FunctionalInterface
public interface SafeRunnable extends Runnable {
	
	void runSafely();
	
	@Override
	default void run() {
		try {
			runSafely();
		} catch (Throwable t) {
			//noinspection CallToPrintStackTrace
			t.printStackTrace();
		}
	}
	
	default SafeRunnable andThen(SafeRunnable after) {
		Objects.requireNonNull(after);
		return () -> { runSafely(); after.runSafely(); };
	}
	
}