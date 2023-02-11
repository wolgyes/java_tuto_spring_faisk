package program.faiskola.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}