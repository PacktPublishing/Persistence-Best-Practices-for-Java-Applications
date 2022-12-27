package dev.a4j.mastering.data;


import jakarta.data.Entity;
import jakarta.data.Id;

import java.util.Objects;

@Entity
public class Airplane {

    @Id
    private String model;

    private String manufacturer;

    private int quantity;

    private String nationality;

    Airplane() {
    }

    Airplane(String model, String manufacturer, int quantity, String nationality) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.nationality = nationality;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getNationality() {
        return nationality;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Airplane airplane = (Airplane) o;
        return Objects.equals(model, airplane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(model);
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", quantity=" + quantity +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
