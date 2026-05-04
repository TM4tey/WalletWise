package org.example.walletwise.service;

import org.example.walletwise.model.Expense;
import org.example.walletwise.repository.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseService expenseService;

    @Test
    void testFindAllReturnsList() {
        // Given
        Expense expense = new Expense();
        expense.setDescription("Test pizza");
        when(expenseRepository.findAll()).thenReturn(List.of(expense));

        // When
        List<Expense> result = expenseService.findAll();

        // Then
        assertEquals(1, result.size());
        assertEquals("Test pizza", result.get(0).getDescription());
    }
}