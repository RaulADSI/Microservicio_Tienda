package edu.tienda.core.controllers;


import edu.tienda.core.configurations.ConfigurationParameters;
import edu.tienda.core.domain.Producto;
import edu.tienda.core.services.ProductoService;
import edu.tienda.core.services.ProductosServiceBdImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoControllerRest {

    @Autowired
    @Lazy
    private ProductoService productosService;

    @Autowired
    private ConfigurationParameters configurationParameters;

    @GetMapping
    public ResponseEntity<?> getProductos(){

        System.out.println("params " + configurationParameters.toString());

        List<Producto> productos = productosService.getProductos();

        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<?> altaCliente(@RequestBody Producto producto){
        productosService.saveProducto(producto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(producto.getId())
                .toUri();
        return ResponseEntity.created(location).body(producto);
    }

    @GetMapping("/fake-productos")
    public ResponseEntity<?> fakeProductosApi(){

        List<Producto> productos = new ArrayList<>(Arrays.asList(
                new Producto(1, "Camiseta Real Cartagena", 1200.0,4),
                new Producto(2, "Camiseta America de Cali", 1500.0,8),
                new Producto(1, "Camiseta Seleccion Colombia", 1800.0,16)
        ));
        return ResponseEntity.ok(productos);
    }




}
