package com.te.storedata.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.storedata.exceptions.CustomException;
import com.te.storedata.model.ResponseModel;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ResponseModel> getException(CustomException ex) {
		return new ResponseEntity<>(new ResponseModel(true,ex.getMessage(), null), HttpStatus.NOT_FOUND);
	}
	
}