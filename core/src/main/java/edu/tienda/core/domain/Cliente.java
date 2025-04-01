package edu.tienda.core.domain;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


@JacksonXmlRootElement(localName = "cliente")

public class Cliente {

    private String username;
    private String password;
    private String nombre;



    // Constructor con parámetros
    public Cliente(String nombre, String username) {
        this.nombre = nombre;
        this.username = username;
    }


}
