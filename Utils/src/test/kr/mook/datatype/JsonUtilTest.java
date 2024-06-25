package kr.mook.datatype;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertNotNull;
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
	
	@DisplayName("JSON 형식의 문자열이 사용자가 원하는 객체로 변환되는지 확인하기 위한 로직")
	@Test
	void stringToArray() {
		String jsonString = "[{\"id\":1,\"userId\":\"test\",\"name\":\"홍길동\",\"age\":30}, {\"id\":2, \"userId\":\"test2\", \"name\":\"홍이동\", \"age\":24}]";
		try {
			assertThatThrownBy(() -> JsonUtil.stringToArray(null))
			.isInstanceOf(JsonParseException.class);
			
			assertThatThrownBy(() -> JsonUtil.stringToArray(""))
			.isInstanceOf(JsonParseException.class);
			
			assertThatThrownBy(() -> JsonUtil.stringToArray("1"))
			.isInstanceOf(JsonParseException.class);
			
			assertThatThrownBy(() -> JsonUtil.stringToArray("{}"))
			.isInstanceOf(JsonParseException.class);
			
			assertThatThrownBy(() -> JsonUtil.stringToArray("abc"))
			.isInstanceOf(JsonParseException.class);
			
			assertThatThrownBy(() -> JsonUtil.stringToArray("{\"id\"=1}"))
			.isInstanceOf(JsonParseException.class);
			
			assertEquals(JsonUtil.stringToArray("[]").size(), 0);
			
			List<UserTestDTO> UserTestList = JsonUtil.stringToArray(jsonString);
			assertEquals(UserTestList.size(), 2);
			assertEquals(UserTestList.get(0).getClass().getName(), UserTestDTO.class.getName());
			assertEquals(UserTestList.get(0).getAge(), 30);
			assertEquals(UserTestList.get(1).getName(), "홍이동");
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
