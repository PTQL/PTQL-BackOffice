package com.sebasgoy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

  
@Controller
@AllArgsConstructor
public class WebController {

	@GetMapping("/")
	public String cargarPaginaPrincipal() {
		return "PaginaPrincipal";
	}
	
}
