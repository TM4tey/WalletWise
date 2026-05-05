package org.example.walletwise.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.walletwise.model.Expense;
import org.example.walletwise.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller for managing expenses.
 */
@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public final class ExpenseController {

    /** The service layer. */
    private final ExpenseService expenseService;

    /**
     * Retrieves all expenses.
     * @return the list of expenses.
     */
    @GetMapping
    public List<Expense> getAll() {
        return expenseService.findAll();
    }

    /**
     * Retrieves one expense.
     * @param id the id.
     * @return the expense response.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getById(@PathVariable final Long id) {
        return expenseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates expense.
     * @param expense the data.
     * @return the created expense.
     */
    @PostMapping
    public Expense create(@Valid @RequestBody final Expense expense) {
        return expenseService.save(expense);
    }

    /**
     * Updates expense.
     * @param id the id.
     * @param details the details.
     * @return the update result.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Expense> update(
            @PathVariable final Long id,
            @Valid @RequestBody final Expense details) {
        return expenseService.findById(id).map(expense -> {
            expense.setDescription(details.getDescription());
            expense.setAmount(details.getAmount());
            expense.setDate(details.getDate());
            expense.setCategory(details.getCategory());
            return ResponseEntity.ok(expenseService.save(expense));
        }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Deletes expense.
     * @param id the id.
     * @return the response.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        if (expenseService.findById(id).isPresent()) {
            expenseService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
