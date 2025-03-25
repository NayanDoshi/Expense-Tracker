package com.developit.expense_tracker_app.mapper;

import com.developit.expense_tracker_app.dto.CategoryDto;
import com.developit.expense_tracker_app.entity.Category;

public class CategoryMapper {

    // Map CategoryDto to Category entity
    public static Category mapToCategory(CategoryDto categoryDto) {
        return new Category(
                categoryDto.id(),
                categoryDto.name()
        );
    }

    // Map Category entity to CategoryDto
    public static CategoryDto mapToCategoryDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }
}
