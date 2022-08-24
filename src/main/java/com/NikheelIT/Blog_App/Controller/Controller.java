
package com.NikheelIT.Blog_App.Controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NikheelIT.Blog_App.ServicesImpl.UserServiceIMPL;
import com.NikheelIT.Blog_App.paylodes.ApiResponce;
import com.NikheelIT.Blog_App.paylodes.UserDto;

@RestController
@RequestMapping("/api/user")
public class Controller {
	
	@Autowired
	private UserServiceIMPL userServiceIMPL ;
	
	
   //	post-create-user 
	@PostMapping("/")
	public ResponseEntity<UserDto> CreateUser(@Valid @RequestBody UserDto userdto){
		UserDto createUser = this.userServiceIMPL.createUser(userdto);
		return new ResponseEntity<UserDto>(createUser,HttpStatus.CREATED);
		
	} 
    // put-Update-User
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateuser (@Valid @RequestBody UserDto userdto,@PathVariable Integer id){
		UserDto updateUser = this.userServiceIMPL.UpdateUser(userdto, id);
		return  ResponseEntity.ok(updateUser) ;
	}
	// Delete delete user
	@DeleteMapping ("/{userId}")
	public ResponseEntity<?> deleteUser (@PathVariable Integer userId){
		this.userServiceIMPL.DeletUser(userId);
		//return new ResponseEntity<>(Map.of("Massge","User DeleteSuccessfully"),HttpStatus.OK) ;
		return new ResponseEntity<ApiResponce>(new ApiResponce("User Delete Sucessfully", true),HttpStatus.OK);
	}
	// Get- user get 
	@GetMapping("/")
	public ResponseEntity<List<UserDto>>getallUser (){
		return ResponseEntity.ok(this.userServiceIMPL.GetAllUser());
	}
	@GetMapping("/{userid}")
	public ResponseEntity<UserDto>getSingalUser (@PathVariable Integer userid){
		return ResponseEntity.ok(this.userServiceIMPL.getUserById(userid));
	}
}
