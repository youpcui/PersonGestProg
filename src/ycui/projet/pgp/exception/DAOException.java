package ycui.projet.pgp.exception;

/**
 * @author CUI
 * DAOException
 */
public class DAOException extends Exception {
	private static final long serialVersionUID = -3217868670771273021L;
	public DAOException(){}
	public DAOException(String message){
		super(message);
	}
}
