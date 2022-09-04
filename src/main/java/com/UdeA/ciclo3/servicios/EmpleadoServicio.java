package com.UdeA.ciclo3.servicios;

import com.UdeA.ciclo3.modelos.Empleado;
import com.UdeA.ciclo3.modelos.Empresa;
import com.UdeA.ciclo3.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicio {

    @Autowired
    EmpleadoRepositorio empleadoRepositorio;

    public List<Empleado> getTodosEmpleados() {
        List<Empleado> empleadoList = new ArrayList<>();
        empleadoRepositorio.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;
    }

    public Empleado getEmpleadoPorId(Long id) {
        return empleadoRepositorio.findById(id).get();
    }

    public boolean crearOModificarEmpleado(Empleado empleado) {
        Empleado emple = empleadoRepositorio.save(empleado);
        if (empleadoRepositorio.findById(emple.getId()) != null) {
            return true;
        }
        return false;
    }

    public boolean eliminarEmpleado(Long id){
        empleadoRepositorio.deleteById(id);
        if(getEmpleadoPorId(id)!= null){
            return false;
    }
    return true;
}



}
