package it.tirinnanzi.ivsb.entity;

public class Account {
	private String id;
	private String password;
	private String email;
	
	public Account(String id, String password) {
		
		this.id = id;
		this.password = password;
	}
	
	public Account(String id, String password,String email) {
		
		this.id = id;
		this.password = password;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toArchive() {
		if(this.email != null) {
			return this.id + "~" + this.password + "~"+ this.email;
		}else{
			return this.id + "~" + this.password;
		}
	}
	@Override
	public String toString() {
		return this.id;
	}
	
	
}
