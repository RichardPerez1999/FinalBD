/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;



import Modelo.ProductoDAO;
import VO.Producto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LabingXEON
 */
public class ControladorProductos extends HttpServlet {

    ProductoDAO daop;

    //es el constructor del Servlet
    @Override
    public void init() throws ServletException {
        this.daop = new ProductoDAO();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
if(request.getParameter("Cargar") != null){
    listar(request, response);
}
if(request.getParameter("buscar") != null){
    List<Producto> pp = new ArrayList<>();
   int id = Integer.parseInt(request.getParameter("ID"));
   Producto p = null;
   if(id != 0){
       try {
          p= this.daop.Buscar(id);
          pp.add(p);
          request.setAttribute("lista", pp);
            RequestDispatcher rq = request.getRequestDispatcher("GestionarProducto.jsp");
            rq.forward(request, response);
           System.out.println(pp.size());
       } catch (SQLException ex) {
           Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
       }
    
   }

}
if(request.getParameter("eliminar") != null){
   int id = Integer.parseInt(request.getParameter("ID"));
   Producto p = null;
   if(id != 0){
       try {
            p =this.daop.Buscar(id);
           this.daop.borrar(p);
           listar(request, response);
       } catch (SQLException ex) {
           Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
       }
      
   }
}
        //Capturar los parametros.
        // nombre--> el name de la clase donde está el login.
       
//Validaciones - SQL Inyection.
if (request.getParameter("agregar") != null) {
     int id = Integer.parseInt(request.getParameter("ID"));
        int cantidad = Integer.parseInt(request.getParameter("Cantidad"));
       
        String nombre = (request.getParameter("Nombre"));
        float PrecioCompra = Float.parseFloat(request.getParameter("PrecioCompra"));
         float PrecioVenta = Float.parseFloat(request.getParameter("PrecioVenta"));
        
        if (id != 0 && nombre.length() > 0) {
            Producto producto = new Producto(id, nombre, cantidad, PrecioCompra, PrecioVenta);
            
            try {
                this.daop.insertar(producto);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
            listar(request, response);

        } else {
            //si no se captura bien los datos
            response.sendRedirect("GestionarProducto.jsp?error=IngreseDatos");
        }
    }
    }
    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Producto> Inventario = null;
        try {
            Inventario = this.daop.BuscarTodo();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            request.setAttribute("lista", Inventario);
            RequestDispatcher rq = request.getRequestDispatcher("GestionarProducto.jsp");
            rq.forward(request, response);
    
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
