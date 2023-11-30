package com.restfullPractica.restfullPractica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.restfullPractica.restfullPractica.Exception.RequestException;
import com.restfullPractica.restfullPractica.dto.ErrorDTO;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(value = RequestException.class)
	public ResponseEntity<ErrorDTO> requestHandlerException(RequestException ex){
		ErrorDTO error = new ErrorDTO();
		error.setCode(ex.getCode());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
