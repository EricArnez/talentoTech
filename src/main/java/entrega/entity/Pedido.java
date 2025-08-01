package entrega.entity;


import entrega.service.ProductoService;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private ProductoService productoServise;
    private ArrayList<ProductosEnPedido> productosEnPedido = new ArrayList<>();

    public void setProductoServise(ProductoService productoServise) {
        this.productoServise = productoServise;
    }

    public void agregarProducto(Long id, int amount){
        Producto p = productoServise.getProductByID(id);
        ProductosEnPedido productosEnPedido1 = new ProductosEnPedido(p.getId(), amount, p.getPrecio() );
        productosEnPedido.add(productosEnPedido1);
    }

    public ArrayList<ProductosEnPedido> getProductosEnPedido() {
        return productosEnPedido;
    }

    public double calcularTotal(){
        double total = 0;
        for (ProductosEnPedido p : productosEnPedido){
            total += p.getPrecio() * p.getAmount();
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public String getProductosEnPedido2String() {
        String result = "";
        for (ProductosEnPedido p : productosEnPedido){
            result += "id: " + p.getProductID() + ", amount: " + p.getAmount() + ", ";
        }
        return result;
    }
}

