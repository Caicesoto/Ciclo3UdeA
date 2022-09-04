package com.UdeA.ciclo3.servicios;

import com.UdeA.ciclo3.modelos.Empresa;
import com.UdeA.ciclo3.repositorio.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaServicio {
    @Autowired
    EmpresaRepositorio empresaRepositorio;

    public List<Empresa> getTodasEmpresas() {
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepositorio.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;
    }
    public Empresa getEmpresaporId(Long id){
        return empresaRepositorio.findById(id).get();
    }
    public boolean crearOModificarEmpresa(Empresa empresa){
        Empresa emp=empresaRepositorio.save(empresa);
        if(empresaRepositorio.findById(emp.getId())!=null){
            return true;
        }
        return false;
    }
    public boolean eliminarEmpresa(Long id){
        empresaRepositorio.deleteById(id);
        if(getEmpresaporId(id)!=null){
            return false;

        }
        return true;
    }


}
