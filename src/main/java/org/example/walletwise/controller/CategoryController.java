package org.example.walletwise.controller;

import lombok.RequiredArgsConstructor;
import org.example.walletwise.model.Category;
import org.example.walletwise.service.CategoryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for categories.
 */
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public final class CategoryController {

    /** The service. */
    private final CategoryService categoryService;

    /** @return all. */
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    /** @param category data.
     * @return gives saved data. */
    @PostMapping
    public Category createCategory(@RequestBody final Category category) {
        return categoryService.save(category);
    }
}
