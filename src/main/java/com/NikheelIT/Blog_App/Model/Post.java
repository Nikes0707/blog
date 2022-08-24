package com.NikheelIT.Blog_App.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Post {
	@Id 
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	private Integer postid;
	@Column (name = "Post_title", length = 100, nullable = false)
	private String tital ;
	@Column(length = 10000)
	private String content ;
	
	private String imagename;
	
	private Date addeddate ;
	@ManyToOne
	private Category category ;
	@ManyToOne
	private User user; 
	

}
