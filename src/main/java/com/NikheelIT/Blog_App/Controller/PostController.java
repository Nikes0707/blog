package com.NikheelIT.Blog_App.Controller;

import java.util.List;
import java.util.Map;

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

import com.NikheelIT.Blog_App.ServicesImpl.PostServiceIMPL;
import com.NikheelIT.Blog_App.paylodes.ApiResponce;
import com.NikheelIT.Blog_App.paylodes.PostDto;

@RestController
@RequestMapping ("/api/post")
public class PostController {
	@Autowired
	private PostServiceIMPL postServiceIMPL ;
	
	@PostMapping ("/user/{userid}/cat/{catid}/posts")
	public ResponseEntity<PostDto> createpost (@RequestBody PostDto postDto, 
			@PathVariable Integer userid,
			@PathVariable Integer catid ){
		
		PostDto createpost = postServiceIMPL.Createpost(postDto, userid, catid );
		
		return new ResponseEntity<>(createpost,HttpStatus.CREATED);
	
	}
	// get by user
	@GetMapping("/user/{id}/post")
   public ResponseEntity<List<PostDto>> GetPostByUser (@PathVariable Integer id){
	   List<PostDto> user = postServiceIMPL.getPostByUser(id);
	   return new ResponseEntity<List<PostDto>>(user,HttpStatus.OK);
   }
	// update Category id 
	@PutMapping ("/postupdate/{id}")
	public ResponseEntity<PostDto> UpdatePost (@RequestBody PostDto postDto ,@PathVariable Integer id){
		PostDto updatePost = postServiceIMPL.updatePost(postDto, id);
		return new ResponseEntity<>(updatePost,HttpStatus.OK);
	}
	// get by Category 
	@GetMapping ("/category/{id}/post")
   public ResponseEntity<List<PostDto>> GetPostBycategory (@PathVariable Integer id) {
	   List<PostDto> category = postServiceIMPL.getPostByCategory(id);
	   return new ResponseEntity<List<PostDto>>(category,HttpStatus.OK);
   }
	
	// get by post id 
	@GetMapping("/post/{id}")
	public ResponseEntity<PostDto> GetPostByid (@PathVariable Integer id ){
		PostDto postById = postServiceIMPL.getPostById(id);
		return new ResponseEntity<PostDto>(postById,HttpStatus.OK) ;
	}
	@GetMapping("/")
	public ResponseEntity<List<PostDto>> GetallResult (){
		return ResponseEntity.ok(this.postServiceIMPL.Getallresult());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?>deletePostByid (@PathVariable Integer id){
		this.postServiceIMPL.deletepost(id);
		return new ResponseEntity<>(Map.of("Message","This id Deleted Succsefully"),HttpStatus.OK);
	}
	

}
