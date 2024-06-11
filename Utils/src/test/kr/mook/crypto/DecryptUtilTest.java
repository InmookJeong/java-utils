package kr.mook.crypto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * DecryptUtilTest
 * 
 * @since 2024.06.11
 * @author In-mook, Jeong
 * @version 1.0.0
 */
class DecryptUtilTest {

	@DisplayName(value = "문자(actual)를 AES 암호화한 후 복호화 시 반환되는 값이 기존 문자(actual)과 같은지 확인")
	@Test
	void fromAES() {
		String actual = "aesPlainText";
		String cipherText = EncryptUtil.toAES(actual);
		String plainText = DecryptUtil.fromAES(cipherText);
		assertEquals(actual, plainText);
	}
}
