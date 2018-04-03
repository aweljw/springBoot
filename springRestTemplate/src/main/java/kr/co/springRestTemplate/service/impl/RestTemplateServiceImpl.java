package kr.co.springRestTemplate.service.impl;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.springRestTemplate.model.RestTemplateRequest;
import kr.co.springRestTemplate.model.RestTemplateResponse;
import kr.co.springRestTemplate.service.RestTemplateService;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

	private final String url = "http://localhost:8080/server";

	@Override
	public RestTemplateResponse getForObject() {
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.getForObject(url, RestTemplateResponse.class);
	}

	@Override
	public RestTemplateResponse getForEntityToObject() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<RestTemplateResponse> responseResult =  restTemplate.getForEntity(url, RestTemplateResponse.class);

		return responseResult.getBody();
	}

	@Override
	public RestTemplateResponse getForEntityToJson() throws JsonParseException, JsonMappingException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper objectMapper = new ObjectMapper();

		ResponseEntity<String> responseResult =  restTemplate.getForEntity(url, String.class);

		return objectMapper.readValue(responseResult.getBody(), RestTemplateResponse.class);
	}

	@Override
	public RestTemplateResponse getForEntityToJsonAddHttpEntity(RestTemplateRequest restTemplateRequest) throws JsonParseException, JsonMappingException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper objectMapper = new ObjectMapper();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity httpEntity = new HttpEntity(restTemplateRequest, httpHeaders);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		        .queryParam("language", "en")
				.queryParam("currency", "usd");

		ResponseEntity<String> responseResult =  restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST, httpEntity, String.class);

		return objectMapper.readValue(responseResult.getBody(), RestTemplateResponse.class);
	}

}
