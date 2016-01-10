package ycui.projet.pgp.operate;

import java.util.Iterator;

import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.util.*;
import ycui.projet.pgp.vo.Person;
import ycui.projet.pgp.vo.Worker;

public class WorkerOperate extends PersonOperate {
	public WorkerOperate(){
		super();
	}
	@Override
	public void add() {
		boolean flag = false;
		Worker w = new Worker(
				new Stamp("1").getTimeStampRandom(),
				input.getString("Saisir le nom d'employ��:"),
				input.getInt("Saisir l'age:"),
				input.getFloat("Saisir le salaire:"));
		try {
			this.dao.doCreate(w);
			flag = true;
		} catch (DAOException e) {
			System.err.println("Echec d'ins��rer employ��(e)-->"
					+e.getMessage());
		}
		System.out.println(RESULTHEAD
				+ "-->L'employ��(e) "+ w.getName() // Ա������
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
				if(p instanceof Worker){
					if(buf.length() == 0){
						buf.append(WORKERHEAD);
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
					buf.append(WORKERHEAD);
				}
				buf.append(p.toString());
				buf.append("\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD
				+ ((p==null)?"-->L'employ��(e) n'est pas trouv��.\n":buf.toString())
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
				if(p instanceof Worker){
					nobody = false;
					if(buf.length() == 0){
						buf.append(WORKERHEAD);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}
