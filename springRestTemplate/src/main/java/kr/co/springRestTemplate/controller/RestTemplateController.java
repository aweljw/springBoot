package kr.co.springRestTemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.springRestTemplate.model.RestTemplateRequest;
import kr.co.springRestTemplate.model.RestTemplateResponse;
import kr.co.springRestTemplate.service.RestTemplateService;

@RestController
public class RestTemplateController {

	@Autowired
	private RestTemplateService restTemplateService;

	public void setRestTemplateService(RestTemplateService restTemplateService) {
		this.restTemplateService = restTemplateService;
	}

	@GetMapping("/getForObject")
	public RestTemplateResponse getForObject() {
		return restTemplateService.getForObject();
	}

	@GetMapping("/getForEntityToObject")
	public RestTemplateResponse getForEntityToObject() {
		return restTemplateService.getForEntityToObject();
	}

	@GetMapping("/getForEntityToJson")
	public RestTemplateResponse getForEntityToJson() {
		RestTemplateResponse restTemplateResponse = new RestTemplateResponse();

		try {
			restTemplateResponse = restTemplateService.getForEntityToJson();
		} catch (Exception e) {

		}

		return restTemplateResponse;
	}
	
	@PostMapping("/getForEntityToJsonAddHttpEntity")
	public RestTemplateResponse getForEntityToJsonAddHttpEntity(@RequestBody RestTemplateRequest restTemplateRequest) {
		RestTemplateResponse restTemplateResponse = new RestTemplateResponse();

		try {
			restTemplateResponse = restTemplateService.getForEntityToJsonAddHttpEntity(restTemplateRequest);
		} catch (Exception e) {

		}

		return restTemplateResponse;
	}
	
}
