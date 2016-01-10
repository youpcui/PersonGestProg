package ycui.projet.pgp.operate;

import java.util.Iterator;

import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.proxy.PersonDAOProxyFile;
import ycui.projet.pgp.util.*;
import ycui.projet.pgp.vo.Person;
import ycui.projet.pgp.vo.Student;

public class StudentOperate extends PersonOperate{	
	public StudentOperate(){
		super();
		this.dao = new PersonDAOProxyFile();
		this.input = new InputData();
	}
	@Override
	public void add() {
		boolean flag = false;
		Student s = new Student(
				new Stamp("2").getTimeStampRandom(),
				input.getString("Saisir le nom d'étudiant:"),
				input.getInt("Saisir l'age:"),
				input.getFloat("Saisir le score:"));
		try {
			this.dao.doCreate(s);
			flag = true;
		} catch (DAOException e) {
			System.err.println("Echec d'insérer étudiant-->"
					+e.getMessage());
		}
		System.out.println("L'étudiant(e) "+
				s.getName()+ // 学生名字
				(flag?" est bien ":" n'est pas ")+ //成功与否
				"ajouté(e)");	
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findAll() {
		StringBuffer buf = new StringBuffer("");

		try {
			Iterator<Person> iter = this.dao.doFindAll().iterator();
			while(iter.hasNext()){
				Person p = (Person) iter.next();
				if(p instanceof Student){
					if(buf.length() == 0){
						buf.append("Etudiant(s)\t\tNom\t\tAge\tScore\n");
					}
					buf.append(p.toString());
					buf.append("\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(buf.toString());
		
	}

	@Override
	public void findById() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findByKey() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
