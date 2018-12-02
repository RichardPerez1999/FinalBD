package Modelo;


import VO.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductoDAO implements IBaseDatos<Producto> {

         
         
    public Producto Buscar(int Id) throws SQLException {
        Producto resultado = null;
        
        String query = "Select * from Producto Where Id_P =" + Id;
        Connection connection = Conexion.getConnection();
        
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            int Id_P = 0;
            String nombre = null;
            int cantidad = 0;
            float Pcomp = 0;
            float Pvent = 0;

            if (rs.next()) {
               
                Id_P = rs.getInt("Id_P");

                nombre = rs.getString("nombre");

                cantidad = rs.getInt("Cantidad");
                
                Pcomp = rs.getFloat("P_Compra");
                
                Pvent = rs.getFloat("P_Venta");
                
                resultado = new Producto(Id_P, nombre, cantidad, Pcomp,Pvent);
                

            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener Productos");
            e.printStackTrace();
        }
        return resultado;
    }

   
    public List<Producto> BuscarTodo() throws SQLException {
        Producto registro = null;
        List<Producto> productos = null;
        String query = "Select * from Producto ";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            int Id_P = 0;
            String nombre = null;
            int cantidad = 0;
            float Pcomp = 0;
            float Pvent = 0;
            
            
            while (rs.next()) {
                if (productos == null) {
                    productos = new ArrayList<Producto>();
                }

                
                Id_P = rs.getInt("Id_P");

                nombre = rs.getString("nombre");

                cantidad = rs.getInt("Cantidad");
                
                Pcomp = rs.getFloat("P_Compra");
                
                Pvent = rs.getFloat("P_Venta");
                
                registro = new Producto(Id_P, nombre, cantidad, Pcomp,Pvent);
                productos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Producto");
            e.printStackTrace();
        }

        return productos;

    }

   
    public boolean insertar(Producto t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into Producto(Id_P,nombre,Cantidad,P_Compra, P_Venta ) values (?,?,?,?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getId_P());
            preparedStmt.setString(2, t.getNombre());
            preparedStmt.setInt(3, t.getCantidad());
            preparedStmt.setFloat(4,t.getP_Compra() );
            preparedStmt.setFloat(5,t.getP_Venta() );
            
            
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    
    public boolean actualizar(Producto t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query
                = "update Producto set cantidad where Id_P = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getId_P());
            preparedStmt.setString(2, t.getNombre());
            preparedStmt.setInt(3, t.getCantidad());
            preparedStmt.setFloat(4,t.getP_Compra() );
            preparedStmt.setFloat(4,t.getP_Venta() );
           

            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

 
    public boolean   borrar(Producto t) throws SQLException {
     boolean result=false;
	   Connection connection = Conexion.getConnection();
	   String query = "delete from Producto where Id_P = ?";
	   PreparedStatement preparedStmt=null;
	   try {
		     preparedStmt = connection.prepareStatement(query);
		     preparedStmt.setInt(1, t.getId_P());
		    result= preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
	   return result;
	}
    

}

