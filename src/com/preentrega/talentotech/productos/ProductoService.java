package com.preentrega.talentotech.productos;

import com.preentrega.talentotech.consoleInterface.ConsoleTextInterface;
import com.preentrega.talentotech.exceptions.StockInsuficienteException;
import com.preentrega.talentotech.pedido.Pedido;
import com.preentrega.talentotech.pedido.ProductosEnPedido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProductoService {


    private ArrayList<Producto> todosLosProductos = new ArrayList<>();
    private ArrayList<Pedido> todosLosPedidos = new ArrayList<>();
    private ConsoleTextInterface textInterface = new ConsoleTextInterface();

    public void agregarProducto() throws Exception {
        Producto newProducto = textInterface.printAgregarProductoResponse();
        todosLosProductos.add(newProducto);
        textInterface.printProductoAgregado(newProducto);
    }

    public void listarProductos() {
        textInterface.printListarProductosResponse(todosLosProductos);
    }

    public void buscarOActualizarProducto() throws Exception {
        textInterface.printBuscarActualizarProductoResponse();
        int productoID = textInterface.printPedirProductoID();
        ProductoActualizado productoConDatosActualizsados = textInterface.printDatosActualizados();
        actualizarProducto(productoID, productoConDatosActualizsados);
        textInterface.printProducto(getProductByID(productoID));
    }

    private void actualizarProducto(int productoID, ProductoActualizado productoConDatosActualizsados) throws Exception {
        for (Producto p : todosLosProductos) {
            if (p.getId() == productoID) {
                p.setNombre(productoConDatosActualizsados.getNombre());
                p.setPrecio(productoConDatosActualizsados.getPrecio());
                p.incrementStock(productoConDatosActualizsados.getStockToIncrase());
                break;
            }
        }
    }

    public Producto getProductByID(int id){
        //todo excepcion si no hay producto con dicha ID
        Producto result = null;
        for (Producto p : todosLosProductos) {
            if (p.getId() == id) {
                result = p;
                break;
            }
        }
        return result;
    }

    public void eliminarProducto() {
        //todo excepcion si no hay producto con dicha ID
        textInterface.printEliminarProductoResponse();
        int productoID = textInterface.printPedirProductoID();

        for (Iterator<Producto> iterator = todosLosProductos.iterator(); iterator.hasNext(); ) {
            Producto p = iterator.next();
            if (p.getId() == productoID) {
                textInterface.printProductoEliminadoRespose(p);
                iterator.remove();
                break;
            }
        }
    }

    public void crearPedido() {
        Pedido p = textInterface.printCrearPedidoResponse(this);
        if (canPedidoBeMade(p)){
            textInterface.printMensajeDePedidoEnCamino(p.calcularTotal());
            todosLosPedidos.add(p);
            updateStock(p);
        } else{
            throw new StockInsuficienteException("No hay stock suficiente");
        }
    }

    private void updateStock(Pedido p) {
        for (ProductosEnPedido productoEnPedido : p.getProductosEnPedido()){
            for (Producto producto : todosLosProductos){
                if (producto.getId() == productoEnPedido.getProductID()){
                    producto.decrementStock(productoEnPedido.getAmount());
                }
            }
        }
    }


    private boolean canPedidoBeMade(Pedido p) {
        for (ProductosEnPedido productoEnPedido : p.getProductosEnPedido()){
            if ((getProductByID(productoEnPedido.getProductID()).getStock() < productoEnPedido.getAmount())){
                return false;
            }
        }
        return true;
    }


    public void listarPedidos() {
        textInterface.printListarPedidosResponse(todosLosPedidos);
    }
}
