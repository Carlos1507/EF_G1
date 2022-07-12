package com.example.ef_g1.Servlets;

import com.example.ef_g1.Beans.Empleado;
import com.example.ef_g1.Daos.LoginDao;
import com.example.ef_g1.Dto.RolesEmpleadosDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Login", value = {"","/Login"})
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();
        RolesEmpleadosDto usuario=(RolesEmpleadosDto)session.getAttribute("usuario");
        //Borramos caché
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setDateHeader("Expires", 0);
        //Borramos caché
        if(usuario!=null){
            String action= request.getParameter("action")==null?"":request.getParameter("action");
            switch (action){
                case "logout"->{
                    session.invalidate();
                    response.sendRedirect(request.getContextPath());
                }
                default -> {
                    if(usuario.getRol().getNombre().equals("vendedor")){
                        response.sendRedirect(request.getContextPath()+"/RolVendedorServlet");
                    }else{
                        if(usuario.getRol().getNombre().equals("gestor")){
                            response.sendRedirect(request.getContextPath()+"/RolGestorServlet");
                        }else{
                            response.sendRedirect(request.getContextPath());
                        }
                    }
                }
            }

        }else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action= request.getParameter("action");
    LoginDao login= new LoginDao();
    HttpSession session;
    switch (action){
        case "login":
            String user= request.getParameter("user");
            String pass= request.getParameter("pass");
            RolesEmpleadosDto e;
            try{
                int dni= Integer.parseInt(user);
                int dniSalario= Integer.parseInt(pass);
                try {
                    if((int)Math.log10(dni)+1==8){
                        e = login.existeEmpleado(dni,dniSalario);
                        if(e.getE()!=null){
                            session= request.getSession();
                            session.setAttribute("usuario",e);
                            response.sendRedirect(request.getContextPath()+"/RolGestorServlet");
                        }else{
                            System.out.println("No existes");
                            session= request.getSession();
                            session.setAttribute("msg","noExiste");
                            response.sendRedirect(request.getContextPath());
                        }
                    }else{
                        session= request.getSession();
                        session.setAttribute("msg","errorDNItam");
                        response.sendRedirect(request.getContextPath());
                    }
                } catch (SQLException ex) {
                    session= request.getSession();
                    session.setAttribute("msg","errorSQL");
                    response.sendRedirect(request.getContextPath());
                }
            }catch (NumberFormatException n){
                System.out.println("No ingreso un numero");
                session= request.getSession();
                session.setAttribute("msg","errorNumero");
                response.sendRedirect(request.getContextPath());
            }
            break;
    }
    }
}
