package edu.tienda.core.services;


import edu.tienda.core.domain.Producto;
import edu.tienda.core.persistance.entities.ProductoEntity;
import edu.tienda.core.persistance.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("BD")
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_BD"
)
public class ProductosServiceBdImpl  implements ProductoService{

    @Autowired
    private ProductosRepository productosRepository;

    public List<Producto> getProductos() {

        List<ProductoEntity> productosEntities = productosRepository.findAll();
        List<Producto> productos = new ArrayList<>();

        for (ProductoEntity productoEntity : productosEntities){
            Producto producto = new Producto();
            producto.setId(productoEntity.getId());
            producto.setNombre(productoEntity.getNombre());
            producto.setPrecio(productoEntity.getPrecio());
            producto.setInventario(productoEntity.getInventario());
            productos.add(producto);
        }
        return productos;
    }

    @Override
    public void saveProducto(Producto producto) {
        ProductoEntity productoEntity = new ProductoEntity();

        productoEntity.setNombre(producto.getNombre());
        productoEntity.setPrecio(producto.getPrecio());
        productoEntity.setInventario(producto.getInventario());

        ProductoEntity savedEntity = productosRepository.save(productoEntity);
        producto.setId(savedEntity.getId());

    }
}
