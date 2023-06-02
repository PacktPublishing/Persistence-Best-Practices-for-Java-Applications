package dev.a4j.mastering.data;


import java.util.Objects;

public class Airplane {

    private String model;

    private String manufacturer;

    private String nationality;

    private int seats;

    Airplane() {
    }

    Airplane(String model, String manufacturer, String nationality, int seats) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.nationality = nationality;
        this.seats = seats;
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

    public int getSeats() {
        return seats;
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
                ", nationality='" + nationality + '\'' +
                ", seats=" + seats +
                '}';
    }

    public static AirplaneBuilder builder() {
        return new AirplaneBuilder();
    }
}
