package dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.DatabaseConnection;
import dao.GenericDAO;
import models.Auth;

public class AuthDAO implements GenericDAO<Auth> {

	private Connection connection;

	public AuthDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean inserir(Auth obj) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "INSERT INTO auth(name,email,hashPassword) VALUES (?,?,?)";

		try {
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getEmail());
			ps.setString(3, obj.getPassword());
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				rs = ps.getGeneratedKeys();

				if (rs.next()) {
					obj.setId(rs.getInt("id"));
					return true;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseConnection.closeStatement(ps);
			DatabaseConnection.closeResultSet(rs);
		}
		return false;
	}

	@Override
	public boolean atualizar(Auth obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletarPeloId(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Auth procurarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean procurarPeloEmail(String email) {

		String sql = "SELECT * FROM auth WHERE email = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public Auth verifyLogin(String email, String password) {

		String sql = "SELECT * FROM auth WHERE email = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				
				String hashPassword = rs.getString("hashPassword");
				Auth auth = new Auth();
				if(auth.checkPassword(password, hashPassword)) {
					auth.setId(rs.getInt("id"));
					auth.setName(rs.getString("name"));
					auth.setEmail(rs.getString("email"));
					return auth;
							
				}
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
