package br.uni7.testes.trabalho.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.uni7.testes.trabalho.config.BDConfig;
import br.uni7.testes.trabalho.entidade.Nota;

public class NotaDAO {

	public List<Nota> listarNotas() throws Exception {
		List<Nota> lista = new ArrayList<>();

		Connection conexao = BDConfig.getConnection();

		String sql = "SELECT * FROM tbl_nota";

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Nota nota = new Nota();
			nota.setId(rs.getInt("id"));
			nota.setTitulo(rs.getString("titulo"));
			nota.setDescricao(rs.getString("descricao"));

			lista.add(nota);
		}

		return lista;
	}
	
	public Nota buscarNotaPorId(int idNota) throws Exception {
		Nota nota = null;

		Connection conexao = BDConfig.getConnection();

		String sql = "SELECT * FROM tbl_nota WHERE id = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idNota);
		ResultSet rs = statement.executeQuery();

		if (rs.next()) {
			nota = new Nota();
			nota.setId(rs.getInt("id"));
			nota.setTitulo(rs.getString("titulo"));
			nota.setDescricao(rs.getString("descricao"));
		}

		return nota;
	}
	
	public void addNota(Nota nota) throws Exception {
		Connection conexao = BDConfig.getConnection();

		String sql = "INSERT INTO tbl_nota(titulo, descricao) VALUES(?, ?)";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, nota.getTitulo());
		statement.setString(2, nota.getDescricao());
		statement.execute();
	}
	
	public void editarNota(Nota nota, int idNota) throws Exception {
		Connection conexao = BDConfig.getConnection();

		String sql = "UPDATE tbl_nota SET titulo = ?, descricao = ? WHERE id = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, nota.getTitulo());
		statement.setString(2, nota.getDescricao());
		statement.setInt(3, idNota);
		statement.execute();
	}
	
	public void removerNota(int idNota) throws Exception {
		Connection conexao = BDConfig.getConnection();

		String sql = "DELETE FROM tbl_nota WHERE id = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idNota);
		statement.execute();
	}
}
