package ycui.projet.pgp.main;

import ycui.projet.pgp.menu.Menu;

public class Main{
	public static void main(String[] args) {
		new Menu();

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
			String str = new String("220160108234351870174");
			Person p = str.substring(0, 1).equals("1")?
					(Worker)dao.doFindById(str):(Student)dao.doFindById(str);
			System.out.println(printPerson(p));
			Student s = (Student)p;
			s.setAge(19);
			s.setScore(19f);
			//修改数据
			System.out.println("\n-------------------------Update-------------------------\n");
			System.out.println(dao.doUpdate(s));
			
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
	 *
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
*/	
	/**
	 *  
	 * @param person
	 * @return
	 
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
	*/
	/**
	 * 
	 * @param type
	 * @return
	 
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
	*/
}
