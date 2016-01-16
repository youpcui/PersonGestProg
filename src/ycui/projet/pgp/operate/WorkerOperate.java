package ycui.projet.pgp.operate;

import java.util.Iterator;

import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.proxy.MessageProxy;
import ycui.projet.pgp.util.*;
import ycui.projet.pgp.vo.Person;
import ycui.projet.pgp.vo.Worker;

public class WorkerOperate extends PersonOperate {
	public WorkerOperate(LangType type) {
		super(type);
	}

	@Override
	public void add() {
		boolean flag = false;
		Worker w = new Worker(new Stamp("1").getTimeStampRandom(),
				input.getString("Saisir le nom d'employ��:"),
				input.getInt("Saisir l'age:"),
				input.getFloat("Saisir le salaire:"));
		try {
			flag = this.dao.doCreate(w);
		} catch (DAOException e) {
			System.err
					.println("Echec d'ins��rer employ��(e)-->" + e.getMessage());
		}
		System.out.println(RESULTHEAD + "-->L'employ��(e) " + w.getName() // Ա������
				+ (flag ? " est bien " : " n'est pas ")// �ɹ����
				+ "ajout��(e).\n" + RESULTEND);
	}

	@Override
	public void update() {
		boolean flag = false;
		StringBuffer buf = new StringBuffer("");
		Person p = null;
		String id = this.input.getString("Saisir id:");
		try {
			p = this.dao.doFindById(id);
			if (p != null) {
				if (p instanceof Worker) {
					Worker tmp = (Worker) p;
					Worker w = new Worker(
							p.getId(),
							input.getString(("Saisir le nouveau nom d'employ�� (original "
									+ tmp.getName() + "):")),
							input.getInt(("Saisir le nouvel age (original "
									+ tmp.getAge() + "):")),
							input.getFloat(("Saisir le nouveau salaire [original "
									+ tmp.getSalary() + "):")));
					flag = this.dao.doUpdate(w);
					buf.append("-->L'employ��(e) [");
					buf.append(p.getId());
					buf.append(flag ? "] est bien modifi��(e)\n"
							: "] n'est pas modifi��(e)\n");
				} else {
					buf.append("-->[");
					buf.append(p.getId());
					buf.append("] est trouv��, mais pas l'employ��(e).\n");
				}
			} else {
				buf.append("-->L'employ��(e) [");
				buf.append(id);
				buf.append("] n'est pas trouv��(e).\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD + buf.toString() + RESULTEND);
	}

	@Override
	public MessageProxy findAll() {
		StringBuffer buf = new StringBuffer("");
		boolean nobody = true;
		MessageProxy mp = null;
		try {
			Iterator<Person> iter = this.dao.doFindAll().iterator();
			while (iter.hasNext()) {
				Person p = (Person) iter.next();
				if (p instanceof Worker) {
					nobody = false;
					if (buf.length() == 0) {
						buf.append(this.lang.operate.getProperty("WORKERHEAD"));
					}
					buf.append(p.toString());
					buf.append("\n");
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD
				+ (nobody ? ("-->La liste est vide.\n") : buf.toString())
				+ RESULTEND);
		return mp;
	}

	@Override
	public void findById() {
		StringBuffer buf = new StringBuffer("");
		Person p = null;
		boolean nobody = true;
		String id = this.input.getString("Saisir id:");
		try {
			p = this.dao.doFindById(id);
			if (p != null && p instanceof Worker) {
				nobody = false;
				if (buf.length() == 0) {
					buf.append(this.lang.operate.getProperty("WORKERHEAD"));
				}
				buf.append(p.toString());
				buf.append("\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD
				+ (nobody ? "-->L'employ��(e) n'est pas trouv��.\n" : buf
						.toString()) + RESULTEND);
	}

	@Override
	public void findByKey() {
		StringBuffer buf = new StringBuffer("");
		String keyWord = this.input.getString("Saisir mot cl��:");
		boolean nobody = true;
		try {
			Iterator<Person> iter = this.dao.doFindByKey(keyWord).iterator();
			while (iter.hasNext()) {
				Person p = (Person) iter.next();
				if (p instanceof Worker) {
					nobody = false;
					if (buf.length() == 0) {
						buf.append(this.lang.operate.getProperty("WORKERHEAD"));
					}
					buf.append(p.toString());
					buf.append("\n");
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out
				.println(RESULTHEAD
						+ (nobody ? ("-->Ne personne correspond �� \"" + keyWord + "\".\n")
								: buf.toString()) + RESULTEND);
	}

	@Override
	public void delete() {
		boolean flag = false;
		StringBuffer buf = new StringBuffer("");
		Person p = null;
		String id = this.input.getString("Saisir id:");
		try {
			p = this.dao.doFindById(id);
			if (p != null && p instanceof Worker) {
				flag = this.dao.doDelete(id);
				buf.append("-->L'employ��(e) ");
				buf.append(p.getName());
				buf.append("[");
				buf.append(p.getId());
				buf.append(flag ? "] est bien supprim��(e)\n"
						: "] n'est pas supprim��(e)\n");
			} else {
				buf.append("-->L'employ��(e) [");
				buf.append(id);
				buf.append("] n'est pas trouv��(e).\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD + buf.toString() + RESULTEND);
	}

	@Override
	public void deleteAll() {
		System.out.println(RESULTHEAD
				+ "Vous avez pas d'autoris�� �� supprimer tous!" + RESULTEND);
	}
/*	
	public static void main(String args[]){
		WorkerOperate wo = new WorkerOperate();
		
		wo.findAll();
	}
*/
}
