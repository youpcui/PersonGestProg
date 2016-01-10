package ycui.projet.pgp.operate;

import java.util.Iterator;

import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.proxy.PersonDAOProxyFile;
import ycui.projet.pgp.util.*;
import ycui.projet.pgp.vo.Person;
import ycui.projet.pgp.vo.Worker;

public class WorkerOperate extends PersonOperate {
	public WorkerOperate(){
		super();
		this.dao = new PersonDAOProxyFile();
		this.input = new InputData();
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
		System.out.println("-->L'employ��(e) "+
				w.getName()+ // Ա������
				(flag?" est bien ":" n'est pas ")+ //�ɹ����
				"ajout��(e)");
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
				if(p instanceof Worker){
					if(buf.length() == 0){
						buf.append("Employ��(e)(s)\t\tNom\t\tAge\tSalaire\n");
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
		StringBuffer buf = new StringBuffer("");
		String id = this.input.getString("Saisir id:");
		try {
			Person p = this.dao.doFindById(id);
			if(p!=null){
				if(buf.length() == 0){
					buf.append("Employ��(e)(s)\t\tNom\t\tAge\tSalaire\n");
				}
				buf.append(p.toString());
				buf.append("\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(buf.toString());
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
/*	
	private String printWorker(Person p){
		StringBuffer buf = new StringBuffer("");
		if(p instanceof Worker){
			if(buf.length() == 0){
				buf.append("Employ��(e)(s)\t\tNom\t\tAge\tSalaire\n");
			}
			buf.append(p.toString());
			buf.append("\n");
		}
		return buf.toString();
	}
*/
}
