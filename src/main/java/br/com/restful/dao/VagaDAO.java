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
		if (instance == null)
			instance = new VagaDAO();
		return instance;
	}

	public ArrayList<Vaga> listarTodos() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Vaga> vagas = null;

		conexao = criarConexao();
		vagas = new ArrayList<Vaga>();
		
		try {
			pstmt = conexao.prepareStatement("SELECT * FROM vaga");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vaga vaga = new Vaga();

				vaga.setId(rs.getInt("id"));
				vaga.setNome(rs.getString("nome"));

				vagas.add(vaga);
				
			}

		} catch (Exception e) {
			System.out.println("Erro ao listar todas as vagas: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		
		return vagas;
		
	}

	public Vaga getById(long id) {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vaga vaga = new Vaga();
		conexao = criarConexao();

		try {
			pstmt = conexao.prepareStatement("SELECT * FROM vaga WHERE id = ?");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vaga.setId(rs.getInt("id"));
				vaga.setNome(rs.getString("nome"));
			}
                        System.out.println("VagaDao.getById: " + vaga.toString());
		} catch (Exception e) {
			System.out.println("Erro ao buscar vaga com ID=" + id + "\n" + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}

		return vaga;

	}
	
	public boolean insert(Vaga vaga) {
		String nome = vaga.getNome();
		boolean isGravado = false;
		PreparedStatement pstmt = null;
		Connection conexao = criarConexao();
		try {
			pstmt = conexao.prepareStatement("insert into vaga(nome)" + "values(?)");
			pstmt.setString(1, nome);
			boolean execute = pstmt.execute();
			isGravado = true;
			System.out.println("Respota do insert: " + execute);

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
		PreparedStatement pstmt = null;
		Connection conexao = criarConexao();
		try {
			pstmt = conexao.prepareStatement("UPDATE vaga SET nome =? WHERE id = ?");
			pstmt.setString(1, nome);
			pstmt.setLong(2, id);
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

	public boolean delete(Vaga vaga) {
		boolean isDeletado = false;
		PreparedStatement pstmt = null;
		Connection conexao = criarConexao();
		try {
			pstmt = conexao.prepareStatement("DELETE FROM vaga WHERE id = ?");
			pstmt.setInt(1, vaga.getId());
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
