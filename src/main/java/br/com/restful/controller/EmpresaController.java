package br.com.restful.controller;

import br.com.restful.dao.EmpresaDAO;
import br.com.restful.model.Empresa;
import br.com.restful.model.Vaga;

import java.util.ArrayList;

public class EmpresaController {

    public ArrayList<Empresa> listarTodos() {
        return EmpresaDAO.getInstance().listarTodos();
    }

    public Empresa buscarPorId(long id) {
        EmpresaDAO dao = new EmpresaDAO();
        Empresa empresa = dao.getById(id);
        return empresa;
    }

    public boolean gravarEmpresa(Empresa empresa) {
        return new EmpresaDAO().insert(empresa);
    }

    public boolean atualizarEmpresa(Empresa empresa) {
        return EmpresaDAO.getInstance().update(empresa);
    }

    public boolean deletarEmpresa(Empresa empresa) {
        return EmpresaDAO.getInstance().delete(empresa);
    }

    public ArrayList<Empresa> razaoSocial(String empresa) {
        return EmpresaDAO.getInstance().listBySomething("razaoSocial", empresa);
    }

    public ArrayList<Empresa> buscarPorEstado(String estado) {
        return EmpresaDAO.getInstance().listBySomething("uf", estado);
    }

    public ArrayList<Empresa> buscarPorCidade(String cidade) {
        return EmpresaDAO.getInstance().listBySomething("cidade", cidade);
    }

    public ArrayList<Empresa> buscarPorBairro(String bairro) {
        return EmpresaDAO.getInstance().listBySomething("bairro", bairro);
    }

}
