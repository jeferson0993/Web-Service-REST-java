package br.com.restful.dao;

import br.com.restful.model.Experiencia;

import java.util.List;

public interface ExperienciaDAOinterface {

	public Experiencia save(Experiencia experiencia);

	public boolean delete(Experiencia experiencia);

	public boolean update(Experiencia experiencia);

	public Experiencia findById(Experiencia experiencia);

	public List<Experiencia> findByName(Experiencia experiencia);

	public List<Experiencia> findAll();
}
