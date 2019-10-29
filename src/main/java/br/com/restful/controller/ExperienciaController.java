package br.com.restful.controller;

import br.com.restful.dao.ExperienciaDAO;
import br.com.restful.model.Experiencia;

import java.util.ArrayList;

public class ExperienciaController {

    public ArrayList<Experiencia> listarTodos() {
        System.out.println("ExperienciaController: listarTodas ");
        return ExperienciaDAO.getInstance().listarTodos();
    }

    public ArrayList<Experiencia> listarTodos(int candidato_id) {
        System.out.println("ExperienciaController.listarTodos(candidato_id = " + candidato_id + ")");
        return ExperienciaDAO.getInstance().listarTodos(candidato_id);
    }

    public Experiencia buscarPorId(long id) {
        System.out.println("ExperienciaController: buscarPorId - " + id);
        ExperienciaDAO dao = new ExperienciaDAO();
        Experiencia experiencia = dao.getById(id);
        return experiencia;
    }

    public boolean gravarexperiencia(Experiencia experiencia) {
        System.out.println("ExperienciaController: gravarexperiencia " + experiencia.getCargo());
        return new ExperienciaDAO().insert(experiencia);
    }

    public boolean atualizarexperiencia(Experiencia experiencia) {
        System.out.println("ExperienciaController: atualizarexperiencia " + experiencia.getCargo());
        return ExperienciaDAO.getInstance().update(experiencia);
    }

    public boolean deletarexperiencia(Experiencia experiencia) {
        System.out.println("ExperienciaController: deletarexperiencia " + experiencia.getCargo());
        return ExperienciaDAO.getInstance().delete(experiencia);
    }

}
