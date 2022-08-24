package com.NikheelIT.Blog_App.paylodes;

import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	
	private int id ;
	 @NotEmpty
	 @Size(min = 4,message = "UserName must be min of 4 charactors !!")
	private String name ;
	 @NotEmpty
     @Email(message = "Email Address IS not Valid !!")
     private String email;
    @NotEmpty
    @Size(min = 3 ,max = 15,message = "PAssword must be mininum of 3 chatactors and Maximum 15 charactors ")
    private String password;
    @NotEmpty
    @Size(min = 5, max =  50 ,message = "About must be minimum 5 charactor maximum 50 charactors")
    private String about;
    
    
}
