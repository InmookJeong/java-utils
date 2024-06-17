package kr.mook.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
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

/**
 * DecryptUtil
 * 
 * @since 2024.06.11
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class DecryptUtil {
	
	// Logger
	private static final Logger log = Logger.getLogger(DecryptUtil.class.getName());
	
	/**
	 * Converts cipher text into plain text using AES decryption.
	 * 
	 * @param plainText
	 * @param secretKey : This is the key for AES encryption. The encryption key is 32 characters long.
	 * @param iv : This is the initialization vector(IV). The IV is 16 characters long.
	 * @return Returns a string decrypted with AES.
	 */
	public static String fromAES(final String cipherText, final String secretKey, final String iv) {
		if(cipherText == null) return null;
		
		String plainText = "";
		byte[] plainTextBytes = Base64.getDecoder().decode(cipherText);
		try {
			// AES Secret key
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), CryptoEnum.AES.getSpec());
			IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
			
			// AES instance
			Cipher cipher = Cipher.getInstance(CryptoEnum.AES.getAlgorithm());
			// Init
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
			// Create plain text
			plainText = new String(cipher.doFinal(plainTextBytes));
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
		}
		
		return plainText;
	}
}
