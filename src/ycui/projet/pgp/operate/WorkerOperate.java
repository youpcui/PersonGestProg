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
				input.getString("Saisir le nom d'employé:"),
				input.getInt("Saisir l'age:"),
				input.getFloat("Saisir le salaire:"));
		try {
			flag = this.dao.doCreate(w);
		} catch (DAOException e) {
			System.err
					.println("Echec d'insérer employé(e)-->" + e.getMessage());
		}
		System.out.println(RESULTHEAD + "-->L'employé(e) " + w.getName() // 员工名字
				+ (flag ? " est bien " : " n'est pas ")// 成功与否
				+ "ajouté(e).\n" + RESULTEND);
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
							input.getString(("Saisir le nouveau nom d'employé (original "
									+ tmp.getName() + "):")),
							input.getInt(("Saisir le nouvel age (original "
									+ tmp.getAge() + "):")),
							input.getFloat(("Saisir le nouveau salaire [original "
									+ tmp.getSalary() + "):")));
					flag = this.dao.doUpdate(w);
					buf.append("-->L'employé(e) [");
					buf.append(p.getId());
					buf.append(flag ? "] est bien modifié(e)\n"
							: "] n'est pas modifié(e)\n");
				} else {
					buf.append("-->[");
					buf.append(p.getId());
					buf.append("] est trouvé, mais pas l'employé(e).\n");
				}
			} else {
				buf.append("-->L'employé(e) [");
				buf.append(id);
				buf.append("] n'est pas trouvé(e).\n");
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
				+ (nobody ? "-->L'employé(e) n'est pas trouvé.\n" : buf
						.toString()) + RESULTEND);
	}

	@Override
	public void findByKey() {
		StringBuffer buf = new StringBuffer("");
		String keyWord = this.input.getString("Saisir mot clé:");
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
						+ (nobody ? ("-->Ne personne correspond à \"" + keyWord + "\".\n")
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
				buf.append("-->L'employé(e) ");
				buf.append(p.getName());
				buf.append("[");
				buf.append(p.getId());
				buf.append(flag ? "] est bien supprimé(e)\n"
						: "] n'est pas supprimé(e)\n");
			} else {
				buf.append("-->L'employé(e) [");
				buf.append(id);
				buf.append("] n'est pas trouvé(e).\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD + buf.toString() + RESULTEND);
	}

	@Override
	public void deleteAll() {
		System.out.println(RESULTHEAD
				+ "Vous avez pas d'autorisé à supprimer tous!" + RESULTEND);
	}
/*	
	public static void main(String args[]){
		WorkerOperate wo = new WorkerOperate();
		
		wo.findAll();
	}
*/
}
