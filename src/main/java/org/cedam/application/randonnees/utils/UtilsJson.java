package org.cedam.application.randonnees.utils;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("utilsJson")
public class UtilsJson {

	public <T> String serialize(T obj) throws JsonProcessingException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
	
	public <T> T deserialize(String valuejson, Class<T> classType) throws JsonProcessingException
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(valuejson, classType);
	}
	
}
