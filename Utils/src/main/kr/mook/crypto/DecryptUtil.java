package kr.mook.crypto;

import java.io.UnsupportedEncodingException;
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

/**
 * DecryptUtil
 * 
 * @since 2024.06.11
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class DecryptUtil {
	
	private static final Logger log = Logger.getLogger(DecryptUtil.class.getName());
	
	private static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
	private static final String AES_KEY_SPEC = "AES";
	private static final String AES_KEY = "test1234test1234test1234";
	
	/**
	 * Converts cipher text into plain text using AES decryption.
	 * 
	 * @param plainText
	 * @return Returns a string decrypted with AES.
	 */
	public static String fromAES(final String cipherText) {
		if(cipherText == null) return null;
		
		String plainText = "";
		try {
			// AES Secret key
			SecretKeySpec secretKey = new SecretKeySpec(AES_KEY.getBytes("UTF-8"), AES_KEY_SPEC);
			IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);
			
			// AES instance
			Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
			// Init
			cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
			// Create plain text
			byte[] plainTextBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
			plainText = new String(plainTextBytes, "UTF-8");
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
		
		return plainText;
	}
}
