package Modelo;


import Modelo.Conexion;
import Modelo.IBaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import VO.Proveedor;


public class ProveedorDAO implements IBaseDatos<Proveedor> {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public Proveedor Buscar(int Id) throws SQLException {
        Proveedor resultado = null;
        String query = "Select * from Proveedor Where Id_Prov ='" + Id + "'";
        System.out.println(query);
        Connection connection = Conexion.getConnection();
        
        try {
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            int Id_Prov=0;
            String Nombre=null;
            String Ciudad=null;
            String Telefono=null;
            String Productos=null;
            if (rs.next()) {
                
                Id_Prov = rs.getInt("Id_Prov");
                              
                
                Nombre = rs.getString("Nombre");
                
                
                Ciudad = rs.getString("Ciudad");
                
                
                Telefono = rs.getString("Telefono");
               
                
                Productos = rs.getString("Productos");
              


                resultado = new Proveedor(Id_Prov, Nombre, Ciudad, Telefono,Productos );

            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener Proveedores");
            e.printStackTrace();
        }
        return resultado;
    }

   
    public List<Proveedor> BuscarTodo() throws SQLException {
        Proveedor registro = null;
        List<Proveedor> Proveedores = null;
         String query = "Select * from Proveedor ";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
             int Id_Prov=0;
            String Nombre=null;
            String Ciudad=null;
            String Telefono=null;
            String Productos=null;
            
            
            while (rs.next()) {
                if (Proveedores == null) {
                    Proveedores = new ArrayList<Proveedor>();
                }

                
                Id_Prov = rs.getInt("Id_Prov");

                Nombre = rs.getString("Nombre");

                Ciudad = rs.getString("Ciudad");
                
                Telefono = rs.getString("Telefono");
                
                Productos = rs.getString("Productos");
                
                
                
                registro = new Proveedor(Id_Prov, Nombre, Ciudad, Telefono,Productos );
                Proveedores.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Proveedores");
            e.printStackTrace();
        }

        return Proveedores;

    }


    public boolean insertar(Proveedor t) throws SQLException {
        
      boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into Proveedor(Id_Prov,Nombre,Ciudad,Telefono,Productos) values (?,?,?,?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getId_Prov());
            preparedStmt.setString(2, t.getNombre());
            preparedStmt.setString(3, t.getCiudad());
            preparedStmt.setString(4,t.getTelefono() );
            preparedStmt.setString(5,t.getProductos() );
          
            
            
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }


  


    public boolean borrar(Proveedor t) throws SQLException {
        
       boolean result=false;
	   Connection connection = Conexion.getConnection();
	   String query = "delete from Proveedor where Id_Prov = ?";
	   PreparedStatement preparedStmt=null;
	   try {
		     preparedStmt = connection.prepareStatement(query);
		     preparedStmt.setInt(1, t.getId_Prov());
		    result= preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
	   return result;
	}
    

    public boolean actualizar(Proveedor t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

