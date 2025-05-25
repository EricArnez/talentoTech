package com.preentrega.talentotech.productos;

public class ProductoActualizado {
    private String nombre;
    private double precio;
    private int stockToIncrase;

    public ProductoActualizado(String nombre, int stockToIncrase, double precio) {
        this.nombre = nombre;
        this.stockToIncrase = stockToIncrase;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStockToIncrase() {
        return stockToIncrase;
    }
}
