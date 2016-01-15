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

	public boolean doCreate(Person person) throws DAOException {
		return this.dao.doCreate(person);
	}

	public boolean doUpdate(Person person) throws DAOException {
		return this.dao.doUpdate(person);
	}

	public boolean doDelete(String id) throws DAOException {
		return this.dao.doDelete(id);
	}

	public boolean doDeleteAll() throws DAOException {
		return this.dao.doDeleteAll();
	}
	
	public Set<Person> doFindAll() throws DAOException {
		return this.dao.doFindAll();
	}

	public Person doFindById(String id) throws DAOException {
		return this.dao.doFindById(id);
	}

	public Set<Person> doFindByKey(String keyWord) throws DAOException {
		return this.dao.doFindByKey(keyWord);
	}

	

}
