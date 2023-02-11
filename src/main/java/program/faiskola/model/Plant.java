package program.faiskola.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plant")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 500)
    private String name;

    @Column(length = 10000)
    private String description;

    @Column(length = 1000)
    private String original_url;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @OneToMany
    @JoinColumn(name = "plant")
    private List<PlantImage> plantImages;

    public Plant(String name, String description, Category category, List<PlantImage> plantImages) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.plantImages = plantImages;
    }

    public Plant(String name, String description, String original_url,  Category category) {
        this.name = name;
        this.description = description;
        this.original_url = original_url;
        this.category = category;
        this.plantImages = new ArrayList<>();
    }

    public Plant() {

    }

    public void addPlantImage(PlantImage plantImage) {
        this.plantImages.add(plantImage);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public Category getCategory() {
        return category;
    }

    public List<PlantImage> getPlantImages() {
        return plantImages;
    }
}