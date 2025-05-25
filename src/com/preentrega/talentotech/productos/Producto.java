package com.preentrega.talentotech.productos;

import com.preentrega.talentotech.exceptions.InvalidAmountException;

public class Producto {
    private static int idCounter;

    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto(String nombre, double p, int s) throws Exception {
        if (p < 0){
            throw new InvalidAmountException("no puede haber pedidos con stock negativo!");
        }
        else {
            this.nombre = nombre;
            this.precio = p;
            this.stock = s;
            this.id = idCounter;
            idCounter++;
        }
    }

    public void setPrecio(double p) throws Exception {
        if (p < 0){
            throw new Exception("El precio no puede ser negativo");
        }
        else {
            this.precio = p;
        }
    }

    public void incrementStock(int amount){
        stock += amount;
    }

    public void decrementStock(int amount){
        if (amount > stock){
            stock = 0;
        }
        else{
            stock -= amount;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
}
