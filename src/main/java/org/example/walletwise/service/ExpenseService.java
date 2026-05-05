package org.example.walletwise.service;

import lombok.RequiredArgsConstructor;
import org.example.walletwise.model.Expense;
import org.example.walletwise.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Expense service.
 */
@Service
@RequiredArgsConstructor
public final class ExpenseService {

    /** The repository. */
    private final ExpenseRepository expenseRepository;

    /** @return all expenses. */
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    /**
     * Finds an expense by its identifier.
     * @param id the id of the expense.
     * @return the optional expense found.
     */
    public Optional<Expense> findById(final Long id) {
        return expenseRepository.findById(id);
    }

    /**
     * Saves the given expense.
     * @param expense the expense to save.
     * @return the saved expense entity.
     */
    public Expense save(final Expense expense) {
        return expenseRepository.save(expense);
    }

    /** @param id the id to delete. */
    public void deleteById(final Long id) {
        expenseRepository.deleteById(id);
    }
}
