package ycui.projet.pgp.proxy;

import java.io.Serializable;

public class MessageProxy implements Serializable {
	private static final long serialVersionUID = -2138855284216336998L;	
	private String message;
	private boolean status;

	public MessageProxy(){
		message = null;
		status = false;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static void main(String args[]){
		MessageProxy proxy = new MessageProxy();
//		boolean b = true;
		String str = "str";
		proxy.setMessage(str);
		System.out.println(proxy.getMessage());
		
	}
}
