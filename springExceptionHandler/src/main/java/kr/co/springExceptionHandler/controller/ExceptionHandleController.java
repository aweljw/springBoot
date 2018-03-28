package kr.co.springExceptionHandler.controller;

import org.apache.el.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionHandleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandleController.class);

	@ExceptionHandler({ Exception.class })
    public void handleException(Exception e) {
        LOGGER.error("Exception Message :", e);
    }

	@ExceptionHandler({ ParseException.class })
    public void handleParseException(ParseException e) {
        LOGGER.error("ParseException Message :", e);
    }

	@ExceptionHandler({ NullPointerException.class })
    public void handleNullPointerException(NullPointerException e) {
        LOGGER.error("NullPointerException Message :", e);
    }

}
