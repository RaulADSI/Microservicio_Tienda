package edu.tienda.core.domain;

import lombok.*;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {

    private String username;
    private String password;
    private String nombre;

}
