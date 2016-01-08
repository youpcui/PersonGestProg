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
		//增加一个新的数据
		Person p1 = getPersonType("w");
		Person p2 = getPersonType("s");
		Person p3 = getPersonType("s");
		Person p4 = getPersonType("s");
		Person p5 = getPersonType("w");
		
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
			System.out.println(printPerson(dao.findAll()));
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		//删除所有
		try {
			dao.doDeleteAll();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		//查询结果
		try {
			System.out.println(printPerson(dao.findAll()));
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
	}
	private static String printPerson(Set<Person> allPerson){
		StringBuffer bufW = new StringBuffer("");
		StringBuffer bufS = new StringBuffer("");
		String separator = "\n-------------------Informations-------------------\n\n";

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
		if((!"".equals(bufW))&&("".equals(bufS))){
			return separator+bufW.toString();
		}else if((!"".equals(bufS))&&("".equals(bufW))){
			return separator+bufS.toString();
		}else
			return separator+bufW.toString()+"\n"+bufS.toString();
	}
	
	private static Person getPersonType(String type){
		Person person = null;
		switch(type){
		case "w":
			Worker w = new Worker(
					new Stamp("w").getTimeStampRandom(),
					input.getString("Saisir le nom d'employée:"),
					input.getInt("Saisir l'age:"),
					input.getFloat("Saisir le salary:"));
			person = (Worker) w;
			break;
		case "s":
			Student s = new Student(
					new Stamp("s").getTimeStampRandom(),
					input.getString("Saisir le nom d'étudiant:"),
					input.getInt("Saisir l'age:"),
					input.getFloat("Saisir le score:"));
			person = (Student) s;
			break;
		}
		return person;
	}

}
