package ua.opnu.labwork21.entity;

public class Hotel {

    private Long id;
    private String name;
    private String city;
    private String address;
    private Integer rating;

    public Hotel() {
    }

    public Hotel(Long id, String name, String city, String address, Integer rating) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.rating = rating;
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

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Integer getRating() {
        return rating;
    }
}

