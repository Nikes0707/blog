package com.NikheelIT.Blog_App.Services;

import java.util.List;

import com.NikheelIT.Blog_App.paylodes.CategoryDto;

public interface CategorySrviceI {
	
public CategoryDto createcategory (CategoryDto categoryDto);
	
	public CategoryDto Updatecategory (CategoryDto categoryDto, Integer id);
	
	public CategoryDto getcategoryById (Integer id);
	
	public List<CategoryDto> GetAllcategory ();

	public void Deletcategory(Integer id);
 

}
