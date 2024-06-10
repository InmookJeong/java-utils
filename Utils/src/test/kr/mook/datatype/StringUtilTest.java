package kr.mook.datatype;

import static org.junit.Assert.assertEquals;
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
		assertTrue(StringUtil.isEmpty(data) == expected);
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
		assertTrue(StringUtil.isNotEmpty(data) == expected);
	}
	
	@DisplayName(value = "문자열의 값이 Null이면 빈 값을 반환하고 Null이 아니면 전달받은 값을 반환하는지 확인")
	@ParameterizedTest
	@CsvSource({
		", ''",
		"'', ''",
		"abc, abc",
		"홍길동, 홍길동"
	})
	void nullToString(String data, String expected) {
		assertEquals(StringUtil.nullToString(data), expected);
	}
	
	@DisplayName(value = "문자열의 값이 Null이면 중간 값(default value)을 반환하고 Null이 아니면 전달받은 값을 반환하는지 확인")
	@ParameterizedTest
	@CsvSource({
		", 'a', 'a'",
		"'', 'b', ''",
		"abc, abc, abc",
		"홍길동, 홍길동, 홍길동"
	})
	void nullToString(String data, String defaultValue, String expected) {
		assertEquals(StringUtil.nullToString(data, defaultValue), expected);
	}
	
	@DisplayName(value = "영문자, 숫자, 특수문자로 랜덤하게 만들어진 문자열의 길이(length)가 예상되는 값(expected)과 일치하는지 확인")
	@ParameterizedTest
	@CsvSource({
		"10, 10",
		"1, 1",
		"15, 15",
		"7, 7"
	})
	void getRandomString(int length, int expected) {
		assertEquals(StringUtil.getRandomString(length).length(), expected);
	}

}
