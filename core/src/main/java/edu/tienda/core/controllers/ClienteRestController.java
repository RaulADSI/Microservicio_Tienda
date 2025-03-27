package edu.tienda.core.controllers;


import edu.tienda.core.domain.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente("arm","1234","Armstrong"),
            new Cliente("ald","1234","Aldrin"),
            new Cliente("col","1234","Colling")
    ));

    public class ClienteNotFoundException extends RuntimeException {
        public ClienteNotFoundException(String message) {
            super(message);
        }
    }

    private Optional<Cliente> buscarClientePorUsername(String userName) {
        return clientes.stream()
                .filter(cli -> cli.getUsername().equalsIgnoreCase(userName))
                .findFirst();
    }

    @GetMapping
    public ResponseEntity<?>getClientes(){
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getCliente(@PathVariable String userName){
        return buscarClientePorUsername(userName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> altaCliente(@RequestBody Cliente cliente){
        clientes.add(cliente);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(cliente.getUsername())
                .toUri();
        return ResponseEntity.created(location).body(cliente);
    }

    @PutMapping
    public ResponseEntity<?> modificacionCliente(@RequestBody Cliente cliente){
        Cliente clienteEncontrado = buscarClientePorUsername(cliente.getUsername())
                .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado"));

        clienteEncontrado.setPassword(cliente.getPassword());
        clienteEncontrado.setNombre(cliente.getNombre());
        return ResponseEntity.ok(clienteEncontrado);


    }

    @DeleteMapping("/{userName}")
    public ResponseEntity  deleteCliente(@PathVariable String userName){
        Cliente clienteEncontrado = buscarClientePorUsername(userName)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado"));
        clientes.remove(clienteEncontrado);
        return ResponseEntity.noContent().build();

    }


}
