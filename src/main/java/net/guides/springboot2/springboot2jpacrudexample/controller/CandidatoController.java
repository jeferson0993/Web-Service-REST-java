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
import net.guides.springboot2.springboot2jpacrudexample.model.Candidato;
import net.guides.springboot2.springboot2jpacrudexample.repository.CandidatoRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class CandidatoController {
	@Autowired
	private CandidatoRepository candidatoRepository;

	@GetMapping("/candidatos")
	public List<Candidato> getAllCandidatos() {
		return candidatoRepository.findAll();
	}

	@GetMapping("/candidatos/{id}")
	public ResponseEntity<Candidato> getCandidatoById(@PathVariable(value = "id") Long candidatoId)
			throws ResourceNotFoundException {
		Candidato candidato = candidatoRepository.findById(candidatoId)
				.orElseThrow(() -> new ResourceNotFoundException("Candidato not found for this id :: " + candidatoId));
		return ResponseEntity.ok().body(candidato);
	}

	@PostMapping("/candidatos")
	public Candidato createCandidato(@Valid @RequestBody Candidato candidato) {
		return candidatoRepository.save(candidato);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/candidatos/{id}")
	public ResponseEntity<Candidato> updateCandidato(@PathVariable(value = "id") Long candidatoId,
			@Valid @RequestBody Candidato candidatoDetails) throws ResourceNotFoundException {
		Candidato candidato = candidatoRepository.findById(candidatoId)
				.orElseThrow(() -> new ResourceNotFoundException("Candidato not found for this id :: " + candidatoId));

		candidato.setId(candidatoDetails.getId());
        candidato.setNome(candidatoDetails.getNome());
        candidato.setCpf(candidatoDetails.getCpf());
        candidato.setDataNascimento(candidatoDetails.getDataNascimento());
        candidato.setRg(candidatoDetails.getRg());
        candidato.setSexo(candidatoDetails.getSexo());
        candidato.setEndereco(candidatoDetails.getEndereco());
        candidato.setTelefone(candidatoDetails.getTelefone());
        candidato.setEstadoCivil(candidatoDetails.getEstadoCivil());
        
		final Candidato updatedCandidato = candidatoRepository.save(candidato);
		return ResponseEntity.ok(updatedCandidato);
	}

	@DeleteMapping("/candidatos/{id}")
	public Map<String, Boolean> deleteCandidato(@PathVariable(value = "id") Long candidatoId)
			throws ResourceNotFoundException {
		Candidato candidato = candidatoRepository.findById(candidatoId)
				.orElseThrow(() -> new ResourceNotFoundException("Candidato not found for this id :: " + candidatoId));

		candidatoRepository.delete(candidato);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
