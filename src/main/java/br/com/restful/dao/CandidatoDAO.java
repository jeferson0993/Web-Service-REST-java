package br.com.restful.dao;

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
		if (instance == null)
			instance = new CandidatoDAO();
		return instance;
	}

	public ArrayList<Candidato> listarTodos() {
		Connection conexao = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Candidato> candidatos = null;

		conexao = criarConexao();
		candidatos = new ArrayList<Candidato>();

		try {
			preparedStatement = conexao.prepareStatement("SELECT * FROM candidato ORDER BY nome");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Candidato candidato = new Candidato();
				candidato.setId(resultSet.getInt("id"));
				candidato.setNome(resultSet.getString("nome"));
				candidato.setCpf(resultSet.getString("cpf"));
				candidato.setDataNascimento(resultSet.getString("dataNascimento"));
				candidatos.add(candidato);
			}
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os candidatos: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, preparedStatement, resultSet);
		}
		return candidatos;
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
				candidato.setCpf(resultSet.getString("cpf"));
				candidato.setDataNascimento(resultSet.getString("dataNascimento"));
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
		String cpf = candidato.getCpf();
		String dataNascimento = candidato.getDataNascimento();
		boolean isGravado = false;
		PreparedStatement preparedStatement = null;
		Connection conexao = criarConexao();
		try {
			preparedStatement = conexao.prepareStatement("insert into candidato(nome,cpf,dataNascimento)" + "values(?,?,?)");
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, cpf);
			preparedStatement.setString(3, dataNascimento);
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
		boolean isAtualizado = false;
		PreparedStatement preparedStatement = null;
		Connection conexao = criarConexao();
		try {
			preparedStatement = conexao.prepareStatement("UPDATE candidato SET nome =?,cpf = ?,dataNascimento = ? WHERE id = ?");
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, cpf);
			preparedStatement.setString(3, dataNascimento);
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

}
