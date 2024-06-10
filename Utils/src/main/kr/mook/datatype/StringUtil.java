package kr.mook.datatype;

import java.util.Random;

/**
 * StringUtil
 * 
 * @since 2024.05.22
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class StringUtil {
	
	private static final String ALPHABET_UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String ALPHABET_LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMBERS = "0123456789";
	private static final String SPECIAL_CHARACTERS = "!@#$_-";
	
	/**
	 * This method to check if value is empty or null.<br/>
	 * If value is empty or null, return true. Else return false.<br/>
	 * 
	 * @param value
	 * @return true or false
	 */
	public static boolean isEmpty(final String value) {
		if(value == null || value.isEmpty()) return true;
		return false;
	}
	
	/**
	 * This method to check if value is not empty and not null.<br/>
	 * If value is empty or null, return false. Else return true.<br/>
	 * 
	 * @param value
	 * @return true or false
	 */
	public static boolean isNotEmpty(final String value) {
		if(value == null || value.isEmpty()) return false;
		return true;
	}
	
	/**
	 * This method checks if the string is null and returns an empty value if the string is null, otherwise it returns the passed value.
	 * 
	 * @param value
	 * @return empty string or parameter value
	 */
	public static String nullToString(final String value) {
		if(value == null) return "";
		return value;
	}
	
	/**
	 * This method checks if the string is null and returns an default value if the string is null, otherwise it returns the passed value.
	 * 
	 * @param value
	 * @return empty string or parameter value
	 */
	public static String nullToString(final String value, final String defaultValue) {
		if(value == null) return defaultValue;
		return value;
	}
	
	/**
	 * When you enter a length, this method creates a string that randomly combines English letters, numbers, and special characters to the length entered.
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(final int length) {
		
		String characters = ALPHABET_UPPERCASE_LETTERS
				+ ALPHABET_LOWERCASE_LETTERS
				+ NUMBERS
				+ SPECIAL_CHARACTERS;
		StringBuilder result = new StringBuilder(length);
		Random random = new Random();
		
		for (int i = 0; i < length; i++) {
			result.append(characters.charAt(random.nextInt(characters.length())));
		}
		
		return result.toString();
	}
}
