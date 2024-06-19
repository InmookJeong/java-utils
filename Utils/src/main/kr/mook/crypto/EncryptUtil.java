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

import kr.mook.enums.CryptoEnum;
import kr.mook.enums.HashEnum;

/**
 * EncryptUtil
 * 
 * @since 2024.06.10
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class EncryptUtil {
	
	// Logger
	private static final Logger log = Logger.getLogger(EncryptUtil.class.getName());
	
	/**
	 * Converts plain text into cipher text using SHA256 encryption.
	 * 
	 * @param plainText
	 * @return Returns a string encrypted with SHA256.
	 */
	public static String toSHA256(final String plainText) {
		String encryptText = "";
		try {
			MessageDigest md = MessageDigest.getInstance(HashEnum.SHA256.getSepc());
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
	 * @param secretKey : This is the key for AES encryption. The encryption key is 32 characters long.
	 * @param iv : This is the initialization vector(IV). The IV is 16 characters long.
	 * @return Returns a string encrypted with AES.
	 */
	public static String toAES(final String plainText, final String secretKey, final String iv) {
		if(plainText == null) return null;
		
		String cipherText = "";
		try {
			// AES Secret key
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), CryptoEnum.AES.getSpec());
			IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
			
			// AES instance
			Cipher cipher = Cipher.getInstance(CryptoEnum.AES.getAlgorithm());
			// Init
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
			// Create cipher text
			byte[] cipherTextBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
			cipherText = new String(Base64.getEncoder().encode(cipherTextBytes));
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
