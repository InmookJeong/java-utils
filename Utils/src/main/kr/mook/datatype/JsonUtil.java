package kr.mook.datatype;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.type.TypeFactory;

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
	 * Method that converts a JSON format string into an object desired by the user.<br/>
	 * If the entered value is not in JSON format, an exception is raised.<br/>
	 * And it only converts based on the JSON-Object format string.<br/>
	 * It does not return a JSON array.<br/>
	 * The returned object must be type converted before use.<br/>
	 * 
	 * @param jsonString JSON format string
	 * @param clz Object class to return
	 * @return
	 * @throws JsonParseException Occurs when the entered value is not in Json format.
	 * @throws Exception Exception If any other exception occurs, an exception is thrown.
	 * @Exmaple
	 * CustomDTO customDto = (CustomDTO) JsonUtil.stringToObject("{'userId':'userTest', 'name':'James'}", CustomDTO.class);
	 */
	public static Object stringToObject(final String jsonString, Class clz) throws JsonParseException, Exception {
		Object obj = null;
		if(jsonString == null || jsonString.isEmpty()) {
			throw new JsonParseException("Your input is null or empty string. Cannot be converted to object.");
		}
		
		if(!jsonString.startsWith("{") && !jsonString.endsWith("}")) {
			throw new JsonParseException("Your input is not json format. Your input is \"" + jsonString + "\". It is not wrapped in Json symbols.");
		}
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			
			obj = objectMapper.readValue(jsonString, clz);
		} catch (UnrecognizedPropertyException e) {
			throw new JsonParseException("There is an unrecognized field. Check your input and return type object filed. Your input is \"" + jsonString + "\" and your class is \"" + clz.getName() + "\".");
		} catch (MismatchedInputException e) {
			throw new JsonParseException("Your input is not json format. Mismatched your data. Your input is \"" + jsonString + "\" and your class is \"" + clz.getName() + "\".");
		} catch (JsonParseException e) {
			throw new JsonParseException("Your input is not json format. Json fails to parse your data. Your input is \"" + jsonString + "\" and your class is \"" + clz.getName() + "\".");
		} catch (JsonMappingException e) {
			throw new Exception("Failed Json mapping. Your input is \""+ jsonString + "\" and your class is \"" + clz.getName() + "\".");
		} catch (JsonProcessingException e) {
			throw new Exception("Failed Json processing. Your input is \""+ jsonString + "\" and your class is \"" + clz.getName() + "\".");
		}
		
		return obj;
	}
	
	/**
	 * Method that converts a JSON format string into an array desired by the user.<br/>
	 * If the entered value is not in JSON format, an exception is raised.<br/>
	 * And it only converts based on the JSON-Array format string.<br/>
	 * It does not return a JSON object.<br/>
	 * The returned array must be type converted before use.<br/>
	 * 
	 * @param jsonString JSON format string
	 * @return Json Array
	 * @throws JsonParseException
	 * @throws Exception
	 * @Exmaple
	 * List<CustomDTO> customDtoList = (List<CustomDTO>) JsonUtil.stringToArray("[{'userId':'userTest', 'name':'James'}]");
	 */
	public static List stringToArray(final String jsonString, Class clz) throws JsonParseException, Exception {
		List list = new ArrayList();
		
		if(jsonString == null || jsonString.isEmpty()) {
			throw new JsonParseException("Your input is null or empty string. Cannot be converted to object.");
		}
		
		if(!jsonString.startsWith("[") && !jsonString.endsWith("]")) {
			throw new JsonParseException("Your input is not json format. Your input is \"" + jsonString + "\". It is not wrapped in Json symbols.");
		}
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			TypeFactory typeFactory = objectMapper.getTypeFactory(); 
			list = objectMapper.readValue(jsonString, typeFactory.constructCollectionType(List.class, clz));
		} catch (UnrecognizedPropertyException e) {
			throw new JsonParseException("There is an unrecognized field. Check your input and return type object filed. Your input is \"" + jsonString + "\".");
		} catch (MismatchedInputException e) {
			throw new JsonParseException("Your input is not json format. Mismatched your data. Your input is \"" + jsonString + "\".");
		} catch (JsonParseException e) {
			throw new JsonParseException("Your input is not json format. Json fails to parse your data. Your input is \"" + jsonString + "\".");
		} catch (JsonMappingException e) {
			throw new Exception("Failed Json mapping. Your input is \""+ jsonString + "\".");
		} catch (JsonProcessingException e) {
			throw new Exception("Failed Json processing. Your input is \""+ jsonString + "\".");
		}
		
		return list;
	}
}
