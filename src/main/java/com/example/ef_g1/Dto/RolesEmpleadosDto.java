package com.example.ef_g1.Dto;

import com.example.ef_g1.Beans.Empleado;
import com.example.ef_g1.Beans.Rol;

public class RolesEmpleadosDto {
    private Rol rol;
    private Empleado e;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Empleado getE() {
        return e;
    }

    public void setE(Empleado e) {
        this.e = e;
    }
}
