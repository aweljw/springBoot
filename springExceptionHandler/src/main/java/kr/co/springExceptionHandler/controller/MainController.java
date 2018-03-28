package kr.co.springExceptionHandler.controller;

import org.apache.el.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/exceptionOccurrence")
	public void exceptionOccurrence() throws Exception {
		throw new Exception();
	}
	
	@GetMapping("/parseExceptionOccurrence")
	public void parseExceptionOccurrence() throws ParseException {
		throw new ParseException();
	}
	
	@GetMapping("/nullPointerExceptionOccurrence")
	public void nullPointerExceptionOccurrencea() throws NullPointerException {
		throw new NullPointerException();
	}
}
