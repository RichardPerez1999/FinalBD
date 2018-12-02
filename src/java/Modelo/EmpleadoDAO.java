package Modelo;

import Modelo.IBaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import VO.Empleado;



public class EmpleadoDAO implements IBaseDatos<Empleado> {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public Empleado Buscar(int Id) throws SQLException {
        Empleado resultado = null;
        String query = "Select * from Empleado Where Id_Emp ='" + Id + "'";
        System.out.println(query);
        Connection connection = Conexion.getConnection();
        
        try {
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            int Id_Emp = 0;        
            String Nombre = null;
            String Usuario = null;
            String Clave = null;
            if (rs.next()) {
                
                Id_Emp = rs.getInt("Id_Emp");
                              
                
                Nombre = rs.getString("Nombre");
                
                
                Usuario = rs.getString("Usuario");
             
                
                Clave = rs.getString("Clave");
              


                resultado = new Empleado(Id_Emp, Nombre, Usuario, Clave);

            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener Empleado");
            e.printStackTrace();
        }
        return resultado;
    }

   
    public List<Empleado> BuscarTodo() throws SQLException {
        Empleado registro = null;
        List<Empleado> Empleados = null;
         String query = "Select * from Empleado ";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            int Id_Emp = 0;        
            String Nombre = null;
            String Usuario = null;
            String Clave = null;
            
            
            while (rs.next()) {
                if (Empleados == null) {
                    Empleados = new ArrayList<Empleado>();
                }

                
                Id_Emp = rs.getInt("Id_Emp");

                Nombre = rs.getString("Nombre");

                Usuario = rs.getString("Usuario");
                
                Clave = rs.getString("Clave");
                
                registro = new Empleado(Id_Emp, Nombre, Usuario, Clave);
                Empleados.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Empleados");
            e.printStackTrace();
        }

        return Empleados;

    }


    public boolean insertar(Empleado t) throws SQLException {
        
      boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into Empleado(Id_Emp,Nombre,Usuario,Clave) values (?,?,?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getId_Emp());
            preparedStmt.setString(2, t.getNombre());
            preparedStmt.setString(3, t.getUsuario());
            preparedStmt.setString(4, t.getClave() );
          
            
            
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }


  


    public boolean borrar(Empleado t) throws SQLException {
        
       boolean result=false;
	   Connection connection = Conexion.getConnection();
	   String query = "delete from Empleado where Id_Emp = ?";
	   PreparedStatement preparedStmt=null;
	   try {
		     preparedStmt = connection.prepareStatement(query);
		     preparedStmt.setInt(1, t.getId_Emp());
		    result= preparedStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
	   return result;
	}
    

    public boolean actualizar(Empleado t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
