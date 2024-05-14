/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 *
 * This code is free software. It comes without any warranty, to the extent permitted by
 * applicable law. You can redistribute it and/or modify it under the terms of the
 * Do What The Fuck You Want To Public License, Version 2, as published by Sam Hocevar.
 * See http://www.wtfpl.net/ for more details.
 */

package ru.antihack3r.bebralib.math;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;

/**
 * Contains four hash algorithms which can be used by
 * calling {@link Hash#compute(String, Charset)}.
 * For example, to get the MD5 hash of "12345678", you
 * go <pre>{@code Hash.MD5.compute("12345678", null);}</pre>.
 */
public enum Hash {
	
	SHA_256("SHA-256"),
	SHA_512("SHA-512"),
	CRC_32("CRC-32") {
		private CRC32 crc32;
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public @Nonnull byte[] compute(@Nonnull byte[] array) {
			if (crc32 == null)
				crc32 = new CRC32();
			
			crc32.update(array);
			long v = crc32.getValue();
			crc32.reset();
			
			return longToBytes(v);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public @Nonnull byte[] compute(@Nonnull String value, Charset charset) {
			return compute(value.getBytes(charset == null? StandardCharsets.UTF_8: charset));
		}
		
	},
	MD5("MD5");
	
	private final String method;
	
	Hash(String method) {
		this.method = method;
	}
	
	/**
	 * Generates the hash using the current method.
	 * @param value the value.
	 * @param charset the charset to be used for extracting bytes from {@code value}.
	 * @return a byte array representing the hash of.
	 */
	public @Nonnull byte[] compute(@Nonnull String value, @Nullable Charset charset) {
		return compute(value.getBytes(charset == null? StandardCharsets.UTF_8: charset));
	}
	
	/**
	 * Generates the hash using the current method.
	 * @param array a byte array the values of which need to be hashed.
	 * @return the hexadecimal hash value.
	 */
	public @Nonnull byte[] compute(@Nonnull byte[] array) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance(method);
		} catch (NoSuchAlgorithmException exception) {
			throw new RuntimeException("This shouldn't happen...");
		}
		
		return digest.digest(array);
	}
	
	/**
	 * Turns a <tt>long</tt> value in its byte representation.
	 * @param l a value which needs to be represented as a byte array.
	 * @return a <tt>long</tt> value in its byte representation.
	 */
	private static byte[] longToBytes(long l) {
		byte[] result = new byte[Long.BYTES];
		for (int i = Long.BYTES - 1; i >= 0; i--) {
			result[i] = (byte)(l & 0xFF);
			
			l >>= Byte.SIZE;
		}
		
		return result;
	}

}
