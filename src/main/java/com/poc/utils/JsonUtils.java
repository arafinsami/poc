package com.poc.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public final class JsonUtils {

	public static JsonNode toNode(Object obj) throws JsonMappingException, JsonProcessingException {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(json);
		return jsonNode;
	}
}
