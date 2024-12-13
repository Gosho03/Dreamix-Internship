package me.georgi.lyubenov.toystore.dto;

public class ToyDTO {
    private String name;
    private double price;

    public ToyDTO() {
    }

    public ToyDTO(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
