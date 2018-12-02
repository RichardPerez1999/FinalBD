/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import java.time.LocalDate;

/**
 *
 * @author Richard Alejandro
 */
public class Venta {
    
    private int Id_Venta;
    private Producto producto;
    private Cliente cliente;
    private Empleado empleado;
    private LocalDate fecha;

    public Venta(int Id_Venta, Producto producto, Cliente cliente, Empleado empleado, LocalDate fecha) {
        this.Id_Venta = Id_Venta;
        this.producto = producto;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fecha = fecha;
    }

    public int getId_Venta() {
        return Id_Venta;
    }

    public void setId_Venta(int Id_Venta) {
        this.Id_Venta = Id_Venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
}
