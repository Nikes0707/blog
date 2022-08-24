package com.NikheelIT.Blog_App.paylodes;

import java.util.Date;

import com.NikheelIT.Blog_App.Model.Category;
import com.NikheelIT.Blog_App.Model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter @NoArgsConstructor 
public class PostDto {
	
   private Integer postid;
	
	private String tital ;
	
	private String content ;
	
	private String imagename ;
	
	private Date addeddate;
	
	private CategoryDto category ;
	
	private UserDto user ;
	
	
	
	 

}
