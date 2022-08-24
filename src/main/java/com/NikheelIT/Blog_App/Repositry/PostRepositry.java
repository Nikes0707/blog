package com.NikheelIT.Blog_App.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NikheelIT.Blog_App.Model.Category;
import com.NikheelIT.Blog_App.Model.Post;
import com.NikheelIT.Blog_App.Model.User;

public interface PostRepositry extends JpaRepository<Post, Integer>{
	
	List <Post> getAllByUser (User user);
	
	List <Post> findByUser (User user);
	
	List <Post> findByCategory (Category category);

}
