package ycui.projet.pgp.operate;

import java.util.Iterator;

import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.util.Stamp;
import ycui.projet.pgp.vo.Person;
import ycui.projet.pgp.vo.Student;

public class StudentOperate extends PersonOperate{	
	public StudentOperate(){
		super();
	}
	@Override
	public void add() {
		boolean flag = false;
		Student s = new Student(
				new Stamp("2").getTimeStampRandom(),
				input.getString("Saisir le nom d'étudiant:"),
				input.getInt("Saisir l'age:"),
				input.getFloat("Saisir le notes:"));
		try {
			this.dao.doCreate(s);
			flag = true;
		} catch (DAOException e) {
			System.err.println("Echec d'insérer étudiant-->"
					+e.getMessage());
		}
		System.out.println(RESULTHEAD 
				+ "-->L'étudiant(e) "+ s.getName() // 学生名字
				+ (flag?" est bien ":" n'est pas ")//成功与否
				+ "ajouté(e).\n" + RESULTEND);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findAll() {
		StringBuffer buf = new StringBuffer("");
		boolean nobody = true;
		try {
			Iterator<Person> iter = this.dao.doFindAll().iterator();
			while(iter.hasNext()){
				Person p = (Person) iter.next();
				if(p instanceof Student){
					nobody = false;
					if(buf.length() == 0){
						buf.append(STUDENTHEAD);
					}
					buf.append(p.toString());
					buf.append("\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD 
				+ (nobody?("-->La liste est vide.\n"):buf.toString())
				+ RESULTEND);
		
	}

	@Override
	public void findById() {
		StringBuffer buf = new StringBuffer("");
		Person p = null;
		String id = this.input.getString("Saisir id:");
		try {
			p = this.dao.doFindById(id);
			if(p!=null){
				if(buf.length() == 0){
					buf.append(STUDENTHEAD);
				}
				buf.append(p.toString());
				buf.append("\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD
				+ ((p==null)?"-->L'étudiant(e) n'est pas trouvé.\n":buf.toString())
				+ RESULTEND);
		
	}

	@Override
	public void findByKey() {
		StringBuffer buf = new StringBuffer("");
		String keyWord = this.input.getString("Saisir mot clé:");
		boolean nobody = true;
		try {
			Iterator<Person> iter = this.dao.doFindByKey(keyWord).iterator();
			while(iter.hasNext()){
				Person p = (Person) iter.next();
				if(p instanceof Student){
					nobody = false;
					if(buf.length() == 0){
						buf.append(STUDENTHEAD);
					}
					buf.append(p.toString());
					buf.append("\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD 
				+ (nobody?("-->Ne personne correspond à \""+keyWord+"\".\n"):buf.toString())
				+ RESULTEND);
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
