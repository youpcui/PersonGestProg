package ycui.projet.pgp.main;

import java.util.Iterator;
import java.util.Set;

import ycui.projet.pgp.dao.PersonDAO;
import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.proxy.PersonDAOProxyFile;
import ycui.projet.pgp.util.InputData;
import ycui.projet.pgp.util.Stamp;
import ycui.projet.pgp.vo.*;

public class Main{
	public static InputData input = new InputData();
	
	public static void main(String[] args) {
		PersonDAO dao = new PersonDAOProxyFile();	
/*		
		//Test create
		//增加一个新的数据
		Person p1 = getPersonType("1");
		Person p2 = getPersonType("2");
		Person p3 = getPersonType("2");
		Person p4 = getPersonType("2");
		Person p5 = getPersonType("1");	

		//保存内容
		try {
			dao.doCreate(p1);
			dao.doCreate(p2);
			dao.doCreate(p3);
			dao.doCreate(p4);
			dao.doCreate(p5);

		} catch (DAOException e) {
			e.printStackTrace();
		}
*/
		//查询列表
		try {
		System.out.println("\n------------------------Find all------------------------\n");
			System.out.println(printAllPerson(dao.doFindAll()));
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		
/*		
		// Test research by id
		//按id查询
		try {
			System.out.println("\n-----------------------Find by ID-----------------------\n");
			System.out.println(printPerson(dao.doFindById("220160108234328445702")));
			System.out.println(printPerson(dao.doFindById("120160108234401030593")));
		} catch (DAOException e) {
			e.printStackTrace();
		}
*/		
/*		
		//Test Update
		try {
			//取得对象
			Person p = dao.doFindById("220160108234328445702");
			if(p instanceof Worker){
				Worker w = (Worker) p;
			}else if(p instanceof Student){
				Student s = (Student) p;
			}
			//修改数据
			System.out.println("\n-------------------------Update-------------------------\n");
			System.out.println(dao.doUpdate(p));
			
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
		 
		//查询结果
		try {
			System.out.println("\n------------------------Find all------------------------\n");
			System.out.println(printAllPerson(dao.doFindAll()));
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
/*		
		//Test delete
		//删除所有
		try {
			dao.doDeleteAll();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		//查询结果
		try {
			System.out.println("\n------------------------Find all------------------------\n");
			System.out.println(printAllPerson(dao.doFindAll()));
		} catch (DAOException e) {
			e.printStackTrace();
		}
*/		
	}
	
	/**
	 * 
	 * @param allPerson
	 * @return
	 */
	private static String printAllPerson(Set<Person> allPerson){
		StringBuffer bufW = new StringBuffer("");
		StringBuffer bufS = new StringBuffer("");

		try {
			Iterator<Person> iter = allPerson.iterator();
			while(iter.hasNext()){
				Person p = (Person) iter.next();
				if(p instanceof Worker){
					if(bufW.length() == 0){
						bufW.append("Employée(s)\t\tNom\t\tAge\tSalaire\n");
					}
					bufW.append(p.toString());
					bufW.append("\n");
				}else if(p instanceof Student){
					if(bufS.length() == 0){
						bufS.append("Etudiant(s)\t\tNom\t\tAge\tScore\n");
					}
					bufS.append(p.toString());
					bufS.append("\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bufW.toString()+"\n"+bufS.toString();
	}
	
	/**
	 *  
	 * @param person
	 * @return
	 */
	private static String printPerson(Person person){
		StringBuffer buf = new StringBuffer("");
		try {
			if(person instanceof Worker){
				buf.append("Employée(s)\t\tNom\t\tAge\tSalaire\n");
				buf.append(person.toString());
				buf.append("\n");
			}else if(person instanceof Student){
				buf.append("Etudiant(s)\t\tNom\t\tAge\tScore\n");
				buf.append(person.toString());
				buf.append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buf.toString()+"\n";
	}
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	private static Person getPersonType(String type){
		Person person = null;
		switch(type){
		case "1":
			Worker w = new Worker(
					new Stamp("1").getTimeStampRandom(),
					input.getString("Saisir le nom d'employée:"),
					input.getInt("Saisir l'age:"),
					input.getFloat("Saisir le salary:"));
			person = (Worker) w;
			break;
		case "2":
			Student s = new Student(
					new Stamp("2").getTimeStampRandom(),
					input.getString("Saisir le nom d'étudiant:"),
					input.getInt("Saisir l'age:"),
					input.getFloat("Saisir le score:"));
			person = (Student) s;
			break;
		}
		return person;
	}

}
