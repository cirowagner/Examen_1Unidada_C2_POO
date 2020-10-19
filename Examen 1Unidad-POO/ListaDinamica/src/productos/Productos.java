package productos;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Productos {
    SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdp2 = new SimpleDateFormat("dd-MM-yyyy");

    private int id;
    private String nameP;
    private String fechaV;
    private String categoria;
    private String marca;
    private double precio;
    private int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getFechaV() {
        return fechaV;
    }

    public void setFechaV(String fechaV) {
        Date dato = null;
        try{
            dato = sdp.parse(fechaV);
            this.fechaV = sdp2.format(dato);
        }catch (Exception e){
        }
    }
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
