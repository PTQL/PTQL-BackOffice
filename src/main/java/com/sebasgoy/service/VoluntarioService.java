package com.sebasgoy.service;


import com.sebasgoy.dto.Actividad;
import com.sebasgoy.dto.Voluntario;
import com.sebasgoy.repository.IVoluntarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VoluntarioService {

    public Long UltimoId() {
        List<Voluntario> activos = getAll();

        if (activos.isEmpty()) {
            return 1L;
        }
        Voluntario ultimoElemento = activos.get(activos.size() - 1);

        return ultimoElemento.getId() + 1;
    }

    private IVoluntarioRepository iVoluntarioRepository;

    public Voluntario findById(Long id){
        return  iVoluntarioRepository.findById(id).orElse(new Voluntario());
    }
    public Optional<Voluntario> findByIdOptional(Long id){
        return  iVoluntarioRepository.findById(id);
    }
    
    public void deleteVoluntario(Voluntario voluntario) {
    	
    	iVoluntarioRepository.delete(voluntario);
    	
    }

    public List<Voluntario> findVoluntarioOfModulo(Long idModulo){
        return iVoluntarioRepository.findVoluntarioByModuloId(idModulo);
    }
    public Voluntario findByDni(String dni){
        return  iVoluntarioRepository.findByDni(dni);
    }
    public boolean existsByDni(String dni){
        return  iVoluntarioRepository.existsByDni(dni);
    }
    
    public List<Voluntario> getAll(){
        return iVoluntarioRepository.findAll();
    }
    public List<Voluntario> getAllWithoutActivity(Actividad actividad){

        List<Voluntario> listVoluntario = iVoluntarioRepository.findAll();

        return listVoluntario.stream()
                .filter(voluntario -> voluntario.getParticipante().stream()
                        .noneMatch(participante -> Objects.equals(participante.getIdActividad(), actividad.getId())))
                .collect(Collectors.toList());
    }
    public void saveVoluntario(Voluntario voluntario) {
        iVoluntarioRepository.save(voluntario);


    }
    


}
