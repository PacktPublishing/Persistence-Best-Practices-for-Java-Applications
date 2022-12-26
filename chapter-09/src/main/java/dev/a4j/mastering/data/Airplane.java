package dev.a4j.mastering.data;


import jakarta.data.Entity;
import jakarta.data.Id;

@Entity
public class Airplane {

    @Id
    private String model;

    private String manufacturer;

    private int buildQuantity;

    private String nationality;

    Airplane() {
    }

    Airplane(String model, String manufacturer, int buildQuantity, String nationality) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.buildQuantity = buildQuantity;
        this.nationality = nationality;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getBuildQuantity() {
        return buildQuantity;
    }

    public String getNationality() {
        return nationality;
    }
}
