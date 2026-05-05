package org.example.walletwise.service;

import org.example.walletwise.model.Category;
import org.example.walletwise.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void testFindAll() {
        when(categoryRepository.findAll()).thenReturn(List.of(new Category()));
        assertFalse(categoryService.findAll().isEmpty());
    }

    @Test
    void testSave() {
        Category category = new Category();
        category.setName("Food");
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        Category saved = categoryService.save(new Category());
        assertEquals("Food", saved.getName());
    }
}