package com.developit.expense_tracker_app.service.impl;


import com.developit.expense_tracker_app.dto.ExpenseDto;
import com.developit.expense_tracker_app.entity.Category;
import com.developit.expense_tracker_app.entity.Expense;
import com.developit.expense_tracker_app.mapper.ExpenseMapper;
import com.developit.expense_tracker_app.repository.CategoryRepository;
import com.developit.expense_tracker_app.repository.ExpenseRepository;
import com.developit.expense_tracker_app.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    // Inject ExpenseRepository using constructor based  DI
    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;


    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {

        // Convert ExpenseDto to Expense entity
        Expense expense = ExpenseMapper.mapToExpense(expenseDto);

        // save expense entity to database
        Expense savedExpense = expenseRepository.save(expense);

        // Convert saved expense entity into ExpenseDto
        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long expenseId) {

        // Get expense entity from the database using expense id
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + expenseId));

        // Convert expense entity to expenseDto
        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream()
                .map((expense -> ExpenseMapper.mapToExpenseDto(expense)))
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {

        // First need to check given expenseId is present in the database or not,
        Expense expense = expenseRepository
                .findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + expenseId));

        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());

        // update category
        if(expenseDto.categoryDto() != null) {

            // get the category entity by id
            Category category = categoryRepository.findById(expenseDto.categoryDto().id())
                    .orElseThrow(() -> new RuntimeException("Category not found with id: " + expenseDto.categoryDto().id()));

            expense.setCategory(category);
        }

        // update the expense entity into database
        Expense updatedExpense = expenseRepository.save(expense);

        // Convert expense entity into ExpenseDto
        return ExpenseMapper.mapToExpenseDto(updatedExpense);

    }

    @Override
    public void deleteExpense(Long expenseId) {
        // First need to check given expenseId is present in the database or not,
        Expense expense = expenseRepository
                .findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + expenseId));

        // Delete the entry from the database
        expenseRepository.delete(expense);
    }
}
