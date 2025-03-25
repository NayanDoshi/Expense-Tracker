package com.developit.expense_tracker_app.repository;

import com.developit.expense_tracker_app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Spring data jpa provides implementation for this interface
    // CRUD methods to perform CRUD database operations on category entity
    // Spring Data JPA provides transaction for all the CRUD methods.
}
