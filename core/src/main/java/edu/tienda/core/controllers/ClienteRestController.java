package edu.tienda.core.controllers;


import edu.tienda.core.domain.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteRestController {

    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente("arm","1234","Armstrong"),
            new Cliente("ald","1234","Aldrin"),
            new Cliente("col","1234","Colling")
    ));

    @GetMapping("/clientes")
    public List<Cliente>getClientes(){
        return clientes;
    }

    @GetMapping("/clientes/{userName}")
    public Optional<Cliente> getCliente(@PathVariable String userName){
        return clientes.stream()
                .filter(cli -> cli.getUsername().equalsIgnoreCase(userName))
                .findFirst();

    }

    @PostMapping("/clientes")
    public Cliente altaCliente(@RequestBody Cliente cliente){
        clientes.add(cliente);
        return cliente;
    }

    @PutMapping("/clientes")
    public Cliente modificacionCliente(@RequestBody Cliente cliente){

        Cliente clienteEncontrado = clientes.stream().
                filter(cli -> cli.getUsername().equalsIgnoreCase(cliente.getUsername())).
                findFirst().orElseThrow();

        clienteEncontrado.setPassword(cliente.getPassword());
        clienteEncontrado.setNombre(clienteEncontrado.getNombre());

        return cliente;
    }

    @DeleteMapping("/clientes/{userName}")
    public void deleteCliente(@PathVariable String userName){
        Cliente clienteEncontrado = clientes.stream().
                filter(cli -> cli.getUsername().equalsIgnoreCase(userName)).
                findFirst().orElseThrow();

        clientes.remove(clienteEncontrado);
    }
}
