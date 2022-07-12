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
        switch (action){
            case "listar"->{
                request.setAttribute("ListaCartelera",funcionesDao.listarFuncionesCartelera());
                RequestDispatcher view = request.getRequestDispatcher("RolGestor.jsp");
                view.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
