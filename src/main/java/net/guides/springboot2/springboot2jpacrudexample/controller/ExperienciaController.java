package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Experiencia;
import net.guides.springboot2.springboot2jpacrudexample.repository.ExperienciaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class ExperienciaController {
	@Autowired
	private ExperienciaRepository experienciaRepository;

	@GetMapping("/experiencias")
	public List<Experiencia> getAllExperiencias() {
		return experienciaRepository.findAll();
	}

	@GetMapping("/experiencias/{id}")
	public ResponseEntity<Experiencia> getExperienciaById(@PathVariable(value = "id") Long experienciaId)
			throws ResourceNotFoundException {
		Experiencia experiencia = experienciaRepository.findById(experienciaId)
				.orElseThrow(() -> new ResourceNotFoundException("Experiencia not found for this id :: " + experienciaId));
		return ResponseEntity.ok().body(experiencia);
	}

	@PostMapping("/experiencias")
	public Experiencia createExperiencia(@Valid @RequestBody Experiencia experiencia) {
		return experienciaRepository.save(experiencia);
	}

	@PutMapping("/experiencias/{id}")
	public ResponseEntity<Experiencia> updateExperiencia(@PathVariable(value = "id") Long experienciaId,
			@Valid @RequestBody Experiencia experienciaDetails) throws ResourceNotFoundException {
		Experiencia experiencia = experienciaRepository.findById(experienciaId)
				.orElseThrow(() -> new ResourceNotFoundException("Experiencia not found for this id :: " + experienciaId));

		experiencia.setId(experienciaDetails.getId());
        experiencia.setCargo(experienciaDetails.getCargo());
        experiencia.setFuncao(experienciaDetails.getFuncao());
        experiencia.setCandidato_id(experienciaDetails.getCandidato_id());
        
		final Experiencia updatedExperiencia = experienciaRepository.save(experiencia);
		return ResponseEntity.ok(updatedExperiencia);
	}

	@DeleteMapping("/experiencias/{id}")
	public Map<String, Boolean> deleteExperiencia(@PathVariable(value = "id") Long experienciaId)
			throws ResourceNotFoundException {
		Experiencia experiencia = experienciaRepository.findById(experienciaId)
				.orElseThrow(() -> new ResourceNotFoundException("Experiencia not found for this id :: " + experienciaId));

		experienciaRepository.delete(experiencia);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
