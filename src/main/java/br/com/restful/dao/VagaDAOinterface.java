package br.com.restful.dao;

import br.com.restful.model.Vaga;

import java.util.List;

public interface VagaDAOinterface {

	public Vaga save(Vaga vaga);

	public boolean delete(Vaga vaga);

	public boolean update(Vaga vaga);

	public Vaga findById(Vaga vaga);

	public List<Vaga> findByName(Vaga vaga);

	public List<Vaga> findAll();
}
