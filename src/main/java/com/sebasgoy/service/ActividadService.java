package com.sebasgoy.service;

import java.util.List;

import com.sebasgoy.repository.IActividadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.sebasgoy.dto.Actividad;


/*En un service va la logica de negocio*/
@Service
@AllArgsConstructor
public class ActividadService {

	private final IActividadRepository iActividadRepository;

	public Actividad findById(Long id){
		return  iActividadRepository.findById(id).orElse(new Actividad());
	}

	public List<Actividad> getAll(){
		return iActividadRepository.findAll();
	}
	public Actividad saveActividad(Actividad actividad) {
		return iActividadRepository.save(actividad);
	}


}