package program.faiskola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import program.faiskola.model.Category;
import program.faiskola.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/createCategory", produces = "application/json")
    public Category createCategory(@RequestParam String name) {
        return categoryService.getOrCreateCategory(name);
    }

    @GetMapping(value = "/getCategories", produces = "application/json")
    public Iterable<Category> getCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(value = "/getCategory", produces = "application/json")
    public String getCategory(@RequestParam String name) {
        Category category = categoryService.getCategoryByName(name);
        if (category != null) {
            return "Category: " + category.getName() + " exists";
        } else {
            return "Category does not exist";
        }
    }
}
