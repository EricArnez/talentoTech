package entrega.entity;

public class ProductosEnPedido {
    private Long productID;
    private int amount;
    private double precio;

    public ProductosEnPedido(Long productID, int amount, double precio) {
        this.productID = productID;
        this.amount = amount;
        this.precio = precio;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Long getProductID() {
        return productID;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrecio() {
        return precio;
    }
}
