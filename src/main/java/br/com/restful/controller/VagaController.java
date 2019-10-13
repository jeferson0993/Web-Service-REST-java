package br.com.restful.controller;

import br.com.restful.dao.VagaDAO;
import br.com.restful.model.Vaga;

import java.util.ArrayList;

public class VagaController {

    public ArrayList<Vaga> listarTodos() {
        System.out.println("VagaController: listarTodas ");
        return VagaDAO.getInstance().listarTodos();
    }

    public ArrayList<Vaga> listarTodos(int empresa_id) {
        System.out.println("VagaController.listarTodos(empresa_id = " + empresa_id + ")");
        return VagaDAO.getInstance().listarTodos(empresa_id);
    }

    public Vaga buscarPorId(long id) {
        System.out.println("VagaController: buscarPorId - " + id);
        VagaDAO dao = new VagaDAO();
        Vaga vaga = dao.getById(id);
        return vaga;
    }

    public boolean gravarvaga(Vaga vaga) {
        System.out.println("VagaController: gravarvaga " + vaga.getNome());
        return new VagaDAO().insert(vaga);
    }

    public boolean atualizarvaga(Vaga vaga) {
        System.out.println("VagaController: atualizarvaga " + vaga.getNome());
        return VagaDAO.getInstance().update(vaga);
    }

    public boolean deletarvaga(Vaga vaga) {
        System.out.println("VagaController: deletarvaga " + vaga.getNome());
        return VagaDAO.getInstance().delete(vaga);
    }

}
