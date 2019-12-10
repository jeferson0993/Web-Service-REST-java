package br.com.restful.dao;

import br.com.restful.controller.VagaController;
import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Empresa;
import br.com.restful.model.Vaga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpresaDAO extends ConnectionFactory {

    private static EmpresaDAO instance;

    public static EmpresaDAO getInstance() {
        if (instance == null) {
            instance = new EmpresaDAO();
        }
        return instance;
    }

    public ArrayList<Empresa> listarTodos() {
        System.out.println("EmpresaDao.listarTodos()");
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Empresa> Empresas = null;
        conexao = criarConexao();
        Empresas = new ArrayList<Empresa>();

        try {
            preparedStatement = conexao.prepareStatement("SELECT * FROM empresa");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(resultSet.getInt("id"));
                empresa.setRazaoSocial(resultSet.getString("razaoSocial"));
                empresa.setCnpj(resultSet.getString("cnpj"));
                empresa.setEndereco(resultSet.getString("endereco"));
                empresa.setBairro(resultSet.getString("bairro"));
                empresa.setCidade(resultSet.getString("cidade"));
                empresa.setCep(resultSet.getString("cep"));
                empresa.setEmail(resultSet.getString("email"));
                empresa.setTelefone(resultSet.getString("telefone"));
                empresa.setUf(resultSet.getString("uf"));
                Empresas.add(empresa);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar todas as empresas: " + e);
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, resultSet);
        }
        System.out.println("lista Empresas: " + Empresas);
        return Empresas;

    }

    public Empresa getById(long id) {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Empresa empresa = new Empresa();
        conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("SELECT * FROM empresa WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                empresa.setId(resultSet.getInt("id"));
                empresa.setRazaoSocial(resultSet.getString("razaoSocial"));
                empresa.setCnpj(resultSet.getString("cnpj"));
                empresa.setEndereco(resultSet.getString("endereco"));
                empresa.setBairro(resultSet.getString("bairro"));
                empresa.setCidade(resultSet.getString("cidade"));
                empresa.setCep(resultSet.getString("cep"));
                empresa.setEmail(resultSet.getString("email"));
                empresa.setTelefone(resultSet.getString("telefone"));
                empresa.setUf(resultSet.getString("uf"));                
                empresa.setVagas(new VagaController().listarTodos(empresa.getId()));
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar Empresa com ID=" + id + "\n" + e);
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, resultSet);
        }
        return empresa;

    }

    public boolean insert(Empresa empresa) {
        System.out.println("EmpresaDAO.insert(" + empresa.toString() +")");
        String razaoSocial = empresa.getRazaoSocial();
        String cnpj = empresa.getCnpj();
        String endereco = empresa.getEndereco();
        ArrayList<Vaga> vagas = empresa.getVagas();
        boolean isGravado = false;
        PreparedStatement preparedStatement = null;
        Connection conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("insert into empresa(razaoSocial)" + "values(?)");
            preparedStatement.setString(1, razaoSocial);
            boolean execute = preparedStatement.execute();
            isGravado = true;
            System.out.println("Respota do insert: " + execute);
        } catch (SQLException e) {
            isGravado = false;
            e.printStackTrace();
        }
        return isGravado;
    }

    public boolean update(Empresa empresa) {
        long id = empresa.getId();
        String razaoSocial = empresa.getRazaoSocial();
        String cnpj = empresa.getCnpj();
        String endereco = empresa.getEndereco();
        String bairro = empresa.getBairro();
        String cidade = empresa.getCidade();
        String uf = empresa.getUf();
        String cep = empresa.getCep();
        String email = empresa.getEmail();
        String telefone = empresa.getTelefone();
        ArrayList<Vaga> vagas = empresa.getVagas();
        boolean isAtualizado = false;
        PreparedStatement preparedStatement = null;
        Connection conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("UPDATE empresa SET razaoSocial = ?,cnpj = ?,endereco = ?, bairro = ?, cidade = ?, uf = ?, cep = ?, email = ?, telefone = ? WHERE id = ?");
            preparedStatement.setString(1, razaoSocial);
            preparedStatement.setString(2, cnpj);
            preparedStatement.setString(3, endereco);
            preparedStatement.setString(4, bairro);
            preparedStatement.setString(5, cidade);
            preparedStatement.setString(6, uf);
            preparedStatement.setString(7, cep);
            preparedStatement.setString(8, email);
            preparedStatement.setString(9, telefone);
            preparedStatement.setLong(10, id);
            int execute = preparedStatement.executeUpdate();
            isAtualizado = true;
            System.out.println("Retorno update: " + execute);
        } catch (SQLException e) {
            isAtualizado = false;
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, null);
        }        
        for (Vaga vaga : vagas) {
            vaga.setEmpresa_id(empresa.getId());
            if (new VagaController().gravarvaga(vaga)) {
                System.out.println("gravado: " + vaga.toString());
            }
        }        
        return isAtualizado;
    }

    public boolean delete(Empresa empresa) {
        boolean isDeletado = false;
        PreparedStatement preparedStatement = null;
        Connection conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("DELETE FROM empresa WHERE id = ?");
            preparedStatement.setInt(1, empresa.getId());
            boolean execute = preparedStatement.execute();
            isDeletado = true;
            System.out.println("Respota do delete: " + execute);
        } catch (SQLException e) {
            isDeletado = false;
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, null);
        }
        return isDeletado;
    }

    public ArrayList<Empresa> listBySomething(String coluna, String valor) {
        String sqlQuery = "SELECT * FROM empresa WHERE " + coluna + " LIKE \"%" + valor +"%\"";
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Empresa> Empresas = null;
        conexao = criarConexao();
        Empresas = new ArrayList<Empresa>();

        try {
            preparedStatement = conexao.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(resultSet.getInt("id"));
                empresa.setRazaoSocial(resultSet.getString("razaoSocial"));
                empresa.setCnpj(resultSet.getString("cnpj"));
                empresa.setEndereco(resultSet.getString("endereco"));
                empresa.setBairro(resultSet.getString("bairro"));
                empresa.setCidade(resultSet.getString("cidade"));
                empresa.setUf(resultSet.getString("uf"));
                empresa.setCep(resultSet.getString("cep"));
                empresa.setEmail(resultSet.getString("email"));
                empresa.setTelefone(resultSet.getString("telefone"));

                Empresas.add(empresa);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar as empresas: " + e);
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, resultSet);
        }
        System.out.println("lista Empresas: " + Empresas);
        return Empresas;

    }

}
