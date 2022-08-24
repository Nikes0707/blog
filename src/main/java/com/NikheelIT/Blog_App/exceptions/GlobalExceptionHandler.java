package com.NikheelIT.Blog_App.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.NikheelIT.Blog_App.paylodes.ApiResponce;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponce> ResourseNotFoundExceptionHandler (ResourceNotFoundException ex){
		
		String message=ex.getMessage();
		ApiResponce apiResponce = new ApiResponce(message,false);
		return new ResponseEntity<ApiResponce>(apiResponce,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> HandleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		
		Map<String, String> resop=new HashMap<>();
	
		ex.getBindingResult().getAllErrors().forEach((error)->{
	String fieldName=((FieldError)error).getField();
	String defaultMessage = error.getDefaultMessage();
	resop.put(fieldName, defaultMessage);
		});
		return new ResponseEntity<Map<String,String>>(resop,HttpStatus.BAD_REQUEST) ;
		
		
	}
	

}
