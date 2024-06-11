package kr.mook.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * EncryptUtil
 * 
 * @since 2024.06.10
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class EncryptUtil {
	
	private static final Logger log = Logger.getLogger(EncryptUtil.class.getName());
	
	private static final String SHA_256_INSTANCE = "SHA-256";
	private static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
	private static final String AES_KEY_SPEC = "AES";
	private static final String AES_KEY = "test1234test1234test1234";
	
	/**
	 * Converts plain text into cipher text using SHA256 encryption.
	 * 
	 * @param plainText
	 * @return Returns a string encrypted with SHA256.
	 */
	public static String toSHA256(final String plainText) {
		String encryptText = "";
		try {
			MessageDigest md = MessageDigest.getInstance(SHA_256_INSTANCE);
			md.update(plainText.getBytes());
			byte[] encryptTextBytes = md.digest();
			StringBuffer sb = new StringBuffer();
			for(byte b : encryptTextBytes) {
				sb.append(String.format("%02x", b));
			}
			
			encryptText = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			log.severe("Error occurred to creation MessageDigest because SHA256 algorithm no such.");
			e.printStackTrace();
		}
		
		return encryptText;
	}
	
	/**
	 * Converts plain text into cipher text using AES encryption.
	 * 
	 * @param plainText
	 * @return Returns a string encrypted with AES.
	 */
	public static String toAES(final String plainText) {
		if(plainText == null) return null;
		
		String cipherText = "";
		try {
			// AES Secret key
			SecretKeySpec secretKey = new SecretKeySpec(AES_KEY.getBytes("UTF-8"), AES_KEY_SPEC);
			IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
			
			// AES instance
			Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
			// Init
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
			// Create cipher text
			byte[] cipherTextBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
			cipherText = Base64.getEncoder().encodeToString(cipherTextBytes);
		} catch (NoSuchAlgorithmException e) {
			log.severe("Error occurred to creation cipher instance because AES algorithm no such.");
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			log.severe("Error occurred to creation cipher instance because AES padding no such.");
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			log.severe("Error occurred to init AES cipher instance because invalid key.");
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			log.severe("Error occurred to init AES cipher instance because invalid algorithm parameter.");
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			log.severe("Error occurred to making AES cipher text.");
			e.printStackTrace();
		} catch (BadPaddingException e) {
			log.severe("Error occurred to making AES cipher text because bad padding.");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			log.severe("Error occurred to making AES cipher text because unsupported encoding.");
			e.printStackTrace();
		}
		
		return cipherText;
	}
}
