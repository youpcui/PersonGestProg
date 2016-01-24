package ycui.projet.pgp.operate;

import java.util.Iterator;

import ycui.projet.pgp.exception.DAOException;
import ycui.projet.pgp.util.*;
import ycui.projet.pgp.vo.MessageComm;
import ycui.projet.pgp.vo.Person;
import ycui.projet.pgp.vo.Worker;

public class WorkerOperate extends PersonOperate {
	public WorkerOperate(LangType type) {
		super(type);
	}

	@Override
	public MessageComm add() {
		MessageComm mp = new MessageComm();
		boolean flag = false;
		Worker w = null;
		String name;
		int age;
		float salary;
		do {
			name = input.getString(lang.translate("PO_00_NAME"));
		} while (name.equals(""));
		do {
			age = input.getInt(lang.translate("PO_00_AGE"));
		} while (age < 0);
		do {
			salary = input.getFloat(lang.translate("PO_00_R01_SALARY"));
		} while (salary < 0);
		w = new Worker(new Stamp("1").getTimeStampRandom(), name, age, salary);
		try {
			flag = this.dao.doCreate(w);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		mp.setMessage(SYSINFO
				+ (flag ? lang.translate("PO_01_R01_OK") : lang
						.translate("PO_01_R01_KO")) + w.getName());

		return mp;
	}

	@Override
	public MessageComm update() {
		MessageComm mp = new MessageComm();
		boolean flag = false;
		Person p = null;
		String id = this.input.getString(lang.translate("PO_00_ID"));
		try {
			p = this.dao.doFindById(id);
			if (p != null && p instanceof Worker) {
				Worker tmp = (Worker) p;
				String name;
				int age;
				float salary;
				name = input.getString(lang.translate("PO_00_NAME") + "("
						+ tmp.getName() + "?)");
				do {
					age = input.getInt(lang.translate("PO_00_AGE") + "("
							+ tmp.getAge() + "?)");
				} while (age < 0);
				do {
					salary = input.getFloat(lang.translate("PO_00_R01_SALARY")
							+ "(" + tmp.getSalary() + "?)");
				} while (salary < 0);
				Worker w = new Worker(p.getId(),
						name.equals("") ? tmp.getName() : name, age, salary);
				flag = this.dao.doUpdate(w);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		mp.setMessage(SYSINFO
				+ (flag ? lang.translate("PO_02_R01_OK") : lang
						.translate("PO_02_R01_KO")) + id);
		return mp;
	}

	@Override
	public MessageComm findAll() {
		MessageComm mp = new MessageComm();
		StringBuffer buf = new StringBuffer("");
		boolean nobody = true;
		try {
			Iterator<Person> iter = this.dao.doFindAll().iterator();
			while (iter.hasNext()) {
				Person p = (Person) iter.next();
				if (p instanceof Worker) {
					nobody = false;
					if (buf.length() == 0) {
						buf.append(lang.translate("PO_03_R01_HEAD"));
					}
					buf.append(p.toString());
					buf.append("\n");
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		if (!nobody) {
			mp.setMessage(PrintFormat.setFormatCenter(lang
					.translate("PO_03_RESULT"))
					+ "\n"
					+ PrintFormat.setFormatFull(SEPARATOR)
					+ "\n"
					+ buf.toString() + PrintFormat.setFormatFull(SEPARATOR));
		} else {
			mp.setMessage(SYSINFO + lang.translate("PO_03_KO")); // LIST EMPTY
		}
		return mp;
	}

	@Override
	public MessageComm findById() {
		MessageComm mp = new MessageComm();
		StringBuffer buf = new StringBuffer("");
		Person p = null;
		boolean nobody = true;
		String id = this.input.getString(lang.translate("PO_00_ID"));
		try {
			p = this.dao.doFindById(id);
			if (p != null && p instanceof Worker) {
				nobody = false;
				if (buf.length() == 0) {
					buf.append(lang.translate("PO_03_R01_HEAD"));
				}
				buf.append(p.toString());
				buf.append("\n");
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		if (!nobody) {
			mp.setMessage(PrintFormat.setFormatCenter(lang
					.translate("PO_03_RESULT"))
					+ "\n"
					+ PrintFormat.setFormatFull(SEPARATOR)
					+ "\n"
					+ buf.toString() + PrintFormat.setFormatFull(SEPARATOR));
		} else {
			mp.setMessage(SYSINFO + lang.translate("PO_03_KO")); // LIST EMPTY
		}
		return mp;
	}

	@Override
	public MessageComm findByKey() {
		MessageComm mp = new MessageComm();
		StringBuffer buf = new StringBuffer("");
		String keyWord = this.input.getString(lang.translate("PO_03_KEY"));
		boolean nobody = true;
		try {
			Iterator<Person> iter = this.dao.doFindByKey(keyWord).iterator();
			while (iter.hasNext()) {
				Person p = (Person) iter.next();
				if (p instanceof Worker) {
					nobody = false;
					if (buf.length() == 0) {
						buf.append(lang.translate("PO_03_R01_HEAD"));
					}
					buf.append(p.toString());
					buf.append("\n");
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		if (!nobody) {
			mp.setMessage(PrintFormat.setFormatCenter(lang
					.translate("PO_03_RESULT"))
					+ "\n"
					+ PrintFormat.setFormatFull(SEPARATOR)
					+ "\n"
					+ buf.toString() + PrintFormat.setFormatFull(SEPARATOR));
		} else {
			mp.setMessage(SYSINFO + lang.translate("PO_03_KO")); // LIST EMPTY
		}
		return mp;
	}

	@Override
	public MessageComm delete() {
		MessageComm mp = new MessageComm();
		boolean flag = false;
		Person p = null;
		String id = this.input.getString(lang.translate("PO_00_ID"));
		try {
			p = this.dao.doFindById(id);
			if (p != null && p instanceof Worker) {
				flag = this.dao.doDelete(id);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		mp.setMessage(SYSINFO
				+ (flag ? lang.translate("PO_04_R01_OK") : lang
						.translate("PO_04_R01_KO")) + id);
		return mp;
	}

}
