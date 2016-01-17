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
	public MessageProxy add() {
		MessageProxy mp = new MessageProxy();
		boolean flag = false;
		Worker w = new Worker(new Stamp("1").getTimeStampRandom(),
				input.getString(lang.getProperty("PO_01_NAME")),
				input.getInt(lang.getProperty("PO_01_AGE")),
				input.getFloat(lang.getProperty("PO_01_R01_SALARY")));
		try {
			flag = this.dao.doCreate(w);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		mp.setStatus(flag);
		if(mp.isStatus()){
			mp.setMessage(SYSINFO + lang.getProperty("PO_01_R01_OK")+w.getName());
		}else{
			mp.setMessage(SYSINFO + lang.getProperty("PO_01_R01_KO")+w.getName());
		}
		return mp;
	}
/*
	@Override
	public MessageProxy update() {
		MessageProxy mp = new MessageProxy();
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
							input.getString(("Saisir le nouveau nom d'employ¨¦ (original "
									+ tmp.getName() + "):")),
							input.getInt(("Saisir le nouvel age (original "
									+ tmp.getAge() + "):")),
							input.getFloat(("Saisir le nouveau salaire [original "
									+ tmp.getSalary() + "):")));
					flag = this.dao.doUpdate(w);
					buf.append("-->L'employ¨¦(e) [");
					buf.append(p.getId());
					buf.append(flag ? "] est bien modifi¨¦(e)\n"
							: "] n'est pas modifi¨¦(e)\n");
				} else {
					buf.append("-->[");
					buf.append(p.getId());
					buf.append("] est trouv¨¦, mais pas l'employ¨¦(e).\n");
				}
			} else {
				buf.append("-->L'employ¨¦(e) [");
				buf.append(id);
				buf.append("] n'est pas trouv¨¦(e).\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD + buf.toString() + RESULTEND);
		return mp;
	}

	@Override
	public MessageProxy findAll() {
		MessageProxy mp = new MessageProxy();
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
						buf.append(lang.getProperty("WORKERHEAD"));
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
	public MessageProxy findById() {
		MessageProxy mp = new MessageProxy();
		StringBuffer buf = new StringBuffer("");
		Person p = null;
		boolean nobody = true;
		String id = this.input.getString("Saisir id:");
		try {
			p = this.dao.doFindById(id);
			if (p != null && p instanceof Worker) {
				nobody = false;
				if (buf.length() == 0) {
					buf.append(lang.getProperty("WORKERHEAD"));
				}
				buf.append(p.toString());
				buf.append("\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD
				+ (nobody ? "-->L'employ¨¦(e) n'est pas trouv¨¦.\n" : buf
						.toString()) + RESULTEND);
		return mp;
	}

	@Override
	public MessageProxy findByKey() {
		MessageProxy mp = new MessageProxy();
		StringBuffer buf = new StringBuffer("");
		String keyWord = this.input.getString("Saisir mot cl¨¦:");
		boolean nobody = true;
		try {
			Iterator<Person> iter = this.dao.doFindByKey(keyWord).iterator();
			while (iter.hasNext()) {
				Person p = (Person) iter.next();
				if (p instanceof Worker) {
					nobody = false;
					if (buf.length() == 0) {
						buf.append(lang.getProperty("WORKERHEAD"));
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
						+ (nobody ? ("-->Ne personne correspond ¨¤ \"" + keyWord + "\".\n")
								: buf.toString()) + RESULTEND);
		return mp;
	}

	@Override
	public MessageProxy delete() {
		MessageProxy mp = new MessageProxy();
		boolean flag = false;
		StringBuffer buf = new StringBuffer("");
		Person p = null;
		String id = this.input.getString("Saisir id:");
		try {
			p = this.dao.doFindById(id);
			if (p != null && p instanceof Worker) {
				flag = this.dao.doDelete(id);
				buf.append("-->L'employ¨¦(e) ");
				buf.append(p.getName());
				buf.append("[");
				buf.append(p.getId());
				buf.append(flag ? "] est bien supprim¨¦(e)\n"
						: "] n'est pas supprim¨¦(e)\n");
			} else {
				buf.append("-->L'employ¨¦(e) [");
				buf.append(id);
				buf.append("] n'est pas trouv¨¦(e).\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		System.out.println(RESULTHEAD + buf.toString() + RESULTEND);
		return mp;
	}
	*/
}
