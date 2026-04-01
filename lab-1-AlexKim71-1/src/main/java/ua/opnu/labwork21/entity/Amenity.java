package ua.opnu.labwork21.entity;

public class Amenity {

    private Long id;
    private String name;
    private String description;

    public Amenity() {
    }

    public Amenity(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

