package models;

public class Contact {

	private Integer id;
	private String name;
	private String email;
	private String telefone;
	private Integer authId;

	public Integer getAuthId() {
		return authId;
	}

	public void setAuthId(Integer authId) {
		this.authId = authId;
	}

	public Contact() {
	}

	public Contact(Integer id, String name, String email, String telefone, Integer authId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefone = telefone;
		this.authId = authId;
	}

	public Contact(Integer id, String name, String email, String telefone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefone = telefone;
	}

	public Contact(String name, String email, String telefone) {
		super();
		this.name = name;
		this.email = email;
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
