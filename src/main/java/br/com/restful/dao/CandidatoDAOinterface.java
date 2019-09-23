package br.com.restful.dao;

import br.com.restful.model.Candidato;

import java.util.List;

public interface CandidatoDAOinterface {

	public Candidato save(Candidato candidato);

	public boolean delete(Candidato candidato);

	public boolean update(Candidato candidato);

	public Candidato findById(Candidato candidato);

	public List<Candidato> findByName(Candidato candidato);

	public List<Candidato> findAll();
}
