package entrega.entity;


import entrega.exceptions.InvalidAmountException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Producto {
    private static Long idCounter;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precio;
    private int stock;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // constructor vacio para usar RequestBody
    public Producto(){
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

    public Long getId() {
        return id;
    }

    public boolean contieneNombre(String busqueda) {
        return nombre.contains(busqueda);
    }
}
