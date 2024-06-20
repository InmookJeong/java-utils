package kr.mook.datatype;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;

/**
 * JsonUtilTest
 * 
 * @since 2024.06.17
 * @author In-mook, Jeong
 * @version 1.0.0
 */
class JsonUtilTest {
	
	@Test
	void stringToMap(){
		HashMap<String, Object> jsonMap = null;
		
		try {
			assertTrue(JsonUtil.stringToHashMap(null).isEmpty());
			assertTrue(JsonUtil.stringToHashMap("").isEmpty());
			assertTrue(JsonUtil.stringToHashMap("{}").isEmpty());
			
			jsonMap = null;
			assertThatThrownBy(() -> JsonUtil.stringToHashMap("1"))
			.isInstanceOf(JsonParseException.class);
			
			assertThatThrownBy(() -> JsonUtil.stringToHashMap("[]"))
			.isInstanceOf(JsonParseException.class);
			
			assertThatThrownBy(() -> JsonUtil.stringToHashMap("abc"))
			.isInstanceOf(JsonParseException.class);
			
			assertThatThrownBy(() -> JsonUtil.stringToHashMap("{\\\"id\\\"=1}"))
			.isInstanceOf(JsonParseException.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String jsonString = "{\"id\":1,\"userId\":\"test\",\"name\":\"홍길동\",\"age\":30}";
		try {
			jsonMap = JsonUtil.stringToHashMap(jsonString);
			assertEquals((int)jsonMap.get("id"), 1);
			assertEquals((String)jsonMap.get("userId"), "test");
			assertEquals((String)jsonMap.get("name"), "홍길동");
			assertEquals((int)jsonMap.get("age"), 30);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jsonMap = null;
		}
	}
}
