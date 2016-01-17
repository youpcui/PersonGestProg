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
	/* 所有的内容都保存在一个集合之中，因为集合可以直接向文件中保存。
	 * 此集合的内容最好由文件读取，因为文件本身要保存对象
	 */
	private Set<Person> allPerson = null; 
	private FileOperate fo = new FileOperate("person.obj");
	
	public PersonDAOImplFile(){
		try {
			this.allPerson =  (Set<Person>) fo.load();
		} catch (FileIOException e) {
			e.printStackTrace();
		}
	} 
	public boolean doCreate(Person person) throws DAOException {
		// 插入 数据
		// 在原有的基础上增加
		boolean flag = false;
		try {
			flag = this.allPerson.add(person);
			flag = flag && this.fo.save(this.allPerson);
		} catch (FileIOException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean doUpdate(Person person) throws DAOException {
		boolean flag = false;
		try {
			Person orig = this.doFindById(person.getId());
			Person dest = person;
			flag = this.allPerson.remove(orig);
			flag = flag && this.allPerson.add(dest);
			flag = flag && this.fo.save(this.allPerson);
		} catch (FileIOException e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean doDeleteAll() throws DAOException {
		boolean flag = false;
		try{
			flag = this.allPerson.removeAll(allPerson);
			flag = flag && this.fo.save(allPerson);
		} catch (FileIOException e) {
			e.printStackTrace();
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
			Person tmp = iter.next();//先赋值
				if(tmp.getId().equals(id)){//再判断
					p = tmp;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
