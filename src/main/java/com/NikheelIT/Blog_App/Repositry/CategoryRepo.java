package com.NikheelIT.Blog_App.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NikheelIT.Blog_App.Model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
