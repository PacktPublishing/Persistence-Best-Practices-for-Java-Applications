package org.soujava.ddd.elder;

import java.util.Objects;
import java.util.function.Supplier;


public final class Email implements Supplier<String> {

    private final String value;

    private Email(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Email{" +
                "value='" + value + '\'' +
                '}';
    }

    /**
     * Cria uma instancia de email válida
     * @param email um texto a ser validado
     * @return uma instancia de email
     * @throws NullPointerException quando o parametro é nulo
     * @throws IllegalArgumentException quando a string nao é válida
     */
    public static Email of(String email ) {
        Objects.requireNonNull(email, "email is required");
        //faz validacao
        return new Email(email);
    }


}
