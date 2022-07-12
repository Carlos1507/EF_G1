package com.example.ef_g1.Daos;

import com.example.ef_g1.Beans.Cine;
import com.example.ef_g1.Beans.Empleado;
import com.example.ef_g1.Beans.Rol;
import com.example.ef_g1.Dto.RolesEmpleadosDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao extends BaseDao {
    public RolesEmpleadosDto existeEmpleado(int user, int pass) throws SQLException {
        RolesEmpleadosDto empleadosDto= new RolesEmpleadosDto();
        String sql="select * from empleado e " +
                "inner join rolempleado r on e.idempleado = r.idempleado " +
                "inner join rol r2 on r.idrol = r2.idrol " +
                "left join empleado j on j.idempleado= e.idjefe " +
                "where e.dni=? and (e.dni-e.salario)=?";
        try(Connection conn= this.getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql);){
            pstmt.setInt(1, user);
            pstmt.setInt(2, pass);
            try(ResultSet rs= pstmt.executeQuery();){
                if(rs.next()){
                    Empleado e= new Empleado();
                    e.setIdEmpleado(rs.getInt(1));
                    e.setNombre(rs.getString(2));
                    e.setApellido(rs.getString(3));
                    e.setDni(rs.getString(4));
                    e.setSalario(rs.getBigDecimal(5));
                    e.setFechaContrato(rs.getString(6));
                    e.setNombreUsuario(rs.getString(7));
                    e.setEdad(rs.getInt(8));
                    e.setActivo(rs.getBoolean(9));
                    Cine cine= new Cine();
                    cine.setIdCine(10);
                    e.setCine(cine);

                    Empleado jefe= new Empleado();
                    jefe.setIdEmpleado(rs.getInt(16));
                    jefe.setNombre(rs.getString(17));
                    jefe.setApellido(rs.getString(18));
                    e.setJefe(jefe);

                    Rol rol= new Rol();
                    rol.setIdRol(rs.getInt(14));
                    rol.setNombre(rs.getString(15));

                    empleadosDto.setE(e);
                    empleadosDto.setRol(rol);
                }
            }
        }
        return empleadosDto;
    }
}
