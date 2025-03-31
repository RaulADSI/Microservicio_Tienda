package edu.tienda.core.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//Esta clase pertenece al modelo de datos y tiene el rol de Data Transfer Object, seutiliza para reprensentar la informacion del producvto en la API REST
public class Producto {

    private Integer id;
    private String nombre;
    private Double precio;
    private Integer inventario;

}
