package edu.tienda.core.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tienda.core.domain.Producto;
import com.fasterxml.jackson.core.type.TypeReference;
import edu.tienda.core.exceptions.ProductoServiceException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Service("JSON")
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_JSON"
)
public class ProductosServiceJsonImpl implements ProductoService {


    public List<Producto> getProductos() {

        try (InputStream inputStream = this.getClass().getResourceAsStream("/productos.json")) {
            if (inputStream == null) {
                throw new ProductoServiceException("Archivo productos.json no encontrado", null);
            }
            return new ObjectMapper().readValue(inputStream, new TypeReference<List<Producto>>() {});
        } catch (IOException e) {
            throw new ProductoServiceException("Error al leer el archivo productos.json", e);
        }

    }

    @Override
    public void saveProducto(Producto producto) {

    }


}
