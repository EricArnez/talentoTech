package entrega.controller;

import entrega.entity.Producto;
import entrega.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductoService service;

    public ProductController(ProductoService service) {
        this.service = service;
    }

    @PostMapping
    public String createProduct(@RequestBody Producto product){
        service.agregarProducto(product);
        return "producto creado";
    }

    @GetMapping("/list")
    public List<Producto> listarProductos(){
        return service.listarProductos();
    }


    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return service.getProductByID(id);
    }


    @PutMapping("/{id}")
    public Producto editarPrecioProducot(@PathVariable Long id, @RequestParam Double nuevoPrecio) throws Exception {
        return service.editarProducto(id, nuevoPrecio);
    }

    @DeleteMapping("/{id}")
    public Producto borrarProducto (@PathVariable Long id){
        return service.eliminarProducto(id);

    }
}
