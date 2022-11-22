package org.soujava.ddd.elder;


import javax.money.MonetaryAmount;
import java.util.Objects;

//entidade
public class Player {

    //identificador
    private String name;

    private String city;

    private Email email;

    private MonetaryAmount salary;

    public Player(String name, String city, Email email, MonetaryAmount salary) {
        this.name = name;
        this.city = city;
        this.email = email;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Email getEmail() {
        return email;
    }

    public MonetaryAmount getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", email=" + email +
                ", salary=" + salary +
                '}';
    }

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }
}
