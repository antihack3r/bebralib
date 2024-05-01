/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 */

package ru.antihack3r.bebralib.math;

import ru.antihack3r.bebralib.data.MoreArrays;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;

/**
 * Contains four hash algorithms which can be used by
 * calling {@link Hash#generateHash(String, Charset)}.
 * For example, to get the MD5 hash of "12345678", you
 * go <pre>{@code Hash.MD5.generateHash("12345678", null);}</pre>.
 */
public enum Hash {
	
	SHA_256("SHA-256"),
	SHA_512("SHA-512"),
	CRC_32("CRC-32") {
		private CRC32 crc32;
		
		@Override
		public @Nonnull String generateHash(@Nonnull String value, Charset charset) {
			if (crc32 == null)
				crc32 = new CRC32();
			
			crc32.update(value.getBytes(charset == null? StandardCharsets.UTF_8: charset));
			long v = crc32.getValue();
			crc32.reset();
			
			return crcValueToHex(v);
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
	 * @return the hexadecimal hash value.
	 */
	public @Nonnull String generateHash(@Nonnull String value, @Nullable Charset charset) {
		byte[] bytes = value.getBytes(charset == null? StandardCharsets.UTF_8: charset);
		
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance(method);
		} catch (NoSuchAlgorithmException exception) {
			throw new RuntimeException(method + " This shouldn't happen...");
		}
		byte[] encodedHash = digest.digest(bytes);
		return bytesToHex(encodedHash);
	}
	
	/**
	 * Turns {@code bytes} into its hexadecimal representation.
	 * @param bytes a byte array.
	 * @return the hexadecimal representation of {@code bytes}.
	 */
	private static @Nonnull String bytesToHex(@Nonnull byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		
		MoreArrays.forEach(bytes, b -> sb.append(String.format("%02X", b)));
		
		return sb.toString();
	}
	
	/**
	 * Represents {@code value} as a hexadecimal string.
	 * @param value a {@code long} to be represented as a hexadecimal string.
	 * @return a hexadecimal string representation of {@code value}.
	 */
	private static @Nonnull String crcValueToHex(long value) {
		return Long.toHexString(value).toUpperCase();
	}

}
