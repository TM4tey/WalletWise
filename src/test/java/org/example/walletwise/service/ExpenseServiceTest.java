package org.example.walletwise.service;

import org.example.walletwise.model.Expense;
import org.example.walletwise.repository.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseService expenseService;

    @Test
    void testFindAll() {
        when(expenseRepository.findAll()).thenReturn(List.of(new Expense()));
        assertEquals(1, expenseService.findAll().size());
    }

    @Test
    void testFindById() {
        Expense expense = new Expense();
        expense.setId(1L);
        when(expenseRepository.findById(1L)).thenReturn(Optional.of(expense));

        Optional<Expense> found = expenseService.findById(1L);
        assertTrue(found.isPresent());
        assertEquals(1L, found.get().getId());
    }

    @Test
    void testSave() {
        Expense expense = new Expense();
        when(expenseRepository.save(any(Expense.class))).thenReturn(expense);

        Expense saved = expenseService.save(new Expense());
        assertNotNull(saved);
        verify(expenseRepository, times(1)).save(any());
    }

    @Test
    void testDelete() {
        doNothing().when(expenseRepository).deleteById(1L);
        expenseService.deleteById(1L);
        verify(expenseRepository, times(1)).deleteById(1L);
    }
}