package kr.co.springRestTemplate.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import kr.co.springRestTemplate.model.RestTemplateRequest;
import kr.co.springRestTemplate.model.RestTemplateResponse;

public interface RestTemplateService {

	public RestTemplateResponse getForObject();

	public RestTemplateResponse getForEntityToObject();

	public RestTemplateResponse getForEntityToJson() throws JsonParseException, JsonMappingException, IOException;

	public RestTemplateResponse getForEntityToJsonAddHttpEntity(RestTemplateRequest restTemplateRequest) throws JsonParseException, JsonMappingException, IOException;

}
