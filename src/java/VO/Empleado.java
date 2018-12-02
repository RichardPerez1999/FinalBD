package VO;

/**
 *
 * @author Richard Alejandro
 */
public class Empleado {
    private int Id_Emp;
    private String Nombre;
    private String Usuario;
    private String Clave;

    public Empleado(int Id_Emp, String Nombre, String Ususario, String Clave) {
        this.Id_Emp = Id_Emp;
        this.Nombre = Nombre;
        this.Usuario = Ususario;
        this.Clave = Clave;
    }

    public int getId_Emp() {
        return Id_Emp;
    }

    public void setId_Emp(int Id_Emp) {
        this.Id_Emp = Id_Emp;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Ususario) {
        this.Usuario = Ususario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    

}
