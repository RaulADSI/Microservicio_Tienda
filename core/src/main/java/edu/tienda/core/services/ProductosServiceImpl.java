package edu.tienda.core.services;

import edu.tienda.core.domain.Producto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service("MEMORY")
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_MEMORIA"
)
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
