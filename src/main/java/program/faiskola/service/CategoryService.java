package program.faiskola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.faiskola.model.Category;
import program.faiskola.repo.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category getOrCreateCategory(String category_name) {
        Category category = null;
        try {
            category = categoryRepository.getCategoryByName(category_name);
        } catch (Exception ignore) {
        }

        if (category == null) {
            category = new Category(category_name);
            categoryRepository.save(category);
        }

        return category;
    }

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAllByOrderByNameAsc();
    }

    public Category getCategoryById(int id) {
        return categoryRepository.getCategoryById((long) id);
    }

    public Category getCategoryByName(String name) {
        try {
            return categoryRepository.getCategoryByName(name);
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteCategoryByName(String name) {
        categoryRepository.deleteCategoryByName(name);
    }

    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }
}
