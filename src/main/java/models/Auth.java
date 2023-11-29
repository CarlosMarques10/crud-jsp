package models;

import org.mindrot.jbcrypt.BCrypt;

public class Auth {

	private String name;
	private String email;
	private String password;
	private Integer id;

	public Auth(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Auth(String name, String email, String password, Integer id) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.id = id;
	}
	
	

	public Auth() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// gerar Hash de senha
	public String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	//comparar senha com hash
	public boolean checkPassword(String candidatePassword, String hashedPassword) {
        return BCrypt.checkpw(candidatePassword, hashedPassword);
    }

}
