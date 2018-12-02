/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.EmpleadoDAO;
import VO.Empleado;
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
public class ControladorEmpleado extends HttpServlet {
 EmpleadoDAO daoE;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  

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
    public void init() throws ServletException {
        this.daoE= new EmpleadoDAO();
    }
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
    List<Empleado> pp = new ArrayList<>();
   int id = Integer.parseInt(request.getParameter("Id_Emp"));
   Empleado e = null;
   if(id != 0){
       try {
          e= this.daoE.Buscar(id);
          pp.add(e);
          request.setAttribute("lista", pp);
            RequestDispatcher rq = request.getRequestDispatcher("GestionarEmpleados.jsp");
            rq.forward(request, response);
           System.out.println(pp.size());
       } catch (SQLException ex) {
           Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
       }
    
   }

}
if(request.getParameter("eliminar") != null){
   int id = Integer.parseInt(request.getParameter("Id_Emp"));
   Empleado e = null;
   if(id != 0){
       try {
            e =this.daoE.Buscar(id);
           this.daoE.borrar(e);
           listar(request, response);
       } catch (SQLException ex) {
           Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
       }
      
   }
}
        //Capturar los parametros.
        // nombre--> el name de la clase donde está el login.
       
//Validaciones - SQL Inyection.
if (request.getParameter("agregar") != null) {
     int id = Integer.parseInt(request.getParameter("Id_Emp"));
        String nombre = (request.getParameter("Nombre"));
        String usuario = (request.getParameter("Usuario"));
        String clave = (request.getParameter("Clave"));
        
        if (id != 0 && nombre.length() > 0) {
            Empleado empleado = new Empleado(id, nombre, usuario, clave);
                    
                    
            
            try {
                this.daoE.insertar(empleado);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
            listar(request, response);

        } else {
            //si no se captura bien los datos
            response.sendRedirect("GestionarEmpleados.jsp?error=IngreseDatos");
        }
    }
    }
    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Empleado> Inventario = null;
        try {
            Inventario = this.daoE.BuscarTodo();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            request.setAttribute("lista", Inventario);
            RequestDispatcher rq = request.getRequestDispatcher("GestionarEmpleados.jsp");
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
