package com.example.ef_g1.Daos;

import com.example.ef_g1.Beans.Cadena;
import com.example.ef_g1.Beans.Cine;
import com.example.ef_g1.Beans.Empleado;

import java.sql.*;
import java.util.ArrayList;

public class ReportesDao extends BaseDao{

    public int cantidadEmpleadosSinJefe(){
        int ola = 0;
        String sql = "select count(*) from empleado where idjefe is null";
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            if (resultSet.next()) {
                ola = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Hubo un error en la conexión!");
            e.printStackTrace();
        }
        return ola;
    }


    public Integer cantidadPeliculas3D(){
        int chau = 0;
        String sql = "select count(*) from cartelera where 3d=1";
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            if (resultSet.next()) {
                chau = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Hubo un error en la conexión!");
            e.printStackTrace();
        }
        return chau;
    }

    public Integer cantidadEmpleados9700(){
        int samir = 0;
        String sql = "select *  from cine c, empleado e where c.idcine = e.idcine and e.salario > 9700 group by c.idcine";
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while (resultSet.next()) {
                samir++;
            }

        } catch (SQLException e) {
            System.out.println("Hubo un error en la conexión!");
            e.printStackTrace();
        }
        return samir;
    }

    public Integer idCadenaMayorCantidad(){
        int owo = 0;
        String sql = "select t.idcadena  from (select count(*) as ´jugis´, ca.idcadena from cadena ca inner join cine ci on ca.idcadena = ci.idcadena\n" +
                "inner join cartelera co on ci.idcine = co.idcine group by ca.idcadena) t\n" +
                "where  t.´jugis´ =  (select max(t1.´jugis´) from (select count(*) as ´jugis´, ca.idcadena from cadena ca inner join cine ci on ca.idcadena = ci.idcadena\n" +
                "inner join cartelera co on ci.idcine = co.idcine group by ca.idcadena) t1 )";
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            if (resultSet.next()) {
                owo = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Hubo un error en la conexión!");
            e.printStackTrace();
        }
        return owo;
    }

    public ArrayList<Empleado> obtenerEmpleadosSinJefe(){
        ArrayList<Empleado> empleados = new ArrayList<>();
        int jin = 0;
        Boolean o = false;
        String sql = "select * from empleado e, cine c where e.idcine = c.idcine and  e.idjefe is null";
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while (resultSet.next()) {
                Empleado e = new Empleado();
                e.setIdEmpleado(resultSet.getInt(1));
                e.setNombre(resultSet.getString(2));
                e.setApellido(resultSet.getString(3));
                e.setDni(resultSet.getString(4));
                e.setSalario(resultSet.getBigDecimal(5));
                e.setFechaContrato(resultSet.getString(6));
                e.setNombreUsuario(resultSet.getString(7));
                e.setEdad(resultSet.getInt(8));
                jin = resultSet.getInt(resultSet.getInt(9));
                if(jin==1) o = true;
                else o = false;
                e.setActivo(o);
                Cine cine = new Cine();
                cine.setNombre(resultSet.getString(13));
                e.setCine(cine);
                empleados.add(e);
            }

        } catch (SQLException e) {
            System.out.println("Hubo un error en la conexión!");
            e.printStackTrace();
        }
        return  empleados;
    }

    public Cadena obtenerCadena(int idcadena){
        Cadena cadena = null;
        String sql = "select * from cadena where idcadena = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idcadena);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    cadena = new Cadena();
                    cadena.setRazonSocial(resultSet.getString(2));
                    cadena.setNombreComercial(resultSet.getString(3));
                    cadena.setRuc(resultSet.getString(4));
                }
            }

        } catch (SQLException e) {
            System.out.println("Hubo un error en la conexión!");
            e.printStackTrace();
        }

        return cadena;
    }

}
