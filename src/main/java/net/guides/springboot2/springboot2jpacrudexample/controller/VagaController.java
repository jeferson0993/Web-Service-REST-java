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
import net.guides.springboot2.springboot2jpacrudexample.model.Vaga;
import net.guides.springboot2.springboot2jpacrudexample.repository.VagaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class VagaController {
	@Autowired
	private VagaRepository vagaRepository;

	@GetMapping("/vagas")
	public List<Vaga> getAllVagas() {
		return vagaRepository.findAll();
	}

	@GetMapping("/vagas/{id}")
	public ResponseEntity<Vaga> getVagaById(@PathVariable(value = "id") Long vagaId)
			throws ResourceNotFoundException {
		Vaga vaga = vagaRepository.findById(vagaId)
				.orElseThrow(() -> new ResourceNotFoundException("Vaga not found for this id :: " + vagaId));
		return ResponseEntity.ok().body(vaga);
	}

	@PostMapping("/vagas")
	public Vaga createVaga(@Valid @RequestBody Vaga vaga) {
		return vagaRepository.save(vaga);
	}

	@PutMapping("/vagas/{id}")
	public ResponseEntity<Vaga> updateVaga(@PathVariable(value = "id") Long vagaId,
			@Valid @RequestBody Vaga vagaDetails) throws ResourceNotFoundException {
		Vaga vaga = vagaRepository.findById(vagaId)
				.orElseThrow(() -> new ResourceNotFoundException("Vaga not found for this id :: " + vagaId));

		vaga.setId(vagaDetails.getId());
        vaga.setNome(vagaDetails.getNome());
        vaga.setUf(vagaDetails.getUf());
        vaga.setValeTransporte(vagaDetails.getValeTransporte());
        vaga.setValeRefeicao(vagaDetails.getValeRefeicao());
        vaga.setEspecificacoes(vagaDetails.getEspecificacoes());
        vaga.setRemuneracao(vagaDetails.getRemuneracao());
        vaga.setTurno(vagaDetails.getTurno());
        vaga.setFormaContratacao(vagaDetails.getFormaContratacao());
        vaga.setEmpresa_id(vagaDetails.getEmpresa_id());
        vaga.setCidade(vagaDetails.getCidade());
        
		final Vaga updatedVaga = vagaRepository.save(vaga);
		return ResponseEntity.ok(updatedVaga);
	}

	@DeleteMapping("/vagas/{id}")
	public Map<String, Boolean> deleteVaga(@PathVariable(value = "id") Long vagaId)
			throws ResourceNotFoundException {
		Vaga vaga = vagaRepository.findById(vagaId)
				.orElseThrow(() -> new ResourceNotFoundException("Vaga not found for this id :: " + vagaId));

		vagaRepository.delete(vaga);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
