package com.example.ef_g1.Servlets;

import com.example.ef_g1.Daos.FuncionesDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RolGestorServlet", value = "/RolGestorServlet")
public class RolGestorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action")==null?"listar":request.getParameter("action");
        FuncionesDao funcionesDao = new FuncionesDao();
        RequestDispatcher view;
        switch (action){
            case "listar"->{
                request.setAttribute("ListaCartelera",funcionesDao.listarFuncionesCartelera());
                view = request.getRequestDispatcher("RolGestor.jsp");
                view.forward(request, response);
            }
            case "crear"->{
                request.setAttribute("listaCines", funcionesDao.listaCines());
                request.setAttribute("listaPeliculas", funcionesDao.listaPeliculas());
                view = request.getRequestDispatcher("Formulario.jsp");
                view.forward(request, response);
            }
            case "eliminar" -> {
                request.getParameter("id")
                funcionesDao.
            }
            default -> {response.sendRedirect(request.getContextPath());}
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
