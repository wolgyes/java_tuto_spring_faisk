package program.faiskola.model;
import java.util.List;

public class BasePlant {

    private String name;
    private String description;

    private String original_url;

    private String category;

    private List<String> plantImages;

    public BasePlant(String name, String description, String category, List<String> plantImages) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.plantImages = plantImages;
    }

    public BasePlant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getPlantImages() {
        return plantImages;
    }

    public void setPlantImages(List<String> plantImages) {
        this.plantImages = plantImages;
    }
}
