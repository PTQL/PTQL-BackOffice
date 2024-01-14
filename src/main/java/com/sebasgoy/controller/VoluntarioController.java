package com.sebasgoy.controller;

import com.sebasgoy.dto.Voluntario;
import com.sebasgoy.service.VoluntarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntario")
@AllArgsConstructor
public class VoluntarioController {

	private final VoluntarioService voluntarioService;
	
	@GetMapping
	public List<Voluntario> getAllVoluntarios(){
		return voluntarioService.getAll();
	}
	@PostMapping("/registro")
	public ResponseEntity<Voluntario> guardarVoluntario(@RequestBody Voluntario voluntario){
		Voluntario response = null;
		try {
			response = voluntarioService.saveVoluntario(voluntario);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}





	
}