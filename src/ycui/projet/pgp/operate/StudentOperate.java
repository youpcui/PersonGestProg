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
				input.getString("Saisir le nom d'��tudiant:"),
				input.getInt("Saisir l'age:"),
				input.getFloat("Saisir le notes:"));
		try {
			this.dao.doCreate(s);
			flag = true;
		} catch (DAOException e) {
			System.err.println("Echec d'ins��rer ��tudiant-->"
					+e.getMessage());
		}
		System.out.println(RESULTHEAD 
				+ "-->L'��tudiant(e) "+ s.getName() // ѧ������
				+ (flag?" est bien ":" n'est pas ")//�ɹ����
				+ "ajout��(e).\n" + RESULTEND);
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
				+ ((p==null)?"-->L'��tudiant(e) n'est pas trouv��.\n":buf.toString())
				+ RESULTEND);
		
	}

	@Override
	public void findByKey() {
		StringBuffer buf = new StringBuffer("");
		String keyWord = this.input.getString("Saisir mot cl��:");
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
				+ (nobody?("-->Ne personne correspond �� \""+keyWord+"\".\n"):buf.toString())
				+ RESULTEND);
	}

	@Override
	public void delete() {
		StringBuffer buf = new StringBuffer("");
		Person p = null;
		String id = this.input.getString("Saisir id:");
		try {
			p = this.dao.doFindById(id);
			if(p!=null){
				if(p instanceof Student){
					this.dao.doDelete(id);
					buf.append("-->L'��tudiantloy��(e) ");
					buf.append(p.getName());
					buf.append("(");
					buf.append(p.getId());
					buf.append(") est bien supprim��(e)\n");
				}else{
					buf.append("-->");
					buf.append(p.getId());
					buf.append(" est trouv��, mais pas l'��tudiant(e).\n");
				}
			}else{
				buf.append("-->L'��tudiant(e) ");
				buf.append(id);
				buf.append(" n'est pas trouv��(e).\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD + buf.toString() + RESULTEND);
	}
	
	@Override
	public void deleteAll(){
			System.out.println(RESULTHEAD+"Vous avez pas d'autoris�� �� supprimer tous!"+RESULTEND);
		}
}
