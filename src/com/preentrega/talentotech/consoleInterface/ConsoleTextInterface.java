package com.preentrega.talentotech.consoleInterface;
import com.preentrega.talentotech.pedido.Pedido;
import com.preentrega.talentotech.productos.Producto;
import com.preentrega.talentotech.productos.ProductoActualizado;
import com.preentrega.talentotech.productos.ProductoService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleTextInterface {

    Scanner scanner;

    public void printMenu(){
        System.out.println("===================================");
        System.out.println("SISTEMA DE GESTIÓN - TECHLAB ");
        System.out.println("===================================");
        System.out.println("1) Agregar producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Buscar/Actualizar producto");
        System.out.println("4) Eliminar producto");
        System.out.println("5) Crear un pedido");
        System.out.println("6) Listar pedidos");
        System.out.println("7) Salir");
        System.out.println(" ");
        System.out.println("Elija una opción: ");
    }



    public int getUserInput(){
        scanner = new Scanner(System.in);
        int userOptionSelected = 0;
        try {
            userOptionSelected = scanner.nextInt();
            return userOptionSelected;
        } catch (InputMismatchException e) {
            System.out.println("por favor ingrese un numero");
        }
        return userOptionSelected;
    }

    public Producto printAgregarProductoResponse() throws Exception {
        String nombre = "";
        double precio = 0;
        int stock = 0;

        scanner = new Scanner(System.in);

        System.out.print("ingrese el nombre del producto: ");
        nombre = scanner.nextLine();

        System.out.print("ahora ingrese el precio que va a tener este: ");
        precio = scanner.nextDouble();

        System.out.print("y por ultimo ingrese el stock: ");
        stock = scanner.nextInt();

        Producto p = new Producto(nombre, precio, stock);


        return p;
    }

    public void printListarProductosResponse(ArrayList<Producto> productos){
        System.out.println("PRODUCTOS");
        for (Producto p : productos) {
            System.out.println(
                "|id: "  + p.getId() + " |nombre: " + p.getNombre() + " |precio: " + p.getPrecio() + " |stock: " + p.getStock() + " |"
            );
        }
    }

    public void printBuscarActualizarProductoResponse(){
        System.out.print("por favor ingrese el id del producto a actualizar: ");
    }

    public void printProducto(Producto p ){
        System.out.println("PRODUCTO");
        System.out.println(
                "|id: "  + p.getId() + " |nombre: " + p.getNombre() + " |precio: " + p.getPrecio() + " |stock: " + p.getStock() + " |"
        );
    }

    public void printEliminarProductoResponse(){
        System.out.print("por favor ingrese el id del producto a eliminar: ");
    }

    public Pedido printCrearPedidoResponse(ProductoService ps){
        boolean itsOn = true;
        int id = 0;
        int amount = 0;
        String seQuierenMasProductos = "";

        Pedido pedido = new Pedido();
        pedido.setProductoServise(ps);
        scanner = new Scanner(System.in);
        while (itsOn) {

            System.out.print("ingrese el id del producto: ");
            id = scanner.nextInt();
            System.out.print("ingrese la cantidad: ");
            amount = scanner.nextInt();
            System.out.println("desea agregar otro producto? ");
            System.out.println("si/no:.. ");
            scanner = new Scanner(System.in);
            seQuierenMasProductos = scanner.nextLine();
            if (seQuierenMasProductos.contains("no")){
                itsOn = false;
            }
            pedido.agregarProducto(id, amount);
        }
        return pedido;
    }

    public void printListarPedidosResponse(ArrayList<Pedido> pedidos) {
        System.out.println("PEDIDOS");
        for (Pedido p : pedidos){
            System.out.println(
                    "|id: "  + p.getId() + " |productos en pedido: " + p.getProductosEnPedido2String() + " |"
            );
        }
    }

    public void printSalirResponse(){
        System.out.print("Hasta pronto!");
    }

    public void printProductoEliminadoRespose(Producto p) {
        System.out.print("el producto con el ID " + p.getId() + " ah sido eliminado");
    }

    public int printPedirProductoID() {
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void printProductoAgregado(Producto newProducto) {
        System.out.println("producto agregado! ");
    }

    public void printMensajeDePedidoEnCamino(double precioTotal) {
        System.out.println("por favor abone " + precioTotal + "$");
        System.out.println("kaching kaching!, gracias por su compra! ");
        System.out.println("pedido en camino");
    }

    public void printSpace(){
        System.out.println(" ");
        System.out.println(" ");
    }

    public ProductoActualizado printDatosActualizados() {
        String nombre = "";
        double precio = 0;
        int stockAIncrementar = 0;
        int id = 0;

        scanner = new Scanner(System.in);

        System.out.print("ingrese el nuevo nombre del producto: ");
        nombre = scanner.nextLine();

        System.out.print("ahora ingrese el nuevo precio que va a tener este: ");
        precio = scanner.nextDouble();

        System.out.print("y por ultimo ingrese la cantidad de stock a incrementar: ");
        stockAIncrementar = scanner.nextInt();

        ProductoActualizado productoActualizado = new ProductoActualizado(nombre, stockAIncrementar, precio);
        return productoActualizado;
    }
}
