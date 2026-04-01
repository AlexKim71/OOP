package ua.opnu.labwork21.entity;

public class Room {

    private Long id;
    private String number;
    private String type;
    private Double pricePerNight;
    private Integer capacity;

    public Room() {
    }

    public Room(Long id, String number, String type, Double pricePerNight, Integer capacity) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public Integer getCapacity() {
        return capacity;
    }
}

