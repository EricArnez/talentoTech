import com.preentrega.talentotech.productos.Producto;
import com.preentrega.talentotech.productos.ProductoService;
import com.preentrega.talentotech.consoleInterface.ConsoleTextInterface;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {

    public static void main(String[] args) throws Exception {
        boolean isOn = true;
        int userInput = 0;
        ProductoService productoService = new ProductoService();
        ConsoleTextInterface textInterface = new ConsoleTextInterface();

        while (isOn){
        userInput = 0;
        textInterface.printMenu();
        userInput = textInterface.getUserInput();



        switch (userInput) {
            case 1:
                productoService.agregarProducto();
                break;
            case 2:
                productoService.listarProductos();
                break;
            case 3:
                productoService.buscarOActualizarProducto();
                break;
            case 4:
                productoService.eliminarProducto();
                break;
            case 5:
                productoService.crearPedido();
                break;
            case 6:
                productoService.listarPedidos();
                break;
            case 7:
                textInterface.printSalirResponse();
                isOn = false;
                break;
            default:
                textInterface.printMenu();
                break;
        }
        textInterface.printSpace();
  ;      }
    }
}