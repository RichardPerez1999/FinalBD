package Modelo;

import java.sql.SQLException;
import java.util.List;


public interface IBaseDatos <T>{
    
    List<T> BuscarTodo() throws SQLException;
    boolean insertar(T t) throws SQLException;
    boolean actualizar(T t) throws SQLException;
    boolean borrar(T t) throws SQLException;
}
