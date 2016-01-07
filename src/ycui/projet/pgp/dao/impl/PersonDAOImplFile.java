package ycui.projet.pgp.dao.impl;

import java.util.Set;

import ycui.projet.pgp.dao.PersonDAO;
import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.exception.FileIOException;
import ycui.projet.pgp.io.FileOperate;
import ycui.projet.pgp.vo.Person;


public class PersonDAOImplFile implements PersonDAO {
	/* 所有的内容都保存在一个集合之中，因为集合可以直接向文件中保存。
	 * 此集合的内容最好由文件读取，因为文件本身要保存对象
	 */
	private Set<Person> allPerson = null ; 
	private FileOperate fo = new FileOperate("person.pgp");
	
	public PersonDAOImplFile(){
		try {
			this.allPerson =  (Set<Person>) fo.load();
		} catch (FileIOException e) {
			System.err.println("Echec d'ouvrir person.pgp!-->"
					+e.getMessage());
		}
	} 
	@Override
	public boolean doCreate(Person person) throws DAOException {
		// 插入 数据
		// 在原有的基础上增加
		boolean flag = false;
		try {
			this.allPerson.add(person);
			this.fo.save(this.allPerson);
			flag = true;
		} catch (FileIOException e) {
			System.err.println("Echec d'insérer l'objet!-->"
					+e.getMessage());
		}
		return flag;
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
