package kr.mook.datatype;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;

import kr.mook.dto.UserTestDTO;
import kr.mook.dto.UserTestDTO2;

/**
 * JsonUtilTest
 * 
 * @since 2024.06.17
 * @author In-mook, Jeong
 * @version 1.0.0
 */
class JsonUtilTest {
	
	@DisplayName("JSON 형식의 문자열을 HashMap으로 변경하기 위한 테스트 기능")
	@Test
	void stringToHashMap(){
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
			
			assertThatThrownBy(() -> JsonUtil.stringToHashMap("{\"id\"=1}"))
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
	
	@DisplayName("JSON 형식의 문자열이 사용자가 원하는 객체로 변환되는지 확인하기 위한 로직")
	@Test
	void stringToObject() {
		try {
			String jsonString = "{\"id\":1,\"userId\":\"test\",\"name\":\"홍길동\",\"age\":30}";
			assertNotNull(JsonUtil.stringToObject(jsonString, UserTestDTO.class));
			assertEquals(JsonUtil.stringToObject(jsonString, UserTestDTO.class).getClass(), UserTestDTO.class);
			UserTestDTO userTestDto = (UserTestDTO) JsonUtil.stringToObject(jsonString, UserTestDTO.class);
			assertEquals(userTestDto.getId(), 1);
			assertEquals(userTestDto.getUserId(), "test");
			assertEquals(userTestDto.getName(), "홍길동");
			assertEquals(userTestDto.getAge(), 30);
			
			HashMap<String, Object> jsonMap = (HashMap<String, Object>) JsonUtil.stringToObject(jsonString, HashMap.class);
			assertEquals((int) jsonMap.get("id"), 1);
			assertEquals((String) jsonMap.get("userId"), "test");
			assertEquals((String) jsonMap.get("name"), "홍길동");
			assertEquals((int) jsonMap.get("age"), 30);
			
			assertThatThrownBy(() -> JsonUtil.stringToObject(null, Object.class))
			.isInstanceOf(JsonParseException.class);
			
			assertThatThrownBy(() -> JsonUtil.stringToObject("", String.class))
			.isInstanceOf(JsonParseException.class);
			
			assertThatThrownBy(() -> JsonUtil.stringToObject("1", Integer.class))
			.isInstanceOf(JsonParseException.class);
			
			assertThatThrownBy(() -> JsonUtil.stringToObject("[]", List.class))
			.isInstanceOf(JsonParseException.class);
			
			assertThatThrownBy(() -> JsonUtil.stringToObject("abc", String.class))
			.isInstanceOf(JsonParseException.class);
			
			assertThatThrownBy(() -> JsonUtil.stringToObject("{\"id\"=1}", HashMap.class))
			.isInstanceOf(JsonParseException.class);
			
			assertThatThrownBy(() -> JsonUtil.stringToObject(jsonString, UserTestDTO2.class))
			.isInstanceOf(JsonParseException.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
