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
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Candidato> candidatos = null;

		conexao = criarConexao();
		candidatos = new ArrayList<Candidato>();
		
		try {
			pstmt = conexao.prepareStatement("SELECT * FROM candidato ORDER BY nome");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Candidato candidato = new Candidato();

				candidato.setId(rs.getInt("id"));
				candidato.setNome(rs.getString("nome"));
				candidato.setCpf(rs.getString("cpf"));
				candidato.setEndereco(rs.getString("endereco"));

				candidatos.add(candidato);
				
			}

		} catch (Exception e) {
			System.out.println("Erro ao listar todos os candidatos: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		
		return candidatos;
		
	}

	public Candidato getById(long id) {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Candidato candidato = null;
		conexao = criarConexao();

		try {
			pstmt = conexao.prepareStatement("SELECT * FROM candidato WHERE id = ?");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				candidato = new Candidato();
				candidato.setId(rs.getInt("id"));
				candidato.setNome(rs.getString("nome"));
				candidato.setCpf(rs.getString("cpf"));
				candidato.setEndereco(rs.getString("endereco"));
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar candidato com ID=" + id + "\n" + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}

		return candidato;

	}
	
	public boolean insert(Candidato candidato) {
		String nome = candidato.getNome();
		String cpf = candidato.getCpf();
		String endereco = candidato.getEndereco();
		boolean isGravado = false;
		PreparedStatement pstmt = null;
		Connection conexao = criarConexao();
		try {
			pstmt = conexao.prepareStatement("insert into candidato(nome,cpf,endereco)" + "values(?,?,?)");
			pstmt.setString(1, nome);
			pstmt.setString(2, cpf);
			pstmt.setString(3, endereco);
			boolean execute = pstmt.execute();
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
		String endereco = candidato.getEndereco();
		boolean isAtualizado = false;
		PreparedStatement pstmt = null;
		Connection conexao = criarConexao();
		try {
			pstmt = conexao.prepareStatement("UPDATE candidato SET nome =?,cpf = ?,endereco = ? WHERE id = ?");
			pstmt.setString(1, nome);
			pstmt.setString(2, cpf);
			pstmt.setString(3, endereco);
			pstmt.setLong(4, id);
			int execute = pstmt.executeUpdate();
			isAtualizado = true;
			System.out.println("Retorno update: " + execute);

		} catch (SQLException e) {
			isAtualizado = false;
			e.printStackTrace();

		} finally {
			fecharConexao(conexao, pstmt, null);
		}
		return isAtualizado;

	}

	public boolean delete(Candidato candidato) {
		boolean isDeletado = false;
		PreparedStatement pstmt = null;
		Connection conexao = criarConexao();
		try {
			pstmt = conexao.prepareStatement("DELETE FROM candidato WHERE id = ?");
			pstmt.setInt(1, candidato.getId());
			boolean execute = pstmt.execute();
			isDeletado = true;
			System.out.println("Respota do delete: " + execute);

		} catch (SQLException e) {
			isDeletado = false;
			e.printStackTrace();

		} finally {
			fecharConexao(conexao, pstmt, null);
		}
		return isDeletado;
	}

}
