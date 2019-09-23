package br.com.restful.dao;

import br.com.restful.model.Empresa;

import java.util.List;

public interface EmpresaDAOinterface {

	public Empresa save(Empresa empresa);

	public boolean delete(Empresa empresa);

	public boolean update(Empresa empresa);

	public Empresa findById(Empresa empresa);

	public List<Empresa> findByName(Empresa empresa);

	public List<Empresa> findAll();
}
