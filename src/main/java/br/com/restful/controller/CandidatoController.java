package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.CandidatoDAO;
import br.com.restful.model.Candidato;

public class CandidatoController {

    public ArrayList<Candidato> listarTodos() {
        return CandidatoDAO.getInstance().listarTodos();

    }

    public Candidato buscarPorId(long id) {
        CandidatoDAO dao = new CandidatoDAO();
        Candidato candidato = dao.getById(id);
        return candidato;
    }

    public boolean gravarCandidato(Candidato candidato) {
        return new CandidatoDAO().insert(candidato);
    }

    public boolean atualizarCandidato(Candidato candidato) {
        return CandidatoDAO.getInstance().update(candidato);
    }

    public boolean deletarCandidato(Candidato candidato) {
        return CandidatoDAO.getInstance().delete(candidato);
    }

    public ArrayList<Candidato> buscarPorNome(String nome) {
        return CandidatoDAO.getInstance().listBySomething("nome", nome);
    }

    public ArrayList<Candidato> buscarPorSexo(String sexo) {
        return CandidatoDAO.getInstance().listBySomething("sexo", sexo);
    }

    public ArrayList<Candidato> buscarPorEstadoCivil(String estado_civil) {
        return CandidatoDAO.getInstance().listBySomething("estadoCivil", estado_civil);
    }

}
