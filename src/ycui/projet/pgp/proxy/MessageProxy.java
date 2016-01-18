package ycui.projet.pgp.proxy;

import java.io.Serializable;

public class MessageProxy implements Serializable {
	private static final long serialVersionUID = -2138855284216336998L;	
	private String message;

	public MessageProxy(){
		message = null;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String toString() {
		return this.getMessage();
	}
}
