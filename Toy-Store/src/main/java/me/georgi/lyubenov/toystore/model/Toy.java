package me.georgi.lyubenov.toystore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Toys")
public class Toy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int toyId;
    private String name;
    private double price;
    public Toy() {}
    public Toy(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return toyId;
    }

    public void setId(int toyId) {
        this.toyId = toyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
