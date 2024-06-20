package kr.mook.datatype;

import java.util.HashMap;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

/**
 * JsonUtil
 * 
 * @since 2024.06.19
 * @author In-mook, Jeong
 * @version 1.0.0
 */
public class JsonUtil {

	// Logger
	private static final Logger log = Logger.getLogger(JsonUtil.class.getName());
	
	/**
	 * Method that converts a JSON format string into HashMap when entered.<br/>
	 * If the entered value is not in JSON format, an exception is raised.
	 * 
	 * @param jsonString
	 * @return
	 * @throws JsonParseException Occurs when the entered value is not in Json format.
	 * @throws Exception If any other exception occurs, an exception is thrown.
	 */
	public static HashMap<String, Object> stringToHashMap(final String jsonString) throws JsonParseException, Exception {
		HashMap<String, Object> jsonMap = new HashMap<String, Object>();
		if(jsonString == null || jsonString.isEmpty()) return jsonMap;
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			jsonMap = objectMapper.readValue(jsonString, HashMap.class);
		} catch (MismatchedInputException e) {
			e.printStackTrace();
			throw new JsonParseException("Your input is not json format. Mismatched your data. Your input is \"" + jsonString + "\".");
		} catch (JsonParseException e) {
			throw new JsonParseException("Your input is not json format. Json fails to parse your data. Your input is \"" + jsonString + "\".");
		} catch (JsonMappingException e) {
			throw new Exception("Failed Json mapping. Your input is \""+ jsonString + "\".");
		} catch (JsonProcessingException e) {
			throw new Exception("Failed Json processing. Your input is \""+ jsonString + "\".");
		}
		
		return jsonMap;
	}
}
