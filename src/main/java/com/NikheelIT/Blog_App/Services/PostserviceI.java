package com.NikheelIT.Blog_App.Services;

import java.util.List;

import com.NikheelIT.Blog_App.Model.Post;
import com.NikheelIT.Blog_App.paylodes.PostDto;

public interface PostserviceI {
	
	
	public  PostDto Createpost (PostDto postDto, Integer userid, Integer categoryid);
	
	public PostDto updatePost (PostDto postDto , Integer id );
	
	public void deletepost (Integer id);
	
	public  List <PostDto> Getallresult ();
	
	public PostDto getPostById (Integer id);
	
	public List <PostDto> getPostByCategory (Integer id);
	
	public List <PostDto> getPostByUser (Integer id);
	
	List <PostDto> saarchPosts (String keyword);

}
