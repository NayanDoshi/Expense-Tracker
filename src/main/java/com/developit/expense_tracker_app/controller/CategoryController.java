package com.developit.expense_tracker_app.controller;

import com.developit.expense_tracker_app.dto.CategoryDto;
import com.developit.expense_tracker_app.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories") // Define the base URI
public class CategoryController {

    private CategoryService categoryService;
    private final String DELETION_SUCCESSFUL_MESSAGE = "Category deleted Successfully";
    //Build create category REST API
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    // Build Get category by id REST API
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId) {
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    // Build Get All categories REST API
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categoryDtoList = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryDtoList, HttpStatus.OK);
    }

    // Build update category REST API
    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> updateCategoryById(@PathVariable("id") Long categoryId,
                                                          @RequestBody CategoryDto categoryDto) {
        CategoryDto updatedCategoryDto = categoryService.updateCategory(categoryId, categoryDto);
        return new ResponseEntity<>(updatedCategoryDto, HttpStatus.OK);
    }

    // Build delte category REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return new ResponseEntity<>(DELETION_SUCCESSFUL_MESSAGE,HttpStatus.OK);
    }
}
