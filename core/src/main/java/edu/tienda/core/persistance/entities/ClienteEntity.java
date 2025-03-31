package edu.tienda.core.persistance.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.util.UUID;

@Entity(name = "clientes")
@Data
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id; // Using UUID as primary key

    private String username; // Typically user-defined
    private String password;
    private String nombre;
}
