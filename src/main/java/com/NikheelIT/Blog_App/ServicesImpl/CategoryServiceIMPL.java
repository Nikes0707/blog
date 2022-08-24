package com.NikheelIT.Blog_App.ServicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NikheelIT.Blog_App.Model.Category;
import com.NikheelIT.Blog_App.Repositry.CategoryRepo;
import com.NikheelIT.Blog_App.Services.CategorySrviceI;
import com.NikheelIT.Blog_App.exceptions.ResourceNotFoundException;
import com.NikheelIT.Blog_App.paylodes.CategoryDto;
@Service
public class CategoryServiceIMPL implements CategorySrviceI{
	  @Autowired
      private CategoryRepo categoryRepo ;
	  @Autowired
	  private ModelMapper modelMapper ;
	@Override
	public CategoryDto createcategory(CategoryDto categoryDto) {
		 Category cat = this.modelMapper.map(categoryDto, Category.class);
		 Category save = this.categoryRepo.save(cat);
		return this.modelMapper.map(save, CategoryDto.class);
	}

	@Override
	public CategoryDto Updatecategory(CategoryDto categoryDto, Integer id) {
		Category cat= this.categoryRepo.findById(id).orElseThrow(()-> new
		 ResourceNotFoundException("category", "Id", id));
		 
		 cat.setCategoryTitle(categoryDto.getCategoryTitle());
		 cat.setCategoryDescription(categoryDto.getCategoryDescription());
		 Category category = this.categoryRepo.save(cat);
		 
		return this.modelMapper.map(category,  CategoryDto.class);
	}

	@Override
	public CategoryDto  getcategoryById(Integer id) {
		Category findById = this.categoryRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Category", "Id", id) );
		return this.modelMapper.map(findById, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> GetAllcategory() {
		 List<Category> category = this.categoryRepo.findAll();
		 List<CategoryDto> catDtos = category.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}

	@Override
	public void Deletcategory(Integer id) {
		 Category  delete = this.categoryRepo.findById(id).orElseThrow(()-> 
		 new ResourceNotFoundException("Category", "Id", id));
		 this.categoryRepo.delete(delete);
		 
		 
	}

}
