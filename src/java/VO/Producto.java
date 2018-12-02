package VO;


public class Producto {
    
    private int Id_P;
    private String nombre;
    private int cantidad;
    private float P_Compra;
    private float P_Venta;

    public Producto(int Id_P, String nombre, int cantidad, float P_Compra, float P_Venta) {
        this.Id_P = Id_P;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.P_Compra = P_Compra;
        this.P_Venta = P_Venta;
    }

    public int getId_P() {
        return Id_P;
    }

    public void setId_P(int Id_P) {
        this.Id_P = Id_P;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getP_Compra() {
        return P_Compra;
    }

    public void setP_Compra(float P_Compra) {
        this.P_Compra = P_Compra;
    }

    public float getP_Venta() {
        return P_Venta;
    }

    public void setP_Venta(float P_Venta) {
        this.P_Venta = P_Venta;
    }

   
   
}
