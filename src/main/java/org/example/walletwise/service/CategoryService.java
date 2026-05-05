package org.example.walletwise.service;

import lombok.RequiredArgsConstructor;
import org.example.walletwise.model.Category;
import org.example.walletwise.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing business logic related to categories.
 */
@Service
@RequiredArgsConstructor
public final class CategoryService {

    /** The repository used for category database operations. */
    private final CategoryRepository categoryRepository;

    /**
     * Retrieves all categories from the database.
     * @return the list of all categories.
     */
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    /**
     * Saves a new or existing category.
     * @param category the category entity to save.
     * @return the saved category entity.
     */
    public Category save(final Category category) {
        return categoryRepository.save(category);
    }
}
