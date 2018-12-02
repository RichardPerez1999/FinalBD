/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Richard Alejandro
 */
public class Proveedor {
    
    private int Id_Prov;
    private String Nombre;
    private String Ciudad;
    private String Telefono;
    private String Productos;

    public Proveedor(int Id_Prov, String Nombre, String Ciudad, String Telefono, String Productos) {
        this.Id_Prov = Id_Prov;
        this.Nombre = Nombre;
        this.Ciudad = Ciudad;
        this.Telefono = Telefono;
        this.Productos = Productos;
    }

    public int getId_Prov() {
        return Id_Prov;
    }

    public void setId_Prov(int Id_Prov) {
        this.Id_Prov = Id_Prov;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getProductos() {
        return Productos;
    }

    public void setProductos(String Productos) {
        this.Productos = Productos;
    }
    
    
}
