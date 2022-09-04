package com.UdeA.ciclo3.controlador;

import com.UdeA.ciclo3.modelos.Empresa;
import com.UdeA.ciclo3.servicios.EmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class Controlador {

    @Autowired
    EmpresaServicio empresaServicio;

    @GetMapping ({"/Empresas","/VerEmpresas"})
    public String vistaEmpresas(Model model){
        List<Empresa> listaEmpresas=empresaServicio.getTodasEmpresas();
        model.addAttribute("emplista",listaEmpresas);
        return "verEmpresas";

    }


}
