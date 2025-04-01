package edu.tienda.core.services;

import edu.tienda.core.domain.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ClienteServiceImpl {

    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente("arm","1234"),
            new Cliente("ald","1234"),
            new Cliente("col","1234")
    ));

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }


    public Stream<Cliente> stream() {
        return clientes.stream();
    }

    public void addCliente(Cliente cliente) {
        if (clientes.stream().anyMatch(c -> c.getUsername().equalsIgnoreCase(cliente.getUsername()))) {
            throw new IllegalArgumentException("Cliente con este username ya existe.");
        }
        clientes.add(cliente);
    }

    public void remove(Cliente cliente) {
        if (!clientes.remove(cliente)) {
            throw new IllegalArgumentException("El cliente no se encontró en la lista.");
        }
    }
}
