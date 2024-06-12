package kr.mook.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * EncryptUtilTest
 * 
 * @since 2024.06.10
 * @author In-mook, Jeong
 * @version 1.0.0
 */
class EncryptUtilTest {

	@DisplayName(value = "문자(actual)를 SHA256 암호화하여 반환되는 값이 예상 값(expected)과 같은지 확인")
	@Test
	void toSHA256() {
		String actual = "test1234";
		String expected = "937e8d5fbb48bd4949536cd65b8d35c426b80d2f830c5c308e2cdec422ae2244";
		assertEquals(EncryptUtil.toSHA256(actual), expected);
	}
	
	@DisplayName(value = "문자(actual)를 AES 암호화한 값이 기존 예상 값(expected)과 같은지 확인")
	@Test
	void toAES() {
		String secretKey = "test1234test1234test1234test1234";
		String iv = "1234567890asdfgh";
		
		String actual = "myPlainText";
		String expected = "YaTUkCT/+T7MPLccODCV5A==";
		String cipherText = EncryptUtil.toAES(actual, secretKey, iv);
		assertEquals(cipherText, expected);
	}
}
