package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.CandidatoDAO;
import br.com.restful.model.Candidato;

public class CandidatoController {

	public ArrayList<Candidato> listarTodos() {
		System.out.println("Controller: listarTodos ");
		return CandidatoDAO.getInstance().listarTodos();

	}

	public Candidato buscarPorId(long id) {
		System.out.println("Controller: buscarPorId - " + id);
		CandidatoDAO dao = new CandidatoDAO();
		Candidato candidato = dao.getById(id);
		return candidato;
	}

	public boolean gravarCandidato(Candidato candidato) {
		System.out.println("Controller: gravarCandidato " + candidato.getNome());
		return new CandidatoDAO().insert(candidato);
	}

	public boolean atualizarCandidato(Candidato candidato) {
		System.out.println("Controller: atualizarCandidato " + candidato.getNome());
		return CandidatoDAO.getInstance().update(candidato);
	}

	public boolean deletarCandidato(Candidato candidato) {
		System.out.println("Controller: deletarCandidato " + candidato.getNome());
		return CandidatoDAO.getInstance().delete(candidato);
	}

}
