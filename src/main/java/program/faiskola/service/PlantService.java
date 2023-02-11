package program.faiskola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.faiskola.model.BasePlant;
import program.faiskola.model.Category;
import program.faiskola.model.Plant;
import program.faiskola.model.PlantImage;
import program.faiskola.repo.PlantImageRepository;
import program.faiskola.repo.PlantRepository;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private PlantImageRepository plantImageRepository;

    @Autowired
    CategoryService categoryService;

    public PlantImage getOrCreateImage(String filePath) {
        PlantImage plantImage = null;
        try {
            plantImage = plantImageRepository.getPlantImageByFilePath(filePath);
        } catch (Exception ignore) {
        }

        if (plantImage == null) {
            plantImage = new PlantImage(filePath);
            plantImageRepository.save(plantImage);
        }
        return plantImage;
    }

    private boolean existsPlantByName(String name) {
        return plantRepository.existsPlantByName(name);
    }

    public Plant addPlant(BasePlant basePlant) {

        if (!existsPlantByName(basePlant.getName())) {

            Category category = categoryService.getOrCreateCategory(basePlant.getCategory());
            Plant plant = new Plant(basePlant.getName(), basePlant.getDescription(), basePlant.getOriginal_url(), category);
            for (String basePlantImage : basePlant.getPlantImages()) {
                PlantImage plantImage = getOrCreateImage(basePlantImage);
                plant.addPlantImage(plantImage);
                plantImageRepository.save(plantImage);
            }
            plantRepository.save(plant);
            return plant;
        }
        else return null;
    }



    public Plant getPlantById(int id) {
        return plantRepository.getPlantById((long) id);
    }

    public Plant getPlantByName(String name) {
        return plantRepository.getPlantByName(name);
    }

    public Iterable<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    public void deletePlantById(int id) {
        plantRepository.deleteById((long) id);
    }

    public void deletePlantByName(String name) {
        plantRepository.deletePlantByName(name);
    }

    public Iterable<Plant> getPlantsByCategory(String category) {
        return plantRepository.getPlantsByCategory(categoryService.getOrCreateCategory(category));
    }
}
