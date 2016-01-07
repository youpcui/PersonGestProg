package ycui.projet.pgp.dao.impl;

import java.util.Set;

import ycui.projet.pgp.dao.PersonDAO;
import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.exception.FileIOException;
import ycui.projet.pgp.io.FileOperate;
import ycui.projet.pgp.vo.Person;


public class PersonDAOImplFile implements PersonDAO {
	/* ���е����ݶ�������һ������֮�У���Ϊ���Ͽ���ֱ�����ļ��б��档
	 * �˼��ϵ�����������ļ���ȡ����Ϊ�ļ�����Ҫ�������
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
		// ���� ����
		// ��ԭ�еĻ���������
		boolean flag = false;
		try {
			this.allPerson.add(person);
			this.fo.save(this.allPerson);
			flag = true;
		} catch (FileIOException e) {
			System.err.println("Echec d'ins��rer l'objet!-->"
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
