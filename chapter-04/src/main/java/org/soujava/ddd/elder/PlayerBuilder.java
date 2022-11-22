package org.soujava.ddd.elder;

import javax.money.MonetaryAmount;

public class PlayerBuilder {
    private String name;
    private String city;
    private Email email;
    private MonetaryAmount salary;

    public PlayerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder city(String city) {
        this.city = city;
        return this;
    }

    public PlayerBuilder email(Email email) {
        this.email = email;
        return this;
    }

    public PlayerBuilder salary(MonetaryAmount salary) {
        this.salary = salary;
        return this;
    }

    public Player build() {
        //validar
        return new Player(name, city, email, salary);
    }
}