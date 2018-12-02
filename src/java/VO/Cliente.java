
package VO;

/**
 *
 * @author Richard Alejandro
 */
public class Cliente {
    
    private String Id_Cliente;
    private String Nombre;
    private String Direccion;
    private String Telefono;

    public Cliente(String Id_Cliente, String Nombre, String Direccion, String Telefono) {
        this.Id_Cliente = Id_Cliente;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

   

    public String getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(String Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

  
}
