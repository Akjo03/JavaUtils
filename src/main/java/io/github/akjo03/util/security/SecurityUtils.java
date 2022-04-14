package io.github.akjo03.util.security;

import org.jetbrains.annotations.NotNull;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public final class SecurityUtils {
	private SecurityUtils() { throw new UnsupportedOperationException("Cannot instantiate SecurityUtils!"); }

	private static final SecureRandom random;
	private static final Cipher cipher;
	private static final byte[] iv;

	static {
		try {
			random = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			throw new SecurityException("Failed to initialize SecureRandom!", e);
		}
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			throw new SecurityException("Failed to initialize Cipher!", e);
		}
		iv = new byte[16];
		random.nextBytes(iv);
	}

	public static byte @NotNull [] getRandomSalt() {
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return salt;
	}

	public static SecretKey getSecretKey(@NotNull String password) {
		KeyGenerator keyGen;
		try {
			keyGen = KeyGenerator.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			throw new SecurityException("Failed to initialize KeyGenerator!", e);
		}
		keyGen.init(256, random);
		return keyGen.generateKey();
	}

	public static byte[] encrypt(byte @NotNull [] data, @NotNull SecretKey key) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
			return cipher.doFinal(data);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
			throw new SecurityException("Failed to initialize Cipher!", e);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			throw new SecurityException("Failed to encrypt data!", e);
		}
	}

	public static byte[] decrypt(byte @NotNull [] data, @NotNull SecretKey key) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
			return cipher.doFinal(data);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
			throw new SecurityException("Failed to initialize Cipher!", e);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			throw new SecurityException("Failed to decrypt data!", e);
		}
	}
}