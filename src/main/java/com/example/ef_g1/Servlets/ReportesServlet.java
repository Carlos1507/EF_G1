package com.example.ef_g1.Servlets;

import com.example.ef_g1.Daos.ReportesDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReportesServlet", value = "/ReportesServlet")
public class ReportesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        ReportesDao reportesDao = new ReportesDao();
        if(action.equals("listar")){
            request.setAttribute("sinjefe", reportesDao.cantidadEmpleadosSinJefe());
            request.setAttribute("peliculas3d",reportesDao.cantidadPeliculas3D());
            request.setAttribute("empleados9700",reportesDao.cantidadEmpleados9700());
            request.setAttribute("cadena",reportesDao.obtenerCadena(reportesDao.idCadenaMayorCantidad()));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ReporteAdmin.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        ReportesDao reportesDao = new ReportesDao();
        if(action.equals("listar1")){
            try {
                String eso = request.getParameter("ola");
                if (eso != null){
                    request.setAttribute("empleadosSinJefe",reportesDao.obtenerEmpleadosSinJefe());
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("");
                    requestDispatcher.forward(request,response);
                }else {
                    response.sendRedirect(request.getContextPath()+"/ReportesServlet");
                }
            }catch (NullPointerException e){
                e.printStackTrace();
            }

        }else{
            response.sendRedirect(request.getContextPath() + "/ReportesServlet");
        }
    }
}
