/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ClienteDAO;
import VO.Cliente;
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
 * @author Richard Alejandro
 */
public class ControladorCliente extends HttpServlet {
     ClienteDAO daoC;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
    
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
     
     public void init() throws ServletException {
        this.daoC = new ClienteDAO();
    }
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
    List<Cliente> pp = new ArrayList<>();
   int id = Integer.parseInt(request.getParameter("ID"));
   Cliente c = null;
   if(id != 0){
       try {
          c= this.daoC.buscar(id);
          pp.add(c);
          request.setAttribute("lista", pp);
            RequestDispatcher rq = request.getRequestDispatcher("GestionarClientes.jsp");
            rq.forward(request, response);
          
       } catch (SQLException ex) {
           Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
       }
    
   }

}
if(request.getParameter("eliminar") != null){
   int id = Integer.parseInt(request.getParameter("ID"));
   Cliente c = null;
   if(id != 0){
       try {
            c =this.daoC.buscar(id);
           this.daoC.borrar(c);
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
     String id = (request.getParameter("ID"));
        String nombre = (request.getParameter("Nombre"));
        String direccion = (request.getParameter("Direccion"));
        String telefono = (request.getParameter("Telefono"));
        
        if (id != null && nombre.length() > 0) {
            Cliente cliente = new Cliente(id, nombre, direccion, telefono);
            
            try {
                this.daoC.insertar(cliente);
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
        List<Cliente> clientes = null;
        try {
            clientes = this.daoC.BuscarTodo();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            request.setAttribute("lista", clientes);
            RequestDispatcher rq = request.getRequestDispatcher("GestionarClientes.jsp");
            rq.forward(request, response);
    
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
