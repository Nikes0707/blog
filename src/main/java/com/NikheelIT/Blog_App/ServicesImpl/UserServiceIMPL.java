package com.NikheelIT.Blog_App.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.NikheelIT.Blog_App.Model.User;
import com.NikheelIT.Blog_App.Repositry.UserRepositry;
import com.NikheelIT.Blog_App.Services.UserServiceI;
import com.NikheelIT.Blog_App.exceptions.ResourceNotFoundException;
import com.NikheelIT.Blog_App.paylodes.UserDto;
@Service
public class UserServiceIMPL implements UserServiceI {
     @Autowired
	 private UserRepositry userRepositry ;
     @Autowired
     private ModelMapper modelMapper ;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.dtoTouser(userDto);
		User save = userRepositry.save(user);
		return modelMapper.map(save,UserDto.class);
	}

	@Override
	public UserDto UpdateUser(UserDto userDto, Integer id) {
		User user=this.userRepositry.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
			user.setName(userDto.getName());	
		    user.setEmail(userDto.getEmail());
		    user.setPassword(userDto.getPassword());
		    user.setAbout(userDto.getAbout());
		    User Update = this.userRepositry.save(user);
		    UserDto userToDto = this.UserToDto(user);
		return userToDto ;
	}

	@Override
	public UserDto getUserById(Integer Userid) {
		User user = this.userRepositry.findById(Userid)
		.orElseThrow(()-> new ResourceNotFoundException("User", "Id", Userid));
		return this.UserToDto(user);
	}

	@Override
	public List<UserDto> GetAllUser() {
       List<User> users = this.userRepositry.findAll();
      
       List<UserDto>  userdtos = users.stream().map(user ->this.UserToDto(user)).collect(Collectors.toList());
		return userdtos;
	}

	@Override
	public void DeletUser(Integer id) {
		 User user = this.userRepositry.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "Id", id));
		this.userRepositry.delete(user);
	}
	 
    private User dtoTouser (UserDto userDto) {
    	User user = this.modelMapper.map(userDto, User.class);
    	User user1=new User ();
    	user1.setId(userDto.getId());
    	user1.setName(userDto.getName());
    	user1.setEmail(userDto.getEmail());
    	user1.setPassword(userDto.getPassword());
    	user1.setAbout(userDto.getAbout());
		return user1;
    	
    }
    
    public UserDto UserToDto (User user) {
    	
    	UserDto userDto = this.modelMapper.map(user, UserDto.class);
    	
    	
    	UserDto userDto1= new UserDto();
    	
    	userDto1.setId(user.getId());
    	userDto1.setName(user.getName());
    	userDto1.setEmail(user.getEmail());
    	userDto1.setPassword(user.getPassword());
    	userDto1.setAbout(user.getAbout());
    	
    	return userDto1;
    }
}
