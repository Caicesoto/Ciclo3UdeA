package com.UdeA.ciclo3;

import com.UdeA.ciclo3.modelos.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.SchemaOutputResolver;

@RestController
@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class Ciclo3Application {

	@GetMapping("/hello")
	public String hello(){
		return "Hola ciclo 3 ... Salderms vivos de esto";
	}

	@GetMapping("/test")
	public String test(){
		Empresa empresa = new Empresa("FRUTI DULCES", "CALLE 5 #95 -24", "7895625", "800221314-5");
		empresa.setNombre("PRODUCTOS FRUTI DULCES");
		return empresa.getNombre();
	}



	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);

	}

}
