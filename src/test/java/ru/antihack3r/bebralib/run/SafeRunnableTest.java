package ru.antihack3r.bebralib.run;

class SafeRunnableTest {
	
	public static void main(String[] args) {
		new Thread((SafeRunnable) () -> {
			System.out.println("goodbye world");
			throw new NullPointerException();
		}).start();
	}
	
}