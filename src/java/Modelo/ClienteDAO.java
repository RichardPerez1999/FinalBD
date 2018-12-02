package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import VO.Cliente;


public class ClienteDAO implements IBaseDatos<Cliente> {

    public Cliente buscar(int id) throws SQLException {
        Cliente resultado = null;
        String query = "Select * from Cliente Where Id_Cliente =" + id;
        Connection connection = Conexion.getConnection();
        
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            String Id_Cliente = null;
            String nombre = null;
            String direccion = null;
            String telefono = null;
            
         

            if (rs.next()) {

                Id_Cliente = rs.getString("Id_Cliente");

                nombre = rs.getString("nombre");

                direccion = rs.getString("direccion");
                
                telefono = rs.getString("telefono");

                resultado = new Cliente(Id_Cliente, nombre, direccion,telefono );

            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener Cliente");
            e.printStackTrace();
        }
        return resultado;
    }

 
    public List BuscarTodo() throws SQLException {
        
        Cliente registro = null;
        List<Cliente> clientes = null;
        String query = "Select * from Cliente ";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            String Id_Cliente = null;
            String nombre = null;
            String Direccion = null;
            String Telefono = null;
           
            
            
            while (rs.next()) {
                if (clientes == null) {
                    clientes = new ArrayList<Cliente>();
                }

                
                Id_Cliente = rs.getString("Id_Cliente");

                nombre = rs.getString("Nombre");

                Direccion = rs.getString("Direccion");
                
                Telefono = rs.getString("Telefono");
                
               
                
                registro = new Cliente(Id_Cliente, nombre, Direccion, Telefono);
                clientes.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Producto");
            e.printStackTrace();
        }

        return clientes;

    }

   
    public boolean insertar(Cliente t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into Cliente(Id_Cliente,Nombre,Direccion,Telefono ) values (?,?,?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getId_Cliente());
            preparedStmt.setString(2, t.getNombre());
            preparedStmt.setString(3, t.getDireccion());
            preparedStmt.setString(4,t.getTelefono() );
          
            
            
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }



    public boolean actualizar(Cliente t) throws SQLException {
        return false;
       
    }

    

    public boolean borrar(Cliente t) throws SQLException {
      boolean result=false;
	   Connection connection = Conexion.getConnection();
	   String query = "delete from Cliente where Id_Cliente = ?";
	   PreparedStatement preparedStmt=null;
	   try {
		     preparedStmt = connection.prepareStatement(query);
		     preparedStmt.setString(1, t.getId_Cliente());
		    result= preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
	   return result;

    }
}
