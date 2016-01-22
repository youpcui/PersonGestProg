package ycui.projet.pgp.dao.impl;

import java.util.Set;

import ycui.projet.pgp.dao.PersonDAO;
import ycui.projet.pgp.dbc.DataBaseConnection;
import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.vo.Person;

public class PersonDAOImplJDBC implements PersonDAO {
	private DataBaseConnection dbc = null;
	
	public PersonDAOImplJDBC(){
		this.dbc = new DataBaseConnection();
	}

	public boolean doCreate(Person person) throws DAOException {
		return false;

	}

	public boolean doUpdate(Person person) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean doDelete(String id) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean doDeleteAll() throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	public Set<Person> doFindAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Person doFindById(String id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Person> doFindByKey(String keyWord) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
