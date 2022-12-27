package dev.a4j.mastering.data;

public class AirplaneBuilder {
    private String model;
    private String manufacturer;
    private String nationality;

    private int seats;

     AirplaneBuilder() {
    }

    public AirplaneBuilder model(String model) {
        this.model = model;
        return this;
    }

    public AirplaneBuilder manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }


    public AirplaneBuilder nationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public AirplaneBuilder seats(int seats) {
        this.seats = seats;
        return this;
    }

    public Airplane build() {
        return new Airplane(model, manufacturer, nationality, seats);
    }
}