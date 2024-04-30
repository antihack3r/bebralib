package ru.antihack3r.bebralib.math;

class CryptographyTest {
	
	public static void main(String[] args) {
		for (Cryptography crypt: Cryptography.values())
			System.out.println(crypt.generateHash("12345678", null));
	}
	
}