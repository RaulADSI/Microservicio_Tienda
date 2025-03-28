package edu.tienda.core.controllers;


import edu.tienda.core.domain.Cliente;
import edu.tienda.core.exceptions.BadRequestException;
import edu.tienda.core.exceptions.ResourceNotFoundExceptions;
import edu.tienda.core.exceptions.ResourceNotFoundExceptions.ClienteNotFoundException;
import edu.tienda.core.services.ClienteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    private ClienteServiceImpl clienteService = new ClienteServiceImpl();

    @GetMapping
    public ResponseEntity<?> getClientes(){
        List<Cliente> clientes = clienteService.getClientes();
        return ResponseEntity.ok(clientes);
    }

    private Optional<Cliente> buscarClientePorUsername(String userName) {
        return clienteService.stream()
                .filter(cli -> cli.getUsername().equalsIgnoreCase(userName))
                .findFirst();
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getCliente(@PathVariable String userName){
        if ((userName.length() != 3) || (userName == null) || userName.isBlank()){
            throw new BadRequestException("El parametro nombre de usuario debe contener 3 caracteres");
        }
        return clienteService.stream()
                .filter(cliente -> cliente.getUsername().equalsIgnoreCase(userName)) // Filtramos el cliente correcto
                .findFirst() // Obtenemos el primer resultado como un Optional
                .map(ResponseEntity::ok) // Si el cliente existe, devolvemos ResponseEntity con 200 OK
                .orElseThrow(() -> new ResourceNotFoundExceptions("Cliente " + userName +" no encontrado")); // Si no existe, lanzamos la excepción
    }

    @PostMapping
    public ResponseEntity<?> altaCliente(@RequestBody Cliente cliente){
        clienteService.addCliente(cliente);

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
    public ResponseEntity<?> deleteCliente(@PathVariable String userName) {
        Cliente clienteEncontrado = buscarClientePorUsername(userName)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado"));
        clienteService.remove(clienteEncontrado);
        return ResponseEntity.noContent().build();


    }


}
