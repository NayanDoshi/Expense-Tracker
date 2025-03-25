package com.developit.expense_tracker_app.service.impl;

import com.developit.expense_tracker_app.dto.CategoryDto;
import com.developit.expense_tracker_app.entity.Category;
import com.developit.expense_tracker_app.mapper.CategoryMapper;
import com.developit.expense_tracker_app.repository.CategoryRepository;
import com.developit.expense_tracker_app.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        // convert CategoryDto  to Category entity
        Category category = CategoryMapper.mapToCategory(categoryDto);

        // save category object into database table - categories
        Category savedCategory = categoryRepository.save(category);

        // convert savedCategory to CategoryDto
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {

        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));

        // convert category to CategoryDto
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();

        // convert List<Category> to List<CategoryDto>\
        return categoryList.stream()
                .map(category -> CategoryMapper.mapToCategoryDto(category))
                .collect(Collectors.toList());

    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto) {
        // get category entity from the database by category id
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));

        // update the category entity object and save to database table
        category.setName(categoryDto.name());
        Category updatedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(updatedCategory);

    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        // get category entity from the database by category id
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));

        // Delete the category entity object
        categoryRepository.delete(category);
    }


}
