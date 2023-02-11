package program.faiskola.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import program.faiskola.model.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category getCategoryByName(String name);

    List<Category> findAllByOrderByNameAsc();

    Category getCategoryById(long id);

    void deleteCategoryByName(String name);
}
