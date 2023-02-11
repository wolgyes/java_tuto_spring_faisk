package program.faiskola.repo;

import program.faiskola.model.Category;
import program.faiskola.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    Plant getPlantByName(String name);

    Plant getPlantById(Long id);

    void deletePlantByName(String name);

    Iterable<Plant> getPlantsByCategory(Category category);

    boolean existsPlantByName(String name);
}