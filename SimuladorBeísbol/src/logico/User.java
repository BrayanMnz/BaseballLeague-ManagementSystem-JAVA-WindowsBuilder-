package logico;

import java.io.Serializable;

public class User implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tipo;
	private String userName;
	private String pass;
	
	
	public User(int tipo, String userName, String pass) {
		super();
		this.tipo = tipo;
		this.userName = userName;
		this.pass = pass;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
