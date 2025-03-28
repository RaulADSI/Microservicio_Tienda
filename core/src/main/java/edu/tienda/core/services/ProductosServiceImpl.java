package edu.tienda.core.services;

import edu.tienda.core.domain.Producto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductosServiceImpl implements ProductoService{

    private List<Producto> productos = new ArrayList<>(Arrays.asList(
            new Producto(1,"Pc Portatil", 1.500, 10),
            new Producto(2,"Smart tv", 2.500, 15),
            new Producto(3,"Tablet", 5.00, 20)
    ));

    public List<Producto> getProductos() {
        return productos;
    }
}
