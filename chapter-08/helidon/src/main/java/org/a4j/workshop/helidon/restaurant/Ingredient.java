package org.a4j.workshop.helidon.restaurant;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Schema(name = "Ingredient", description = "The ingredient of an item")
public class Ingredient {

    @Schema(required = true, name = "name", description = "The ingredient name", example = "water")
    @NotBlank
    @Size(min = 3, max = 20, message = "The name size should be between 3 and 10 chars")
    private String name;

    @Schema(required = true, name = "unit", description = "The ingredient unit of measurement", example = "L")
    @NotBlank
    private String unit;

    @Schema(required = true, name = "quantity", description = "The ingredient quantity", example = "1")
    @PositiveOrZero(message = "a quantity cannot be negative")
    private double quantity;

    @JsonbCreator
    public Ingredient( @JsonbProperty("name") String name,
                @JsonbProperty("unit")String unit,
                @JsonbProperty("quantity") double quantity) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }

    @Deprecated
    public Ingredient() {
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
