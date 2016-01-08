package ycui.projet.pgp.dao.impl;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import ycui.projet.pgp.dao.PersonDAO;
import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.exception.FileIOException;
import ycui.projet.pgp.io.FileOperate;
import ycui.projet.pgp.vo.Person;
import ycui.projet.pgp.vo.Student;
import ycui.projet.pgp.vo.Worker;


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
			System.err.println("Echec d'ins��rer "+person.getId()+"!-->"
					+e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Person person) throws DAOException {
		//id����
		boolean flag = false;
		try {
			Person orig = this.findById(person.getId());
			if(orig instanceof Student){ // ���ƥ��ѧ��
				Student dest = (Student) person;
				orig.setId(dest.getId());
				orig.setName(dest.getName());
				orig.setAge(dest.getAge());
				((Student) orig).setScore(dest.getScore());
			}
			if(orig instanceof Worker){ // ���ƥ�乤��
				Worker dest = (Worker) person;
				orig.setId(dest.getId());
				orig.setName(dest.getName());
				orig.setAge(dest.getAge());
				((Worker) orig).setSalary(dest.getSalary());
			}
			this.allPerson.add(orig);
			this.fo.save(this.allPerson);
			flag = true;
		} catch (FileIOException e) {
			System.err.println("Echec de mettre �� jour "+person.getId()+"!-->"
					+e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean doDelete(String id) throws DAOException {
		boolean flag = false;
		try {
			this.allPerson.remove(this.findById(id));
			this.fo.save(this.allPerson);
			flag = true;
		} catch (FileIOException e) {
			System.err.println("Echec de supprimer "+id+"!-->"
					+e.getMessage());
		}
		return flag;
	}
	
	@Override
	public boolean doDeleteAll() throws DAOException {
		boolean flag = false;
		try{
		this.allPerson.removeAll(allPerson);
		this.fo.save(allPerson);
		flag = true;
		} catch (FileIOException e) {
			System.err.println("Echec de supprimer!-->"
					+e.getMessage());
		}
		return flag;
	}

	@Override
	public Set<Person> findAll() throws DAOException {
		return this.allPerson;
	}

	@Override
	public Person findById(String id) throws DAOException {
		Person p = null;
		try {
			Iterator<Person> iter = this.allPerson.iterator();
			while(iter.hasNext()){
				if(iter.next().getId().equals(id)){
					// idһ��
					p = iter.next();
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("Personne correspond �� "+id+"!-->"
					+e.getMessage());
		}
		return p;
	}

	@Override
	public Set<Person> findByKey(String keyWord) throws DAOException {
		Set<Person> search = new TreeSet<Person>();
		Iterator<Person> iter = this.allPerson.iterator();
		while(iter.hasNext()){
			Person p = (Person) iter.next();
			if(p.getName().indexOf(keyWord) != -1){
				search.add(p);
			}
		}
		return null;
	}
	
}
