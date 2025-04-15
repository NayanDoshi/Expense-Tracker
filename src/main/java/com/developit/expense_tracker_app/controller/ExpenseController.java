package com.developit.expense_tracker_app.controller;

import com.developit.expense_tracker_app.dto.ExpenseDto;
import com.developit.expense_tracker_app.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses") // base URI
public class ExpenseController {

    private static final String DELETION_SUCCESSFUL_MESSAGE = "Expense deleted successfully";

    // Inject the ExpenseService using the constructor based DI
    private ExpenseService expenseService;

    // Build create expense REST API
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {

        ExpenseDto savedExpense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    // Build get expense REST API
    @GetMapping("{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long expenseId) {
        ExpenseDto expenseDto = expenseService.getExpenseById(expenseId);
        return new ResponseEntity<>(expenseDto, HttpStatus.OK);
    }

    // Build get all expenses REST API
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        List<ExpenseDto> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    // Build update expense by Id REST API
    @PutMapping("{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long expenseId,
                                                    @RequestBody ExpenseDto expenseDto) {
        ExpenseDto updateedExpense = expenseService.updateExpense(expenseId, expenseDto);

        return new ResponseEntity<>(updateedExpense, HttpStatus.OK);
    }

    // Build delete expense by Id REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId) {
        expenseService.deleteExpense(expenseId);
        return new ResponseEntity<>(DELETION_SUCCESSFUL_MESSAGE,HttpStatus.OK);
    }
}
