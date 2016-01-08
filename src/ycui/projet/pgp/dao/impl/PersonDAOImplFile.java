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
			System.err.println("Echec d'insérer "+person.getId()+"!-->"
					+e.getMessage());
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Person person) throws DAOException {
		//id不变
		boolean flag = false;
		try {
			Person orig = this.findById(person.getId());
			if(orig instanceof Student){ // 如果匹配学生
				Student dest = (Student) person;
				orig.setId(dest.getId());
				orig.setName(dest.getName());
				orig.setAge(dest.getAge());
				((Student) orig).setScore(dest.getScore());
			}
			if(orig instanceof Worker){ // 如果匹配工人
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
			System.err.println("Echec de mettre à jour "+person.getId()+"!-->"
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
					// id一致
					p = iter.next();
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("Personne correspond à "+id+"!-->"
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
