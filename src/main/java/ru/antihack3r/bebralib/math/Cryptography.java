/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 */

package ru.antihack3r.bebralib.math;

import ru.antihack3r.bebralib.data.MoreArrays;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;

public enum Cryptography {
	
	SHA_256("SHA-256"),
	SHA_512("SHA-512"),
	CRC_32("CRC-32"),
	MD5("MD5");
	
	private final String method;
	
	Cryptography(String method) {
		this.method = method;
	}
	
	private CRC32 crc32;
	
	public String generateHash(String value, Charset charset) {
		byte[] bytes = value.getBytes(charset == null? StandardCharsets.UTF_8: charset);
		
		if (this == CRC_32) {
			if (crc32 == null)
				crc32 = new CRC32();
			
			crc32.update(bytes);
			long v = crc32.getValue();
			crc32.reset();
			
			return crcValueToHex(v);
		} else {
			MessageDigest digest;
			try {
				digest = MessageDigest.getInstance(method);
			} catch (NoSuchAlgorithmException exception) {
				throw new RuntimeException(method + " This shouldn't happen...");
			}
			byte[] encodedHash = digest.digest(bytes);
			return bytesToHex(encodedHash);
		}
	}
	
	private static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		
		MoreArrays.forEach(bytes, b -> sb.append(String.format("%02X", b)));
		
		return sb.toString();
	}
	
	private static String crcValueToHex(long value) {
		return Long.toHexString(value).toUpperCase();
	}

}
