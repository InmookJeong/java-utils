package kr.mook.datatype;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * StringUtilTest
 * 
 * @since 2024.05.22
 * @author In-mook, Jeong
 * @version 1.0.0
 */
class StringUtilTest {

	@DisplayName(value = "문자열의 값이 Null이거나 빈 값인지 확인")
	@ParameterizedTest
	@CsvSource({
		", true",
		"'', true",
		"1, false",
		"value, false",
		"홍길동, false"
	})
	void isEmpty(String data, boolean expected) {
		if(data == null || data.isEmpty()) assertTrue(expected);
		else assertFalse(expected);
	}
	
	@DisplayName(value = "문자열의 값이 Null이 아니고 빈 값이 아닌지 확인")
	@ParameterizedTest
	@CsvSource({
		", false",
		"'', false",
		"1, true",
		"value, true",
		"홍길동, true"
	})
	void isNotEmpty(String data, boolean expected) {
		if(data == null || data.isEmpty()) assertFalse(expected);
		else assertTrue(expected);
	}

}
