package br.com.restful.dao;

import br.com.restful.controller.ExperienciaController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Candidato;

public class CandidatoDAO extends ConnectionFactory {

    private static CandidatoDAO instance;

    public static CandidatoDAO getInstance() {
        if (instance == null) {
            instance = new CandidatoDAO();
        }
        return instance;
    }

    public ArrayList<Candidato> listarTodos() {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Candidato> Candidatos = null;

        conexao = criarConexao();
        Candidatos = new ArrayList<Candidato>();

        try {
            preparedStatement = conexao.prepareStatement("SELECT * FROM candidato");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Candidato candidato = new Candidato();
                candidato.setId(resultSet.getInt("id"));
                candidato.setNome(resultSet.getString("nome"));
                candidato.setRg(resultSet.getString("rg"));
                candidato.setCpf(resultSet.getString("cpf"));
                candidato.setSexo(resultSet.getString("sexo"));
                candidato.setTelefone(resultSet.getString("telefone"));
                candidato.setEndereco(resultSet.getString("endereco"));
                candidato.setEstadoCivil(resultSet.getString("estadoCivil"));
                candidato.setDataNascimento(resultSet.getString("dataNascimento"));
                /*EXPERIENCIAS:*/
                candidato.setExperiencias(new ExperienciaController().listarTodos(candidato.getId()));
                Candidatos.add(candidato);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar todos os candidatos: " + e);
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, resultSet);
        }
        System.out.println("lista candidatos: " + Candidatos);
        return Candidatos;
    }

    public Candidato getById(long id) {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Candidato candidato = null;
        conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("SELECT * FROM candidato WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                candidato = new Candidato();
                candidato.setId(resultSet.getInt("id"));
                candidato.setNome(resultSet.getString("nome"));
                candidato.setRg(resultSet.getString("rg"));
                candidato.setCpf(resultSet.getString("cpf"));
                candidato.setSexo(resultSet.getString("sexo"));
                candidato.setTelefone(resultSet.getString("telefone"));
                candidato.setEndereco(resultSet.getString("endereco"));
                candidato.setEstadoCivil(resultSet.getString("estadoCivil"));
                candidato.setDataNascimento(resultSet.getString("dataNascimento"));
                /*EXPERIENCIAS:*/
                candidato.setExperiencias(new ExperienciaController().listarTodos(candidato.getId()));
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar candidato com ID=" + id + "\n" + e);
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, resultSet);
        }
        return candidato;
    }

    public boolean insert(Candidato candidato) {
        String nome = candidato.getNome();
        boolean isGravado = false;
        PreparedStatement preparedStatement = null;
        Connection conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("insert into candidato(nome)" + "values(?)");
            preparedStatement.setString(1, nome);
            boolean execute = preparedStatement.execute();
            isGravado = true;
            System.out.println("Respota do insert: " + execute);
        } catch (SQLException e) {
            isGravado = false;
            e.printStackTrace();
        }
        return isGravado;
    }

    public boolean update(Candidato candidato) {
        long id = candidato.getId();
        String nome = candidato.getNome();
        String cpf = candidato.getCpf();
        String dataNascimento = candidato.getDataNascimento();
        String sexo = candidato.getSexo();
        String estadoCivil = candidato.getEstadoCivil();
        String rg = candidato.getRg();
        String endereco = candidato.getEndereco();
        String telefone = candidato.getTelefone();
        boolean isAtualizado = false;
        PreparedStatement preparedStatement = null;
        Connection conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("UPDATE candidato SET nome =?,cpf = ?,dataNascimento = ?, sexo = ?, estadoCivil = ?, rg = ?, endereco = ?, telefone = ? WHERE id = ?");
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cpf);
            preparedStatement.setString(3, dataNascimento);
            preparedStatement.setString(4, sexo);
            preparedStatement.setString(5, estadoCivil);
            preparedStatement.setString(6, rg);
            preparedStatement.setString(7, endereco);
            preparedStatement.setString(8, telefone);
            preparedStatement.setLong(9, id);
            int execute = preparedStatement.executeUpdate();
            isAtualizado = true;
            System.out.println("Retorno update: " + execute);
        } catch (SQLException e) {
            isAtualizado = false;
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, null);
        }
        return isAtualizado;
    }

    public boolean delete(Candidato candidato) {
        boolean isDeletado = false;
        PreparedStatement preparedStatement = null;
        Connection conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("DELETE FROM candidato WHERE id = ?");
            preparedStatement.setInt(1, candidato.getId());
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

    public ArrayList<Candidato> listBySomething(String coluna, String valor) {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Candidato> Candidatos = null;

        conexao = criarConexao();
        Candidatos = new ArrayList<Candidato>();

        try {
            preparedStatement = conexao.prepareStatement("SELECT * FROM candidato WHERE " + coluna + " LIKE \"%" + valor + "%\"");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Candidato candidato = new Candidato();
                candidato.setId(resultSet.getInt("id"));
                candidato.setNome(resultSet.getString("nome"));
                candidato.setRg(resultSet.getString("rg"));
                candidato.setCpf(resultSet.getString("cpf"));
                candidato.setSexo(resultSet.getString("sexo"));
                candidato.setTelefone(resultSet.getString("telefone"));
                candidato.setEndereco(resultSet.getString("endereco"));
                candidato.setEstadoCivil(resultSet.getString("estadoCivil"));
                candidato.setDataNascimento(resultSet.getString("dataNascimento"));
                
                Candidatos.add(candidato);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar todos os candidatos: " + e);
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, resultSet);
        }
        System.out.println("lista candidatos: " + Candidatos);
        return Candidatos;
    }

}
