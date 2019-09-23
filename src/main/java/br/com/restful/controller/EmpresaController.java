package br.com.restful.controller;

import br.com.restful.dao.EmpresaDAO;
import br.com.restful.model.Empresa;

import java.util.ArrayList;

public class EmpresaController {

	public ArrayList<Empresa> listarTodos() {
		System.out.println("Controller: listarTodos ");
		return EmpresaDAO.getInstance().listarTodos();

	}

	public Empresa buscarPorId(long id) {
		System.out.println("Controller: buscarPorId - " + id);
		EmpresaDAO dao = new EmpresaDAO();
		Empresa empresa = dao.getById(id);
		return empresa;
	}

	public boolean gravarEmpresa(Empresa empresa) {
		System.out.println("Controller: gravarEmpresa " + empresa.getRazaoSocial());
		return new EmpresaDAO().insert(empresa);
	}

	public boolean atualizarEmpresa(Empresa empresa) {
		System.out.println("Controller: atualizarEmpresa " + empresa.getRazaoSocial());
		return EmpresaDAO.getInstance().update(empresa);
	}

	public boolean deletarEmpresa(Empresa empresa) {
		System.out.println("Controller: deletarEmpresa " + empresa.getRazaoSocial());
		return EmpresaDAO.getInstance().delete(empresa);
	}

}
