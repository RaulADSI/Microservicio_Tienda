package edu.tienda.core.persistance.repositories;

import edu.tienda.core.persistance.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepository extends JpaRepository<ProductoEntity, Integer> {

    List<ProductoEntity> findByprecioLessThan(Double precio);

    List<ProductoEntity> findByNombreLike(String nombre);

    //List<ProductoEntity> findByPrecioGreaterThanAndInventarioLessThan(Double precio,Integer inventario);


}
