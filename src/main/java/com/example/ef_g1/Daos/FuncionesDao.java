package com.example.ef_g1.Daos;

import com.example.ef_g1.Beans.Cadena;
import com.example.ef_g1.Beans.Cartelera;
import com.example.ef_g1.Beans.Cine;
import com.example.ef_g1.Beans.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionesDao extends BaseDao{
    public ArrayList<Cartelera> listarFuncionesCartelera(){
        ArrayList<Cartelera> carteleraFunciones = new ArrayList<>();
        String sql="select idCartelera, cad.nombre_comercial, cine.nombre, p.nombre, cart.`3d`, cart.subtitulada, cart.doblada, cart.horario\n" +
                "       from cartelera cart\n" +
                "inner join cine on cart.idcine = cine.idcine\n" +
                "inner join cadena cad on cine.idcadena = cad.idcadena\n" +
                "inner join pelicula p on cart.idpelicula = p.idpelicula;\n";
        try(Connection conn=this.getConnection();
            PreparedStatement ptmt= conn.prepareStatement(sql);){
            try(ResultSet rs = ptmt.executeQuery()){
                while(rs.next()){
                    Cartelera cartelera = new Cartelera();
                    Cine cine = new Cine();
                    Cadena cadena = new Cadena();
                    Pelicula pelicula = new Pelicula();
                    cartelera.setIdCartelera(rs.getInt(1));
                    cadena.setNombreComercial(rs.getString(2));
                    cine.setNombre(rs.getString(3));
                    pelicula.setNombre(rs.getString(4));
                    cartelera.setTresD(rs.getInt(5));
                    cartelera.setSubtitulada(rs.getInt(6));
                    cartelera.setDoblada(rs.getInt(7));
                    cartelera.setHorario(rs.getString(8));
                    cine.setCadena(cadena);
                    cartelera.setPelicula(pelicula);
                    cartelera.setCine(cine);
                    carteleraFunciones.add(cartelera);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carteleraFunciones;
    }
}
