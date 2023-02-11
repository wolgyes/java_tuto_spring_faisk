package program.faiskola.model;

import javax.persistence.*;

@Entity
@Table(name = "plant_image")
public class PlantImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    public PlantImage() {

    }


    private String filePath;

    public PlantImage(String imagePath) {
        this.filePath = imagePath;
    }
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}