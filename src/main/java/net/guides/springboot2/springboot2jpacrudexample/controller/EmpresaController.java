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
import net.guides.springboot2.springboot2jpacrudexample.model.Empresa;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmpresaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class EmpresaController {
	@Autowired
	private EmpresaRepository EmpresaRepository;

	@GetMapping("/empresas")
	public List<Empresa> getAllEmpresas() {
		return EmpresaRepository.findAll();
	}

	@GetMapping("/empresas/{id}")
	public ResponseEntity<Empresa> getEmpresaById(@PathVariable(value = "id") Long EmpresaId)
			throws ResourceNotFoundException {
		Empresa Empresa = EmpresaRepository.findById(EmpresaId)
				.orElseThrow(() -> new ResourceNotFoundException("Empresa not found for this id :: " + EmpresaId));
		return ResponseEntity.ok().body(Empresa);
	}

	@PostMapping("/empresas")
	public Empresa createEmpresa(@Valid @RequestBody Empresa Empresa) {
		return EmpresaRepository.save(Empresa);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/empresas/{id}")
	public ResponseEntity<Empresa> updateEmpresa(@PathVariable(value = "id") Long EmpresaId,
			@Valid @RequestBody Empresa EmpresaDetails) throws ResourceNotFoundException {
		Empresa Empresa = EmpresaRepository.findById(EmpresaId)
				.orElseThrow(() -> new ResourceNotFoundException("Empresa not found for this id :: " + EmpresaId));

		Empresa.setId(EmpresaDetails.getId());
        Empresa.setRazaoSocial(EmpresaDetails.getRazaoSocial());
        Empresa.setCnpj(EmpresaDetails.getCnpj());
        Empresa.setEndereco(EmpresaDetails.getEndereco());
        Empresa.setCidade(EmpresaDetails.getCidade());
        Empresa.setBairro(EmpresaDetails.getBairro());
        Empresa.setUf(EmpresaDetails.getUf());
        Empresa.setEmail(EmpresaDetails.getEmail());
        Empresa.setCep(EmpresaDetails.getCep());
        Empresa.setTelefone(EmpresaDetails.getTelefone());
        
		final Empresa updatedEmpresa = EmpresaRepository.save(Empresa);
		return ResponseEntity.ok(updatedEmpresa);
	}

	@DeleteMapping("/empresas/{id}")
	public Map<String, Boolean> deleteEmpresa(@PathVariable(value = "id") Long EmpresaId)
			throws ResourceNotFoundException {
		Empresa Empresa = EmpresaRepository.findById(EmpresaId)
				.orElseThrow(() -> new ResourceNotFoundException("Empresa not found for this id :: " + EmpresaId));

		EmpresaRepository.delete(Empresa);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
