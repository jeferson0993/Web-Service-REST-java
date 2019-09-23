package br.com.restful.controller;

import br.com.restful.dao.VagaDAO;
import br.com.restful.model.Vaga;

import java.util.ArrayList;

public class VagaController {

	public ArrayList<Vaga> listarTodos() {
		System.out.println("Controller: listarTodos ");
		return VagaDAO.getInstance().listarTodos();

	}

	public Vaga buscarPorId(long id) {
		System.out.println("Controller: buscarPorId - " + id);
		VagaDAO dao = new VagaDAO();
		Vaga vaga = dao.getById(id);
		return vaga;
	}

	public boolean gravarvaga(Vaga vaga) {
		System.out.println("Controller: gravarvaga " + vaga.getNome());
		return new VagaDAO().insert(vaga);
	}

	public boolean atualizarvaga(Vaga vaga) {
		System.out.println("Controller: atualizarvaga " + vaga.getNome());
		return VagaDAO.getInstance().update(vaga);
	}

	public boolean deletarvaga(Vaga vaga) {
		System.out.println("Controller: deletarvaga " + vaga.getNome());
		return VagaDAO.getInstance().delete(vaga);
	}

}
