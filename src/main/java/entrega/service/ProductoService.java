package entrega.service;

import entrega.entity.Producto;
import entrega.exceptions.ProductNotFoundException;
import entrega.repository.ProductRepository;
import entrega.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private ProductRepository repository;
    private ProductoRepository repositoryJpa;

    public void ProductService(ProductRepository repository, ProductoRepository repositoryJpa) {
        this.repository = repository;
        this.repositoryJpa = repositoryJpa;
    }

    public Producto agregarProducto(Producto producto){
        Producto productoGuardado = this.repositoryJpa.save(producto);
        return productoGuardado;
    }

    public List<Producto> listarProductos() {
        return this.repositoryJpa.findAll();
    }

    public ArrayList<Producto> buscarProducto(String busqueda) {
        ArrayList<Producto> encontrados = this.repository.buscarProducto(busqueda);

        if (encontrados.isEmpty()){
            throw new ProductNotFoundException(busqueda);
        }

        return encontrados;
    }

    public Producto buscarPorId(Long id) {
        Optional<Producto> encontrado = this.repositoryJpa.findById(id);
        if (encontrado.isEmpty()){
            throw new ProductNotFoundException(id.toString());
        }

        return encontrado.get();
    }

    public Producto getProductByID(Long id) {
        return this.repositoryJpa.findById(id).orElseThrow(() -> new ProductNotFoundException(id.toString()));
    }

    public Producto editarProducto(Long id, Double nuevoPrecio) throws Exception {
        Producto encontrado = this.buscarPorId(id);

        encontrado.setPrecio(nuevoPrecio);
        this.repositoryJpa.save(encontrado);

        return encontrado;
    }

    public Producto eliminarProducto(Long id) {
        Producto encontrado = this.buscarPorId(id);

        this.repositoryJpa.delete(encontrado);

        return encontrado;
    }

}
