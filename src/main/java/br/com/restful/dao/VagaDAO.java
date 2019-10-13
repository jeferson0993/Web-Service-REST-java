package br.com.restful.dao;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Vaga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VagaDAO extends ConnectionFactory {
    
    private static VagaDAO instance;
    
    public static VagaDAO getInstance() {
        if (instance == null) {
            instance = new VagaDAO();
        }
        return instance;
    }
    
    public ArrayList<Vaga> listarTodos() {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Vaga> vagas = null;
        conexao = criarConexao();
        vagas = new ArrayList<Vaga>();
        try {
            preparedStatement = conexao.prepareStatement("SELECT * FROM vaga");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Vaga vaga = new Vaga();
                
                vaga.setId(resultSet.getInt("id"));
                vaga.setNome(resultSet.getString("nome"));
                vaga.setFormaContratacao(resultSet.getString("formaDeContratacao"));
                vaga.setRemuneracao(resultSet.getString("remuneracao"));
                vaga.setTurno(resultSet.getString("turno"));
                vaga.setUf(resultSet.getString("uf"));
                vaga.setValeRefeicao(resultSet.getBoolean("valeRefeicao"));
                vaga.setValeTransporte(resultSet.getBoolean("valeTransporte"));
                vaga.setEspecificacoes(resultSet.getString("especificacaoDoCargo"));
                vaga.setEmpresa_id(resultSet.getInt("empresa_id"));
                
                vagas.add(vaga);
                System.out.println("VagaDao.listarTodos: " + vaga.toString());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar todas as vagas: " + e);
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, resultSet);
        }
        return vagas;
    }
    
    public ArrayList<Vaga> listarTodos(int empresa_id) {
        System.out.println("VagaDAO.listarTodos(empresa_id = " + empresa_id + ")");
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Vaga> vagas = null;
        conexao = criarConexao();
        vagas = new ArrayList<Vaga>();
        try {
            preparedStatement = conexao.prepareStatement("SELECT * FROM vaga WHERE empresa_id = " + empresa_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Vaga vaga = new Vaga();
                
                vaga.setId(resultSet.getInt("id"));
                vaga.setNome(resultSet.getString("nome"));
                vaga.setFormaContratacao(resultSet.getString("formaDeContratacao"));
                vaga.setRemuneracao(resultSet.getString("remuneracao"));
                vaga.setTurno(resultSet.getString("turno"));
                vaga.setUf(resultSet.getString("uf"));
                vaga.setValeRefeicao(resultSet.getBoolean("valeRefeicao"));
                vaga.setValeTransporte(resultSet.getBoolean("valeTransporte"));
                vaga.setEspecificacoes(resultSet.getString("especificacaoDoCargo"));
                vaga.setEmpresa_id(resultSet.getInt("empresa_id"));
                
                vagas.add(vaga);
                System.out.println("VagaDao.listarTodos: " + vaga.toString());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar todas as vagas: " + e);
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, resultSet);
        }
        return vagas;
    }    
    
    public Vaga getById(long id) {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Vaga vaga = new Vaga();
        conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("SELECT * FROM vaga WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                vaga.setId(resultSet.getInt("id"));
                vaga.setNome(resultSet.getString("nome"));
                vaga.setFormaContratacao(resultSet.getString("formaDeContratacao"));
                vaga.setRemuneracao(resultSet.getString("remuneracao"));
                vaga.setTurno(resultSet.getString("turno"));
                vaga.setUf(resultSet.getString("uf"));
                vaga.setValeRefeicao(resultSet.getBoolean("valeRefeicao"));
                vaga.setValeTransporte(resultSet.getBoolean("valeTransporte"));
                vaga.setEspecificacoes(resultSet.getString("especificacaoDoCargo"));
                vaga.setEmpresa_id(resultSet.getInt("empresa_id"));
            }
            System.out.println("VagaDao.getById: " + vaga.toString());
        } catch (Exception e) {
            System.out.println("Erro ao buscar vaga com ID=" + id + "\n" + e);
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, preparedStatement, resultSet);
        }
        return vaga;
    }
    
    public boolean insert(Vaga vaga) {
        String nome = vaga.getNome();
        String remuneracao = vaga.getRemuneracao();
        boolean valeTransporte = vaga.getValeTransporte();
        boolean valeRefeicao = vaga.getValeRefeicao();
        String uf = vaga.getUf();
        String turno = vaga.getTurno();
        String formaDeContratacao = vaga.getFormaContratacao();
        int empresa_id = vaga.getEmpresa_id();
        boolean isGravado = false;
        PreparedStatement preparedStatement = null;
        Connection conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("insert into vaga(nome,remuneracao,valeTransporte,valeRefeicao,uf,turno,formaDeContratacao,empresa_id)" + "values(?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, remuneracao);
            preparedStatement.setBoolean(3, valeTransporte);
            preparedStatement.setBoolean(4, valeRefeicao);
            preparedStatement.setString(5, uf);
            preparedStatement.setString(6, turno);
            preparedStatement.setString(7, formaDeContratacao);
            preparedStatement.setInt(8, empresa_id);
            boolean execute = preparedStatement.execute();
            isGravado = true;
            /*System.out.println("Respota do insert: " + execute);*/
        } catch (SQLException e) {
            isGravado = false;
            e.printStackTrace();
        }
        return isGravado;
    }
    
    public boolean update(Vaga vaga) {
        long id = vaga.getId();
        String nome = vaga.getNome();
        boolean isAtualizado = false;
        PreparedStatement preparedStatement = null;
        Connection conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("UPDATE vaga SET nome =? WHERE id = ?");
            preparedStatement.setString(1, nome);
            preparedStatement.setLong(2, id);
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
    
    public boolean delete(Vaga vaga) {
        boolean isDeletado = false;
        PreparedStatement preparedStatement = null;
        Connection conexao = criarConexao();
        try {
            preparedStatement = conexao.prepareStatement("DELETE FROM vaga WHERE id = ?");
            preparedStatement.setInt(1, vaga.getId());
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
