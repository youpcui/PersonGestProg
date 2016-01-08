package ycui.projet.pgp.proxy;

import java.util.Set;

import ycui.projet.pgp.dao.PersonDAO;
import ycui.projet.pgp.dao.impl.PersonDAOImplFile;
import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.vo.Person;


public class PersonDAOProxyFile implements PersonDAO {
private PersonDAO dao = null;

	public PersonDAOProxyFile(){
		this.dao = new PersonDAOImplFile();
	}

	@Override
	public boolean doCreate(Person person) throws DAOException {
		return this.dao.doCreate(person);
	}

	@Override
	public boolean doUpdate(Person person) throws DAOException {
		return this.dao.doUpdate(person);
	}

	@Override
	public boolean doDelete(String id) throws DAOException {
		return this.dao.doDelete(id);
	}

	@Override
	public boolean doDeleteAll() throws DAOException {
		return this.dao.doDeleteAll();
	}
	
	@Override
	public Set<Person> findAll() throws DAOException {
		return this.dao.findAll();
	}

	@Override
	public Person findById(String id) throws DAOException {
		return this.dao.findById(id);
	}

	@Override
	public Set<Person> findByKey(String keyWord) throws DAOException {
		return this.dao.findByKey(keyWord);
	}

	

}
