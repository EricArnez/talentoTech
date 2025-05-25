package com.preentrega.talentotech.pedido;

public class ProductosEnPedido {
    private int productID;
    private int amount;
    private double precio;

    public ProductosEnPedido(int productID, int amount, double precio) {
        this.productID = productID;
        this.amount = amount;
        this.precio = precio;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductID() {
        return productID;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrecio() {
        return precio;
    }
}
