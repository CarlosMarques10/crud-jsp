package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.GenericDAO;
import models.Auth;
import models.Contact;

public class ContactDAO implements GenericDAO<Contact> {

	private Connection connection;

	public ContactDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean inserir(Contact obj) {

		PreparedStatement ps = null;

		String sql = "INSERT INTO contatos(name,email,telefone,auth_id) VALUES (?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getEmail());
			ps.setString(3, obj.getTelefone());
			ps.setInt(4, obj.getAuthId());
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean atualizar(Contact obj) {

		PreparedStatement ps = null;

		String sql = "UPDATE contatos SET name = ?, email = ?, telefone = ? WHERE id = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getEmail());
			ps.setString(3, obj.getTelefone());
			ps.setInt(4, obj.getId());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void deletarPeloId(Integer id) {
		
		PreparedStatement ps = null;

		String sql = "DELETE FROM contatos WHERE id = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Contact procurarPeloId(Integer id) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM contatos WHERE id = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				Contact contato = new Contact();
				contato.setId(rs.getInt("id"));
				contato.setName(rs.getString("name"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				return contato;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<Contact> mostrarContato(int authId) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Contact> contatos = new ArrayList<Contact>();

		String sql = "SELECT contatos.id,contatos.name,contatos.email,contatos.telefone FROM contatos JOIN auth ON contatos.auth_id = auth.id WHERE contatos.auth_id = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, authId);
			rs = ps.executeQuery();

			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setTelefone(rs.getString("telefone"));
				contatos.add(contact);
			}

			return contatos;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contatos;
	}

}
