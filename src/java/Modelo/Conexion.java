package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static Connection CONEXION=null;
        
        public static Connection getConnection() throws SQLException{
            if(CONEXION == null){
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    
                } catch (Exception e) {
                }
                try {
                    CONEXION = DriverManager.getConnection("jdbc:mysql://localhost:3306/VariedadesSepia","root","root");
                   
                } catch (Exception e) {
                }
            }
            return CONEXION;
        }
        
        public static void closeConnection() throws SQLException{
            try {
                if(CONEXION!=null){
                    CONEXION.close();
                    CONEXION=null;
                }
            } catch (Exception e) {
            }
        }
}
