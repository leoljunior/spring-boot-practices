package com.prova.leonardojunior.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<Error> handleObjectNotFound(
						ObjectNotFoundException excecaoCapturada, HttpServletRequest req) {
		
		Error error = new Error(
				excecaoCapturada.getMessage(),
				HttpStatus.NOT_FOUND.value(), 
				new Date());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
}
