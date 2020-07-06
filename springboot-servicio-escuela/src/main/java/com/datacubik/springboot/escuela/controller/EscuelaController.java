package com.datacubik.springboot.escuela.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.datacubik.springboot.escuela.model.Escuela;
import com.datacubik.springboot.escuela.model.Estudiante;
import com.datacubik.springboot.escuela.model.service.IEscuelaService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
public class EscuelaController {
	
	@Autowired
	@Qualifier("serviceFeign")
	private IEscuelaService escuelaService;
	
	@GetMapping("/echoEscuela")
	public Escuela echoEscuela() {
		return new Escuela();
	}
	
	@GetMapping("/listarEstudiantes")
	public List<Estudiante> listarEstudiantes(){
		return escuelaService.findAll();
	}
	
	@HystrixCommand(fallbackMethod = "detalleEstudianteFallback")
	@GetMapping("/detalleEstudiante/{id}")
	public Estudiante detalleEstudiante(@PathVariable int id) {
		return escuelaService.findById(id);
	}
	
	public Estudiante detalleEstudianteFallback(int id) {
		Estudiante e = new Estudiante();
		e.setNombre("Error desde fallback");
		return e;
	}

}