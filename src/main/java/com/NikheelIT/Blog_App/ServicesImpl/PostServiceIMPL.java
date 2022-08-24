package com.NikheelIT.Blog_App.ServicesImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NikheelIT.Blog_App.Model.Category;
import com.NikheelIT.Blog_App.Model.Post;
import com.NikheelIT.Blog_App.Model.User;
import com.NikheelIT.Blog_App.Repositry.CategoryRepo;
import com.NikheelIT.Blog_App.Repositry.PostRepositry;
import com.NikheelIT.Blog_App.Repositry.UserRepositry;
import com.NikheelIT.Blog_App.Services.PostserviceI;
import com.NikheelIT.Blog_App.exceptions.ResourceNotFoundException;
import com.NikheelIT.Blog_App.paylodes.PostDto;
import com.NikheelIT.Blog_App.paylodes.UserDto;
@Service
public class PostServiceIMPL implements PostserviceI{
	@Autowired
	private PostRepositry postRepositry ;
	@Autowired
	private ModelMapper moddMapper ;
	@Autowired
	private UserRepositry userRepositry ;
	@Autowired
	private CategoryRepo categoryRepo ;

	@Override
	public PostDto Createpost(PostDto postdto,Integer userid,Integer categoryid ) {
		User user = userRepositry.findById(userid).orElseThrow(()-> 
		new ResourceNotFoundException("User", "id", userid));
		
		
		Category category = categoryRepo.findById(categoryid).orElseThrow(()-> 
		new ResourceNotFoundException("Category", "Categoryid", categoryid));
		
		
		Post save = moddMapper.map(postdto, Post.class);
		save.setImagename("defult.png");
		save.setAddeddate(new Date());
		save.setUser(user);
		save.setCategory(category);
          Post post = postRepositry.save( save);
		return this.moddMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer id) {
		 Post post = this.postRepositry.findById(id).orElseThrow(()-> 
		 new ResourceNotFoundException("post", "Id", id));
		 post.setTital(postDto.getTital());
		 post.setContent(postDto.getContent());
		 post.setImagename(postDto.getImagename());
		 Post update  = postRepositry.save(post);
		return this.moddMapper.map(update, PostDto.class);
	}

	@Override
	public void deletepost(Integer id) {
     Post delete = postRepositry.findById(id).orElseThrow(()-> new ResourceNotFoundException("post", "post_id", id));
     postRepositry.delete(delete);
		 
		
	}

	@Override
	public List<PostDto> Getallresult() {
		 List<Post> list = postRepositry.findAll();
		 List<PostDto> collect = list.stream().map((post)-> this.moddMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public PostDto getPostById(Integer id) {
		 Post post = postRepositry.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "Post_id", id));
	return this.moddMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer id) {
		Category cat = categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "Category_id", id));
		 List<Post> posts = postRepositry.findByCategory(cat);
         List<PostDto> postDtos = posts.stream().map((post)-> this.moddMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer id) {
		 User user = userRepositry.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "User_id", id));
		 List<Post> posts = postRepositry.findByUser(user);
		 List<PostDto> listDtos = posts.stream().map((post)->this.moddMapper.map(post,  PostDto.class)).collect(Collectors.toList());
		return listDtos;
	}

	@Override
	public List<PostDto> saarchPosts(String keyword) {
		 
		return null;
	}

}
