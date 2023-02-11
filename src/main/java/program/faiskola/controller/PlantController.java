package program.faiskola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import program.faiskola.model.BasePlant;
import program.faiskola.model.Plant;
import program.faiskola.service.PlantService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    PlantService plantService;
    @PostMapping(value = "/createPlant", consumes = "application/json", produces = "application/json")
    public Plant createPlant(@RequestBody BasePlant plant) {
        System.out.println(plant);
        return plantService.addPlant(plant);
    }

    @GetMapping(value = "/getPlant", produces = "application/json")
    public Plant getPlant(@RequestParam Integer id) {
        return plantService.getPlantById(id);
    }

    @GetMapping(value = "/getPlantByName", produces = "application/json")
    public Plant getPlant(@RequestParam String name) {
        return plantService.getPlantByName(name);
    }

    @GetMapping(value = "/getPlants", produces = "application/json")
    public List<Plant> getPlants() {
        return (List<Plant>) plantService.getAllPlants();
    }

    @GetMapping(value = "/getPlantsByCategory", produces = "application/json")
    public Iterable<Plant> getPlantsByCategory(@RequestParam String category) {
        return plantService.getPlantsByCategory(category);
    }

    @DeleteMapping(value = "/deletePlant", produces = "application/json")
    public void deletePlant(@RequestParam Integer id) {
        plantService.deletePlantById(id);
    }

    @DeleteMapping(value = "/deletePlantByName", produces = "application/json")
    public void deletePlantByName(@RequestParam String name) {
        plantService.deletePlantByName(name);
    }



}
