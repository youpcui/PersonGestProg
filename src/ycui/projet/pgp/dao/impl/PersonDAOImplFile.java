package ycui.projet.pgp.dao.impl;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import ycui.projet.pgp.dao.PersonDAO;
import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.exception.FileIOException;
import ycui.projet.pgp.io.FileOperate;
import ycui.projet.pgp.vo.Person;


public class PersonDAOImplFile implements PersonDAO {
	/* ���е����ݶ�������һ������֮�У���Ϊ���Ͽ���ֱ�����ļ��б��档
	 * �˼��ϵ�����������ļ���ȡ����Ϊ�ļ�����Ҫ�������
	 */
	private Set<Person> allPerson = null; 
	private FileOperate fo = new FileOperate("person.obj");
	
	public PersonDAOImplFile(){
		try {
			this.allPerson =  (Set<Person>) fo.load();
		} catch (FileIOException e) {
			System.err.println("Echec d'ouvrir person.obj!-->"
					+e.getMessage());
		}
	} 
	public boolean doCreate(Person person) throws DAOException {
		// ���� ����
		// ��ԭ�еĻ���������
		boolean flag = false;
		try {
			flag = this.allPerson.add(person);
			flag = flag && this.fo.save(this.allPerson);
		} catch (FileIOException e) {
			System.err.println("Echec d'ins��rer "+person.getId()+"!-->"
					+e.getMessage());
		}
		return flag;
	}

	public boolean doUpdate(Person person) throws DAOException {
		//id����
		boolean flag = false;
		try {
			
			Person orig = this.doFindById(person.getId());
			Person dest = person;
/*
			if(orig instanceof Student){ // ���ƥ��ѧ��
				destS = (Student) person;
//				orig.setId(dest.getId());
//				orig.setName(dest.getName());
//				orig.setAge(dest.getAge());
//				((Student) orig).setScore(dest.getScore());
			}
			if(orig instanceof Worker){ // ���ƥ�乤��
				destW = (Worker) person;
//				orig.setId(dest.getId());
//				orig.setName(dest.getName());
//				orig.setAge(dest.getAge());
//				((Worker) orig).setSalary(dest.getSalary());
			}
*/
			flag = this.allPerson.remove(orig);
			flag = flag && this.allPerson.add(dest);
			flag = flag && this.fo.save(this.allPerson);
		} catch (FileIOException e) {
			System.err.println("Echec de mettre �� jour "+person.getId()+"!-->"
					+e.getMessage());
		}
		return flag;
	}

	public boolean doDelete(String id) throws DAOException {
		boolean flag = false;
		try {
			Person p = this.doFindById(id);
				if(p.getId().equals(id)){
					flag = this.allPerson.remove(p);
				}
				flag = flag && this.fo.save(this.allPerson);
		} catch (FileIOException e) {
			System.err.println("Echec de supprimer "+id+"!-->"
					+e.getMessage());
		}
		return flag;
	}
	
	public boolean doDeleteAll() throws DAOException {
		boolean flag = false;
		try{
			flag = this.allPerson.removeAll(allPerson);
			flag = flag && this.fo.save(allPerson);
		} catch (FileIOException e) {
			System.err.println("Echec de supprimer!-->"
					+e.getMessage());
		}
		return flag;
	}

	public Set<Person> doFindAll() throws DAOException {
		return this.allPerson;
	}

	public Person doFindById(String id) throws DAOException {
		Person p = null;
		try {
			Iterator<Person> iter = this.allPerson.iterator();
			while(iter.hasNext()){
			Person tmp = iter.next();//�ȸ�ֵ
				if(tmp.getId().equals(id)){//���ж�
					p = tmp;
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("Personne correspond �� "+id+"!-->"
					+e.getMessage());
		}
		return p;
	}

	public Set<Person> doFindByKey(String keyWord) throws DAOException {
		Set<Person> search = new TreeSet<Person>();
		Iterator<Person> iter = this.allPerson.iterator();
		while(iter.hasNext()){
			Person p = (Person) iter.next();
			if(p.getName().indexOf(keyWord) != -1){
				search.add(p);
			}
		}
		return search;
	}
}
