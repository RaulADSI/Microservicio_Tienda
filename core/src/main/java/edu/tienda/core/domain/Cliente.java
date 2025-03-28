package edu.tienda.core.domain;

import java.util.Objects;

public class Cliente {

    private String username;
    private String password;
    private String nombre;

    public Cliente(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(username, cliente.username); // Usa el campo único que identifica a un cliente
    }

    @Override
    public int hashCode() {
        return Objects.hash(username); // Asegúrate de usar el mismo campo
    }
}
