package com.example.ef_g1.Filters;

import com.example.ef_g1.Dto.RolesEmpleadosDto;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "GestorFiltro", value = "/RolGestorServlet")
public class GestorFiltro implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse res= (HttpServletResponse) response;
        HttpServletRequest req= (HttpServletRequest) request;
        RolesEmpleadosDto usuario= (RolesEmpleadosDto)req.getSession().getAttribute("usuario");

        if(usuario==null || usuario.getE()==null){
            res.sendRedirect(req.getContextPath());
        }else{

            if(usuario.getRol().getNombre().equals("gestor")){
                //Borramos caché
                res.setHeader("Pragma", "No-cache");
                res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                res.setDateHeader("Expires", 0);
                //Borramos caché
                chain.doFilter(req,res);
            }else{
                if(usuario.getRol().getNombre().equals("vendedor")){
                    res.sendRedirect(req.getContextPath()+"/RolVendedorServlet");
                }else{
                    res.sendRedirect(req.getContextPath());
                }
            }
        }
    }
}
