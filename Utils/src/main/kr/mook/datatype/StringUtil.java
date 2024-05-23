package kr.mook.datatype;

/**
 * StringUtil
 * 
 * @since 2024.05.22
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class StringUtil {
	
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
}