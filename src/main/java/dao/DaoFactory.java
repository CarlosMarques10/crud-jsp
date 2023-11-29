package dao;

import connection.DatabaseConnection;
import dao.implement.AuthDAO;
import dao.implement.ContactDAO;

public class DaoFactory {
	
	public static AuthDAO createAuthDAO() {
		return new AuthDAO(DatabaseConnection.getConnection());
	}
	
	public static ContactDAO createContactDAO() {
		return new ContactDAO(DatabaseConnection.getConnection());
	}

}
