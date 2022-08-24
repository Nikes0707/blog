package com.NikheelIT.Blog_App.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
	
	String resourceName;
	
	String fieldName;
	
	Long fieldValue ;

	public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
		super(String.format("%S not found With  %S : %S",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public ResourceNotFoundException(String resourceName2, String fieldName2, Integer userId) {
		// TODO Auto-generated constructor stub
	}
	
	

}
