package com.developit.expense_tracker_app.repository;

import com.developit.expense_tracker_app.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Spring data jpa provides implementation for this interface
    // CRUD methods to perform CRUD database operations on expense entity
    // Spring Data JPA provides transaction for all the CRUD methods.
}
