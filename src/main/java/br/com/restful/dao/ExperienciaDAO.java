package br.com.restful.dao;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Experiencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExperienciaDAO extends ConnectionFactory {
    
    private static ExperienciaDAO instance;
    
    public static ExperienciaDAO getInstance() {
        if (instance == null) {
            instance = new ExperienciaDAO();
        }
        return instance;
    }
    
    public ArrayList<Experiencia> listarTodos() {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Experiencia> experiencias = null;
        conexao = criarConexao();
        experiencias = new ArrayList<Experiencia>();
        try {
            preparedStatement = conexao.prepareStatement("SELECT * FROM experiencia");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Experiencia experiencia = new Experiencia();
                
                experiencia.setId(resultSet.getInt("id"));
                experiencia.setCargo(resultSet.getString("cargo"));
                experiencia.setFuncao(resultSet.getString("funcao"));
                experiencia.setCandidato_id(resultSet.getInt("candidato_id"));    
                
                experiencias.add(experiencia);
                System.out.println("ExperienciaDao.listarTodos: " + experiencia.toString());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar todas as experiencias: " + e);
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, resultSet);
        }
        return experiencias;
    }
    
    public ArrayList<Experiencia> listarTodos(int candidato_id) {
        System.out.println("ExperienciaDAO.listarTodos(candidato_id = " + candidato_id + ")");
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Experiencia> experiencias = null;
        conexao = criarConexao();
        experiencias = new ArrayList<Experiencia>();
        try {
            preparedStatement = conexao.prepareStatement("SELECT * FROM experiencia WHERE candidato_id = " + candidato_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Experiencia experiencia = new Experiencia();
                
                experiencia.setId(resultSet.getInt("id"));
                experiencia.setCargo(resultSet.getString("cargo"));
                experiencia.setFuncao(resultSet.getString("funcao"));
                experiencia.setCandidato_id(resultSet.getInt("candidato_id"));
                
                experiencias.add(experiencia);
                System.out.println("ExperienciaDao.listarTodos do candidato:" + candidato_id + "\n" + experiencia.toString());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar todas as experiencias: " + e);
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, resultSet);
        }
        return experiencias;
    }    
    
    public Experiencia getById(long id) {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Experiencia experiencia = new Experiencia();
        conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("SELECT * FROM experiencia WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                experiencia.setId(resultSet.getInt("id"));
                experiencia.setCargo(resultSet.getString("cargo"));
                experiencia.setFuncao(resultSet.getString("funcao"));
                experiencia.setCandidato_id(resultSet.getInt("candidato_id"));
            }
            System.out.println("ExperienciaDao.getById: " + experiencia.toString());
        } catch (Exception e) {
            System.out.println("Erro ao buscar experiencia com ID=" + id + "\n" + e);
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, resultSet);
        }
        return experiencia;
    }
    
    public boolean insert(Experiencia experiencia) {
        String cargo = experiencia.getCargo();
        boolean isGravado = false;
        PreparedStatement preparedStatement = null;
        Connection conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("insert into experiencia(cargo)" + "values(?)");
            preparedStatement.setString(1, cargo);
            boolean execute = preparedStatement.execute();
            isGravado = true;
        } catch (SQLException e) {
            isGravado = false;
            e.printStackTrace();
        }
        return isGravado;
    }
    
    public boolean update(Experiencia experiencia) {
        long id = experiencia.getId();
        String cargo = experiencia.getCargo();
        boolean isAtualizado = false;
        PreparedStatement preparedStatement = null;
        Connection conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("UPDATE experiencia SET cargo =?, funcao=?, candidato_id=? WHERE id = ?");
            preparedStatement.setString(1, cargo);
            preparedStatement.setString(2, experiencia.getFuncao());
            preparedStatement.setInt(3, experiencia.getCandidato_id());
            preparedStatement.setLong(4, id);
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
    
    public boolean delete(Experiencia experiencia) {
        boolean isDeletado = false;
        PreparedStatement preparedStatement = null;
        Connection conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("DELETE FROM experiencia WHERE id = ?");
            preparedStatement.setInt(1, experiencia.getId());
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
    
}
