package kr.mook.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * EncryptUtil
 * 
 * @since 2024.06.10
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class EncryptUtil {
	
	/**
	 * Converts plain text into ciphertext using SHA256 encryption.
	 * 
	 * @param plainText
	 * @return Returns a string encrypted with SHA256.
	 */
	public static String toSHA256(final String plainText) {
		String encryptText = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(plainText.getBytes());
			byte[] encryptTextBytes = md.digest();
			StringBuffer sb = new StringBuffer();
			for(byte b : encryptTextBytes) {
				sb.append(String.format("%02x", b));
			}
			
			encryptText = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encryptText;
	}

}
