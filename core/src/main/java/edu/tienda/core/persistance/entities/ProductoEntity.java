package edu.tienda.core.persistance.entities;

import com.googlecode.jmapper.annotations.JMap;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "productos")
@Data
// Entidad que representa la tabla 'productos' en la base de datos.
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JMap
    private Integer id;
    @JMap
    private String nombre;
    private Double precio;
    private Integer inventario;
}
