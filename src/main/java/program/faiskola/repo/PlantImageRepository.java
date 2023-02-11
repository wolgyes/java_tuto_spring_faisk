package program.faiskola.repo;

import program.faiskola.model.PlantImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantImageRepository extends JpaRepository<PlantImage, Integer> {
    PlantImage getPlantImageByFilePath(String filePath);
}