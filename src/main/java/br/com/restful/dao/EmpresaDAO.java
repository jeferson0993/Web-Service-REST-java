package br.com.restful.dao;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpresaDAO extends ConnectionFactory {

	private static EmpresaDAO instance;

	public static EmpresaDAO getInstance() {
		if (instance == null)
			instance = new EmpresaDAO();
		return instance;
	}

	public ArrayList<Empresa> listarTodos() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Empresa> Empresas = null;

		conexao = criarConexao();
		Empresas = new ArrayList<Empresa>();
		
		try {
			pstmt = conexao.prepareStatement("SELECT * FROM empresa ORDER BY nome");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Empresa empresa = new Empresa();

				empresa.setId(rs.getInt("id"));
				empresa.setRazaoSocial(rs.getString("razaoSocial"));
				empresa.setCnpj(rs.getString("cnpj"));
				empresa.setEndereco(rs.getString("endereco"));

				Empresas.add(empresa);
				
			}

		} catch (Exception e) {
			System.out.println("Erro ao listar todas as empresas: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		
		return Empresas;
		
	}

	public Empresa getById(long id) {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Empresa empresa = new Empresa();
		conexao = criarConexao();

		try {
			pstmt = conexao.prepareStatement("SELECT * FROM empresa WHERE id = ?");
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				empresa.setId(rs.getInt("id"));
				empresa.setRazaoSocial(rs.getString("nome"));
				empresa.setCnpj(rs.getString("cnpj"));
				empresa.setEndereco(rs.getString("endereco"));				
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar Empresa com ID=" + id + "\n" + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}

		return empresa;

	}
	
	public boolean insert(Empresa empresa) {
		String razaoSocial = empresa.getRazaoSocial();
		String cnpj = empresa.getCnpj();
		String endereco = empresa.getEndereco();
		boolean isGravado = false;
		PreparedStatement pstmt = null;
		Connection conexao = criarConexao();
		try {
			pstmt = conexao.prepareStatement("insert into empresa(nome,cpf,endereco)" + "values(?,?,?)");
			pstmt.setString(1, razaoSocial);
			pstmt.setString(2, cnpj);
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

	public boolean update(Empresa empresa) {
		long id = empresa.getId();
		String razaoSocial = empresa.getRazaoSocial();
		String cnpj = empresa.getCnpj();
		String endereco = empresa.getEndereco();
		boolean isAtualizado = false;
		PreparedStatement pstmt = null;
		Connection conexao = criarConexao();
		try {
			pstmt = conexao.prepareStatement("UPDATE empresa SET nome =?,cpf = ?,endereco = ? WHERE id = ?");
			pstmt.setString(1, razaoSocial);
			pstmt.setString(2, cnpj);
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

	public boolean delete(Empresa empresa) {
		boolean isDeletado = false;
		PreparedStatement pstmt = null;
		Connection conexao = criarConexao();
		try {
			pstmt = conexao.prepareStatement("DELETE FROM empresa WHERE id = ?");
			pstmt.setInt(1, empresa.getId());
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
