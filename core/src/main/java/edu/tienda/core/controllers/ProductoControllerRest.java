package edu.tienda.core.controllers;


import edu.tienda.core.domain.Producto;
import edu.tienda.core.services.ProductoService;
import edu.tienda.core.services.ProductosServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoControllerRest {

    private ProductoService productosServices = new ProductosServiceImpl();

    @GetMapping
    public ResponseEntity<?> getProductos(){
        List<Producto> productos = productosServices.getProductos();
        return ResponseEntity.ok(productos);
    }
}
