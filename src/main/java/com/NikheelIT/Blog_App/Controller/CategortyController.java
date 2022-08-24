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

import com.NikheelIT.Blog_App.ServicesImpl.CategoryServiceIMPL;
import com.NikheelIT.Blog_App.paylodes.ApiResponce;
import com.NikheelIT.Blog_App.paylodes.CategoryDto;



@RestController
@RequestMapping("/api/category")
public class CategortyController {
	@Autowired
	private CategoryServiceIMPL categoryServiceIMPL;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto>  createcategory (@Valid @RequestBody CategoryDto categoryDto){
	 CategoryDto createcategory = this.categoryServiceIMPL.createcategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createcategory,HttpStatus.CREATED);
		
	}
	@PutMapping ("/{id}")
	public ResponseEntity<CategoryDto> updatecategory (@Valid @RequestBody CategoryDto categoryDto ,@PathVariable Integer id){
		CategoryDto updatecategory = this.categoryServiceIMPL.Updatecategory(categoryDto, id);
		return new ResponseEntity<>(updatecategory, HttpStatus.OK);
		
	}
	@DeleteMapping ("/{id}")
	public ResponseEntity<?> DeleteCategory (@PathVariable Integer id){
		
		this.categoryServiceIMPL.Deletcategory(id);
		//return new ResponseEntity<ApiResponce>(new ApiResponce("Category delete successully", true),HttpStatus.OK);
		return new ResponseEntity<>(Map.of("messge", "delete category successfully"),HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getsingaleCategory ( @PathVariable Integer id){
		CategoryDto getcategoryById = this.categoryServiceIMPL.getcategoryById(id);
	 	return new  ResponseEntity<CategoryDto>(getcategoryById,HttpStatus.ACCEPTED);
	}
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getallCategory (){
		return ResponseEntity.ok(this.categoryServiceIMPL.GetAllcategory());
	}
	

}
