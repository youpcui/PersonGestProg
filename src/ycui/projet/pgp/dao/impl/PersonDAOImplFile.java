package ycui.projet.pgp.dao.impl;

import java.util.Set;

import ycui.projet.pgp.dao.PersonDAO;
import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.vo.Person;


public class PersonDAOImplFile implements PersonDAO {

	@Override
	public boolean doCreate(Person person) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Person person) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(String id) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<? extends Person> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findById(String id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<? extends Person> findByKey(String keyWord) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
