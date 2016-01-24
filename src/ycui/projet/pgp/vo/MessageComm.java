package ycui.projet.pgp.vo;

import java.io.Serializable;

public class MessageComm implements Serializable {
	private static final long serialVersionUID = -2138855284216336998L;	
	private String message;

	public MessageComm(){
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
