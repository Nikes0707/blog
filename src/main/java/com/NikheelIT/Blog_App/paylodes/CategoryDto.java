package com.NikheelIT.Blog_App.paylodes;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor
public class CategoryDto {
	
	
	private Integer categoryid;
	@NotBlank
	@Size(min = 4, message = "min size of category is 4")
	private String categoryTitle;

	@NotBlank
	@Size (min =  10 ,message = "min size of category is 10")
	private String categoryDescription;
}
