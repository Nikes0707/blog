package com.NikheelIT.Blog_App.Services;

import java.util.List;

import com.NikheelIT.Blog_App.paylodes.UserDto;

public interface UserServiceI {
	
	public UserDto createUser (UserDto user);
	
	public UserDto UpdateUser (UserDto user, Integer id);
	
	public UserDto getUserById (Integer Userid);
	
	public List<UserDto> GetAllUser ();

	public void DeletUser(Integer id);
 
}
