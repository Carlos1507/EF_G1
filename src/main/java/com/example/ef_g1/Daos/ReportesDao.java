package com.example.ef_g1.Daos;

import com.example.ef_g1.Beans.Empleado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ReportesDao extends BaseDao{

    public Integer cantidadEmpleadosSinJefe(){
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

    public ArrayList<Empleado> empleadosSinJefe(){

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

    public ArrayList<Empleado> obtenerEmpleados(){
        ArrayList<Empleado> empleados = new ArrayList<>();

        return  empleados;
    }
}
