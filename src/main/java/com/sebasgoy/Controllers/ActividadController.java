package com.sebasgoy.Controllers;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sebasgoy.Models.Actividad;
import com.sebasgoy.Service.ActividadService;

 
@RestController
@RequestMapping("/api/actividad")
@AllArgsConstructor
public class ActividadController {

	private final ActividadService actividadService;
	
	@GetMapping
	public List<Actividad> getAllActividades(){
		return actividadService.getAll();
	}

	@PostMapping("/registro")
	public  ResponseEntity<Actividad> guardarActividad(@RequestBody Actividad actividad) {
		Actividad response = null;
		try {
			response = actividadService.saveActividad(actividad);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}






	
}
